package com.junit;

import org.junit.MyMath;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    void calculate_Three_Number_Array() {
        assertEquals(6, myMath.calculateSum(new int[] {1,2,3}));
    }


    @Test
    void calculate_Zero_Number_Array() {
        assertEquals(0, myMath.calculateSum(new int[] {}));
    }
}
