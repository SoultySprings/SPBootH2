package com.rmndls.SPBootH2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class mathematics {
    private int mno;
    private int marks;

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + mno +
                ", Marks: " + marks;
    }
}
