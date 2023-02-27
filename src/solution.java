import java.util.Arrays;

/**
 * This class responsible for searching of two indexes of array. Sum of values of these indexes should be equal to target value.
 * For searching used recursive method recursiveSumSearch().
 * In the case if the array doesn't consist indexes that sum will be equal the target value, method twoSum() will return [-1, -1];
 *
 * @author DmitrySheyko
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int sumSearchResult;
        for (int i = 0; i < sortedNums.length; i++) {
            sumSearchResult = recursiveSumSearch(sortedNums, sortedNums[i], i + 1, sortedNums.length - 1, target);
            if (sumSearchResult != -1) {
                int[] result = new int[2];
                boolean isResult0Done = false;
                boolean isResult1Done = false;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == sortedNums[i] && !isResult0Done) {
                        result[0] = j;
                        isResult0Done = true;
                        continue;
                    }
                    if (nums[j] == sortedNums[sumSearchResult] && !isResult1Done) {
                        result[1] = j;
                        isResult1Done = true;
                    }
                }
                return result;
            }
        }
        return new int[]{-1, -1};

    }
    public int recursiveSumSearch(int[] nums, int firstElt, int startIndex, int endIndex, int target) {
        if (endIndex <= startIndex) {
            if ((firstElt + nums[endIndex]) == target) {
                return endIndex;
            } else {
                return -1;
            }
        }
        int middleIndex = endIndex - ((endIndex - startIndex) / 2);
        if ((firstElt + nums[middleIndex]) == target) {
            return middleIndex;
        } else if (firstElt + nums[middleIndex] > target) {
            return recursiveSumSearch(nums, firstElt, startIndex, middleIndex-1, target);
        } else if (firstElt + nums[middleIndex] < target) {
            return recursiveSumSearch(nums, firstElt, middleIndex+1, endIndex, target);
        }
        return -1;
    }

}
