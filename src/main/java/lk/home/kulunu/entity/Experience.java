package lk.home.kulunu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
