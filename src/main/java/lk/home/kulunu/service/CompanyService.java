package lk.home.kulunu.service;

import lk.home.kulunu.dto.CompanyDTO;
import lk.home.kulunu.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAllCompany();

    CompanyDTO findCompany(String companyId);

    void saveCompany(String companyId, CompanyDTO companyDTO);

    boolean updateCompany(String companyId, CompanyDTO companyDTO);

    boolean deleteCompany(String companyId);


}
