package fr.cinquin.andy.festixapi.controller;

import fr.cinquin.andy.festixapi.dto.ArtistDto;
import fr.cinquin.andy.festixapi.model.Artist;
import fr.cinquin.andy.festixapi.model.Response;
import fr.cinquin.andy.festixapi.model.Role;
import fr.cinquin.andy.festixapi.service.implementation.ArtistServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistServiceImpl artistService;

    @GetMapping("/list/")
    public ResponseEntity<Response> getArtists() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artists", artistService.list(30)))
                        .message("Artists retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/random/")
    public ResponseEntity<Response> getRandomArtist() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artists", artistService.random()))
                        .message("Artist retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/list/byevent/{idEvent}")
    public ResponseEntity<Response> getArtistsByEvent(@PathVariable("idEvent") String uuid) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artists", artistService.byevent(uuid)))
                        .message("Events retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{uuid}/")
    public ResponseEntity<Response> getArtist(@PathVariable("uuid") String uuid) {
        Artist result = artistService.get(uuid);
        if (result == null) {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("artist", ""))
                            .message("Artist inexistant")
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build()
            );
        }
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artist", result))
                        .message("Artist retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{uuid}/")
    public ResponseEntity<Response> deleteArtist(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", artistService.delete(uuid)))
                        .message("Artist deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @PatchMapping("/update/{uuid}/")
    public ResponseEntity<Response> saveArtist(@RequestBody @Valid ArtistDto artistDto, @PathVariable("uuid") String uuid) {
        artistDto.setId(UUID.fromString(uuid));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artist", artistService.update(artistDto)))
                        .message("Artist saved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/create/")
    public ResponseEntity<Response> createArtist(@RequestBody ArtistDto artistDto) {
        System.out.println(artistDto);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("artist", artistService.create(artistDto)))
                        .message("Artist created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
