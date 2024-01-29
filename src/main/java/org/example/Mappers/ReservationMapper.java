package org.example.Mappers;

import org.example.Data.Hotel;
import org.example.Data.Reservation;
import org.example.Dtos.HotelDTO;
import org.example.Dtos.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationMapper {

    private final RoomMapper roomMapper;

    public ReservationMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    public ReservationDTO toDto(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        return new ReservationDTO(
                reservation.getId(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate(),
                roomMapper.toDto(reservation.getRoom())
        );
    }
    public Reservation toEntity(ReservationDTO reservationDTO) {
        return new Reservation(reservationDTO.getId(), reservationDTO.getCheckInDate(), reservationDTO.getCheckOutDate(), roomMapper.toEntity(reservationDTO.getRoomId()));
    }

    public List<ReservationDTO> toDTOList(List<Reservation> hotels) {
        return hotels
                .stream()
                .map(this::toDto)
                .toList();
    }
}
