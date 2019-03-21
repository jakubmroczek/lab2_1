package edu.iis.mto.bsearch;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {

    private static int ELEMENT_NOT_PRESENT = -1;

    @Test
    @Parameters(method = "oneSetUp")
    public void shouldReturnProperIndexInOneElementSequence(int key, int expectedIndex) {
        int[] seq = {5};
        SearchResult sut = BinarySearch.search(key, seq);
        int resultIndex = sut.getPosition();
        assertThat(expectedIndex, is(resultIndex));
    }

    @Test
    @Parameters(method = "multipleSetUp")
    public void shouldReturnProperIndexInNumerousCollection(int key, int expectedIndex) {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult sut = BinarySearch.search(key, seq);
        int resultIndex = sut.getPosition();
        assertThat(expectedIndex, is(resultIndex));
    }

    // Order: key, expected element
    private Object[] oneSetUp() {
        return new Object[] {
            new Object[] {5, 0},
            new Object[] {6, ELEMENT_NOT_PRESENT}
        };
    }

    // Order: key, expected element
    private Object[] multipleSetUp() {
        return new Object[] {
                new Object[] {1, 0},
                new Object[] {5, 4},
                new Object[] {3, 2},
                new Object[] {-1, ELEMENT_NOT_PRESENT}
        };
    }

}
