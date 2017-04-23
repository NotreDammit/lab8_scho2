package com.cs60333.scho2.lab2_scho2;

/**
 * Created by samcholo on 4/9/17.
 */

public class Book {

    int _id;
    String bookname;

    public Book(int _id, String book_name) {
        this._id = _id;
        this.bookname = book_name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
