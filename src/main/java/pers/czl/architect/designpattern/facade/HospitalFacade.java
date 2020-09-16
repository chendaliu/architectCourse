package pers.czl.architect.designpattern.facade;

/**
 * @Title: 医院外观
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-11 14:29
 * @Version:1.0
 **/
public class HospitalFacade {

    //挂号
    private Register register;
    //门诊看病
    private Outpatient outpatient;
    //付钱
    private Payer payer;
    //拿药
    private Drug drug;

    public HospitalFacade(Register register, Outpatient outpatient, Payer payer, Drug drug) {
        this.register = register;
        this.outpatient = outpatient;
        this.payer = payer;
        this.drug = drug;
    }

    public void seeTheDoctor() {
        this.register.regist();
        this.outpatient.checkup();
        this.payer.pay();
        this.drug.getDrug();
    }

}