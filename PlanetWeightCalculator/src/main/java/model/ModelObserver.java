package model;

import java.util.Map;

public interface ModelObserver {
    void onWeightCalculated(double earthWeight, Map<String, Double> planetWeights);
}