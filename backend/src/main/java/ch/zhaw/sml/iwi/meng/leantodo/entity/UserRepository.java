package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT u FROM User u WHERE NOT u.benutzername = ?1")
    public List<User> getAllUserExpectYourself (String benutzername);
}