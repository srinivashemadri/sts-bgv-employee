package com.sts.bgv.employee.controller;
import com.sts.bgv.employee.model.BGVStatusResponse;
import com.sts.bgv.employee.model.CompanyHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BGVController {
    @PutMapping
    ResponseEntity<BGVStatusResponse> doBGV(@RequestBody List<CompanyHistory> companyHistory);

}
