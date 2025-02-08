package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem2_3 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        List<Integer> list = findAnagrams(s, p);
        //List<Integer> list1 = findAnagrams2(s, p);

        System.out.println(list);
    }

    private static List<Integer> findAnagrams2(String s, String p) {
        //使用一个字符数组，记录两个字符串之间的差异，全为0时说明两个字符串完全一样
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    //方法一 使用字符频数法的滑动窗口
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<Integer>();
        if(p.length()>s.length()){
            return list;
        }

        int [] char_p = new int[26];
        int [] char_t = new int[26];
        for(char c : p.toCharArray()) {
            char_p[c - 'a']++;
        }
        //System.out.println(Arrays.toString(char_p));
        for(int i = 0 ; i < p.length() ; i++) {
            char_t[s.charAt(i) - 'a']++;
        }
        //System.out.println(Arrays.toString(char_t));
        if (Arrays.equals(char_p, char_t)) {
            list.add(0);
        }
        for(int i = 0 ; i +p.length()< s.length() ; i++) {
            char_t[s.charAt(i+p.length()) - 'a']++;
            char_t[s.charAt(i) - 'a']--;
            if(Arrays.equals(char_p, char_t)) {
                list.add(i+1);
            }
        }
        return list;
    }

}
