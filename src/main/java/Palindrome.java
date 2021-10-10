import java.util.Arrays;

public class Palindrome {
    public boolean isPalindrome(int numToCheck) {
        boolean isPartialPalindrome = false;
        //if the array is odd size, need to stop at middle digit length/2
        //if array is even size, then consider the middle and the before number
        int[] digits = Integer.toString(numToCheck).chars().map(c -> c-'0').toArray();
        boolean isArrayEven = (digits.length)%2 == 0 ;
        int arrayLength = digits.length-1;
        System.out.println(Arrays.toString(digits));

        process: for(int i=0 ; i <= arrayLength ; i++) {

            if (digits[i] == digits[arrayLength -i ]) {
                //first and last matched..
                isPartialPalindrome = true;
                if(!isArrayEven && i +1 == arrayLength/2) {
                    System.out.println("Odd array. Yes the number is Palindrome:: ");
                    //break;
                    return isPartialPalindrome;
                } else if(isArrayEven &&  i == arrayLength/2) {
                    if(digits[i] == digits[i+1]) {
                        System.out.println("Even array. Yes the number is Palindrome:: ");
                        //break;
                        return isPartialPalindrome;
                    }

                }

            } else {
                //if the corresponding end digits are not matching, waste of looping.
                isPartialPalindrome = false;
               // break;
                return isPartialPalindrome;
            }
        }
        return isPartialPalindrome;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

        int numToCheck = 212;


        System.out.println(palindrome.isPalindrome(numToCheck));
    }
}
