package com.neog.studentmngmtsystem.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String name, gender, branch;
    private long contactNo;

    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("gender", gender);
        params.put("branch", branch);
        params.put("contactNo", contactNo);
        return params;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

}
