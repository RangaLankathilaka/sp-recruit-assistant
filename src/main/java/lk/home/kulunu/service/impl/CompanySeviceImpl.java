package lk.home.kulunu.service.impl;

import lk.home.kulunu.dto.CompanyDTO;
import lk.home.kulunu.entity.Company;
import lk.home.kulunu.repository.CompanyRepository;
import lk.home.kulunu.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanySeviceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CompanyDTO> findAllCompany() {
        List<Company> all = companyRepository.findAll();
        List<CompanyDTO> companyDTOList=new ArrayList<>();
        for(int i=0;i<all.size();i++){
            companyDTOList.add(new CompanyDTO());
            BeanUtils.copyProperties(all.get(i),companyDTOList.get(i));
        }

        return companyDTOList;
    }

    @Transactional(readOnly = true)
    @Override
    public CompanyDTO findCompany(String companyId) {
        Company company = companyRepository.findById(companyId).get();
        CompanyDTO companyDTO = new CompanyDTO();
        BeanUtils.copyProperties(company,companyDTO);
        return companyDTO;
    }

    @Override
    public void saveCompany(String companyId, CompanyDTO companyDTO) {
       if(!companyId.equals(companyDTO.getCompanyId())){
           throw new RuntimeException("Company IDs are mismatched");
       }
       Company company=new Company();
       BeanUtils.copyProperties(companyDTO,company);
       companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(String companyId, CompanyDTO companyDTO) {
        if(companyRepository.existsById(companyId)){
            saveCompany(companyId,companyDTO);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean deleteCompany(String companyId) {
        companyRepository.deleteById(companyId);
        return true;
    }
}
