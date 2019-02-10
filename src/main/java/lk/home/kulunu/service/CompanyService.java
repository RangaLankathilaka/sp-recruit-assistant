package lk.home.kulunu.service;

import lk.home.kulunu.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAllCompany();

    CompanyDTO findCompany(String companyId);

    void saveCompany(String companyId, CompanyDTO companyDTO);

    boolean updateCompany(String companyId, CompanyDTO companyDTO);

    boolean deleteCompany(String companyId);
}
