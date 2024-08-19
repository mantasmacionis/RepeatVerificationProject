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

    @Test
    @DisplayName("Stay instantiation with null entryDateTime throws NullPointerException")
    void stayInstantiationNullEntryDateTime() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(NullPointerException.class, () -> new Stay(new Gate(1, "Entry Gate A"), new Gate(2, "Exit Gate B"), null, LocalDateTime.of(2024, 8, 1, 12, 0), new BigDecimal("10.00"), sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with null exitDateTime throws NullPointerException")
    void stayInstantiationNullExitDateTime() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(NullPointerException.class, () -> new Stay(new Gate(1, "Entry Gate A"), new Gate(2, "Exit Gate B"), LocalDateTime.of(2024, 8, 1, 10, 0), null, new BigDecimal("10.00"), sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with null charge throws NullPointerException")
    void stayInstantiationNullCharge() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(NullPointerException.class, () -> new Stay(new Gate(1, "Entry Gate A"), new Gate(2, "Exit Gate B"), LocalDateTime.of(2024, 8, 1, 10, 0), LocalDateTime.of(2024, 8, 1, 12, 0), null, sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with negative charge throws IllegalArgumentException")
    void stayInstantiationNegativeCharge() {
        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        assertThrows(IllegalArgumentException.class, () -> new Stay(new Gate(1, "Entry Gate A"), new Gate(2, "Exit Gate B"), LocalDateTime.of(2024, 8, 1, 10, 0), LocalDateTime.of(2024, 8, 1, 12, 0), new BigDecimal("-10.00"), sameCarParkValidator));
    }

    @Test
    @DisplayName("Stay instantiation with identical entry and exit gates")
    void stayInstantiationIdenticalGates() {
        Gate gate = new Gate(1, "Gate A");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        Stay stay = new Stay(gate, gate, entryDateTime, exitDateTime, charge, sameCarParkValidator);

        assertEquals(gate, stay.getEntryGate());
        assertEquals(gate, stay.getExitGate());
    }

    @Test
    @DisplayName("Stay equality and hashCode")
    void stayEqualityAndHashCode() {
        Gate entryGate1 = new Gate(1, "Entry Gate A");
        Gate exitGate1 = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime1 = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime1 = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge1 = new BigDecimal("10.00");

        CarParkValidator sameCarParkValidator = (g1, g2) -> true;

        Stay stay1 = new Stay(entryGate1, exitGate1, entryDateTime1, exitDateTime1, charge1, sameCarParkValidator);
        Stay stay2 = new Stay(entryGate1, exitGate1, entryDateTime1, exitDateTime1, charge1, sameCarParkValidator);

        assertEquals(stay1, stay2);
        assertEquals(stay1.hashCode(), stay2.hashCode());
    }

}
