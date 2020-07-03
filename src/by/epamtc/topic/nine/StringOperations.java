package by.epamtc.topic.nine;

import java.math.BigInteger;

public class StringOperations {

    public static final String LOWERCASE_LETTERS = "[a-z]";
    public static final String UPPERCASE_LETTERS = "[A-Z]";
    public static final String DELIMITER_BY_WORDS = "[^A-Za-zА-Яа-я]+";
    public static final String WHITESPACES = "\\s";
    public static final String EXTRA_SPACES = "\\s{2,}";

    public static void main(String[] args) {

        EvenOddPair pair = splitEvenOddChars("WHoerllldo");
        System.out.println("Even: " + pair.getEven() + " odd: " + pair.getOdd());

        System.out.println(percentageLowerUppercase("CaC"));

        System.out.println(deleteDuplicateChars("AaCdACdCdA"));

        System.out.println(calcCharsQuantity("epamtc@gmail.com", '@'));

        System.out.println(reverseString("нофелет"));

        System.out.println(insertSubstring("Привет, ", "мир!", 8));

        System.out.println(deleteSubstring("Можно принести с собой только воду", "только"));

        System.out.println(copyStringPart("epamtc@gmail.com", 0, 6));

        printWordsInReverse("Andrew is policemen");

        System.out.println(countSubstringQuantity("you can do anything you want", "you"));

        System.out.println(replaceWhitespaces("Another test \n\tstring"));

        System.out.println(replaceLongestWordChars("Wanna buy your alouse"));

        System.out.println(calcShortestWordLength("No one likes to fall"));

        System.out.println(countWordsPerString("Five words in this string"));

        System.out.println(swapWords("дорогу осилит идущий"));

        System.out.println(deleteLastWord("Delete last word"));

        System.out.println(addWhitespaces("FBI"));

        System.out.println(isPalindrome("шалаш"));
        System.out.println(isPalindrome("bounce"));

        System.out.println(replaceSubstring("Currently we are looking for operators",
                "operators", "security guard"));

        System.out.println(sumOfLargeIntegers("12000000000000000000000000", "63800000000000000000000000"));

        System.out.println(deleteWordsPerLength("We are champions here", 4));

        System.out.println(removeExtraSpaces("   thanks     a  lot "));

    }

    public static EvenOddPair splitEvenOddChars(String source) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            if (i % 2 != 0) {
                even.append(source.charAt(i));
            } else {
                odd.append(source.charAt(i));
            }
        }

        return new EvenOddPair(even.toString(), odd.toString());
    }

    public static double percentageLowerUppercase(String source) {
        String lowercaseRemoved = source.replaceAll(LOWERCASE_LETTERS, "");
        String uppercaseRemoved = source.replaceAll(UPPERCASE_LETTERS, "");

        double lowercaseCount = source.length() - lowercaseRemoved.length();
        double uppercaseCount = source.length() - uppercaseRemoved.length();

        return (lowercaseCount / uppercaseCount) * 100;
    }

    public static String deleteDuplicateChars(String original) {
        StringBuilder uniqueChars = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            char originChar = original.charAt(i);

            int indexInUnique = uniqueChars.toString().indexOf(originChar);
            if (indexInUnique < 0) {
                uniqueChars.append(originChar);
            }
        }

        return uniqueChars.toString();
    }

    public static int calcCharsQuantity(String source, char neededChar) {
        String ch = Character.toString(neededChar);
        String charsReplaced = source.replace(ch, "");

        return source.length() - charsReplaced.length();
    }

    public static String reverseString(String original) {
        StringBuilder reversed = new StringBuilder(original).reverse();
        return reversed.toString();
    }

    public static String insertSubstring(String original, String insertion, int offset) {
        StringBuilder insertionAdded = new StringBuilder(original);
        insertionAdded.insert(offset, insertion);

        return insertionAdded.toString();
    }

    public static String deleteSubstring(String original, String substring) {
        String result = original.replaceAll(substring, "");
        result = removeExtraSpaces(result);
        return result;
    }

    public static String copyStringPart(String source, int from, int to) {
        return source.substring(from, to);
    }

    public static int calcStringLength(String source) {
        return source.length();
    }

    public static int countSubstringQuantity(String source, String stringPart) {
        int substringLength = stringPart.length();
        if (substringLength == 0) {
            return -1;
        }

        String substringRemoved = source.replaceAll(stringPart, "");

        return (source.length() - substringRemoved.length()) / substringLength;
    }

    public static void printWordsInReverse(String source) {
        String[] words = wordsFromString(source);

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }

    public static String replaceWhitespaces(String original) {
        return original.replaceAll(WHITESPACES, "*");
    }

    public static String replaceLongestWordChars(String original) {
        String[] words = wordsFromString(original);

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        String wordCharsReplaced = longestWord.replace('a', 'b');
        return original.replace(longestWord, wordCharsReplaced);
    }

    public static int calcShortestWordLength(String source) {
        String[] words = wordsFromString(source);
        if (words.length == 0) {
            return -1;
        }

        int shortestWordLength = words[0].length();
        for (String word : words) {
            if (word.length() < shortestWordLength) {
                shortestWordLength = word.length();
            }
        }

        return shortestWordLength;
    }

    public static int countWordsPerString(String source) {
        String[] words = wordsFromString(source);
        return words.length;
    }

    public static String swapWords(String original) {
        String[] words = wordsFromString(original);
        int wordsCount = words.length;
        if (wordsCount == 0) {
            return original;
        }

        String tmp = words[0];
        words[0] = words[wordsCount - 1];
        words[wordsCount - 1] = tmp;

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }

        return sb.toString();
    }

    public static String deleteLastWord(String original) {
        original = original.trim();
        return original.substring(0, original.lastIndexOf(" "));
    }

    public static String addWhitespaces(String original) {
        StringBuilder result = new StringBuilder();

        for (Character c : original.toCharArray()) {
            result.append(c).append(" ");
        }
        return result.toString().trim();
    }

    public static boolean isPalindrome(String source) {
        source = source.trim();

        StringBuilder sb = new StringBuilder(source);
        String reversed = sb.reverse().toString();

        return reversed.equals(source);
    }

    public static String replaceSubstring(String original, String stringPart, String replacement) {
        return original.replaceAll(stringPart, replacement);
    }

    public static BigInteger sumOfLargeIntegers(String firstTerm, String secondTerm) {
        BigInteger sum = new BigInteger(firstTerm);
        sum = sum.add(new BigInteger(secondTerm));

        return sum;
    }

    public static String deleteWordsPerLength(String original, int givenLength) {
        String[] words = wordsFromString(original);

        for (String word : words) {
            if (word.length() == givenLength) {
                original = original.replace(word, "");
            }
        }

        return original;
    }

    public static String removeExtraSpaces(String original) {
        return original.replaceAll(EXTRA_SPACES, " ").trim();
    }

    public static String[] wordsFromString(String source) {
        return source.trim().split(DELIMITER_BY_WORDS);
    }

}
