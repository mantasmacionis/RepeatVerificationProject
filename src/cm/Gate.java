package cm;

import java.util.Objects;

public class Gate {

    private int gateId;
    private String location;

    public Gate(int gateId, String location) {
        if (gateId < 0) {
            throw new IllegalArgumentException("Gate ID must be non-negative");
        }
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        this.gateId = gateId;
        this.location = location;
    }

    public int getGateId() {
        return gateId;
    }

    public String getLocation() {
        return location;
    }
}
