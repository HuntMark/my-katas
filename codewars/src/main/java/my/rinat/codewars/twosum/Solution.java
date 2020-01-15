package my.rinat.codewars.twosum;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((i != j) && (numbers[i] + numbers[j] == target)) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("Two sum elements not found");
    }
}