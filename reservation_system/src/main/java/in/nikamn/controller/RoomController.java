package in.nikamn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nikamn.dto.ApiResponse;
import in.nikamn.model.Room;
import in.nikamn.service.RoomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ApiResponse getAllRooms() {
        return roomService.getAllRooms();
    }

    // @GetMapping
    // public List<Room> getAvailableRooms(@RequestParam(name = "availability") Boolean availability) {
    //     return roomService.getAvailableRooms(availability);
    // }

    @GetMapping("/{id}")
    public ApiResponse getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room addNewRoom(@RequestBody Room room) {
        return roomService.addNewRoom(room);
    }

    @DeleteMapping("/{id}")
    public void removeRoom(@PathVariable int id) {
        roomService.removeRoom(id);
    }

}
