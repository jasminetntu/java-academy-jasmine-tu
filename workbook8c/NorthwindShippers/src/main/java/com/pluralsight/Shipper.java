package com.pluralsight;

public class Shipper {
    private long id;
    private String companyName;
    private String phone;

    public Shipper(long id, String companyName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }
}
