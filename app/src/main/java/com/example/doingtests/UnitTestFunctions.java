package com.example.doingtests;

import java.util.ArrayList;
import java.util.List;

public class UnitTestFunctions {
    public List<String> filterRates(List<String> allRates, String query) {  // filtravimo funkcija
        if (query == null || query.isEmpty()) return allRates;

        List<String> result = new ArrayList<>();
        for (String rate : allRates) {
            if (rate.toLowerCase().contains(query.toLowerCase())) {
                result.add(rate);
            }
        }
        return result;
    }
    public double extractRateValue(String rateString) {  // parsinimas "USD = 1.2" i skaiciu
        try {
            String[] parts = rateString.split("=");
            return Double.parseDouble(parts[1].trim());
        } catch (Exception e) {
            return -1;
        }
    }
    public String detectFormat(String url) {     // tikrinimas ar nuoroda yra xml ar json
        if (url.endsWith(".xml")) return "XML";
        if (url.endsWith(".json")) return "JSON";
        return "UNKNOWN";
    }
}
