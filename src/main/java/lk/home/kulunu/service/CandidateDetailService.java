package lk.home.kulunu.service;

import com.ebay.xcelite.Xcelite;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CandidateDetailService {

    public <T> File GenerateExcelFile(Class<T> type,String sheetName){
        File temp = null;
        try {
            temp = File.createTempFile("temp", ".xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Xcelite xcelite = new Xcelite();
        xcelite.createSheet(sheetName).getBeanWriter(type).write(new ArrayList<T>());
        xcelite.write(temp);
        return temp;
    }

    public <T> List<T> readExcelFile(Class<T> type, MultipartFile file, String sheetName) throws IllegalStateException, IOException{

        Xcelite xcelite = new Xcelite(multipartToFile(file));
        Collection<T> returnList = xcelite.getSheet(sheetName).getBeanReader(type).read();
        return returnList.stream().collect(Collectors.toList()) ;
    }

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }










}