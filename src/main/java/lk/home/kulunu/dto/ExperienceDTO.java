package lk.home.kulunu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExperienceDTO implements Serializable {
    private int experienceId;
    private String companyName;
    private String designation;
    private double period;
}
