package com.vd.learn.springboot.reservation.landon.data.repository;

import com.vd.learn.springboot.reservation.landon.data.entity.Guest;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {
    Optional<Guest> findById(Long id);
}