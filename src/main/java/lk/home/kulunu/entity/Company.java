package lk.home.kulunu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {
    @Id
    private String companyId;
    private String companyName;
    private String CompanyAddress;
    private int CompanyContact;
    private String recruitDesignation;
    private String favorite1;
    private String favorite2;
    private String favorite3;
}
