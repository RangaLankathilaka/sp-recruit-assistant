package lk.home.kulunu.service;

import lk.home.kulunu.LocalelizationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class LocaleService {

    @Autowired
    private LocalelizationConfig localelizationConfig;

    public ArrayList<String> getSource(String locale){


        String how= localelizationConfig.messageSource().getMessage("how.txt",null,new Locale(locale));
        String helloworld= localelizationConfig.messageSource().getMessage("helloworld.txt",null,new Locale(locale));

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(how);
        arrayList.add(helloworld);

        return arrayList;




    }
}
