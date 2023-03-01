package com.alibou.security.booking;

import com.alibou.security.user.User;
import com.turkraft.springfilter.boot.Filter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping()
    public Page<Booking> findAll(
            Pageable pageable
    ){
        return bookingService.findAll(pageable);
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
