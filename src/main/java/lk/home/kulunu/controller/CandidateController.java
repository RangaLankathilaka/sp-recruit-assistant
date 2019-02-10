package lk.home.kulunu.controller;

import lk.home.kulunu.dto.CandidateDTO;
import lk.home.kulunu.dto.ExperienceDTO;
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
