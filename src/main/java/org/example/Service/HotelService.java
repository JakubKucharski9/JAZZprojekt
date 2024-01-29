package org.example.Service;


import lombok.RequiredArgsConstructor;
import org.example.Data.Hotel;
import org.example.Repo.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).stream().findFirst().orElse(null);
    }

    public Hotel createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }
}