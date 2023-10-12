package com.sts.bgv.employee.service;

import com.sts.bgv.employee.model.BGVStatusResponse;
import com.sts.bgv.employee.model.CompanyHistory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BGVSvc {

    ResponseEntity<BGVStatusResponse> doBGV(List<CompanyHistory> companyHistory);

}
