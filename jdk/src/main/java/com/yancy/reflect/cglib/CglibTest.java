package com.yancy.reflect.cglib;

/**
 * Created by yancy on 2017/11/1.
 */
public class CglibTest {

    public static void main(String[] args) {
        BookFacadeImpl1 bookFacade=new BookFacadeImpl1();
        BookFacadeCglib  cglib=new BookFacadeCglib();
        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(bookFacade);
        bookCglib.addBook();
    }
}
