package pers.czl.architect.designpattern.visitor.vistor;

import pers.czl.architect.designpattern.visitor.element.Student;
import pers.czl.architect.designpattern.visitor.element.Teacher;

/**
 * 抽象访问者
 * @author: daliu
 * @date: 2022-03-25 17:00
 **/
public interface Selection {
    void visit(Teacher teacher);
    void visit(Student student);
}
