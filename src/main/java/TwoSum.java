import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] numsToAdd, int target){
        int[] finalArray = new int[2];
        for(int i = 0; i< numsToAdd.length;i++){
            for (int j = i+1; j < (numsToAdd.length ) ; j++) {
                if(numsToAdd[i] + numsToAdd[j] == target) {
                    finalArray[0] = i;
                    finalArray[1] = j;
                    break;
                }
            }
        }

        return finalArray;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numsToAdd = {3,2,4};
        int target = 6;
        int[] twoSumArray = twoSum.twoSum(numsToAdd, target);
        System.out.println("To get sum value, " + target+  " from the array: " + Arrays.toString(numsToAdd) + " add the value of positions: " +  Arrays.toString(twoSumArray));
    }
}
