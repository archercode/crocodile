package com.crocodille.model;

/**
 * Created by tonnyquintos on 12/30/15.
 */
public class Violation {
    String code;
    String date;
    String status;
    String description;

    public Violation(String code,String description, String date, String status){
        this.code = code;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
