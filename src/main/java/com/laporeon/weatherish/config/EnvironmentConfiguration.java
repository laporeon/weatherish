package com.laporeon.weatherish.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Optional;

public class EnvironmentConfiguration {
    private static final Dotenv ENV = Dotenv.configure().ignoreIfMissing().load();
    private static final String ENVIRONMENT_VARIABLE_API_KEY = "API_KEY";
    private static final String MISSING_API_KEY = "Required environment variable '%s' is missing or blank.";

    public static String apiKey() {
        return require(ENVIRONMENT_VARIABLE_API_KEY);
    }

    public static void validate() {
        apiKey();
    }

    private static String require(String variable) {
        return Optional.ofNullable(System.getenv(variable))
                       .filter(value -> !value.isBlank())
                       .or(() -> Optional.ofNullable(ENV.get(variable)))
                       .filter(value -> !value.isBlank())
                       .orElseThrow(() -> new IllegalStateException(
                               MISSING_API_KEY.formatted(variable)
                       ));
    }
}