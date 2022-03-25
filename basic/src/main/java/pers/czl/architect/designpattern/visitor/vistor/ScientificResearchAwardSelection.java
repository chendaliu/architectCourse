package pers.czl.architect.designpattern.visitor.vistor;

import pers.czl.architect.designpattern.visitor.element.Student;
import pers.czl.architect.designpattern.visitor.element.Teacher;

/**
 * 具体访问者 - 科研奖评选
 * @author: daliu
 * @date: 2022-03-25 17:01
 **/
public class ScientificResearchAwardSelection implements Selection {

    @Override
    public void visit(Teacher teacher) {
        if (teacher.getNumberOfPapers() >= 10) {
            System.out.println("颁给老师" + teacher.getName() + "科研奖");
        }
    }

    @Override
    public void visit(Student student) {
        if (student.getNumberOfPapers() >= 2) {
            System.out.println("颁给学生" + student.getName() + "科研奖");
        }
    }
}