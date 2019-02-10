package lk.home.kulunu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company_CandidateDTO {

    private String companyId;
    private String candidateNic;

    private Date applyDate;

}
