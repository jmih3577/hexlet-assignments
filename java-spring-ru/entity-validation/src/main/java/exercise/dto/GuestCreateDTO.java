package exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^[+][0-9]{11,13}$")
    public String phoneNumber;
    @Length(min = 4, max = 4)
    public long clubCard;
    @Future
    private LocalDate cardValidUntil;
}
// END
