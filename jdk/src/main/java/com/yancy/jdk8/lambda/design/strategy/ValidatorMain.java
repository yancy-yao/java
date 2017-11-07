package com.yancy.jdk8.lambda.design.strategy;

/**
 * Created by yancy on 2017/11/6.
 */
public class ValidatorMain {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = numericValidator.validate("bbb");

        //lambda
        Validator numericValidatorL = new Validator((String s) -> s.matches("[a-z]+"));
        boolean l1 = numericValidatorL.validate("aaa");
        Validator lowerCaseValidatorL = new Validator((String s) -> s.matches("\\d+"));
        boolean l2 = lowerCaseValidatorL.validate("bbb");
    }
}
