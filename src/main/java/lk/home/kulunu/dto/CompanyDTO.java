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
public class CompanyDTO implements Serializable {
    private String companyId;
    private String companyName;
    private String CompanyAddress;
    private int CompanyContact;
    private String recruitDesignation;
    private String favorite1;
    private String favorite2;
    private String favorite3;
}
