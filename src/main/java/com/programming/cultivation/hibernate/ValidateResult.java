package com.programming.cultivation.hibernate;

/**
 * 校验结果
 */
public class ValidateResult {

    /**
     * 是否通过校验
     */
    private boolean passed;
    /**
     * 校验信息
     */
    private String message;

    public boolean isPassed() {
        return passed;
    }

    public String getMessage() {
        return message;
    }

    public ValidateResult(boolean passed, String message) {
        this.passed = passed;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidateResult{" +
                "passed=" + passed +
                ", message='" + message + '\'' +
                '}';
    }
}
