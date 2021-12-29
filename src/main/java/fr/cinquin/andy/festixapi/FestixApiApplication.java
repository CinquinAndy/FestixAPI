package fr.cinquin.andy.festixapi;

import fr.cinquin.andy.festixapi.dao.*;
import fr.cinquin.andy.festixapi.model.*;
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
    CommandLineRunner run(UserRepository userRepository, FestivalRepository festivalRepository, EventRepository eventRepository, ArtistRepository artistRepository, AuthorityRepository authorityRepository) {
        return args -> {
            Authority admin = new Authority(null, "ADMIN", null);
            Authority user = new Authority(null, "USER", null);
            authorityRepository.save(admin);
            authorityRepository.save(user);

            Users andy = new Users(null, "andy", "Andy", "Cinquin", passwordEncoder.encode("password"), "cinquin.andy@gmail.com", true, List.of(admin));
            Users test = new Users(null, "test", "test", "test", passwordEncoder.encode("password"), "test.test@test.com", true, List.of(admin));
            Users andy2 = new Users(null, "andy2", "Andy2", "Cinquin2", passwordEncoder.encode("password"), "cinquin.andy2@gmail.com", true, null);
            Users andy3 = new Users(null, "andy3", "Andy3", "Cinquin3", passwordEncoder.encode("password"), "cinquin.andy3@gmail.com", true, List.of(user));

            userRepository.save(andy);
            userRepository.save(test);
            userRepository.save(andy2);
            userRepository.save(andy3);

            Festival festival = new Festival(null, "Eurockéennes de Belfort", """
                    Candy canes marshmallow chocolate bar gummi bears marzipan cake muffin bear claw. Pudding topping caramels carrot cake chocolate cake. Ice cream chupa chups chocolate bonbon muffin.

                    Chocolate bar bonbon muffin halvah tootsie roll muffin jelly-o jujubes wafer. Shortbread chocolate icing chupa chups shortbread jelly macaroon chupa chups. Apple pie carrot cake toffee sesame snaps brownie. Ice cream jelly beans candy tiramisu lemon drops marshmallow danish icing gingerbread.""",
                    "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", LocalDate.now(), LocalDate.now().plusDays(1));
            Festival festival2 = new Festival(null, "Vieilles charrues", """
                    Soufflé chocolate dessert sweet roll soufflé dragée. Cotton candy chupa chups cake halvah ice cream sugar plum sugar plum. Liquorice toffee cake tiramisu sesame snaps. Pie oat cake chocolate gummi bears gummi bears chocolate bar donut chupa chups cupcake.

                    Dragée jujubes apple pie tart liquorice. Cake dragée cake powder soufflé ice cream gingerbread fruitcake brownie. Donut tart marshmallow caramels caramels oat cake soufflé.""",
                    "https://images.unsplash.com/photo-1506157786151-b8491531f063?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
            Festival festival3 = new Festival(null, "Hellfest", "Wafer topping lollipop chocolate bear claw candy canes ice cream macaroon danish. Pie tootsie roll chocolate cake soufflé topping halvah cookie. Croissant shortbread gingerbread liquorice sesame snaps cake. Candy tiramisu dragée cheesecake cupcake jelly-o sweet roll.",
                    "https://images.unsplash.com/photo-1514525253161-7a46d19cd819?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80", LocalDate.now().plusDays(3), LocalDate.now().plusDays(4));
            Festival festival4 = new Festival(null, "Les Nuits Secrètes", """
                    Jelly beans cheesecake dragée pie gingerbread caramels shortbread. Brownie chocolate chupa chups biscuit toffee pie jelly. Chocolate cake sweet apple pie lollipop chocolate bar shortbread marshmallow.

                    Sweet cookie topping brownie dragée chocolate cake cotton candy wafer biscuit. Danish jelly-o tart gingerbread biscuit. Tart cake tootsie roll candy croissant. Danish marshmallow jelly-o carrot cake pastry sweet icing chocolate bar.""",
                    "https://images.unsplash.com/photo-1505842465776-3b4953ca4f44?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", LocalDate.now().plusDays(5), LocalDate.now().plusDays(6));
            Festival festival5 = new Festival(null, "Main Square", """
                    Tart bear claw oat cake tootsie roll liquorice muffin pie. Dessert tart sesame snaps liquorice cookie cupcake muffin. Jelly-o candy pastry halvah cotton candy jelly beans gummi bears.

                    Chocolate bar cookie chocolate bar pastry jelly dessert. Wafer soufflé marshmallow wafer macaroon. Liquorice caramels cake halvah chocolate cake dessert tootsie roll.""",
                    "https://images.unsplash.com/photo-1619229666372-3c26c399a4cb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", LocalDate.now().plusDays(7), LocalDate.now().plusDays(8));
            festivalRepository.save(festival);
            festivalRepository.save(festival2);
            festivalRepository.save(festival3);
            festivalRepository.save(festival4);
            festivalRepository.save(festival5);

            Artist artist1 = new Artist(null, "Kamil Feczko",
                    "Fruitcake candy dessert caramels jelly beans tootsie roll. Cheesecake liquorice croissant gummi bears apple pie oat cake lollipop. Chocolate donut lemon drops sesame snaps fruitcake icing pastry. Icing tiramisu tootsie roll gingerbread pie halvah sweet.",
                    "Pop, Rock, Rap",
                    "https://images.unsplash.com/photo-1526218626217-dc65a29bb444?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                    null);
            Artist artist2 = new Artist(null, "Jason Rosewell",
                    "Lollipop apple pie halvah jujubes jelly beans marzipan tart. Chupa chups jelly-o brownie cookie sweet apple pie marshmallow gingerbread jelly-o. Jujubes lemon drops muffin chocolate cake dragée apple pie.",
                    "Rock, Blues, Pop",
                    "https://images.unsplash.com/photo-1460723237483-7a6dc9d0b212?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                    null);
            Artist artist3 = new Artist(null, "Melanie Van Leeuwen",
                    "Chocolate cake oat cake cupcake sweet roll brownie chocolate jujubes jelly beans. Jujubes muffin dessert pie gummies jujubes cake shortbread topping. Brownie gingerbread cupcake powder powder toffee.",
                    "Classique, Rock",
                    "https://images.unsplash.com/photo-1565145368739-29e5a81be478?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                    null);
            Artist artist4 = new Artist(null, "Claudia Rayia",
                    "Biscuit bonbon gummi bears chocolate cake cotton candy muffin jelly beans powder. Powder liquorice chocolate macaroon sesame snaps sesame snaps wafer oat cake. Topping dessert cheesecake ice cream oat cake ice cream sweet roll.",
                    "Classique, Chill",
                    "https://images.unsplash.com/photo-1608319917470-9d9179430f8d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
                    null);
            Artist artist5 = new Artist(null, "Zoé Gomez",
                    "Wafer tootsie roll pudding jelly beans tart croissant donut biscuit. Jelly candy donut fruitcake tart apple pie. Cotton candy carrot cake icing sesame snaps candy. Chupa chups topping toffee tart cake danish caramels.",
                    "Rock, Blues, Pop",
                    "https://images.unsplash.com/photo-1597169428801-7c1adf2623bd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1202&q=80",
                    null);

            artistRepository.save(artist1);
            artistRepository.save(artist2);
            artistRepository.save(artist3);
            artistRepository.save(artist4);
            artistRepository.save(artist5);

            Set<Artist> artists = new HashSet<>(Arrays.asList(artist1, artist2, artist3));
            Event event = new Event(null, "Premier Event", LocalDateTime.now(), festival, artists, artist1.getArtistName());
            Event event6 = new Event(null, "Deuxième Event", LocalDateTime.now().plusHours(1), festival, artists, artist2.getArtistName());
            Event event7 = new Event(null, "Troisième Event", LocalDateTime.now().plusHours(2), festival, artists, artist3.getArtistName());
            Set<Artist> artists2 = new HashSet<>(Arrays.asList(artist2, artist3));
            Event event2 = new Event(null, "Premier Event", LocalDateTime.now(), festival2, artists2, artist3.getArtistName());
            Set<Artist> artists3 = new HashSet<>(Arrays.asList(artist3, artist4));
            Event event3 = new Event(null, "Premier Event", LocalDateTime.now(), festival3, artists3,artist4.getArtistName());
            Set<Artist> artists4 = new HashSet<>(Arrays.asList(artist4, artist5));
            Event event4 = new Event(null, "Premier Event", LocalDateTime.now(), festival4, artists4, artist5.getArtistName());
            eventRepository.save(event);
            eventRepository.save(event2);
            eventRepository.save(event3);
            eventRepository.save(event4);
            eventRepository.save(event6);
            eventRepository.save(event7);
        };
    }
}
