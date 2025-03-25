package se.kth.ki.waitapp.auth;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class KeycloakMocker {

    private static final String REALM = "testrealm";
    private static final String BASE_URL = "/realms/" + REALM;
    private static final int MOCK_SERVER_PORT = 9090;

    private static WireMockServer wireMockServer;

    private KeycloakMocker() {
        // Private constructor to prevent instantiation
    }

    public static void startMockServer() {
        if (wireMockServer == null) {
            // wireMockServer = new WireMockServer(options().port(MOCK_SERVER_PORT));
            wireMockServer = new WireMockServer(WireMockConfiguration.options().port(MOCK_SERVER_PORT));
            wireMockServer.start();
            configureFor("localhost", MOCK_SERVER_PORT);
            setupMockKeycloakEndpoints();
        }
    }

    public static void stopMockServer() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }

    private static void setupMockKeycloakEndpoints() {
        stubWellKnownEndpoint();
        stubJwksEndpoint();
        stubKeycloakTokenEndpoint();
        stubKeycloakUserInfoEndpoint();
        stubKeycloakLogoutEndpoint();
    }

    private static void stubWellKnownEndpoint() {
        String wellKnownPath = BASE_URL + "/.well-known/openid-configuration";
        stubFor(get(urlEqualTo(wellKnownPath))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\n" +
                                "  \"issuer\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL + "\",\n" +
                                "  \"authorization_endpoint\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL
                                + "/protocol/openid-connect/auth\",\n" +
                                "  \"token_endpoint\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL
                                + "/protocol/openid-connect/token\",\n" +
                                "  \"userinfo_endpoint\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL
                                + "/protocol/openid-connect/userinfo\",\n" +
                                "  \"end_session_endpoint\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL
                                + "/protocol/openid-connect/logout\",\n" +
                                "  \"subject_types_supported\": [\"public\", \"pairwise\"],\n" +
                                "  \"jwks_uri\": \"http://localhost:" + MOCK_SERVER_PORT + BASE_URL
                                + "/.well-known/jwks.json\"\n" +
                                "}")));
    }

    private static void stubJwksEndpoint() {
        String jwksPath = BASE_URL + "/.well-known/jwks.json";
        stubFor(get(urlEqualTo(jwksPath))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\n" +
                                "  \"keys\": [\n" +
                                "    {\n" +
                                "      \"kty\": \"RSA\",\n" +
                                "      \"kid\": \"example-key\",\n" +
                                "      \"use\": \"sig\",\n" +
                                "      \"n\": \"modulus\",\n" +
                                "      \"e\": \"AQAB\"\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")));
    }

    private static void stubKeycloakTokenEndpoint() {
        stubFor(post(urlEqualTo(BASE_URL + "/protocol/openid-connect/token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"access_token\":\"mocked-token\",\"expires_in\":3600}")));
    }

    private static void stubKeycloakUserInfoEndpoint() {
        stubFor(get(urlEqualTo(BASE_URL + "/protocol/openid-connect/userinfo"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"sub\":\"user123\", \"name\": \"Test User\"}")));
    }

    private static void stubKeycloakLogoutEndpoint() {
        stubFor(post(urlEqualTo(BASE_URL + "/protocol/openid-connect/logout"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(204)));
    }
}