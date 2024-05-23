package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTranslatorTest {


    void when_localeGerman_then_greetingHallo() {
        // Arrange
        GreetingTranslator greetingTranslator
                = new GreetingTranslator();
        Locale locale = Locale.GERMAN;

        // Act
        String greeting = greetingTranslator
                .getGreeting(locale);

        // Assert
        assertEquals("Hallo", greeting);
    }


    void when_localeEnglish_then_greetingHello() {
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertEquals(
                "Hello",
                greetingTranslator.getGreeting(Locale.ENGLISH)
        );
    }

    @Test
    void when_localeFrance_then_greetingBonjour() {
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertEquals(
                "Bonjour",
                greetingTranslator.getGreeting(Locale.FRANCE)
        );
    }

    @Test
    void when_localeNotSupported_then_IllegalArgumentException() {
        GreetingTranslator greetingTranslator = new GreetingTranslator();
        assertThrows(
                IllegalArgumentException.class,
                () -> greetingTranslator.getGreeting(Locale.ITALY)
        );
    }

}