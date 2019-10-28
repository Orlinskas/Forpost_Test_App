package com.orlinskas.ForpostTestApp.request;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class RequestURLGeneratorTest {
    private String expectedURL;
    private Request request;

    @Before
    public void setUp() {
        expectedURL = "https://randomuser.me/api/?results=20";
        request = new Request();
    }

    @Test
    public void generate() {
        RequestURLGenerator urlGenerator = new RequestURLGenerator();
        String actualURL = urlGenerator.generate(request).toString();
        assertEquals(expectedURL, actualURL);
    }
}

