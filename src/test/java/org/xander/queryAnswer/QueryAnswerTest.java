package org.xander.queryAnswer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QueryAnswerTest {
    String[] data = {"cat", "dog", "parrot"};
    private QueryAnswer queryAnswer;


    @Before
    public void setUp(){
        queryAnswer = new QueryAnswer(data);
    }

    @Test
    public void fillTheData() {
        assertArrayEquals(data, queryAnswer.getData());
    }

    @Test
    public void answerIfPresent() {

    }
}
