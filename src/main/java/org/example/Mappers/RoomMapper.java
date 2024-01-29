package org.example.Mappers;

import org.example.Data.Room;
import org.example.Dtos.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapper {

    public RoomDTO toDto(Room room) {
        if (room == null) {
            return null;
        }
        return new RoomDTO(
                room.getId(),
                room.getNumber(),
                room.getCapacity(),
                room.getPrice()
        );
    }

    public Room toEntity(RoomDTO roomDTO) {
        return new Room(roomDTO.getId(), roomDTO.getNumber(), roomDTO.getCapacity(), roomDTO.getPrice());
    }

    public List<RoomDTO> toDTOList(List<Room> rooms) {
        return rooms
                .stream()
                .map(this::toDto)
                .toList();
    }
}