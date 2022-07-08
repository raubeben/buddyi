package ch.zhaw.sml.iwi.meng.leantodo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Role;
import ch.zhaw.sml.iwi.meng.leantodo.entity.RoleRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.User;
import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Veranstaltung;
import ch.zhaw.sml.iwi.meng.leantodo.entity.VeranstaltungRepository;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class Buddyi implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Buddyi.class, args);

    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private VeranstaltungRepository veranstaltungRepository;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // This is only really relevant for development, where we have different servers
                        // for frontend and backend
                        .allowedOrigins("http://localhost:8100")
                        .allowedMethods("GET", "PUT", "POST", "DELETE")
                        // AllowCredentials is necessary, as it sets 'Access-Control-Allow-Credentials'.
                        // Otherwise Angular's HttpClient will not pass the Cookie back.
                        .allowCredentials(true);
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setBenutzername("user");
        u.setPasswordHash(new BCryptPasswordEncoder().encode("user"));
        u.setGeschlecht("m");
        u.setName("Müller");
        u.setVorname("Mario");
        u.setTelefonnummer("+41 52 123 45 67");

        User u2 = new User();
        u2.setBenutzername("derMensch");
        u2.setPasswordHash(new BCryptPasswordEncoder().encode("mensch"));
        u2.setGeschlecht("m");
        u2.setName("Marrone");
        u2.setVorname("Paulo");
        u2.setTelefonnummer("+41 52 111 22 33");

        User u3 = new User();
        u3.setBenutzername("derAlien");
        u3.setPasswordHash(new BCryptPasswordEncoder().encode("alien"));
        u3.setGeschlecht("w");
        u3.setName("Meier");
        u3.setVorname("Erika");
        u3.setTelefonnummer("+41 52 999 88 77");

        User u4 = new User();
        u4.setBenutzername("derInformatiker");
        u4.setPasswordHash(new BCryptPasswordEncoder().encode("informatiker"));
        u4.setGeschlecht("m");
        u4.setName("Erle");
        u4.setVorname("Manuel");
        u4.setTelefonnummer("+41 44 111 22 33");

        User u5 = new User();
        u5.setBenutzername("dieMutter");
        u5.setPasswordHash(new BCryptPasswordEncoder().encode("mutter"));
        u5.setGeschlecht("w");
        u5.setName("Meierhof");
        u5.setVorname("Sonja");
        u5.setTelefonnummer("+41 43 555 44 33");

        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Veranstaltung v = new Veranstaltung();
        v.setBeschreibung("Wir werden auf der Schützi wieder die Leidenschaft für den Fussball zelebrieren. Darum sei auch dabei! Wir suchen nämlich noch weitere Spieler. Wir lieben auch neue Gesichter zu sehen - sei willkommen, Bruder!");
        v.setActivity("Fussball");
        v.setOrt("Winterthur, Schützenwiese, Platz 4");
        Date date = format.parse("30-07-2022 15:30");
        v.setDatum(date);

        Veranstaltung v2 = new Veranstaltung();
        v2.setBeschreibung("Falls du auch den Winterspeck verlieren möchtest, dann bist auch du herzlich eingeladen, um mitzukommen. Wir treffen uns auf den Üetliberg beim Turm.");
        v2.setActivity("Jogging");
        v2.setOrt("Zürich, Üetliberg");
        Date date2 = format.parse("24-07-2022 18:45");
        v2.setDatum(date2);

        Veranstaltung v3 = new Veranstaltung();
        v3.setBeschreibung("Liebst du auch brennende Arme? Dann bist du willkommen an unser Volleyballabend. Wir treffen uns in der Turnhalle beim Schulhaus Moor in Schaffhausen. Wir freuen uns auf dich!");
        v3.setActivity("Volleyball");
        v3.setOrt("Schaffhausen, Schulhaus Moor");
        Date date3 = format.parse("16-08-2022 20:15");
        v3.setDatum(date3);

        Veranstaltung v4 = new Veranstaltung();
        v4.setBeschreibung("Ping-Pong-Ping-Pong...So einfach ist nämlich PingPong nicht. Wenn du richtig PingPong spielen möchtest, dann bist du bei uns am richtigen Platz. Wir treffen uns im Stadtpark neben dem Schulhaus.");
        v4.setActivity("PingPong");
        v4.setOrt("Winterthur, Stadtpark");
        Date date4 = format.parse("31-09-2022 15:00");
        v4.setDatum(date4);

        u.getRoles().add(r);
        u2.getRoles().add(r);
        u3.getRoles().add(r);
        u4.getRoles().add(r);
        u5.getRoles().add(r);

        userRepository.save(u);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);
        userRepository.save(u5);

        v.getUsers().add(u);
        v.getUsers().add(u2);
        v2.getUsers().add(u);

        veranstaltungRepository.save(v);
        veranstaltungRepository.save(v2);
        veranstaltungRepository.save(v3);
        veranstaltungRepository.save(v4);
    }
}
