package com.wfz.primary;

import java.util.HashMap;

public class WordSpelling {
    /*

    拼写单词

    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

    假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

    注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。

    返回词汇表 words 中你掌握的所有单词的 长度之和。

    输入：words = ["cat","bt","hat","tree"], chars = "atach"
    输出：6
    解释：
    可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。

    输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    输出：10
    解释：
    可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。

    W思路分析
    1. 将字母表都放到hashmap里，且key为char，value为字母个数（getOrDefault(c,0)）;
    2. 将每个world单词，都放到hashmap里，且key为char，value为字母个数（getOrDefault(c,0)）;
    3. 俩个hashmap进行比较时，可以使用value的大小来比较，同时value的值记录了char个数，若个数不够，则不能拼成world；


     */

    public static void main(String[] args) {

//        String[] words = new String[]{"cat", "bt", "hat", "tree"};
//
//        String chars = "atach";

        String[] words = new String[]{"hello","world","leetcode"};

        String chars = "welldonehoneyr";



//        HashMap<Character, Integer> charsMap = new HashMap<>();
//        for (int i = 0; i < chars.length(); i++) {
//            char c = chars.charAt(i);
//            charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
//        }
//
//        System.out.println(charsMap.getOrDefault('a', 0));

        System.out.println(wordSpelling(words, chars));


    }

    private static int wordSpelling(String[] words, String chars) {

        HashMap<Character, Integer> charsMap = new HashMap<>();

        int result = 0;

        for (char c : chars.toCharArray()) {
            //此处比较巧妙，在map的value的位置放置char字母出现的次数
            charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {

            boolean flag = true;

            HashMap<Character, Integer> wordMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                //此处比较巧妙，在map的value的位置放置char字母出现的次数
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
            }


            for (Character character : wordMap.keySet()) {

                if (wordMap.getOrDefault(character, 0) > charsMap.getOrDefault(character, 0)) {
                    flag = false;
                    break;
                }

            }

            if (flag) {

                result = result + word.length();
            }
        }

        return result;
    }
}
