package lk.home.kulunu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company_Candidate implements Serializable {

    @EmbeddedId
    private Company_Candidate_PK company_candidate_pk;
    @Temporal(TemporalType.DATE)
    private Date applyDate;

    @ManyToOne
    @JoinColumn(name = "companyId",referencedColumnName = "companyId",insertable = false,updatable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "candidateNic",referencedColumnName = "candidateNic",insertable = false,updatable = false)
    private Candidate candidate;

    public Company_Candidate(String companyId,String candidateNic, Date applyDate) {
        this.company_candidate_pk = new Company_Candidate_PK(companyId,candidateNic);
        this.applyDate = applyDate;
    }
}
