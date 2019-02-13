package lk.home.kulunu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String coreLanguage;
    private String frontEndLanguages;
    private String backEndLanguages;
    private String developField;
    @Temporal(TemporalType.DATE)
    private Date candidateBday;

    @OneToMany(mappedBy = "candidate",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Education> educations=new ArrayList<>();

    @OneToMany(mappedBy = "candidate",cascade = {CascadeType.ALL,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Experience> experiences=new ArrayList<>();

    @OneToMany(mappedBy = "candidate",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Document> documents=new ArrayList<>();

    @OneToMany(mappedBy = "candidate",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Company_Candidate> company_candidate=new ArrayList<>();



}
