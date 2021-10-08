import java.util.*;

public class RomanToInt {

    public int romanToInt(String roman) {
        char[] romanChars = roman.toCharArray();
        Integer updatedVal = new Integer(0);
        Integer prevValue = new Integer(0);
        Integer nextVal = new Integer(0);
        Map<String,Integer> romanToInt = new HashMap<String,Integer>();
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);
        for (int i=0; i<romanChars.length; i++ ) {
            String currentStr = Character.toString(romanChars[i]);
            Integer val = romanToInt.get(currentStr);
            System.out.println(romanChars[i] + ","  + val);
            if(prevValue > 0 && prevValue < val) {
                if(updatedVal == prevValue) {
                    updatedVal = val - prevValue;
                } else {
                    updatedVal =updatedVal +(val - prevValue);
                }

            } else if( prevValue >= val  ) {
                if(i < romanChars.length-1 ){
                  nextVal =  romanToInt.get(Character.toString(romanChars[i+1]));
                  if(nextVal > val) {
                      prevValue = val;
                      continue;
                  } else {
                      updatedVal = updatedVal + val;
                      prevValue = val;
                  }
                } else {
                    updatedVal = updatedVal + val;
                }
            } else {
                updatedVal = val;
                prevValue = val;
                continue;
            }
            prevValue = val;
        }
        System.out.println(Math.abs(updatedVal.intValue()));
        return updatedVal.intValue();
    }

    public static void main(String[] args) {
//        String romanNumber = "MCMXCIV";
        String romanNumber = "MCMXCIV";
        int intValue = 0;
        RomanToInt romanToInt = new RomanToInt();
        intValue = romanToInt.romanToInt(romanNumber);
        System.out.println("Roman Number: " + romanNumber+ " is converted to: " + intValue);
    }
}
