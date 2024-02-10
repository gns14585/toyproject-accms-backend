package com.example.accmsbackend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CustomAccountDto {
    private String offices;
    private String bankingInformation;
    private String accountNumber;
    private String companyNumber;
    private String abbreviated;
    private String companyName;
    private String representative;
    private String responsiblefor;
    private String businessType;
    private String items;
    private String postalCode;
    private String primaryAddress;
    private String detailedAddress;
    private String phoneNumber;
    private String faxNumber;
    private String homepageurl;
    private String companyType;
    private String countryType;
    private LocalDate contractPeriod1;
    private LocalDate contractPeriod2;
    private String registrationInformation;
    private LocalDateTime registrationDateTime;
    private String changeInformation;
    private LocalDateTime changeDateTime;
}
