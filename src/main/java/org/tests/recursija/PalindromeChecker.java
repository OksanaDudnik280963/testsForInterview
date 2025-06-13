package org.tests.recursija;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PalindromeChecker {
    public static final String IS_PALINDROME = " is a palindrome: ";

    public static boolean isPalindrome(String str) {
        // Base case: an empty string or a string with one character is a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Recursive case: check if the first and last characters are equal,
        // and recursively check if the substring between them is a palindrome
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);

        if (firstChar != lastChar) {
            return false;
        }

        String remainingSubstring = str.substring(1, str.length() - 1);
        return isPalindrome(remainingSubstring);
    }

    public static void main(String[] args) {
        String palindrome1 = "madam";
        boolean isPalindrome1 = isPalindrome(palindrome1);
        log.info(palindrome1 + IS_PALINDROME + isPalindrome1);

        String palindrome2 = "level";
        boolean isPalindrome2 = isPalindrome(palindrome2);
        log.info(palindrome2 + IS_PALINDROME + isPalindrome2);

        String notPalindrome = "java";
        boolean isPalindrome3 = isPalindrome(notPalindrome);
        log.info(notPalindrome + IS_PALINDROME + isPalindrome3);
    }
}
