package lk.home.kulunu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate implements Serializable {

    @Id
    private String candidateNic;
    private String candidateName;
    private String candidateAddress;
    private int andidateContact;
    private String candidateEmail;
    private Date candidateBday;

}
