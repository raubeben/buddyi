package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.User;
import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Veranstaltung;
import ch.zhaw.sml.iwi.meng.leantodo.entity.VeranstaltungRepository;


@Component
public class VeranstaltungController {

    @Autowired
    private VeranstaltungRepository veranstaltungRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Veranstaltung> listAllVeranstaltungen(){
        return veranstaltungRepository.findAll();
    }

    public List<Veranstaltung> listAllVeranstalungenByUser(String benutzername){
       return veranstaltungRepository.findByUser(userRepository.findById(benutzername).get());
       
    }

    public Veranstaltung checkVeranstaltungById (Long id){
        return veranstaltungRepository.findById(id).get();
    }

    public void createNewEvent(Veranstaltung veranstaltung, String benutzername){
        User user = userRepository.findById(benutzername).get();
        Veranstaltung veranstaltung2 = veranstaltung;

        veranstaltung2.getUsers().add(user);
        veranstaltungRepository.save(veranstaltung2);
    }

    public String removeParticipant(Veranstaltung veranstaltung, String benutzername){
        User user = userRepository.findById(benutzername).get();
        Veranstaltung v = veranstaltungRepository.findById(veranstaltung.getId()).get();

        if (v.getUsers().contains(user)) {
            v.getUsers().remove(user);
            veranstaltungRepository.save(v);
            String messagePositive = "Du hast dich vom Event entfernt.";
            return messagePositive;
        } else {
            String messageNegative = "Du bist nicht im Event eingetragen.";
            return messageNegative;
        }

    }

    public String updateEventParticipant(Veranstaltung veranstaltung, String benutzername){
        User user = userRepository.findById(benutzername).get();
        Veranstaltung v = veranstaltungRepository.findById(veranstaltung.getId()).get();

        if (v.getUsers().contains(user)) {
            String messageNegative = "Du nimmst bereits teil";
            return messageNegative;
        } else {
            v.getUsers().add(user);
            veranstaltungRepository.save(v);
            String messagePositive = "Besten Dank für die Teilnahme";
            return messagePositive;
        }
    }
    
 
}
