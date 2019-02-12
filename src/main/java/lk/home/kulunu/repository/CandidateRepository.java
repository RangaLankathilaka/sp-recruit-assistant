package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Candidate;
import lk.home.kulunu.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,String> {

    @Query("SELECT c FROM Candidate c WHERE c.candidateAddress LIKE :candidateAddress%")
    List<Candidate> cabdidateAddressLike(@Param("candidateAddress") String candidateAddress);


}
