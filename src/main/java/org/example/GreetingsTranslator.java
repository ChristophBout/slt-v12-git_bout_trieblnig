package org.example;

import java.util.Locale;

public class GreetingsTranslator {

    public String greetingTranslator(Locale locale) {
        if (locale.GERMAN == locale) {
            return "Hallo";
        }
        throw new IllegalArgumentException("Language not supported");
    }



}
