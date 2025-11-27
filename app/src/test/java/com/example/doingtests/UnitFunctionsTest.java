package com.example.doingtests;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UnitFunctionsTest {

    // testai susije su 5 praktiniu darbu

    @Test
    public void GivenFilterCalledWithUsd_WhenExecuted_ShouldReturnOneItem() {
        UnitTestFunctions utils = new UnitTestFunctions();

        List<String> allRates = Arrays.asList(
                "USD = 1.0",
                "EUR = 0.9",
                "JPY = 160.0"
        );

        List<String> expectedResult = Arrays.asList("USD = 1.0");

        List<String> actualResult = utils.filterRates(allRates, "usd");

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void GivenValidRateString_WhenExtracted_ShouldReturnNumber() {
        UnitTestFunctions utils = new UnitTestFunctions();

        double expectedResult = 1.25;
        double actualResult = utils.extractRateValue("USD = 1.25");

        assertEquals(expectedResult, actualResult, 0.001);
    }


    @Test
    public void GivenInvalidRateString_WhenExtracted_ShouldReturnMinusOne() {
        UnitTestFunctions utils = new UnitTestFunctions();

        double expectedResult = -1;
        double actualResult = utils.extractRateValue("BROKEN STRING");

        assertEquals(expectedResult, actualResult, 0.001);
    }


    @Test
    public void GivenXmlUrl_WhenDetected_ShouldReturnXml() {
        UnitTestFunctions utils = new UnitTestFunctions();

        String expectedResult = "XML";
        String actualResult = utils.detectFormat("https://example.com/data.xml");

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void GivenJsonUrl_WhenDetected_ShouldReturnJson() {
        UnitTestFunctions utils = new UnitTestFunctions();

        String expectedResult = "JSON";
        String actualResult = utils.detectFormat("https://example.com/api.json");

        assertEquals(expectedResult, actualResult);
    }
}
