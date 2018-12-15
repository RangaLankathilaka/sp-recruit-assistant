package lk.home.kulunu.controller;


import lk.home.kulunu.dto.CandidatedetailDTO;
import lk.home.kulunu.dto.CompanyDetailDTO;
import lk.home.kulunu.dto.ResponseMessage;

import lk.home.kulunu.service.CandidateDetailService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("api/v1/details")
public class GlobalDetailController {

    private
    CandidateDetailService supportDataProcessingService;

    @Autowired
    private ResponseMessage meassage ;


    @GetMapping(value = "/download-candidate-detail")
    public ResponseEntity downloadTemplate() throws IOException {

        File returnFile = supportDataProcessingService.GenerateExcelFile(CandidatedetailDTO.class,"CandidateDetails");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"candidate-details.xlsx\"")
                .body(FileUtils.readFileToByteArray(returnFile));
    }

    @GetMapping(value = "/download-company-detail")
    public ResponseEntity  downloadInvoice() throws IOException {

        File returnFile = supportDataProcessingService.GenerateExcelFile(CompanyDetailDTO.class, "CompanyDetails");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"company-detail.xlsx\"")
                .body(FileUtils.readFileToByteArray(returnFile));
    }



    @PostMapping(value = "/get-candidate-detail")
    public ResponseEntity<?> getInvoice(@RequestParam("file") MultipartFile file)  {


        try {

            meassage.setData(supportDataProcessingService.readExcelFile(CandidatedetailDTO.class, file,"CandidateDetails"));
            meassage.setStatusCode(HttpStatus.OK.value());
            return ResponseEntity.ok(meassage);

        } catch (IOException e) {
            e.printStackTrace();
            meassage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            meassage.setError("Error Occured");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(meassage);
        }
    }

    @PostMapping(value = "/get-company-detail")
    public ResponseEntity<?> getPurchaseOrder(@RequestParam("file") MultipartFile file) {

        try {
            meassage.setData(supportDataProcessingService.readExcelFile(CompanyDetailDTO.class, file,"CompanyDetails"));
            meassage.setStatusCode(HttpStatus.OK.value());

            return ResponseEntity.ok(meassage);

        } catch (IOException e) {
            e.printStackTrace();
            meassage.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            meassage.setError("Error Occured");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(meassage);
        }
    }





}
