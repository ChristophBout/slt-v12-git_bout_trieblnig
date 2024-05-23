package org.example;

import java.util.Locale;
//mport static org.junit.jupiter.api.Assertions.*;


public class GreetingsTranslatorTest {
    public void when_localeGerman_then_GreetingHallo() {
        //Arrange
        GreetingsTranslator gretee = new GreetingsTranslator();
        Locale locale = Locale.GERMAN;

        //Act
        String greeting = greetingTranslator();
                .getGreeting(locale);

        //Assert





    }
}
