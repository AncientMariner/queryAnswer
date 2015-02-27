package org.xander.queryAnswer;

import java.util.Objects;

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
}
