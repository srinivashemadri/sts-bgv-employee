package com.sts.bgv.employee.service;

import com.sts.bgv.employee.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BGVSvcImpl implements BGVSvc {

    @Autowired
    RestTemplate restTemplate;

    private ResponseEntity<UpdateBGVStatusResponse> updateBGVStatus(List<BGVModel> bgvModelList){

        String url = "http://localhost:8080/history/employee/bgvStatus";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(bgvModelList, headers);


        return restTemplate.exchange(url, HttpMethod.PUT,requestEntity, UpdateBGVStatusResponse.class);
    }

    private boolean isCompanyValid(String companyName){
        for(ValidCompanies validCompany: ValidCompanies.values()){
            if(validCompany.getValidCompany().equalsIgnoreCase(companyName)){
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<BGVStatusResponse>doBGV(List<CompanyHistory> companyHistoryList) {

        BGVStatusResponse bgvStatusResponse = null;
        bgvStatusResponse = new BGVStatusResponse();
        try{
            List<BGVModel> bgvModelList = new ArrayList<>();
            for(CompanyHistory companyHistory: companyHistoryList){
                BGVModel bgvModel = new BGVModel();
                bgvModel.setHistoryId(companyHistory.getHistoryId());
                if(isCompanyValid(companyHistory.getPrevCompanyName())){
                    bgvModel.setBgvStatus(BGVStatus.COMPLETED);
                }
                else {
                    bgvModel.setBgvStatus(BGVStatus.FAILED);
                }
                bgvModelList.add(bgvModel);
            }

            ResponseEntity<UpdateBGVStatusResponse> updateBGVStatusResponseResponseEntity = updateBGVStatus(bgvModelList);
            if(updateBGVStatusResponseResponseEntity.getStatusCode() == HttpStatus.OK && updateBGVStatusResponseResponseEntity.getBody() != null){

                bgvStatusResponse.setBgvModelList(updateBGVStatusResponseResponseEntity.getBody().getBgvModelList());
                bgvStatusResponse.setResponseHasError(false);
                bgvStatusResponse.setErrorMessage(null);
                return new ResponseEntity<>(bgvStatusResponse, HttpStatus.OK);
            }
            else{
                throw new Exception("Some error"+ updateBGVStatusResponseResponseEntity.getStatusCode());
            }
        }
        catch (Exception e){
            bgvStatusResponse.setBgvModelList(new ArrayList<>());
            bgvStatusResponse.setResponseHasError(true);
            bgvStatusResponse.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(bgvStatusResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
