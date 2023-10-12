package com.sts.bgv.employee.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyHistory{

    @NotNull
    private int historyId;

    @NotNull
    private String prevCompanyName;

    @NotNull
    private String prevCompanyAddress;

    @NotNull
    private Date prevCompanyStartDate;

    @NotNull
    private Date prevCompanyEndDate;

    @NotNull
    private String prevCompanyHREmail;

    @NotNull
    private String prevCompanyDesignation;
}
