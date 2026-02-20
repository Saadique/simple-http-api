package com.java.assesment.simplehttpapi.service;

import org.springframework.stereotype.Service;

@Service
public class NameRuleService {

    public boolean isValidName(String name) {
        if (name == null) {
            return false;
        }

        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            return false;
        }

        char firstLetter = trimmedName.charAt(0);

        // Must start with an English letter A-Z/a-z
        if (!isEnglishLetter(firstLetter)) {
            return false;
        }

        // Valid only if firstLetter letter is A-M/a-m
        char upper = Character.toUpperCase(firstLetter);
        return upper >= 'A' && upper <= 'M';
    }

    private boolean isEnglishLetter(char firstLetter) {
        return (firstLetter >= 'A' && firstLetter <= 'Z') || (firstLetter >= 'a' && firstLetter <= 'z');
    }

    public String buildGreeting(String name) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            return trimmedName;
        }

        // Capitalize first letter
        char firstLetter = trimmedName.charAt(0);

        // Remaining characters after the first letter
        String remainingCharacters = trimmedName.substring(1);

        // Reconstructed name with capitalized first letter
        String formattedName = Character.toUpperCase(firstLetter) + remainingCharacters;

        return "Hello " + formattedName;
    }
}
