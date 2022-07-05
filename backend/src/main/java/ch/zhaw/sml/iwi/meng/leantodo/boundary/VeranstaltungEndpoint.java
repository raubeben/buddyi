package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.VeranstaltungController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Veranstaltung;

@RestController
public class VeranstaltungEndpoint {

    @Autowired
    private VeranstaltungController veranstaltungController;

    @RequestMapping(path = "/api/veranstaltungen/all", method = RequestMethod.GET)
    public List<Veranstaltung> getAllVeranstaltungen() {
        return veranstaltungController.listAllVeranstaltungen();
    }

    /* 
    @RequestMapping(path = "/api/veranstaltungen/user", method = RequestMethod.GET)
    @PreAuthorize ("isAuthenticated() AND hasRole('USER')")
    public List<Veranstaltung> getAllVeranstaltungenByUser(Principal principal) {
        return veranstaltungController.listAllVeranstalungenByUser(principal.getName());
    }
    */
    
}
