class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char source = s.charAt(i);
            char target = t.charAt(i);

            // Check s -> t mapping
            if (sToT.containsKey(source)) {
                if (sToT.get(source) != target) {
                    return false;
                }
            } else {
                sToT.put(source, target);
            }

            // Check t -> s mapping
            if (tToS.containsKey(target)) {
                if (tToS.get(target) != source) {
                    return false;
                }
            } else {
                tToS.put(target, source);
            }
        }

        return true;
    }
}