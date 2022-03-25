package pers.czl.architect.designpattern.visitor;

import pers.czl.architect.designpattern.visitor.element.Student;
import pers.czl.architect.designpattern.visitor.element.Teacher;
import pers.czl.architect.designpattern.visitor.objectStructure.MemberList;
import pers.czl.architect.designpattern.visitor.vistor.OutstandingAchievementAwardSelection;
import pers.czl.architect.designpattern.visitor.vistor.ScientificResearchAwardSelection;

/**
 * 访问者模式，参考：https://blog.csdn.net/lovelion/article/details/7433567
 * 角色：
 * 1.抽象访问者 Vistor
 * 2.具体访问者 ConcreteVisitor
 * 3.抽象元素 Element
 * 4.具体元素 ConcreteElement
 * 5.对象结构 ObjectStructure
 *
 * 适用于元素不常变，但是访问者常变的情况
 *
 * 练习：Sunny软件公司欲为某高校开发一套奖励审批系统，该系统可以实现教师奖励和学生奖励的审批(Award Check)，
 * 如果教师发表论文数超过10篇或者学生论文超过2篇可以评选科研奖，如果教师教学反馈分大于等于90分或者学生平均成绩大于等于90分
 * 可以评选成绩优秀奖。试使用访问者模式设计该系统，以判断候选人集合中的教师或学生是否符合某种获奖要求
 *
 * @author: daliu
 * @date: 2022-03-25 14:39
 **/
public class Client {

    public static void main(String[] args) {
        Teacher teacherZhao = new Teacher("赵老师", 10, 90);
        Teacher teacherQian = new Teacher("钱老师", 2, 80);

        Student studentSun = new Student("孙同学", 2, 70);
        Student studentLi = new Student("李同学", 1, 90);

        MemberList memberList = new MemberList();
        memberList.addMember(teacherZhao);
        memberList.addMember(teacherQian);
        memberList.addMember(studentSun);
        memberList.addMember(studentLi);

        OutstandingAchievementAwardSelection selection1 = new OutstandingAchievementAwardSelection();
        memberList.accept(selection1);

        ScientificResearchAwardSelection selection2 = new ScientificResearchAwardSelection();
        memberList.accept(selection2);
    }
}