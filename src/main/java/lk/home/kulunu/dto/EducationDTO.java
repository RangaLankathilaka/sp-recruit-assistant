package lk.home.kulunu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EducationDTO implements Serializable {
    private int educationId;
    private String schoolName;
    private Date beginDate;
    private Date endDate;
    private double GPA;
}
