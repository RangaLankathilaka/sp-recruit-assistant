package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Company;
import lk.home.kulunu.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,String> {
}
