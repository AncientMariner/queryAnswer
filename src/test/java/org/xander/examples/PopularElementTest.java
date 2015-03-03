package org.xander.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class PopularElementTest {
    @Test
    public void popularityIndexValue() {
        int[] sortedArray = {1, 2, 3, 3,
                             3, 3, 4, 5,
                             6, 7, 8, 9,
                             10, 11, 12, 13};
        PopularElement popularElement = new PopularElement(sortedArray);
        assertEquals(sortedArray.length / 4, popularElement.getPopularityIndex(), 0.5);
    }

    @Test
    public void popularItemValue() {
        int[] sortedArray = {1, 2, 3, 4,
                             4, 4, 4, 5,
                             6, 7, 8, 9,
                             10, 11, 12, 13};
        PopularElement popularElement = new PopularElement(sortedArray);
        assertEquals(4, popularElement.getPopularElementMapWay());
    }

    @Test
    public void testSearch1() {
        int[] sortedArray = {1, 2, 3, 4,
                             5, 7, 8, 9,
                             9, 9, 9, 9,
                             10, 11, 12, 13,
                             14, 15, 16, 17};
        PopularElement popularElement = new PopularElement(sortedArray);
        assertEquals(9, popularElement.findPopularElement());
    }

    @Test
    public void testSearch2() {
        int[] sortedArray = {1, 1, 1, 1,
                             1, 1, 2, 2,
                             3, 4, 5, 6,
                             7, 8, 9, 9,
                             10, 11, 12, 13,
                             14, 15, 16, 17};
        PopularElement popularElement = new PopularElement(sortedArray);
        assertEquals(1, popularElement.findPopularElement());
    }

    @Test
    public void testSearch3() {
        int[] sortedArray = {1, 2, 3, 11,
                             11, 11, 12, 13,
                             14, 15, 16, 17};
        PopularElement popularElement = new PopularElement(sortedArray);
        assertEquals(11, popularElement.findPopularElement());
    }

    @Test(expected = IllegalStateException.class)
    public void nullData() {
        new PopularElement(null);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyData() {
        new PopularElement(new int[]{});
    }
}