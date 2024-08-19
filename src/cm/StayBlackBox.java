package cm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StayBlackBox {

    @Test
    @DisplayName("Stay instantiation with valid parameters")
    void stayInstantiationValid() {
        Gate entryGate = new Gate(1, "Entry Gate A");
        Gate exitGate = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        CarParkValidator sameCarParkValidator = (g1, g2) -> true; // Simulates the same CarPark

        Stay stay = new Stay(entryGate, exitGate, entryDateTime, exitDateTime, charge, sameCarParkValidator);

        assertEquals(entryGate, stay.getEntryGate());
        assertEquals(exitGate, stay.getExitGate());
        assertEquals(entryDateTime, stay.getEntryDateTime());
        assertEquals(exitDateTime, stay.getExitDateTime());
        assertEquals(charge, stay.getCharge());
    }

    @Test
    @DisplayName("Stay instantiation with entryDateTime after exitDateTime")
    void stayInstantiationInvalidDates() {
        Gate entryGate = new Gate(1, "Entry Gate A");
        Gate exitGate = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 13, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(IllegalArgumentException.class, () -> new Stay(entryGate, exitGate, entryDateTime, exitDateTime, charge, sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with null entryGate throws NullPointerException")
    void stayInstantiationNullEntryGate() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(NullPointerException.class, () -> new Stay(null, new Gate(2, "Exit Gate B"), LocalDateTime.of(2024, 8, 1, 10, 0), LocalDateTime.of(2024, 8, 1, 12, 0), new BigDecimal("10.00"), sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with null exitGate throws NullPointerException")
    void stayInstantiationNullExitGate() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(NullPointerException.class, () -> new Stay(new Gate(1, "Entry Gate A"), null, LocalDateTime.of(2024, 8, 1, 10, 0), LocalDateTime.of(2024, 8, 1, 12, 0), new BigDecimal("10.00"), sameCarParkValidator));
    }

}
