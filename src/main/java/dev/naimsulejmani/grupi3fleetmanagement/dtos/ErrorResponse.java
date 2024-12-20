package dev.naimsulejmani.grupi3fleetmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int status;
    private String statusName;
    private Exception exception;
    private LocalDateTime timestamp;
    private String path;
}
