package lk.home.kulunu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int experienceId;
    private String companyName;
    private String designation;
    private double period;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="candidateNic",referencedColumnName = "candidateNic")
    private Candidate candidate;
}
