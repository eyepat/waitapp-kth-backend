package se.kth.ki.waitapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import se.kth.ki.waitapp.auth.KeycloakMocker;

public abstract class GenericTestWithAuth {

    @BeforeAll
    public static void setup() {
        KeycloakMocker.startMockServer(); // Start the mock Keycloak server before running tests
    }

    @AfterAll
    public static void tearDown() {
        KeycloakMocker.stopMockServer(); // Stop the mock server after tests are complete
    }
}
