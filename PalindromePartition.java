/*
 * File: PalindromePartition.java
 * Project: abhijeet
 * Created Date: Wednesday, 17th February 2021 1:24:58 pm
 * -----
 * Code by: Abhijeet Suryawanshi
 * Student Number: 19370773
 * -----
 * Modified By: Abhijeet Suryawanshi
 * Date Modified: Wednesday, 17th February 2021 6:04 pm
 */

import java.util.*;

class PalindromePartition {

    public static List<List<String>> partition(String s) {
        
        List<List<String>> palindromesList = new ArrayList<List<String>>();
        List<String> decompositionList = new ArrayList<String>();

        decomposeString(s, 0, palindromesList, decompositionList);
        
        return palindromesList;
    }

    public static void decomposeString(String s, int currentChar, List<List<String>> palindromesList, List<String> decompositionList) {

        if (currentChar == s.length()) {

            palindromesList.add(new ArrayList<String>(decompositionList));
        }

        for (int i = currentChar; i < s.length(); i++) {

            if (isPalindrome(s, currentChar, i)) {

                decompositionList.add(s.substring(currentChar, i + 1));
                decomposeString(s, i + 1, palindromesList, decompositionList);
                decompositionList.remove(decompositionList.size() - 1);
            }
        }
    }
    
    public static boolean isPalindrome(String s, int startIndex, int endIndex) {
        
        while (startIndex < endIndex) {

            if (s.charAt(startIndex++) != s.charAt(endIndex--)) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aab";

        System.out.println(partition(s));
    }
}
