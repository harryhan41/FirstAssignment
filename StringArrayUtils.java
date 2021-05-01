import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        if(array == null || array.length <= 0){
            return null;
        }
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        if(array == null || array.length <= 1){
            return null;
        }
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        if(array == null || array.length <= 0){
            return null;
        }
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        if(array == null || array.length <= 1){
            return null;
        }
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        List<String> list = Arrays.asList(array);
        HashSet<String> set = new HashSet<>(list);
        return set.contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        String[] reverse = new String[array.length];
        for(int i = array.length-1; i >= 0; i--){
            reverse[array.length - i-1] = array[i];
        }
        return reverse;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        if(array == null || array.length <= 1){
            return true;
        }
        int i = 0, j = array.length - 1;
        while(i <= j){
            if(!array[i].equals(array[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        if(array == null || array.length <= 0){
            return false;
        }
        int[] freq = new int[26];
        for(String str : array){
            char[] chars = str.replaceAll("\\s", "").toLowerCase().toCharArray();
            for(char c : chars){
                freq[c - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        Map<String, Integer> map = new HashMap<>();
        for(String str: array){
            map.put(str, map.getOrDefault(str, 0)+1);
        }
//        map = list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return map.getOrDefault(value, 0);
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        List<String> list = new ArrayList<>();
        for(String str : array){
            if(!str.equals(valueToRemove)){
                list.add(str);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(!array[i].equals(array[j])){
                list.add(array[j]);
                j=i;
            }

            if(i == array.length - 1){
                list.add(array[i]);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(array[j])){
                sb.append(array[i]);
            }else {
                list.add(sb.toString());
                sb = new StringBuilder();
                sb.append(array[i]);
                j = i;
            }
        }

        list.add(sb.toString());
        return list.toArray(new String[0]);
    }


}
