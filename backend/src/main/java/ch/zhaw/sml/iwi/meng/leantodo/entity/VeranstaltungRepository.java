package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeranstaltungRepository extends JpaRepository<Veranstaltung,String> {

    //@Query("SELECT v FROM Veranstaltungen AS v WHERE ?1 IN v.user")
    //public List<Veranstaltung> findByUser(String user);
    
}
