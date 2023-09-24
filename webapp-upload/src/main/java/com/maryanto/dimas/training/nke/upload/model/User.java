package com.maryanto.dimas.training.nke.upload.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private LocalDateTime time;
}
