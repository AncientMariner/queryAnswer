package org.xander.queryAnswer;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryAnswer {
    final private String[] data;

    public QueryAnswer(String[] data) {
        if (data.length == 0) {
            throw new IllegalStateException("data is not filled, not able to check");
        }
        this.data = data;
    }

    public String checkValuePresent(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("argument is not correct, please change it");
        }

        char[] valueChars = value.toCharArray();

        for (String element : data) {
            if (value.equals(element)) {
                return "yes";
            } else {
                char[] elementChars = element.toCharArray();
                if (elementChars.length == valueChars.length) {
                    for (int i = 0; i < valueChars.length; i++) {
                        if (elementChars[i] != valueChars[i]) {
                            if (valueChars[i] == '*') {
                                continue;
                            } else
                                return "no";
                        }
                    }
                    return "yes";
                }
            }
        }
        return "no";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String a : data) {
            result.append(a).append("\n");
        }
        return result.toString();
    }

    public String takeCareOfComplexity(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("argument is not correct, please change it");
        }
        String allInOne = toString();
        String valueForRegex = value.replace('*', '.');

        Pattern pattern = Pattern.compile("^" + valueForRegex + "$", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(allInOne);

        if (matcher.find()) {
            return "yes";
        }
        return "no";
    }
}
