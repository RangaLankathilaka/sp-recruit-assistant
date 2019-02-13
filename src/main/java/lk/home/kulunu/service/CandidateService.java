package lk.home.kulunu.service;

import lk.home.kulunu.dto.CandidateDTO;
import lk.home.kulunu.dto.ExperiancePeriodDTO;
import lk.home.kulunu.entity.Candidate;


import java.util.List;

public interface CandidateService {

    List<CandidateDTO> findAllCandidate();

    CandidateDTO findCandidate(String candidateNic);

    void saveCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean updateCandidate(String candidateNic, CandidateDTO customerDTO);

    boolean deleteCandidate(String candidateNic);

    List<CandidateDTO> cabdidateAddressLike(String candidateAddress);

    List<CandidateDTO> cabdidateCoreLanguage(String corelanguage);

    List<CandidateDTO> cabdidateDevelopField(String developField);

    List<CandidateDTO> cabdidateCoreLanguageAndField(String corelanguage,String developField);

    List<CandidateDTO> getCandidateExperience(double candidateExperiance);

    List<CandidateDTO> getExperiencePeriodandCoreLanguage(double candidateExperiance, String coreLanguage);

    List<CandidateDTO> getExperiencePeriodanddevelopField(double candidateExperiance,String developField);

    List<CandidateDTO> getExperienceLanguageField(double candidateExperiance,String coreLanguage,String developField);
}
