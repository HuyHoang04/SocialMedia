package hv.socialmedia.dto.request;

import java.time.LocalDate;

import hv.socialmedia.enums.EnumConstants.PrivacySetting;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDTO {
    String name;
    String gender;
    LocalDate dob;
    String email;
    String bio;
    String avatar;
    String coverPicture;
    PrivacySetting privacySetting;
}
