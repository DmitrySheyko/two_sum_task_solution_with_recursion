import java.util.Arrays;

/**
 * {@link Main} class. Responsible for sending of array and target value to class {@link Solution}.
 *
 * @author DmitrySheyko
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{-4, -2, 0, 2, 5, 6,}, 3);
        System.out.println(Arrays.toString(result));
    }

}