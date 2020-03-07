package com.programming.cultivation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoverageSampleMethodsTest {

    @Test
    @DisplayName("daughter")
    @RepeatedTest(2)
    @ParameterizedTest
    @CsvSource(value = {"1,2,3"})
    public void testCoverageSampleMethods(int k, int j, int d) {
        CoverageSampleMethods methods = new CoverageSampleMethods();
        Assertions.assertTrue(methods.testMethod(k, j, d));
    }


    @RepeatedTest(2)
    public void test3() {
        CoverageSampleMethods methods = new CoverageSampleMethods();
        Assertions.assertTrue(methods.testMethod(1,2,3));
    }


    @RepeatedTest(3)
    public void test(){
        System.out.println("11");
    }
}
