package in.nikamn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nikamn.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findRoomsByAvailability(Boolean availability);
}
