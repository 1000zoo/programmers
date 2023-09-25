//2023-03-26
//https://school.programmers.co.kr/learn/courses/30/lessons/72410
//신규 아이디 추천

package codingtest_practice.level1;

public class RecommendNewID {

    public String newSolution(String newID) {
        newID = newID.toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]", "")
                .replaceAll("[.]$", "");

        if (newID.length() == 0) newID = "a";
        if (newID.length() > 15) {
            newID = newID.substring(0, 15).replaceAll("[.]$", "");
        }
        if (newID.length() < 3) newID += newID.substring(newID.length() - 1).repeat(3 - newID.length());

        return newID;
    }

    public String solution(String new_id) {
        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        return new_id;
    }

    private String step1(String new_id) {
        return new_id.toLowerCase();
    }

    private String step2(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if (isValidChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String step3(String new_id) {
        boolean dot = false;
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if (c == '.') {
                if (!dot) {
                    sb.append(c);
                    dot = true;
                }
            } else {
                sb.append(c);
                dot = false;
            }
        }

        return sb.toString();
    }

    private String step4(String new_id) {
        if (new_id.length() == 0) return new_id;
        if (new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (new_id.length() == 0) return new_id;
        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        return new_id;
    }

    private String step5(String new_id) {
        return new_id.length() == 0 ? "a" : new_id;
    }

    private String step6(String new_id) {
        return new_id.length() > 15 ? step4(new_id.substring(0, 15)) : new_id;
    }

    private String step7(String new_id) {
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }

    private boolean isValidChar(char c) {
        return isAlp(c) || isNum(c) || isETC(c);
    }
    private boolean isAlp(char c) {
        return c >= 'a' && c <= 'z';
    }
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean isETC(char c) {
        return c == '.' || c == '-' || c == '_';
    }
}
