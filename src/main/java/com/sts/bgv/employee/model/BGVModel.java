package com.sts.bgv.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BGVModel {
    private int historyId;
    private BGVStatus bgvStatus;
}
