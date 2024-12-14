package dev.naimsulejmani.grupi3fleetmanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @NotNull(message = "Username is not provided, null")
    @NotBlank(message = "Username is not provided, blank or empty")
    @Size(min=4, max=50, message = "Username must be between 4 and 50 characters long")
    private String username;

    @NotBlank(message = "Password is not provided, blank or empty")
    @Size(min=8, max=100, message = "Password must be between 8 and 100 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
            message = "Password must contain at least one uppercase letter, one lowercase letter and one digit")
    private String password;

    private boolean rememberMe;
}
