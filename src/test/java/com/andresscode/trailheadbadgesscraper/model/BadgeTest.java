package com.andresscode.trailheadbadgesscraper.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadgeTest {
    private float delta;
    private Badge minute;
    private Badge minutes;
    private Badge hour;
    private Badge hours;
    private Badge hourAndMinute;
    private Badge hourAndMinutes;
    private Badge hoursAndMinute;
    private Badge hoursAndMinutes;

    @Test
    public void convertToHoursMinuteTest() {
        float expected = 0.02f;
        assertEquals(expected, minute.getHours(), delta);
    }

    @Test
    public void convertToHoursMinutesTest() {
        float expected = 0.17f;
        assertEquals(expected, minutes.getHours(), delta);
    }

    @Test
    public void convertToHoursHourTest() {
        float expected = 1.00f;
        assertEquals(expected, hour.getHours(), delta);
    }

    @Test
    public void convertToHoursHoursTest() {
        float expected = 10.00f;
        assertEquals(expected, hours.getHours(), delta);
    }

    @Test
    public void convertToHoursHourAndMinuteTest() {
        float expected = 1.02f;
        assertEquals(expected, hourAndMinute.getHours(), delta);
    }

    @Test
    public void convertToHoursHourAndMinutesTest() {
        float expected = 1.17f;
        assertEquals(expected, hourAndMinutes.getHours(), delta);
    }

    @Test
    public void convertToHoursHoursAndMinuteTest() {
        float expected = 10.02f;
        assertEquals(expected, hoursAndMinute.getHours(), delta);
    }

    @Test
    public void convertToHoursHoursAndMinutesTest() {
        float expected = 10.17f;
        assertEquals(expected, hoursAndMinutes.getHours(), delta);
    }

    @Test
    public void gettersTest() {
        String expectedType = "Type";
        String expectedName = "Name";
        String expectedHref = "http://type/name";
        assertEquals(expectedType, minute.getType());
        assertEquals(expectedName, minute.getName());
        assertEquals(expectedHref, minute.getHref());
    }

    @Before
    public void setup() {
        delta = 0.01f;

        String type = "Type";
        String name = "Name";
        String href = "http://type/name";

        minute = new Badge(type, name, href, "1 min");
        minutes = new Badge(type, name, href, "10 mins");
        hour = new Badge(type, name, href, "1 hr");
        hours = new Badge(type, name, href, "10 hrs");
        hourAndMinute = new Badge(type, name, href, "1 hr 1 min");
        hourAndMinutes = new Badge(type, name, href, "1 hr 10 mins");
        hoursAndMinute = new Badge(type, name, href, "10 hrs 1 min");
        hoursAndMinutes = new Badge(type, name, href, "10 hrs 10 mins");
    }
}
