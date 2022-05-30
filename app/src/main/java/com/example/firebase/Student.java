package com.example.firebase;

public class Student {
    private String pid;
    private String pname;
    private String paddress;
    private Integer pcontact;

    public Student() {}

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public Integer getPcontact() {
        return pcontact;
    }

    public void setPcontact(Integer pcontact) {
        this.pcontact = pcontact;
    }
}
