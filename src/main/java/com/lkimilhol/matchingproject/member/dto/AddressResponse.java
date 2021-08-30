package com.lkimilhol.matchingproject.member.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.address.domain.Address;
import com.lkimilhol.matchingproject.address.domain.City;

@Getter
@NoArgsConstructor
public class AddressResponse {
    private Long addressId;
    private Long memberId;
    private String city;
    private String district;

    private AddressResponse(Long addressId, Long memberId, String city, String district) {
        this.addressId = addressId;
        this.memberId = memberId;
        this.city = city;
        this.district = district;
    }

    public static AddressResponse of(Address address) {
        return new AddressResponse(address.getId(), address.getMember().getId(), address.getCity().toString(), address.getDistrict().getName());
    }

    public static List<AddressResponse> listOf(List<Address> addresses) {
        return addresses.stream()
                .map(AddressResponse::of)
                .collect(Collectors.toList());
    }
}
