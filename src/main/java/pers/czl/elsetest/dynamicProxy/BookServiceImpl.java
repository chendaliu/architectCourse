package pers.czl.elsetest.dynamicProxy;

public class BookServiceImpl implements BookService {
    @Override
    public void buyBook() {
        System.out.println("买一本书...");
    }
}
