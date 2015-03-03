package org.xander.examples;

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
        String actualAnswer = queryAnswer.takeCareOfComplexity("cat");
        assertEquals("yes", actualAnswer);
    }

    @Test
    public void answerIfNotPresent() {
        String actualAnswer = queryAnswer.takeCareOfComplexity("elephant");
        assertEquals("no", actualAnswer);
    }

    @Test(expected = IllegalStateException.class)
    public void noAnswersPresent() {
        new QueryAnswer(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void questionNotCorrect() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"2"});
        queryAnswer.takeCareOfComplexity(null);
    }

    @Test
    public void zeroLengthArgument() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"2"});
        assertEquals("no", queryAnswer.takeCareOfComplexity(""));

    }

    @Test
    public void zeroLengthArgumentPresent() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{""});
        assertEquals("yes", queryAnswer.takeCareOfComplexity(""));
    }

    @Test
    public void emptySpaceArgument() {
        QueryAnswer queryAnswer = new QueryAnswer(new String[]{"   "});
        assertEquals("yes", queryAnswer.takeCareOfComplexity("   "));
    }

    @Test
    public void onePlaceHolder() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("c*t"));
    }

    @Test
    public void onePlaceHolderLastPosition() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("ca*"));
    }

    @Test
    public void twoPlaceHoldersLastPosition() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("c**"));
    }

    @Test
    public void twoPlaceHoldersFirstPosition() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("**t"));
    }

    @Test
    public void onePlaceHolderFirstPosition() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("*at"));
    }

    @Test
    public void threePlaceHolders() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("***"));
    }

    @Test
    public void fivePlaceHoldersNotPresent() {
        assertEquals("yes", queryAnswer.takeCareOfComplexity("******"));
    }

    @Test
    public void fourPlaceHoldersNotPresent() {
        assertEquals("no", queryAnswer.takeCareOfComplexity("****"));
    }

    @Test
    public void wrongWordNotPresent() {
        assertEquals("no", queryAnswer.takeCareOfComplexity("catn"));
    }
}
