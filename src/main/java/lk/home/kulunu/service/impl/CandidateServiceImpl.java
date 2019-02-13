package lk.home.kulunu.service.impl;

import lk.home.kulunu.dto.*;
import lk.home.kulunu.entity.Candidate;
import lk.home.kulunu.entity.Company_Candidate;
import lk.home.kulunu.entity.Education;
import lk.home.kulunu.entity.Experience;
import lk.home.kulunu.repository.CandidateRepository;
import lk.home.kulunu.repository.CustomRepository;
import lk.home.kulunu.repository.ExperienceRepository;
import lk.home.kulunu.service.CandidateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CustomRepository customRepository;

    @Autowired
    private ExperienceRepository experienceRepository;


    @Transactional(readOnly = true)
    @Override
    public List<CandidateDTO> findAllCandidate() {

        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        return findAll(candidates, candidateDTOS);

    }

    @Transactional(readOnly = true)
    @Override
    public CandidateDTO findCandidate(String candidateNic) {
        Candidate candidate = candidateRepository.findById(candidateNic).get();


        CandidateDTO candidateDTO = new CandidateDTO();

        return findById(candidateDTO, candidate);


    }

    @Override
    public void saveCandidate(String candidateNic, CandidateDTO candidateDTO) {
        if (!candidateNic.equals(candidateDTO.getCandidateNic())) {
            throw new RuntimeException("Candidate IDs are mismatched");
        }

        System.out.println(candidateDTO.getBackEndLanguages());
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDTO, candidate);
        String nic = candidateDTO.getCandidateNic();



       // saveBackEndLanguages(candidateDTO);
       // saveFrontEndLanguages(candidateDTO);

        if (candidateDTO.getExperienceDTOList() != null) {
            List<ExperienceDTO> experienceDTOList = candidateDTO.getExperienceDTOList();


            List<Experience> experiences = new ArrayList<>();
            for (int i = 0; i < experienceDTOList.size(); i++) {


                experiences.add(new Experience());


                BeanUtils.copyProperties(experienceDTOList.get(i), experiences.get(i));
                experiences.get(i).setCandidate(candidate);


            }

            candidate.setExperiences(experiences);


        }

        if (candidateDTO.getEducationDTOList() != null) {

            List<EducationDTO> educationDTOList = candidateDTO.getEducationDTOList();


            List<Education> educations = new ArrayList<>();
            for (int i = 0; i < educationDTOList.size(); i++) {


                educations.add(new Education());


                BeanUtils.copyProperties(educationDTOList.get(i), educations.get(i));
                educations.get(i).setCandidate(candidate);


            }
            candidate.setEducations(educations);

        }

        //comany_candidate details
        if (candidateDTO.getCompany_candidateDTOS() != null) {
            List<Company_CandidateDTO> company_candidateDTOList = candidateDTO.getCompany_candidateDTOS();
            List<Company_Candidate> company_candidates = new ArrayList<>();

            for (Company_CandidateDTO company_candidateDTO : company_candidateDTOList) {
                Company_Candidate company_candidate = new Company_Candidate(company_candidateDTO.getCompanyId(), company_candidateDTO.getCandidateNic(), company_candidateDTO.getApplyDate());
                company_candidates.add(company_candidate);
            }

            candidate.setCompany_candidate(company_candidates);

        }


        candidateRepository.save(candidate);


    }

    @Override
    public boolean updateCandidate(String candidateNic, CandidateDTO candidateDTO) {
        if (candidateRepository.existsById(candidateNic)) {
            saveCandidate(candidateNic, candidateDTO);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCandidate(String candidateNic) {
        candidateRepository.deleteById(candidateNic);
        return true;
    }

    @Override
    public List<CandidateDTO> cabdidateAddressLike(String candidateAddress) {
        List<Candidate> candidates = candidateRepository.cabdidateAddressLike(candidateAddress + "%");
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        return findAll(candidates, candidateDTOS);
    }

    @Override
    public List<CandidateDTO> cabdidateCoreLanguage(String corelanguage) {
        List<Candidate> candidates = candidateRepository.cabdidateCoreLanguage(corelanguage);
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        return findAll(candidates, candidateDTOS);


    }

    @Override
    public List<CandidateDTO> cabdidateDevelopField(String developField) {
        List<Candidate> candidates = candidateRepository.cabdidateDevelopField(developField);
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        return findAll(candidates, candidateDTOS);
    }

    @Override
    public List<CandidateDTO> cabdidateCoreLanguageAndField(String corelanguage, String developField) {

        List<Candidate> candidates = candidateRepository.cabdidateCoreLanguageAndField(corelanguage,developField);
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        return findAll(candidates, candidateDTOS);
    }


    @Override
    public List<CandidateDTO> getCandidateExperience(double candidateExperiance) {
        List<ExperiancePeriodDTO> experiancePeriodDTOS = customRepository.fetchExperiencePeriod(candidateExperiance);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (ExperiancePeriodDTO experiancePeriodDTO : experiancePeriodDTOS) {
            String candidateNic = experiancePeriodDTO.getCandidateNic();
            CandidateDTO candidate = findCandidate(candidateNic);
            candidateDTOList.add(candidate);
        }
        return candidateDTOList;
    }

    @Override
    public List<CandidateDTO> getExperiencePeriodandCoreLanguage(double candidateExperiance, String coreLanguage) {
        List<ExperiancePeriodDTO> experiancePeriodDTOS = customRepository.fetchExperiencePeriodandCoreLanguage(candidateExperiance,coreLanguage);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (ExperiancePeriodDTO experiancePeriodDTO : experiancePeriodDTOS) {
            String candidateNic = experiancePeriodDTO.getCandidateNic();
            CandidateDTO candidate = findCandidate(candidateNic);
            candidateDTOList.add(candidate);
        }
        return candidateDTOList;
    }

    @Override
    public List<CandidateDTO> getExperiencePeriodanddevelopField(double candidateExperiance, String developField) {
        List<ExperiancePeriodDTO> experiancePeriodDTOS = customRepository.fetchExperiencePeriodanddevelopField(candidateExperiance,developField);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (ExperiancePeriodDTO experiancePeriodDTO : experiancePeriodDTOS) {
            String candidateNic = experiancePeriodDTO.getCandidateNic();
            CandidateDTO candidate = findCandidate(candidateNic);
            candidateDTOList.add(candidate);
        }
        return candidateDTOList;
    }

    @Override
    public List<CandidateDTO> getExperienceLanguageField(double candidateExperiance, String coreLanguage, String developField) {
        List<ExperiancePeriodDTO> experiancePeriodDTOS = customRepository.fetchExperienceLanguageField(candidateExperiance,coreLanguage,developField);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        for (ExperiancePeriodDTO experiancePeriodDTO : experiancePeriodDTOS) {
            String candidateNic = experiancePeriodDTO.getCandidateNic();
            CandidateDTO candidate = findCandidate(candidateNic);
            candidateDTOList.add(candidate);
        }
        return candidateDTOList;
    }

    public List<CandidateDTO> findAll(List<Candidate> candidates, List<CandidateDTO> candidateDTOS) {
        for (int i = 0; i < candidates.size(); i++) {
            List<ExperienceDTO> experienceDTOS = new ArrayList<>();
            List<EducationDTO> educationDTOList = new ArrayList<>();
            candidateDTOS.add(new CandidateDTO());
            BeanUtils.copyProperties(candidates.get(i), candidateDTOS.get(i));

            //fetch experience
            List<Experience> experiences = candidates.get(i).getExperiences();
            for (int j = 0; j < experiences.size(); j++) {
                experienceDTOS.add(new ExperienceDTO());
                BeanUtils.copyProperties(experiences.get(j), experienceDTOS.get(j));

            }
            candidateDTOS.get(i).setExperienceDTOList(experienceDTOS);

            // fetch education
            List<Education> educations = candidates.get(i).getEducations();
            for (int k = 0; k < educations.size(); k++) {
                educationDTOList.add(new EducationDTO());
                BeanUtils.copyProperties(educations.get(k), educationDTOList.get(k));
            }
            candidateDTOS.get(i).setEducationDTOList(educationDTOList);


        }

        return candidateDTOS;
    }

    public CandidateDTO findById(CandidateDTO candidateDTO, Candidate candidate) {
        List<Experience> experiences = candidate.getExperiences();


        List<ExperienceDTO> experienceDTOS = new ArrayList<>();

        BeanUtils.copyProperties(candidate, candidateDTO);

        //fetch experience list
        for (int i = 0; i < experiences.size(); i++) {
            experienceDTOS.add(new ExperienceDTO());
            BeanUtils.copyProperties(experiences.get(i), experienceDTOS.get(i));

        }
        candidateDTO.setExperienceDTOList(experienceDTOS);
        //fetch education list
        List<Education> educations = candidate.getEducations();
        List<EducationDTO> educationDTOList = new ArrayList<>();
        for (int i = 0; i < educations.size(); i++) {
            educationDTOList.add(new EducationDTO());
            BeanUtils.copyProperties(educations.get(i), educationDTOList.get(i));
        }


        candidateDTO.setEducationDTOList(educationDTOList);


        return candidateDTO;
    }

//    public void saveBackEndLanguages(CandidateDTO candidateDTO) {
//        List<String> backEndLanguages = candidateDTO.getBackEndLanguages();
//        String backendcollect = backEndLanguages.stream().collect(Collectors.joining(","));
//        Candidate candidate = new Candidate();
//        candidate.setBackEndLanguages(backendcollect);
//
//    }
//
//    public void saveFrontEndLanguages(CandidateDTO candidateDTO) {
//        List<String> frontEndLanguages = candidateDTO.getFrontEndLanguages();
//        String frontendcollect = frontEndLanguages.stream().collect(Collectors.joining(","));
//        Candidate candidate = new Candidate();
//        candidate.setFrontEndLanguages(frontendcollect);
//
//    }


}
