package fr.cinquin.andy.festixapi;

import fr.cinquin.andy.festixapi.dao.repository.*;
import fr.cinquin.andy.festixapi.model.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FestixApiApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FestixApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository, FestivalRepository festivalRepository, EventRepository eventRepository, ArtistRepository artistRepository, AuthorityRepository authorityRepository, AuthoritiesRepository authoritiesRepository) {
        return args -> {
            Authority admin = new Authority(null, "ADMIN", null);
            Authority user = new Authority(null, "USER", null);
            authorityRepository.save(admin);
            authorityRepository.save(user);

            Users andy = new Users(null, "andy", "Andy", "Cinquin", passwordEncoder.encode("password"), "cinquin.andy@gmail.com", true, null);
            Users test = new Users(null, "test", "test", "test", passwordEncoder.encode("test"), "test.test@test.com", true, null);
            Users andy2 = new Users(null, "andy2", "Andy2", "Cinquin2", passwordEncoder.encode("password2"), "cinquin.andy2@gmail.com", true, null);
            Users andy3 = new Users(null, "andy3", "Andy3", "Cinquin3", passwordEncoder.encode("password3"), "cinquin.andy3@gmail.com", true, null);

            userRepository.save(andy);
            userRepository.save(test);
            userRepository.save(andy2);
            userRepository.save(andy3);

            Authorities authorities = new Authorities(null, andy, admin);
            authoritiesRepository.save(authorities);

            Festival festival = new Festival(null, "Premier festival", "Description", "photoUrl", LocalDate.now(), LocalDate.now(), null);
            Festival festival2 = new Festival(null, "Premier festival2", "Description2", "photoUrl2", LocalDate.now(), LocalDate.now(), null);
            Festival festival3 = new Festival(null, "Premier festival3", "Description3", "photoUrl3", LocalDate.now(), LocalDate.now(), null);
            Festival festival4 = new Festival(null, "Premier festival4", "Description4", "photoUrl4", LocalDate.now(), LocalDate.now(), null);
            Festival festival5 = new Festival(null, "Premier festival5", "Description5", "photoUrl5", LocalDate.now(), LocalDate.now(), null);
            festivalRepository.save(festival);
            festivalRepository.save(festival2);
            festivalRepository.save(festival3);
            festivalRepository.save(festival4);
            festivalRepository.save(festival5);

            Artist artist1 = new Artist(null, "Nom d'artiste", "Description d'artiste", "Style de musique d'artiste", "Photo d'artiste", null);
            Artist artist2 = new Artist(null, "Nom d'artiste2", "Description d'artiste2", "Style de musique d'artiste2", "Photo d'artiste2", null);
            Artist artist3 = new Artist(null, "Nom d'artiste3", "Description d'artiste3", "Style de musique d'artiste3", "Photo d'artiste3", null);
            Artist artist4 = new Artist(null, "Nom d'artiste4", "Description d'artiste4", "Style de musique d'artiste4", "Photo d'artiste4", null);
            Artist artist5 = new Artist(null, "Nom d'artiste5", "Description d'artiste5", "Style de musique d'artiste5", "Photo d'artiste5", null);
            artistRepository.save(artist1);
            artistRepository.save(artist2);
            artistRepository.save(artist3);
            artistRepository.save(artist4);
            artistRepository.save(artist5);

            Set<Artist> artists = new HashSet<>(Arrays.asList(artist1, artist2, artist3));
            Event event = new Event(null, "Premier Event", LocalDateTime.now(), festival, artists);
            Event event6 = new Event(null, "Deuxième Event", LocalDateTime.now().plusHours(1), festival, artists);
            Event event7 = new Event(null, "Troisième Event", LocalDateTime.now().plusHours(2), festival, artists);
            Set<Artist> artists2 = new HashSet<>(Arrays.asList(artist2, artist3));
            Event event2 = new Event(null, "Premier Event", LocalDateTime.now(), festival2, artists2);
            Set<Artist> artists3 = new HashSet<>(Arrays.asList(artist3, artist4));
            Event event3 = new Event(null, "Premier Event", LocalDateTime.now(), festival3, artists3);
            Set<Artist> artists4 = new HashSet<>(Arrays.asList(artist4, artist5));
            Event event4 = new Event(null, "Premier Event", LocalDateTime.now(), festival4, artists4);
            eventRepository.save(event);
            eventRepository.save(event2);
            eventRepository.save(event3);
            eventRepository.save(event4);
            eventRepository.save(event6);
            eventRepository.save(event7);
        };
    }
}
