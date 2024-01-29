package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Repo.RoomRepository;
import org.example.Data.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id){
        return roomRepository.findById(id).stream().findFirst().orElse(null);
    }

    public Room createRoom(Room room){
        roomRepository.save(room);
        return room;
    }
}
