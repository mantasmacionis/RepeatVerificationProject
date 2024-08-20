package cm;

import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Stay {

    private Gate entryGate;
    private Gate exitGate;
    private LocalDateTime entryDateTime;
    private LocalDateTime exitDateTime;
    private BigDecimal charge;
    private CarParkValidator carParkValidator;

    public Stay(Gate entryGate, Gate exitGate, LocalDateTime entryDateTime, LocalDateTime exitDateTime, BigDecimal charge, CarParkValidator carParkValidator) {
        if (entryGate == null || exitGate == null || entryDateTime == null || exitDateTime == null || charge == null) {
            throw new NullPointerException("Arguments cannot be null");
        }
        if (entryDateTime.isAfter(exitDateTime)) {
            throw new IllegalArgumentException("Entry date time must be before exit date time");
        }
        if (charge.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Charge must be non-negative");
        }
        if (!carParkValidator.belongToSameCarPark(entryGate, exitGate)) {
            throw new IllegalArgumentException("Entry and exit gates must belong to the same CarPark if they are different");
        }
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.entryDateTime = entryDateTime;
        this.exitDateTime = exitDateTime;
        this.charge = charge;
        this.carParkValidator = carParkValidator;
    }
}
