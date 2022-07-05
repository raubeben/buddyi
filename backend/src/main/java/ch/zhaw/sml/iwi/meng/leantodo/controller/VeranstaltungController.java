package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Veranstaltung;
import ch.zhaw.sml.iwi.meng.leantodo.entity.VeranstaltungRepository;


@Component
public class VeranstaltungController {

    @Autowired
    private VeranstaltungRepository veranstaltungRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Veranstaltung> listAllVeranstaltungen() {
        return veranstaltungRepository.findAll();
    }

    public List<Veranstaltung> listAllVeranstalungenByUser(String benutzername){
       return veranstaltungRepository.hugo();
       
    }
    
 
}
