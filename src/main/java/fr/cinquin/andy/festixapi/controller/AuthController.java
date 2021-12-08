package fr.cinquin.andy.festixapi.controller;

import fr.cinquin.andy.festixapi.dto.UserDto;
import fr.cinquin.andy.festixapi.model.Response;
import fr.cinquin.andy.festixapi.service.implementation.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/register/")
    public ResponseEntity<Response> saveAdmin(@RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user",authService.register(userDto)))
                        .message("Users created")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
