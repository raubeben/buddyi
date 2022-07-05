package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeranstaltungRepository extends JpaRepository<Veranstaltung,Long> {


    @Query("SELECT DISTINCT v FROM Veranstaltung v WHERE ?1 MEMBER OF v.users")
    public List<Veranstaltung> findByUser(User user);
    
}
