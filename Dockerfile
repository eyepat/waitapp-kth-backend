FROM --platform=$BUILDPLATFORM openjdk:22-slim-bullseye AS builder

WORKDIR /app

COPY .mvn .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline -DskipTests

COPY src src

RUN --mount=type=cache,target=/root/.m2/repositories ./mvnw package -DskipTests

FROM registry.access.redhat.com/ubi8/openjdk-21:1.20

ENV LANGUAGE='en_US:en'

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --from=builder --chown=185 --link /app/target/quarkus-app/lib/ /deployments/lib/
COPY --from=builder --chown=185 --link /app/target/quarkus-app/*.jar /deployments/
COPY --from=builder --chown=185 --link /app/target/quarkus-app/app/ /deployments/app/
COPY --from=builder --chown=185 --link /app/target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]
