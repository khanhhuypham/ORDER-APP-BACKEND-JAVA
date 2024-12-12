package com.ra.orderapp_java.model.dto.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.orderapp_java.validate.user.UserUnique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {

    @NotBlank(message = "Không rỗng")
    private String username;

    @NotBlank(message = "Không rỗng")
    private String fullName;

    @NotBlank(message = "Không rỗng")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Không đúng định dạng email")
    @UserUnique(message = "Email da ton tai")
    private String email;

    @NotBlank(message = "Không rỗng")
    @Size(min = 8,message = "tối thiếu 8 ký tự")
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Past(message = "ngày sinh phải là ngày quá khứ")
    private LocalDate birthday;

    @NotBlank(message = "Không rỗng")
    private Set<String> roles;

}
