package in.nikamn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nikamn.custom_exceptions.ResourceNotFoundException;
import in.nikamn.dto.ApiResponse;
import in.nikamn.model.Room;
import in.nikamn.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public ApiResponse getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        if (rooms.size() == 0) {
            return new ApiResponse("No rooms found @...!");
        }
        return new ApiResponse(rooms.toString());
    }

    public List<Room> getAvailableRooms(Boolean availability) {
        return roomRepository.findRoomsByAvailability(availability);
    }

    public ApiResponse getRoomById(int id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            return new ApiResponse("Room does not exist");
        }
        
        return new ApiResponse(room.get().toString());
    }

    public Room addNewRoom(Room room) {
        return roomRepository.save(room);
    }

    // public Room updateRoom(Integer id, Room room) {
    // Room persistentRoom = roomRepository.findById(id).get();
    // // update persistentRoom with room details
    // return roomRepository.save(persistentRoom);
    // }

    public ApiResponse removeRoom(int id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return new ApiResponse("Room " + id + " deleted successfully");
        } else {
            throw new ResourceNotFoundException("No such room exists!");
        }
    }
}
