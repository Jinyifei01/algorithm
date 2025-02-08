package leetcode;

import java.util.HashMap;

public class problem2_6 {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }
    //方法二
    public String minWindow2(String s, String t) {
        int resx=0,resy=s.length()-1;
        boolean flag=false;
        char[] schr=s.toCharArray();
        int n=schr.length;int tn=t.length();
        int[] differ=new int[128];
        for(char c: t.toCharArray()){
            differ[c]--;
        }
        int cnt=0;
        int left=0;
        for(int i=0;i<n;i++){
            char c=schr[i];
            if(differ[c]<0) cnt++;
            differ[c]++;
            while(cnt==tn){
                flag=true;
                if(resy-resx>i-left){
                    resx=left;
                    resy=i;
                }
                differ[schr[left]]--;
                if(differ[schr[left]]<0){
                    cnt--;
                }
                left++;
            }
        }
        return flag?  s.substring(resx,resy+1): "";

    }


    //方法一
    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) return "";
        HashMap<Character, Integer> map_t = new HashMap<>();
        HashMap<Character, Integer> map_s = new HashMap<>();
        for (char c : t.toCharArray()) {
            map_t.put(c, map_t.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        int min_start = 0;
        int check = map_t.size();
        while (end < s.length()) {

           if (map_t.containsKey(s.charAt(end))) {
               map_s.put(s.charAt(end), map_s.getOrDefault(s.charAt(end), 0) + 1);
               //equals与等号的差异
               if (map_t.get(s.charAt(end)).equals(map_s.get(s.charAt(end)))  ) {
                   check--;
               }
           }
           end++;
           while (check == 0) {
               if (end-start < min) {
                   min =  end - start;
                   min_start = start;
               }

               if(map_t.containsKey(s.charAt(start))){

                   map_s.put(s.charAt(start), map_s.get(s.charAt(start)) - 1);
                   if (map_s.get(s.charAt(start)) < map_t.get(s.charAt(start))) check++;
               }
               start++;
           }



        }
        return min == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min);
    }

}
