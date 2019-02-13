package lk.home.kulunu.controller;

import lk.home.kulunu.dto.CandidateDTO;
import lk.home.kulunu.dto.ExperiancePeriodDTO;
import lk.home.kulunu.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<CandidateDTO> findAllCustomers() {
        return candidateService.findAllCandidate();
    }

    @GetMapping(value = "/{candidateNic}")
    public CandidateDTO findCustomer(@PathVariable("candidateNic") String candidateNic) {
        return candidateService.findCandidate(candidateNic);
    }

    @GetMapping(params = {"action=search", "candidateAddress"})
    public List<CandidateDTO> findCustomerAddressLike(@RequestParam("candidateAddress") String candidateAddress) {
        return candidateService.cabdidateAddressLike(candidateAddress);
    }

    @GetMapping(params = {"action=search", "corelanguage"})
    public List<CandidateDTO> cabdidateCoreLanguage(@RequestParam("corelanguage") String corelanguage) {
        return candidateService.cabdidateCoreLanguage(corelanguage);
    }

    @GetMapping(params = {"action=search", "developField"})
    public List<CandidateDTO> cabdidateDevelopField(@RequestParam("developField") String developField) {
        return candidateService.cabdidateDevelopField(developField);
    }

    @GetMapping(params = {"action=search", "developField","corelanguage"})
    public List<CandidateDTO> cabdidateCoreLanguageAndField(@RequestParam("corelanguage") String corelanguage,@RequestParam("developField") String developField) {
        return candidateService.cabdidateCoreLanguageAndField(corelanguage,developField);
    }


    @GetMapping(params = {"action=search", "yearOfExperience"})
    public List<CandidateDTO> getCandidateExperience(@RequestParam("yearOfExperience") double yearOfExperience) {
        return candidateService.getCandidateExperience(yearOfExperience);
    }

    @GetMapping(params = {"action=search", "yearOfExperience","corelanguage"})
    public List<CandidateDTO> getExperiencePeriodandCoreLanguage(@RequestParam("yearOfExperience") double yearOfExperience, @RequestParam("corelanguage")String coreLanguage) {
        return candidateService.getExperiencePeriodandCoreLanguage(yearOfExperience,coreLanguage);
    }

    @GetMapping(params = {"action=search", "yearOfExperience","developField"})
    public List<CandidateDTO> getExperiencePeriodandDevelopField(@RequestParam("yearOfExperience") double yearOfExperience, @RequestParam("developField")String developField) {
        return candidateService.getExperiencePeriodanddevelopField(yearOfExperience,developField);
    }


    @PutMapping(value = "/{candidateNic}")
    public void saveCustomer(@PathVariable("candidateNic") String candidateNic, @RequestBody CandidateDTO candidateDTO) {


        candidateService.saveCandidate(candidateNic, candidateDTO);
    }

    @PostMapping(value = "/{candidateNic}")
    public boolean updateCustomer(@PathVariable("candidateNic") String candidateNic, @RequestBody CandidateDTO candidateDTO) {
        return candidateService.updateCandidate(candidateNic, candidateDTO);
    }

    @DeleteMapping(value = "/{candidateNic}")
    public boolean deleteCustomer(@PathVariable("candidateNic") String candidateNic) {
        return candidateService.deleteCandidate(candidateNic);
    }




}
