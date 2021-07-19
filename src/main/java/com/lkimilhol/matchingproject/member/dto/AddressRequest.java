package com.lkimilhol.matchingproject.member.dto;

public class AddressRequest {
    private Long memberId;
    private Long addressId;
    private String city;
    private String district;

    public AddressRequest() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
