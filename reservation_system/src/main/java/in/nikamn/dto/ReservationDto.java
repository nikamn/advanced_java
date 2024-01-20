package in.nikamn.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDto {
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomId;
    private double price;
}
