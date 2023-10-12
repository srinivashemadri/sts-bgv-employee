package com.sts.bgv.employee.controller;

import com.sts.bgv.employee.model.BGVStatusResponse;
import com.sts.bgv.employee.model.CompanyHistory;
import com.sts.bgv.employee.service.BGVSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bgv/employee")
public class BGVControllerImpl implements BGVController{

    @Autowired
    BGVSvc bgvSvc;

    @Override
    public ResponseEntity<BGVStatusResponse> doBGV(List<CompanyHistory> companyHistory) {
        return bgvSvc.doBGV(companyHistory);
    }


}
