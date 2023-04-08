package com.alibou.security.booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>, JpaRepository<Booking, Integer>, PagingAndSortingRepository<Booking, Integer>, JpaSpecificationExecutor<Booking>{
    // @Query("select c from Booking c where concat(lower(c.name), lower(c.status) ) like lower( concat ( '%', ?1, '%'))")
    Page<Booking> findAllByActiveTrue(Pageable pageable);
    Page<Booking> findAll(Pageable pageable);
    // Page<Booking> findAll(Specification<Booking> spec, Pageable pageable);
}
