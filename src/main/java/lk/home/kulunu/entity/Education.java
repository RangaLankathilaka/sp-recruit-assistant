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
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationId;
    private String schoolName;
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private double gpa;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="candidateNic",referencedColumnName = "candidateNic")
    private Candidate candidate;
}
