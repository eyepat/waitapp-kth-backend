# Waitapp backend v2

Refacored backend with keycloak

## Development

> [!NOTE]
> Check out the [waitapp repo](https://github.com/wait-app/waitapp) where devcontainers are provided.

```bash
docker compose --file dev.docker-compose.yml up -d # start keycloak and postgres
./mvnw quarkus:dev # start quarkus dev server (hot-reloading)
```
