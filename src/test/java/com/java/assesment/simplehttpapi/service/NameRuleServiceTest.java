package com.java.assesment.simplehttpapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameRuleServiceTest {

    private final NameRuleService service = new NameRuleService();

    @Test
    public void shouldReturnTrueWhenNameStartsWithAtoM() {
        assertTrue(service.isValidName("alice"));
        assertTrue(service.isValidName("Bob"));
        assertTrue(service.isValidName("mike"));
    }

    @Test
    public void shouldReturnFalseWhenNameStartsWithNtoZ() {
        assertFalse(service.isValidName("nathan"));
        assertFalse(service.isValidName("Zack"));
    }

    @Test
    public void shouldReturnFalseWhenNameIsNullOrBlank() {
        assertFalse(service.isValidName(null));
        assertFalse(service.isValidName(""));
        assertFalse(service.isValidName("   "));
    }

    @Test
    public void shouldReturnFalseWhenNameStartsWithNonLetter() {
        assertFalse(service.isValidName("1alice"));
        assertFalse(service.isValidName("_bob"));
        assertFalse(service.isValidName("-test"));
    }

    @Test
    public void shouldReturnFalseWhenNameStartsWithNonEnglishLetter() {
        assertFalse(service.isValidName("1alice"));
        assertFalse(service.isValidName("_bob"));
        assertFalse(service.isValidName("李"));
        assertFalse(service.isValidName("Γιώργος"));
        assertFalse(service.isValidName(" Äzam"));
        assertFalse(service.isValidName("éclair"));
    }

    @Test
    public void shouldTrimWhitespaceBeforeValidation() {
        assertTrue(service.isValidName("   alice"));
        assertFalse(service.isValidName("   zed"));
    }

    @Test
    public void shouldBuildGreetingWithCapitalizedFirstLetter() {
        String result = service.buildGreeting("alice");
        assertEquals("Hello Alice", result);
    }

    @Test
    public void shouldBuildGreetingAfterTrimmingInput() {
        String result = service.buildGreeting("   bob");
        assertEquals("Hello Bob", result);
    }
}