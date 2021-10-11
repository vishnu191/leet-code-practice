
public class ValidParathensis {

    public boolean isValid(String s) {
        char[] iCharArray = s.toCharArray();
        char[] paranthesisArray = {'{', '}'};
        char[] curlyArray = {'(', ')'};
        char[] squareArray = {'[', ']'};
        String chars_NoMatch = "";

        if (iCharArray.length % 2 != 0) {
            System.out.println("String entered is not valid");
            return false;
        }
        int initCharLength = iCharArray.length;
        for (int i = 0; i < initCharLength; i++) {
            if (i == 0) {
                chars_NoMatch = matchStrings(iCharArray, paranthesisArray, curlyArray, squareArray);
              if  ("".equals(chars_NoMatch)) {
                  return true;
              }
            } else if (!"".equals(chars_NoMatch)) {
                    iCharArray = chars_NoMatch.toCharArray();
                    chars_NoMatch = matchStrings(iCharArray, paranthesisArray, curlyArray, squareArray);
                    if  ("".equals(chars_NoMatch)) {
                        return true;
                    }
            } else {
                return true;
            }

        }
        return false;
    }

    private String matchStrings(char[] iCharArray, char[] paranthesisArray, char[] curlyArray, char[] squareArray) {
        String chars_NoMatch = "";
        for(int i = 0; i< iCharArray.length ; i++) {
            if (iCharArray[i] == paranthesisArray[0] && i +1 < iCharArray.length && iCharArray[i + 1] == paranthesisArray[1]) {
                System.out.println("partial match! good start");
                //can i remove the matched elements in the array
                chars_NoMatch = chars_NoMatch + String.valueOf(iCharArray).substring(i+2);
                     break;
            } else if (i +1 <iCharArray.length && iCharArray[i] == curlyArray[0] && iCharArray[i + 1] == curlyArray[1]) {
                System.out.println("partial match! good start");
                chars_NoMatch = chars_NoMatch + String.valueOf(iCharArray).substring(i+2);
                break;
            } else if (i+1 <iCharArray.length && iCharArray[i] == squareArray[0] && iCharArray[i + 1] == squareArray[1]) {
                System.out.println("partial match! good start");
                chars_NoMatch = chars_NoMatch + String.valueOf(iCharArray).substring(i+2);
                break;
            } else {
                chars_NoMatch = chars_NoMatch + String.valueOf(iCharArray[i]);
            }
        }
        return chars_NoMatch;
    }

    public static void main(String[] args) {
        //String val = "[{()}]}}";
        String val = "[({(())}[()])]";
        ValidParathensis vp = new ValidParathensis();
        System.out.println("The provided String is Valid: " + vp.isValid(val));
    }
}
