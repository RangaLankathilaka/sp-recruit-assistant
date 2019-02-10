package lk.home.kulunu.service;

import lk.home.kulunu.dto.CandidateDTO;

import java.util.List;

public interface CandidateService {

    List<CandidateDTO> findAllCandidate();

    CandidateDTO findCandidate(String candidateNic);

    void saveCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean updateCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean deleteCandidate(String candidateNic);
}
