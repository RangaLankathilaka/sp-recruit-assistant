package lk.home.kulunu.controller;

import lk.home.kulunu.dto.CompanyDTO;
import lk.home.kulunu.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/companies")
public class CompanyController {
   @Autowired
    private CompanyService companyService;

   @GetMapping
   public List<CompanyDTO> findAllCompany(){
       return companyService.findAllCompany();

   }

   @GetMapping(value = "/{companyId}")
   public CompanyDTO findCompany(@PathVariable("companyId") String companyId){
       return companyService.findCompany(companyId);
   }

   @PutMapping(value = "/{companyId}")
   public void saveCompany(@PathVariable("companyId") String companyId,@RequestBody CompanyDTO companyDTO){
       companyService.saveCompany(companyId,companyDTO);
   }

   @PostMapping(value = "/{companyId}")
   public boolean updateCompany(@PathVariable String companyId,@RequestBody CompanyDTO companyDTO){

       return companyService.updateCompany(companyId,companyDTO);
   }

   @DeleteMapping(value = "/{companyId}")
   public boolean deleteCompany(@PathVariable String companyId){
       return companyService.deleteCompany(companyId);
    }

}
