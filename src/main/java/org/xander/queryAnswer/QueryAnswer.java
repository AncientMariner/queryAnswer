package org.xander.queryAnswer;

public class QueryAnswer {
    private String[] data;

    public QueryAnswer(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    public String checkValuePresent(String value) {
        if (data.length == 0) {
            throw new IllegalStateException("data is not filled, not able to check");
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
