package org.xander.queryAnswer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
        String actualAnswer = queryAnswer.checkValuePresent("cat");
        assertEquals("yes", actualAnswer);
    }

    @Test
    public void answerIfNotPresent() {
        String actualAnswer = queryAnswer.checkValuePresent("elephant");
        assertEquals("no", actualAnswer);
    }

    @Test(expected = IllegalStateException.class)
    public void noAnswersPresent() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{});
        queryAnswer.checkValuePresent("no matter what, no values anyway");
    }

    @Test
    public void onePlaceHolder() {
        assertEquals("yes", queryAnswer.checkValuePresent("c*t"));
    }

    @Test
    public void onePlaceHolderLastPosition() {
        assertEquals("yes", queryAnswer.checkValuePresent("ca*"));
    }

    @Test
    public void twoPlaceHoldersLastPosition() {
        assertEquals("yes", queryAnswer.checkValuePresent("c**"));
    }

    @Test
    public void twoPlaceHoldersFirstPosition() {
        assertEquals("yes", queryAnswer.checkValuePresent("**t"));
    }

    @Test
    public void onePlaceHolderFirstPosition() {
        assertEquals("yes", queryAnswer.checkValuePresent("*at"));
    }

    @Test
    public void threePlaceHolders() {
        assertEquals("yes", queryAnswer.checkValuePresent("***"));
    }

    @Test
    public void fivePlaceHoldersNotPresent() {
        assertEquals("yes", queryAnswer.checkValuePresent("******"));
    }

    @Test
    public void fourPlaceHoldersNotPresent() {
        assertEquals("no", queryAnswer.checkValuePresent("****"));
    }

    @Test
    public void wrongWordNotPresent() {
        assertEquals("no", queryAnswer.checkValuePresent("catn"));
    }
}
