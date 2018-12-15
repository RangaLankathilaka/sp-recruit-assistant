package lk.home.kulunu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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


}
