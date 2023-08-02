package com.example.filmwebapplication.DTOs;

public class Links {
    private String next;
    private String previous;

    public Links() {
        this.next = null;
        this.previous = null;
    }

    public Links(String next, String previous) {
        this.next = next;
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
