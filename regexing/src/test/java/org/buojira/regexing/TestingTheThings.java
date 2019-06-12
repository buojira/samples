package org.buojira.regexing;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class TestingTheThings {

    private final String text =
            "A thing I want is to find something, or anything. I do not really care, but I do no want go with nothing at hand.";

    @Test
    public void testingWithW() {
        System.out.println("\nTesting with [\\w]+thing");

        Pattern pattern = Pattern.compile("[\\w]+thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals("something", result.get(0));
        assertEquals("anything", result.get(1));
        assertEquals("nothing", result.get(2));
    }

    @Test
    public void testingWithazAZ() {
        System.out.println("\nTesting with [a-zA-Z_]+thing");

        Pattern pattern = Pattern.compile("[a-zA-Z_]+thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals("something", result.get(0));
        assertEquals("anything", result.get(1));
        assertEquals("nothing", result.get(2));
    }

    @Test
    public void testingWithOptionalOperator() {
        System.out.println("\nTesting with [\\w]*thing");

        Pattern pattern = Pattern.compile("[\\w]*thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(4, result.size());
        assertEquals("thing", result.get(0));
        assertEquals("something", result.get(1));
        assertEquals("anything", result.get(2));
        assertEquals("nothing", result.get(3));
    }

    @Test
    public void testingWithoutOperator() {
        System.out.println("\nTesting with [\\w]thing");

        Pattern pattern = Pattern.compile("[\\w]thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals("ething", result.get(0));
        assertEquals("ything", result.get(1));
        assertEquals("othing", result.get(2));
    }

    @Test
    public void testingWith2Characters() {
        System.out.println("\nTesting with [\\w]{2}thing");

        Pattern pattern = Pattern.compile("[\\w]{2}thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals("mething", result.get(0));
        assertEquals("nything", result.get(1));
        assertEquals("nothing", result.get(2));
    }

    @Test
    public void testingWith3OrMoreCharacters() {
        System.out.println("\nTesting with [\\w]{3,}thing");

        Pattern pattern = Pattern.compile("[\\w]{3,}thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(2, result.size());
        assertEquals("something", result.get(0));
        assertEquals("anything", result.get(1));
    }

    @Test
    public void testingWith1Until3Characters() {
        System.out.println("\nTesting with [\\w]{1,3}thing");

        Pattern pattern = Pattern.compile("[\\w]{1,3}thing");
        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals("omething", result.get(0));
        assertEquals("anything", result.get(1));
        assertEquals("nothing", result.get(2));
    }

    @Test
    public void testingWithFullWords() {

        Pattern pattern = Pattern.compile("\\W[\\w]{1,3}thing");
        System.out.println("\nTesting with " + pattern.pattern());

        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(2, result.size());
        assertEquals(" anything", result.get(0));
        assertEquals(" nothing", result.get(1));
    }

    @Test
    public void testingWithFullWordsVariation() {

        Pattern pattern = Pattern.compile("\\s[\\w]{1,3}thing");
        System.out.println("\nTesting with " + pattern.pattern());

        Matcher matcher = pattern.matcher(text);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(2, result.size());
        assertEquals(" anything", result.get(0));
        assertEquals(" nothing", result.get(1));
    }

    @Test
    public void testingWhenTheLinesStartsWithTargetWordButNotWorking() {

        Pattern pattern = Pattern.compile("\\W+[\\w]{1,3}thing");
        System.out.println("\nTesting with " + pattern.pattern());

        String newTestText = "Nothing " + text;
        Matcher matcher = pattern.matcher(newTestText);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(2, result.size());
        assertEquals(" anything", result.get(0));
        assertEquals(" nothing", result.get(1));
    }

    @Test
    public void testingWhenTheLinesStartsWithTargetWordNowWithALittleHelp() {

        Pattern pattern = Pattern.compile("\\W+[\\w]{1,3}thing");
        System.out.println("\nTesting with " + pattern.pattern());

        String newTestText = "Nothing " + text;
        Matcher matcher = pattern.matcher(" " + newTestText);

        List<String> result = new ArrayList<String>();

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Found " + match);
            result.add(match);
        }

        assertEquals(3, result.size());
        assertEquals(" Nothing", result.get(0));
        assertEquals(" anything", result.get(1));
        assertEquals(" nothing", result.get(2));
    }


}
