package com.andresscode.trailheadbadgesscraper.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularBadgeTest {
    private float delta;
    private RegularBadge minute;
    private RegularBadge minutes;
    private RegularBadge hour;
    private RegularBadge hours;
    private RegularBadge hourAndMinute;
    private RegularBadge hourAndMinutes;
    private RegularBadge hoursAndMinute;
    private RegularBadge hoursAndMinutes;

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

    @Before
    public void setup() {
        delta = 0.01f;

        String type = "Type";
        String name = "Name";
        String href = "http://type/name";

        minute = new RegularBadge(type, name, href, "1 min");
        minutes = new RegularBadge(type, name, href, "10 mins");
        hour = new RegularBadge(type, name, href, "1 hr");
        hours = new RegularBadge(type, name, href, "10 hrs");
        hourAndMinute = new RegularBadge(type, name, href, "1 hr 1 min");
        hourAndMinutes = new RegularBadge(type, name, href, "1 hr 10 mins");
        hoursAndMinute = new RegularBadge(type, name, href, "10 hrs 1 min");
        hoursAndMinutes = new RegularBadge(type, name, href, "10 hrs 10 mins");
    }
}
