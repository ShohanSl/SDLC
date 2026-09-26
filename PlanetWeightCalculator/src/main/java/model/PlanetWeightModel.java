package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlanetWeightModel {
    private static final Map<String, Double> GRAVITY_FACTORS = new LinkedHashMap<>();

    static {
        GRAVITY_FACTORS.put("Меркурий", 0.38);
        GRAVITY_FACTORS.put("Венера", 0.91);
        GRAVITY_FACTORS.put("Луна", 0.166);
        GRAVITY_FACTORS.put("Марс", 0.38);
        GRAVITY_FACTORS.put("Юпитер", 2.34);
        GRAVITY_FACTORS.put("Сатурн", 1.06);
        GRAVITY_FACTORS.put("Уран", 0.92);
        GRAVITY_FACTORS.put("Нептун", 1.19);
        GRAVITY_FACTORS.put("Плутон", 0.06);
    }

    private final List<ModelObserver> observers = new ArrayList<>();
    private Double lastCalculatedWeight = null;

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void calculatePlanetaryWeights(double earthWeight) {
        this.lastCalculatedWeight = earthWeight;

        Map<String, Double> results = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : GRAVITY_FACTORS.entrySet()) {
            results.put(entry.getKey(), earthWeight * entry.getValue());
        }

        notifyObservers(earthWeight, results);
    }

    private void notifyObservers(double earthWeight, Map<String, Double> results) {
        for (ModelObserver observer : observers) {
            observer.onWeightCalculated(earthWeight, results);
        }
    }

    public Double getLastCalculatedWeight() {
        return lastCalculatedWeight;
    }
}