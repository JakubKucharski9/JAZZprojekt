package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Repo.ReservationRepository;
import org.example.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){return reservationRepository.findAll();}

    public Reservation getReservationById(Long id){return reservationRepository.findById(id).stream().findFirst().orElse(null);}

    public Reservation createReservation(Reservation reservation){
        reservationRepository.save(reservation);
        return reservation;
    }

    public List<Reservation> getReservationsByRoomId(Long roomId){
        return reservationRepository.findByRoomId(roomId);
    }
}
