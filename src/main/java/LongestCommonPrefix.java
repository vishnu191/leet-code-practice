public class LongestCommonPrefix {
   //String[] strArrayStatic ={"flower","flow","flight"};
  // String[] strArrayStatic ={"flower","","flow"};
   // String[] strArrayStatic ={"baab","bacb","b","cbc"};
     String[] strArrayStatic ={"flower","flow","flight","flew"};
   // String[] strArrayStatic ={"a","a","b"};
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String strArray[] = lcp.strArrayStatic;
        String commonPrefix = lcp.longestCommonPrefix(strArray);
       // System.out.println(commonPrefix);
    }

    public  String longestCommonPrefix(String[] strArray) {
        int strArrayLength = strArray.length;
        String[] strArray2 = {};
        StringBuffer buf = new StringBuffer();
        for(int i = 0 ;i < strArrayLength; i++) {
           if(buf.toString().indexOf("|") >= 0) {
               strArray2 = buf.toString().substring(1).split("\\|");
               strArray = strArray2;
               buf.delete(0,buf.length());
           }
           if(i ==0  || strArray.length >1) {

               invokeLCP(strArray,buf);
           } else if(strArray.length == 1 && !"".equalsIgnoreCase(strArray[0])){
              // System.out.println("Common String found is: " + strArray[0]);
               return strArray[0];
           } else {
              // System.out.println("No common Prefix found for the Array of Strings provided");
               return strArray[0];
           }
        }

    return strArray[0];
    }


    private void  invokeLCP(String[] strArray, StringBuffer buf) {
        boolean matchfound = false;
        boolean isFirstTimeInLoop2 = true;
        buf.append("|") ;
        char[] firstCharArray = strArray[0].toCharArray();
        loop1: for(int i = 1; i< strArray.length ; i++) {
             if(matchfound) {
                 buf.append("|") ;
             }
             loop2: for(int j = 0; j< firstCharArray.length; j++) {
                 if("".equalsIgnoreCase(strArray[i])) {
                     buf.delete(1,buf.length());
                     break loop1;
                 }
                 char[] innerCharArray = strArray[i].toCharArray();

                loop3: for(int k = j; k < innerCharArray.length;k++ ) {
                    // if(Character.toString(charStringArray[j]).indexOf() )
                    if(firstCharArray[j] == innerCharArray[k]) {
                        //for the first time, and there is a match add it to the buffer
                        //subsequent loops of k, check the first value in the buffer and compare if they are equal
                        if(i== 1 || !isFirstTimeInLoop2) {
                            buf.append(firstCharArray[j]);
                            matchfound = true;
//                            System.out.println(firstCharArray[j]);
                            isFirstTimeInLoop2 = false;
                            break loop3;
                        }
                    } else if (k ==0 && !buf.toString().equals("|")) {
                        //remove the alphabet
                        buf.delete(1,buf.length());
                        break loop1;
                    } else {
                        break loop2;
                    }

                 }
             }

         }
      //  System.out.println(buf.toString());
    }
}
