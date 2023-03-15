package com.lms.Bean;

import com.sun.prism.impl.Disposer;

public class RecordCombine extends Record {
    private String bookName;
    private String publish;
    private String address;
    private double price;

    public RecordCombine() {
    }

    public RecordCombine(String bookName, String publish, String address, double price) {
        this.bookName = bookName;
        this.publish = publish;
        this.address = address;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RecordCombine{" +
                super.toString()+
                "bookName='" + bookName + '\'' +
                ", publish='" + publish + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
