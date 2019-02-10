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
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fileId;


    private String fileName;

    private String fileDownloadUri;
    private String fileType;
    private long size;

    @ManyToOne
    @JoinColumn(name="candidateNic",referencedColumnName = "candidateNic")
    private Candidate candidate;


}
