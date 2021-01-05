package pers.czl.architect.designpattern.dynamicProxy;

public class BookServiceImpl implements BookService {
    @Override
    public void buyBook() {
        System.out.println("买一本书...");
    }
}
