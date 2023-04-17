package RestuarantApp.Restuarant.dto;

import RestuarantApp.Restuarant.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
     @NotEmpty
    private String firstName;
     @NotEmpty
    private String lastName;
     @NotEmpty(message = "Email should not be empty")
    private String email;
     @NotEmpty(message="Password should not be empty")
     private String password;
     @NotEmpty
     @Length(min = 10,message ="Password should be atleast 10 number long")
    private String mobileNumber;
     @NotEmpty
     private Gender gender;

}
