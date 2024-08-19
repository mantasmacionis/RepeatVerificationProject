package cm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
public class GateBlackBox {

    @Test
    @DisplayName("Gate instantiation with valid parameters")
    void gateInstantiationValid() {
        int gateId = 1;
        String location = "Gate A";

        Gate gate = new Gate(gateId, location);

        assertEquals(gateId, gate.getGateId());
        assertEquals(location, gate.getLocation());
    }

    @Test
    @DisplayName("Gate instantiation with negative gateId")
    void gateInstantiationNegativeGateId() {
        int gateId = -1;
        String location = "Gate A";

        assertThrows(IllegalArgumentException.class, () -> new Gate(gateId, location));
    }

    @Test
    @DisplayName("Gate instantiation with null location")
    void gateInstantiationNullLocation() {
        int gateId = 1;
        String location = null;

        assertThrows(IllegalArgumentException.class, () -> new Gate(gateId, location));
    }

    @Test
    @DisplayName("Gate instantiation with empty location")
    void gateInstantiationEmptyLocation() {
        int gateId = 1;
        String location = "";

        assertThrows(IllegalArgumentException.class, () -> new Gate(gateId, location));
    }

    @Test
    @DisplayName("Gate equality and hashCode")
    void gateEqualityAndHashCode() {
        Gate gate1 = new Gate(1, "Gate A");
        Gate gate2 = new Gate(1, "Gate A");
        Gate gate3 = new Gate(2, "Gate B");

        assertEquals(gate1, gate2);
        assertNotEquals(gate1, gate3);
        assertEquals(gate1.hashCode(), gate2.hashCode());
        assertNotEquals(gate1.hashCode(), gate3.hashCode());
    }
}
