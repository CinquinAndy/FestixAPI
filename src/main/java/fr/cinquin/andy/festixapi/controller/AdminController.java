package fr.cinquin.andy.festixapi.controller;

import fr.cinquin.andy.festixapi.model.Admin;
import fr.cinquin.andy.festixapi.model.Response;
import fr.cinquin.andy.festixapi.service.implementation.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServiceImpl adminService;
    @GetMapping("/list/")
    public ResponseEntity<Response> getAdmins(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("admins",adminService.list(30)))
                        .message("Admins retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{uuid}/")
    public ResponseEntity<Response> getAdmin(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("admin",adminService.get(UUID.fromString(uuid))))
                        .message("Admin retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{uuid}/")
    public ResponseEntity<Response> deleteAdmin(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",adminService.delete(UUID.fromString(uuid))))
                        .message("Admin deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save/")
    public ResponseEntity<Response> saveAdmin(@RequestBody @Valid Admin admin){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("admin",adminService.update(admin)))
                        .message("Admin saved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/create/")
    public ResponseEntity<Response> createAdmin(@RequestBody @Valid Admin admin){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("admin",adminService.create(admin)))
                        .message("Admin created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
