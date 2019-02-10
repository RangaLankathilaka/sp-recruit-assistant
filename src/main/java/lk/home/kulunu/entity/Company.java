package lk.home.kulunu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {
    @Id
    private String companyId;
    private String companyName;
    private String companyAddress;
    private int companyContact;
    private String recruitDesignation;
    private String favorite1;
    private String favorite2;
    private String favorite3;

    @OneToMany(mappedBy = "company",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Company_Candidate> company_candidate;


}
