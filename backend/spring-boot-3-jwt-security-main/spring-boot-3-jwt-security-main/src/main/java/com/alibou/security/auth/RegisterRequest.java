package com.alibou.security.auth;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotNull
  @NotEmpty
  @Size(min = 2, max = 200)
  private String firstname;

  @NotNull
  @NotEmpty
  private String lastname;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") // Email pattern
  @Email
  private String email;

  @NotNull
  @NotEmpty
  private String password;
}
