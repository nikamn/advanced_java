package in.nikamn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nikamn.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByRoomId(int id);

}
