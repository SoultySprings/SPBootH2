package com.rmndls.SPBootH2.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class student {
    private int rollno;
    private String fullname;
    private String city;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "student{" +
                "rollno=" + rollno +
                ", fullname='" + fullname + '\'' +
                ", city='" + city + '\'' +
                "}\n";
    }
}
