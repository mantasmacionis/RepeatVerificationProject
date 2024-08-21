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
}
