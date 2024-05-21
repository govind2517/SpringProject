package com.neog.helloproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ResponseDTO {
    private UUID transactionId = UUID.randomUUID();
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private int status;
    private String details;
}
