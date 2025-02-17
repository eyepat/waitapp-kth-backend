# Waitapp backend v2

Refacored backend with keycloak

## Development

```bash
docker compose --file dev.docker-compose.yml up -d # start keycloak and postgres
./mvnw quarkus:dev # start quarkus dev server (hot-reloading)
```
