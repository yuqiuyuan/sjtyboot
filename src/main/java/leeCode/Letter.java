package leeCode;

import java.util.*;

public class Letter {
    public List<String> letterCombinations(String digits) {
        List<String> r = new LinkedList<>();
        Map<Character, String> numLetter = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        for (int i = 0; i < digits.length(); i++) {
            String c = numLetter.get(digits.charAt(i));
            List<String> c_r;
            if (r.isEmpty()) {
                for (int j = 0; j < c.length(); j++) {
                    r.add(c.charAt(j) + "");
                }
            } else {
                c_r = new LinkedList<>();
                for (int j = 0; j < c.length(); j++) {
                    for (String e : r) {
                        c_r.add(e + c.charAt(j));
                    }
                }
                r = c_r;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Letter l = new Letter();
        System.out.println(l.letterCombinations("29852"));
    }
}
