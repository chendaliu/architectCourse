package pers.czl.architect.designpattern.visitor.vistor;

import pers.czl.architect.designpattern.visitor.element.Student;
import pers.czl.architect.designpattern.visitor.element.Teacher;

/**
 * 具体访问者 - 成绩优秀奖评选
 * @author: daliu
 * @date: 2022-03-25 17:03
 **/
public class OutstandingAchievementAwardSelection implements Selection {

    @Override
    public void visit(Teacher teacher) {
        if (teacher.getFeedbackScore() >= 90) {
            System.out.println("颁给老师" + teacher.getName() + "成绩优秀奖");
        }
    }

    @Override
    public void visit(Student student) {
        if (student.getAvgScore() >= 90) {
            System.out.println("颁给学生" + student.getName() + "成绩优秀奖");
        }
    }
}