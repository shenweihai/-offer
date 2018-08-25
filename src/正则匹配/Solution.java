package 正则匹配;

/**
 * 1.str到尾&&pattern到尾，return true
 * 2.str没到尾&&pattern到尾，return false
 * 3.当前位的下一位为'*'
 *   看当前位是否匹配，匹配则有三种情况，匹配0个、匹配1个、匹配n个
 *   不匹配则相当于匹配0个，strIndex不变，patternIndex+2
 * 4.当前位的下一位不为'*'
 *   当前位是否匹配，匹配则strIndex++，patternIndex++
 *   不匹配则return false
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return matchCurrent(str, 0, pattern, 0);
    }

    private boolean matchCurrent(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //如果当前位的下一位为'*'
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && isMatch(str[strIndex], pattern[patternIndex])) {
                return matchCurrent(str, strIndex, pattern, patternIndex + 2) ||
                        matchCurrent(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCurrent(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCurrent(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //如果当前位的下一位不为'*'
        if (strIndex != str.length && isMatch(str[strIndex], pattern[patternIndex])) {
            return matchCurrent(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    private boolean isMatch(char str, char pattern) {
        return str == pattern || pattern == '.';
    }
    /*public boolean matchCurrent(char[] str, int i, char[] pattern, int j) {
        if (str.length - i == 0 && pattern.length - j == 0) {
            return true;
        } else if (str.length - i != 0 && pattern.length - j == 0) {
            return false;
        } else {
            if (j < pattern.length - 1 && pattern[j + 1] == '*') {
                if (i <= str.length - 1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return matchCurrent(str, i, pattern, j + 2) || matchCurrent(str, i + 1, pattern, j);
                } else {
                    return matchCurrent(str, i, pattern, j + 2);
                }
            } else {
                if (i <= str.length - 1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return matchCurrent(str, i + 1, pattern, j + 1);
                } else {
                    return false;
                }
            }
        }
    }*/

    public static void main(String[] s) {
        System.out.println(new Solution().match(new char[]{}, new char[]{'.', '*'}));
    }
}