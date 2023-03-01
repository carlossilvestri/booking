package com.alibou.security.booking;

import jakarta.validation.constraints.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingCreateDao {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastname;

    @NotNull
    @NotEmpty
    private String type_of_document;

    @NotNull
    @NotEmpty
    private String identification;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") // Email pattern
    @Email
    private String email;

    private Date date;

    @Enumerated(EnumType.STRING)
    private Reserve type_of_reserve;

    @Positive
    private Integer quantity_person;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30000)
    private String description;
}
