
import ua.lviv.iot.Solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int distance = 2;
        List<Integer> list = Arrays.asList(3, 3, 3);

        Solution solution = new Solution(distance, list);
        System.out.println(solution.findTheWorstCase());
    }
}