package com.rmndls.SPBootH2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class physics {
    private int pno;
    private int marks;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "physics{" +
                "pno=" + pno +
                ", marks=" + marks +
                "}\n";
    }
}
