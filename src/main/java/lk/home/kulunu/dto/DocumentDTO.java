package lk.home.kulunu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentDTO {

    private int documentId;
    private String documentName;
    private String documentPath;


}

