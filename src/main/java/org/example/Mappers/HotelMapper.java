package org.example.Mappers;

import org.example.Data.Hotel;
import org.example.Data.Room;
import org.example.Dtos.HotelDTO;
import org.example.Dtos.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelMapper {

    public HotelDTO toDto(Hotel hotel) {
        if (hotel == null) {
            return null;
        }
        return new HotelDTO(
                hotel.getId(),
                hotel.getName(),
                hotel.getAddress()
        );
    }
    public Hotel toEntity(HotelDTO hotelDTO) {
        return new Hotel(hotelDTO.getId(), hotelDTO.getName(), hotelDTO.getAddress());
    }

    public List<HotelDTO> toDTOList(List<Hotel> hotels) {
        return hotels
                .stream()
                .map(this::toDto)
                .toList();
    }
}
