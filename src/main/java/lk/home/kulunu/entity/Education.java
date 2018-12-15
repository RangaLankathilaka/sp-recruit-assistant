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
    private Date beginDate;
    private Date endDate;
    private double GPA;
}
