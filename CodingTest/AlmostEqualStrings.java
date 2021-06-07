package CodingTest;

import java.util.*;
import java.lang.Math;

class AlmostEqualStrings {
    public static void main(String[] args) {

        List<String> s = new ArrayList<>();
        List<String> t = new ArrayList<>();
        s.add("dddd");
        t.add("klmn");
        List<String> result = almost(s, t);

        System.out.println(result);
    }

    public static List<String> almost(List<String> s, List<String> t) {

        List<String> result = new ArrayList<>();

        for (int idx = 0; idx < s.size(); idx++) {
            String[] sArray = (s.get(idx)).split("");
            String[] tArray = (t.get(idx)).split("");
            Map<String, Integer> aMap = new HashMap<>();
            for (int i = 0; i < sArray.length; i++) {
                if (!aMap.containsKey(sArray[i])) {
                    aMap.put(sArray[i], 1);
                } else {
                    aMap.put(sArray[i], ((int) aMap.get(sArray[i])) + 1);
                }
            }
            for (int i = 0; i < tArray.length; i++) {
                if (!aMap.containsKey(tArray[i])) {
                    aMap.put(tArray[i], -1);
                } else {
                    aMap.put(tArray[i], ((int) aMap.get(tArray[i])) - 1);
                }
            }
            // System.out.println(aMap);
            boolean isVaL = false;
            Iterator entries = aMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();

                int val = Math.abs((Integer) entry.getValue());
                if (val >= 4) {
                    result.add("NO");
                    isVaL = true;
                    break;
                }
            }
            if (!isVaL) {
                result.add("YES");
            }
        }
        return result;
    }
}