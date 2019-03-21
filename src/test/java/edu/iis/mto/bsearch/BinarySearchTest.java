package edu.iis.mto.bsearch;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {

    @Test
    @Parameters(method = "oneSetUp")
    public void shouldReturnProperIndexInOneElementSequence(int key, int expectedIndex) {
        int[] seq = {5};
        SearchResult sut = BinarySearch.search(key, seq);
        int resultIndex = sut.getPosition();
        Assert.assertEquals(expectedIndex, resultIndex);
    }

    @Test
    @Parameters(method = "multipleSetUp")
    public void shouldReturnProperIndexInNumerousCollection(int key, int expectedIndex) {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult sut = BinarySearch.search(key, seq);
        int resultIndex = sut.getPosition();
        Assert.assertEquals(expectedIndex, resultIndex);
    }

    // Order: key, expected element
    private Object[] oneSetUp() {
        return new Object[] {
            new Object[] {5, 0},
            new Object[] {5, -1}
        };
    }

    // Order: key, expected element
    private Object[] multipleSetUp() {
        return new Object[] {
                new Object[] {1, 0},
                new Object[] {5, 4},
                new Object[] {3, 2},
                new Object[] {-1, -1}
        };
    }

}
