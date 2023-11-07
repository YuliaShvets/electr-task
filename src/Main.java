
import ua.lviv.iot.ElectrTask;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int distance = 2;
        List<Integer> list = Arrays.asList(3, 3, 3);

        ElectrTask electrTask = new ElectrTask(distance, list);
        System.out.println(electrTask.findTheWorstCase());
    }
}
