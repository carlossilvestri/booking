package com.alibou.security.booking;

import com.alibou.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    /*
    * Create a booking (Reservation).
    * @Param BookingRequest _booking, User user
    * @Return Booking
    * */
    public Booking create(BookingCreateDao _booking){
        var booking = Booking.builder()
                .name(_booking.getName())
                .lastname(_booking.getLastname())
                .type_of_document(_booking.getType_of_document())
                .identification(_booking.getIdentification())
                .email(_booking.getEmail())
                .date(_booking.getDate())
                .type_of_reserve(_booking.getType_of_reserve())
                .quantity_person(_booking.getQuantity_person())
                .description(_booking.getDescription())
                .status(Status.CREATED)
                .active(true)
                .build();
        return bookingRepository.save(booking);
    }

    /*
     * Get paginated bookings.
     * @Param Pageable pageable
     * @Return Page<Booking>
     * */
    public Page<Booking> findAll(Pageable pageable){
        return bookingRepository.findAllByActiveTrue(pageable);
    }

    /*
     * Update a booking.
     * @Param BookingUpdateDao bookingRequest, Integer id
     * @Return Booking
     * */
    public Booking update(BookingUpdateDao bookingRequest, Integer id){
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Booking not found for this id : " + id));

        if(bookingRequest.getEmail() != null){
            booking.setEmail(bookingRequest.getEmail());
        }
        if(bookingRequest.getName() != null){
            booking.setName(bookingRequest.getName());
        }
        if(bookingRequest.getLastname() != null){
            booking.setLastname(bookingRequest.getLastname());
        }
        if(bookingRequest.getStatus() != null){
            booking.setStatus(bookingRequest.getStatus());
        }
        if(bookingRequest.getDescription() != null){
            booking.setDescription(bookingRequest.getDescription());
        }
        if(bookingRequest.getQuantity_person() != null){
            booking.setQuantity_person(bookingRequest.getQuantity_person());
        }
        final Booking updatedBooking = bookingRepository.saveAndFlush(booking);
        return updatedBooking;
    }

    /*
     * Find a booking by id.
     * @Param Integer id
     * @Return Booking
     * */
    public Booking findById(Integer id){
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Booking not found for this id :: " + id));
        return booking;
    }
}
