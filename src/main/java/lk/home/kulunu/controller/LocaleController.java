package lk.home.kulunu.controller;

import lk.home.kulunu.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@RestController
@RequestMapping("api/v1/Files")
public class LocaleController {

    @Autowired
    private LocaleService localeService;

    @GetMapping
    public ArrayList<String> getSource(@RequestHeader("Accept-Language") String locale){


     return localeService.getSource(locale);

    }
}
