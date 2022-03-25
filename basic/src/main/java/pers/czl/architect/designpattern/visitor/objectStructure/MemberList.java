package pers.czl.architect.designpattern.visitor.objectStructure;

import pers.czl.architect.designpattern.visitor.element.Member;
import pers.czl.architect.designpattern.visitor.vistor.Selection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: daliu
 * @date: 2022-03-25 17:08
 **/
public class MemberList {

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void accept(Selection selection) {
        this.members.forEach(m -> m.accept(selection));
    }
}