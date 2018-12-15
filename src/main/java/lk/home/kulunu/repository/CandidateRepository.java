package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Candidate;
import lk.home.kulunu.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,String> {
}
