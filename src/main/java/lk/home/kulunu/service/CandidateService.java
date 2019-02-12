package lk.home.kulunu.service;

import lk.home.kulunu.dto.CandidateDTO;
import lk.home.kulunu.dto.ExperienceDTO;
import lk.home.kulunu.dto.ExperiancePeriodDTO;

import java.util.List;

public interface CandidateService {

    List<CandidateDTO> findAllCandidate();

    CandidateDTO findCandidate(String candidateNic);

    void saveCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean updateCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean deleteCandidate(String candidateNic);

    List<CandidateDTO> cabdidateAddressLike(String candidateAddress);

    List<ExperiancePeriodDTO> fetchExperiencePeriod(double candidateExperiance);

    public List<ExperienceDTO> candidateExperiance(double candidateExperiance);
}
