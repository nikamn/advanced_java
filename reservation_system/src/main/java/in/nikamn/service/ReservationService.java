package in.nikamn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nikamn.custom_exceptions.ApiException;
import in.nikamn.custom_exceptions.ResourceNotFoundException;
import in.nikamn.dto.ApiResponse;
import in.nikamn.model.Reservation;
import in.nikamn.model.Room;
import in.nikamn.repository.ReservationRepository;
import in.nikamn.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).get();
    }

    public Reservation createReservation(Reservation reservation) {
        Room room = roomRepository.findById(reservation.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Room Id @...!"));

        Reservation prevReservation = reservationRepository.findReservationByRoomId(reservation.getRoomId());
        
        if (prevReservation != null) {
            throw new ApiException("@This room is already reserved.");
        }

        room.setAvailability(false);
        return reservationRepository.save(reservation);
    }

    public ApiResponse cancelReservation(int reservationId) {

        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
            return new ApiResponse("Reservation " + reservationId + " deleted successfully");
        } else {
            throw new ResourceNotFoundException("No such reservation exists!");
        }
    }
}
