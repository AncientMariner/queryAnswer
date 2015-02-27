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
        for (String element : data) {
            if (value.equals(element)) {
                return "yes";
            }
        }
        return "no";
    }
}
