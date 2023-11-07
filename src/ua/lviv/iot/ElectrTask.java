package ua.lviv.iot;

import java.util.List;

public class ElectrTask {
    private final int distance;
    private final List<Integer> bolt;

    public ElectrTask(int distance, List<Integer> bolt) {
        this.distance = distance;
        this.bolt = bolt;
    }

    public float findTheWorstCase() {
        float length = 0;
        if (bolt.size() <= 50) {
            boolean isElementLimit = true;
            for (int i : bolt) {
                if (i < 1 || i > 100) {
                    isElementLimit = false;
                    break;
                }
            }
            if (isElementLimit) {
                boolean isLastWasChangedToOne = false;
                int index = 0;
                for (int i : bolt) {
                    index++;
                    if (index != bolt.size()) {
                        if (isLastWasChangedToOne) {
                            if (bolt.get(index) > 1) {
                                length += (float) Math.sqrt(Math.pow((bolt.get(index) - 1), 2) + Math.pow(distance, 2));
                            } else {
                                length += distance;
                            }
                            isLastWasChangedToOne = false;
                        } else {
                            float withNoChanges = (float) (Math.sqrt((Math.pow((bolt.get(index) - i), 2)) + Math.pow(distance, 2)));
                            float withChanges = (float) (Math.sqrt((Math.pow((1 - i), 2)) + Math.pow(distance, 2)));
                            if (withChanges > withNoChanges) {
                                isLastWasChangedToOne = true;
                                length += withChanges;
                            } else {
                                length += withNoChanges;
                            }
                        }
                    }
                }
            }
        }
        return length;
    }
}
