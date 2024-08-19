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

}
