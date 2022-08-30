package com.hz.pojo;

public class Address {
    private String AddressAreaId;
    private String AddressName;
    private String  AddressRegion;

    @Override
    public String toString() {
        return "Address{" +
                "AddressAreaId='" + AddressAreaId + '\'' +
                ", AddressName='" + AddressName + '\'' +
                ", AddressRegion='" + AddressRegion + '\'' +
                '}';
    }

    public String getAddressAreaId() {
        return AddressAreaId;
    }

    public void setAddressAreaId(String addressAreaId) {
        AddressAreaId = addressAreaId;
    }

    public String getAddressName() {
        return AddressName;
    }

    public void setAddressName(String addressName) {
        AddressName = addressName;
    }

    public String getAddressRegion() {
        return AddressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        AddressRegion = addressRegion;
    }
}
