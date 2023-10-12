package com.sts.bgv.employee.model;

public enum ValidCompanies {
    MICROSOFT("MICROSOFT"),
    AMAZON("AMAZON"),
    WELLS_FARGO("WELLS FARGO"),
    JPMC("JP Morgan Chase"),
    MORGAN_STANLEY("MORGAN STANLEY"),
    VIRTUSA("VIRTUSA"),
    TCS("TCS"),
    INFOSYS("INFOSYS"),
    WIPRO("WIPRO"),
    ACCENTURE("ACCENTURE"),
    CAPGEMINI("CAPGEMINI");

    private final String validCompany;

    ValidCompanies(String validCompany){
        this.validCompany = validCompany;
    }

    public String getValidCompany() {
        return validCompany;
    }
}
