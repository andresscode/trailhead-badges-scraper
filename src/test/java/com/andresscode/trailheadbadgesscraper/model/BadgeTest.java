package com.andresscode.trailheadbadgesscraper.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadgeTest {
    @Test
    public void gettersTest() {
        Badge badge = new Badge("Type", "Name", "http://type/name");
        String expectedType = "Type";
        String expectedName = "Name";
        String expectedHref = "http://type/name";
        assertEquals(expectedType, badge.getType());
        assertEquals(expectedName, badge.getName());
        assertEquals(expectedHref, badge.getHref());
    }
}
