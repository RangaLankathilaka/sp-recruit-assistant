package lk.home.kulunu.dto;


import lk.home.kulunu.entity.Company_Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDTO implements Serializable {
    private String companyId;
    private String companyName;
    private String companyAddress;
    private int companyContact;
    private String recruitDesignation;
    private String favorite1;
    private String favorite2;
    private String favorite3;


}
