package edu.iis.mto.bsearch;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

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

    // Moglby byc sparametryzowany, ale w jakis sposob trzeba polozyc nacisk na corner case
    @Test
    public void shouldReturnProperIndexForElementNextToTheCenter() {
        int[] seq = {11, 25, 36, 49, 50};
        SearchResult sut = BinarySearch.search(25, seq);

        int resultIndex = sut.getPosition();
        assertThat(1, is(resultIndex));

        sut = BinarySearch.search(49, seq);
        resultIndex = sut.getPosition();

        assertThat(3, is(resultIndex));
    }

    // Moglby byc sparametryzowany, ale w jakis sposob trzeba polozyc nacisk na corner case
    @Test
    public void shouldReturnProperIndexForBorderElements() {
        int[] seq = {-1, 4, 7, 8};
        SearchResult sut = BinarySearch.search(-1, seq);

        int resultIndex = sut.getPosition();
        assertThat(0, is(resultIndex));

        sut = BinarySearch.search(8, seq);
        resultIndex = sut.getPosition();

        assertThat(3, is(resultIndex));
    }

    @Test
    public void shouldNotModifySeguence() {
        int original[] = {4, 5, 6, 7, 9};
        int copy[] = Arrays.copyOf(original, original.length);
        SearchResult sut = BinarySearch.search(10, original);

        assertThat(copy, is(original));
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
