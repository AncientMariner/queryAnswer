package org.xander.queryAnswer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryAnswerTest {
    String[] data = {"cat", "dog", "parrot"};
    private QueryAnswer queryAnswer;

    @Before
    public void setUp(){
        queryAnswer = new QueryAnswer(data);
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
        new QueryAnswer(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void questionNotCorrect() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"2"});
        queryAnswer.checkValuePresent(null);
    }

    @Test
    public void zeroLengthArgument() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"2"});
        assertEquals("no", queryAnswer.checkValuePresent(""));

    }

    @Test
    public void zeroLengthArgumentPresent() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{""});
        assertEquals("yes", queryAnswer.checkValuePresent(""));
    }

    @Test
    public void emptySpaceArgument() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"   "});
        assertEquals("yes", queryAnswer.checkValuePresent("   "));
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
