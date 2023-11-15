package com.vip.coffee.service.dto;

public class SaveMachineDto extends SaveMachineTemplateDto {
    private String uniqMachineNumber;
    private String warrantyEndDate;
    private String additionalInformation;

    public String getUniqMachineNumber() {
        return uniqMachineNumber;
    }

    public SaveMachineDto setUniqMachineNumber(String uniqMachineNumber) {
        this.uniqMachineNumber = uniqMachineNumber;
        return this;
    }

    public String getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public SaveMachineDto setWarrantyEndDate(String warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public SaveMachineDto setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }
}
