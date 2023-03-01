package com.alibou.security.booking;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingUpdateDao {

    private String name;

    private String lastname;

    private String type_of_document;

    private String identification;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") // Email pattern
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date date;

    @Enumerated(EnumType.STRING)
    private Reserve type_of_reserve;

    @Positive
    private Integer quantity_person;

    private String description;
}
