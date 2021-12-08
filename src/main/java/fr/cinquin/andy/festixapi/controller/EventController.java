package fr.cinquin.andy.festixapi.controller;

import fr.cinquin.andy.festixapi.dto.EventDto;
import fr.cinquin.andy.festixapi.model.Event;
import fr.cinquin.andy.festixapi.model.Response;
import fr.cinquin.andy.festixapi.service.implementation.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventServiceImpl eventService;

    @GetMapping("/list/")
    public ResponseEntity<Response> getEvents() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("events", eventService.list(30)))
                        .message("Events retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{uuid}/")
    public ResponseEntity<Response> getEvent(@PathVariable("uuid") String uuid) {
        Event result = eventService.get(uuid);
        if (result == null) {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("event", ""))
                            .message("Event inexistant")
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build()
            );
        }
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("event", result))
                        .message("Event retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{uuid}/")
    public ResponseEntity<Response> deleteEvent(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", eventService.delete(uuid)))
                        .message("Event deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @PatchMapping("/update/{uuid}/")
    public ResponseEntity<Response> saveEvent(@RequestBody @Valid EventDto eventDto, @PathVariable("uuid") String uuid) {
        eventDto.setId(UUID.fromString(uuid));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("event", eventService.update(eventDto)))
                        .message("Event saved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/create/")
    public ResponseEntity<Response> createEvent(@RequestBody EventDto eventDto) {
        System.out.println(eventDto);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("event", eventService.create(eventDto)))
                        .message("Event created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
