package cm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MyTestSuite {

    /* GATE WHITE BOX TESTS START */

    @Test
    @DisplayName("Gate equals: self-comparison returns true")
    void gateEqualsSelfComparison() {
        Gate gate = new Gate(1, "Gate A");
        assertTrue(gate.equals(gate));
    }

    @Test
    @DisplayName("Gate equals: comparison with null returns false")
    void gateEqualsNullComparison() {
        Gate gate = new Gate(1, "Gate A");

        assertFalse(gate.equals(null)); // Comparing with null
    }

    @Test
    @DisplayName("Gate equals: comparison with different object type returns false")
    void gateEqualsDifferentTypeComparison() {
        Gate gate = new Gate(1, "Gate A");
        assertFalse(gate.equals("Some String"));
    }

    @Test
    @DisplayName("Gate equals: comparison with a gate having a different gateId returns false")
    void gateEqualsDifferentGateId() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(2, "Gate A"); // Different gateId

        assertFalse(gate1.equals(gate2));
    }

    @Test
    @DisplayName("Gate equals: comparison with a gate having a different location returns false")
    void gateEqualsDifferentLocation() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(1, "Gate B"); // Different location

        assertFalse(gate1.equals(gate2));
    }

    @Test
    @DisplayName("Gate hashCode: same gateId and location should produce same hashCode")
    void gateHashCodeSameAttributes() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(1, "Gate A");
        assertEquals(gate1.hashCode(), gate2.hashCode());
    }

    @Test
    @DisplayName("Gate hashCode: different gateId or location should produce different hashCode")
    void gateHashCodeDifferentAttributes() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(2, "Gate A");
        Gate gate3 = new Gate(1, "Gate B");
        assertNotEquals(gate1.hashCode(), gate2.hashCode());
        assertNotEquals(gate1.hashCode(), gate3.hashCode());
    }

    @Test
    @DisplayName("Gate instantiation with negative gateId throws IllegalArgumentException")
    void gateInstantiationNegativeGateId() {
        assertThrows(IllegalArgumentException.class, () -> new Gate(-1, "Gate A"));
    }

    @Test
    @DisplayName("Gate instantiation with null location throws IllegalArgumentException")
    void gateInstantiationNullLocation() {
        assertThrows(IllegalArgumentException.class, () -> new Gate(1, null));
    }

    @Test
    @DisplayName("Gate instantiation with empty location throws IllegalArgumentException")
    void gateInstantiationEmptyLocation() {
        assertThrows(IllegalArgumentException.class, () -> new Gate(1, ""));
    }

    @Test
    @DisplayName("Gate getter for gateId")
    void gateGetGateId() {
        Gate gate = new Gate(1, "Gate A");
        assertEquals(1, gate.getGateId());
    }

    @Test
    @DisplayName("Gate getter for location")
    void gateGetLocation() {
        Gate gate = new Gate(1, "Gate A");
        assertEquals("Gate A", gate.getLocation());
    }

    @Test
    @DisplayName("Gate equals: comparison with identical gates returns true")
    void gateEqualsIdenticalGates() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(1, "Gate A"); // Identical gateId and location

        assertTrue(gate1.equals(gate2));
    }

    @Test
    @DisplayName("Gate equals: comparison with different objects returns false")
    void gateEqualsDifferentObjectType() {
        Gate gate = new Gate(1, "Gate A");

        assertFalse(gate.equals("Some String")); // Comparing with different object type
    }

    /* GATE WHITE BOX TESTS END */

    /* STAY WHITE BOX TESTS START */

    @Test
    @DisplayName("Stay equals: self-comparison returns true")
    void stayEqualsSelfComparison() {
        Gate entryGate = new Gate(1, "Entry Gate A");
        Gate exitGate = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        Stay stay = new Stay(entryGate, exitGate, entryDateTime, exitDateTime, charge, (g1, g2) -> true);
        assertTrue(stay.equals(stay));
    }

    @Test
    @DisplayName("Stay equals: comparison with null returns false")
    void stayEqualsNullComparison() {
        Gate entryGate = new Gate(1, "Entry Gate A");
        Gate exitGate = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        Stay stay = new Stay(entryGate, exitGate, entryDateTime, exitDateTime, charge, (g1, g2) -> true);
        assertFalse(stay.equals(null));
    }

    @Test
    @DisplayName("Stay equals: comparison with different object type returns false")
    void stayEqualsDifferentTypeComparison() {
        Gate entryGate = new Gate(1, "Entry Gate A");
        Gate exitGate = new Gate(2, "Exit Gate B");
        LocalDateTime entryDateTime = LocalDateTime.of(2024, 8, 1, 10, 0);
        LocalDateTime exitDateTime = LocalDateTime.of(2024, 8, 1, 12, 0);
        BigDecimal charge = new BigDecimal("10.00");

        Stay stay = new Stay(entryGate, exitGate, entryDateTime, exitDateTime, charge, (g1, g2) -> true);
        assertFalse(stay.equals("Some String"));
    }
}
