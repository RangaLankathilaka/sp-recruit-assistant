package lk.home.kulunu.dto;

import lk.home.kulunu.entity.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.LifecycleState;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CandidateDTO {

    private String candidateNic;
    private String candidateName;
    private String candidateAddress;
    private int andidateContact;
    private String candidateEmail;
    private String coreLanguage;
    private String frontEndLanguages;
    private String backEndLanguages;
    private String developField;
    private Date candidateBday;
    private List<EducationDTO> educationDTOList;
    private List<ExperienceDTO> experienceDTOList;
    private List<DocumentDTO> documentDTOList;

    private List<Company_CandidateDTO> company_candidateDTOS;
}
