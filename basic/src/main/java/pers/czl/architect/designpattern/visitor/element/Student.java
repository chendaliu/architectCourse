package pers.czl.architect.designpattern.visitor.element;

import pers.czl.architect.designpattern.visitor.vistor.Selection;

/**
 * 具体元素
 * @author: daliu
 * @date: 2022-03-25 16:58
 **/
public class Student extends Member {
    private Integer numberOfPapers;
    private Integer avgScore;

    public Student(String name, Integer numberOfPapers, Integer avgScore) {
        this.name = name;
        this.numberOfPapers = numberOfPapers;
        this.avgScore = avgScore;
    }

    public Integer getNumberOfPapers() {
        return numberOfPapers;
    }

    public void setNumberOfPapers(Integer numberOfPapers) {
        this.numberOfPapers = numberOfPapers;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public void accept(Selection selection) {
        selection.visit(this);
    }
}