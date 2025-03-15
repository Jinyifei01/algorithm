package leetcode;

import java.util.ArrayList;


public class problem2_2 {
    public static void main(String[] args) {
        String str = "abc";
        int max=0;
        int count=0;

        ArrayList<Character> list = new ArrayList<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            list.clear();
            count=0;
            while (!list.contains(array[i+count])) {
                list.add(array[i+count]);
                count++;
                if (count + i > array.length-1 ) {
                    break;
                }

            }
            max=Math.max(max,count);
        }
        System.out.println(max);

    }

}
