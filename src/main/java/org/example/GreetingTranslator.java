package org.example;

import java.util.Locale;

public class GreetingTranslator {


    public String getGreeting(Locale locale) {
        if (Locale.GERMAN == locale) {
            return "Hallo";
        }

        if (Locale.ENGLISH == locale) {
            return "Hello";
        }

        if (Locale.FRANCE == locale) {
            return "Bonjour";
        }

        throw new IllegalArgumentException("Language not supported");
    }
}