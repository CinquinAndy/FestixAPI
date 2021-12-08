package fr.cinquin.andy.festixapi.controller;

import fr.cinquin.andy.festixapi.dto.FestivalDto;
import fr.cinquin.andy.festixapi.model.Festival;
import fr.cinquin.andy.festixapi.model.Response;
import fr.cinquin.andy.festixapi.service.implementation.FestivalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/festival")
@RequiredArgsConstructor
public class FestivalController {
    private final FestivalServiceImpl festivalService;

    @GetMapping("/list/")
    public ResponseEntity<Response> getFestivals() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("festivals", festivalService.list(30)))
                        .message("Festivals retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{uuid}/")
    public ResponseEntity<Response> getFestival(@PathVariable("uuid") String uuid) {
        Festival result = festivalService.get(uuid);
        if (result == null) {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("festival", ""))
                            .message("Festival inexistant")
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build()
            );
        }
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("festival", result))
                        .message("Festival retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{uuid}/")
    public ResponseEntity<Response> deleteFestival(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", festivalService.delete(uuid)))
                        .message("Festival deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @PatchMapping("/update/{uuid}/")
    public ResponseEntity<Response> saveFestival(@RequestBody @Valid FestivalDto festivalDto, @PathVariable("uuid") String uuid) {
        festivalDto.setId(UUID.fromString(uuid));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("festival", festivalService.update(festivalDto)))
                        .message("Festival saved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/create/")
    public ResponseEntity<Response> createFestival(@RequestBody FestivalDto festivalDto) {
        System.out.println(festivalDto);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("festival", festivalService.create(festivalDto)))
                        .message("Festival created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
