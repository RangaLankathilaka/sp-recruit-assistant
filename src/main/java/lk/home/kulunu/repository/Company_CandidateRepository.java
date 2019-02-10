package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Company_Candidate;
import lk.home.kulunu.entity.Company_Candidate_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Company_CandidateRepository extends JpaRepository<Company_Candidate,Company_Candidate_PK> {
}
