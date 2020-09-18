package pers.czl.architect.designpattern.facade;

/**
 * @Title: 外观模式
 * @Description: 把多个复杂操作组装到一起，用户方便使用
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-11 14:34
 * @Version:1.0
 **/
public class Client {

    public static void main(String[] args) {
        HospitalFacade facade = new HospitalFacade(new Register(), new Outpatient(), new Payer(), new Drug());
        facade.seeTheDoctor();
    }
}