package com.sky.carDealershipApplication.Repository;

import com.sky.carDealershipApplication.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
