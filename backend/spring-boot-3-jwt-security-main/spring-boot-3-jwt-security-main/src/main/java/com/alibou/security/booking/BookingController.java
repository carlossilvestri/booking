package com.alibou.security.booking;

import com.turkraft.springfilter.converter.FilterSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "booking")
@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" })
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Booking> register(
            @Valid @RequestBody BookingCreateDao request) {

        return ResponseEntity.ok(bookingService.create(request));
    }

    @Operation(parameters = @Parameter(name = "filter", in = ParameterIn.QUERY, schema = @Schema(type = "string"),
            example = "active:true and status:'CREATED' and email:'test@gmail.com' or date > '2023-01-01' and description~~'%cumple%'"))
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping()
    public Page<Booking> findAll(
            @Parameter(hidden = true) FilterSpecification<Booking> filter, Pageable pageable
    ){
        return bookingService.findAll(filter, pageable);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PatchMapping("/{id}")
    public ResponseEntity<Booking> update(
            @PathVariable(value = "id") Integer id,
            @Valid @RequestBody BookingUpdateDao bookingRequest
    ){
        return ResponseEntity.ok(bookingService.update(bookingRequest, id));
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<Booking> update(
            @PathVariable(value = "id") Integer id
    ){
        return ResponseEntity.ok(bookingService.findById(id));
    }
}
