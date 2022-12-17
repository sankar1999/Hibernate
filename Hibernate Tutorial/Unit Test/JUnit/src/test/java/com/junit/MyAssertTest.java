package com.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {

        Boolean test = todos.contains("AWS");

        assertEquals(true, test);
        assertEquals(3, todos.size(), "Error Message");
        assertArrayEquals(new int[]{1,2,3}, new int[] {1,2,3});
    }
}
