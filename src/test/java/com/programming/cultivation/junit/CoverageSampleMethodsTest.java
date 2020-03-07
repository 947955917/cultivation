package com.programming.cultivation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoverageSampleMethodsTest {

    @Test
    @ParameterizedTest
    @DisplayName("daughter")
    @CsvSource(value = {"1,2,3","4,5,6"})
    public void testCoverageSampleMethods(int k, int j, int d) {
        CoverageSampleMethods methods = new CoverageSampleMethods();
        Assertions.assertTrue(methods.testMethod(k, j, d));
    }

}
