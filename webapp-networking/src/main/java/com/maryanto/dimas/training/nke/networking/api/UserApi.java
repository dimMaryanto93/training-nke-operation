package com.maryanto.dimas.training.nke.networking.api;

import com.maryanto.dimas.training.nke.networking.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @GetMapping("/dimas")
    public ResponseEntity<User> getUser() {
        log.info("User: {} has access this request api", "admin");
        User dimas = User.builder()
                .firstName("Dimas")
                .lastName("Maryanto")
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(dimas);
    }
}
