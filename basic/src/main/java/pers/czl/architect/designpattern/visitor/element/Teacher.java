package pers.czl.architect.designpattern.visitor.element;

import pers.czl.architect.designpattern.visitor.vistor.Selection;

/**
 * 具体元素
 *
 * @author: daliu
 * @date: 2022-03-25 16:59
 **/
public class Teacher extends Member {
    private Integer numberOfPapers;
    private Integer feedbackScore;

    public Teacher(String name, Integer numberOfPapers, Integer feedbackScore) {
        this.name = name;
        this.numberOfPapers = numberOfPapers;
        this.feedbackScore = feedbackScore;
    }

    public Integer getNumberOfPapers() {
        return numberOfPapers;
    }

    public void setNumberOfPapers(Integer numberOfPapers) {
        this.numberOfPapers = numberOfPapers;
    }

    public Integer getFeedbackScore() {
        return feedbackScore;
    }

    public void setFeedbackScore(Integer feedbackScore) {
        this.feedbackScore = feedbackScore;
    }

    public void accept(Selection selection) {
        selection.visit(this); //调用访问者的访问方法
    }
}