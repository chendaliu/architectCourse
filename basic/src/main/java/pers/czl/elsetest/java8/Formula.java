package pers.czl.elsetest.java8;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-14 17:17
 * @Version:1.0
 **/
interface Formula {
    double calculate(int a, int b);

    default double sum(int a, int b) {
        return a + b;
    }

    Formula formula = new Formula() {
        @Override
        public double calculate(int a, int b) {
            return sum(a, b);
        }
    };

}