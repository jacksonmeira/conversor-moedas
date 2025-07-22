package com.projeto.conversormoedas.model;

import com.google.gson.JsonObject;
import java.util.Set;

public class Conversor {
    private final JsonObject rates;

    public Conversor(JsonObject rates) {
        this.rates = rates;
    }

    public Set<String> getMoedasSuportadas() {
        return rates.keySet();
    }

    public double converter(double valor, String from, String to) {
        double rateFrom = rates.get(from).getAsDouble();
        double rateTo   = rates.get(to).getAsDouble();
        return valor / rateFrom * rateTo;
    }
}