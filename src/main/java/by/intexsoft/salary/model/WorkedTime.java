package by.intexsoft.salary.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * @author Tsimur Haidel
 */
@Schema(description = "Time of work")
public class WorkedTime {

    @Positive
    @NotNull
    private String mitarbeiterId;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime beginn;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime ende;
    @Positive
    private int dauer;

    @Schema(description = "ID")
    public String getMitarbeiterId() {
        return mitarbeiterId;
    }

    public void setMitarbeiterId(String mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }

    @Schema(description = "Starting work that day")
    public LocalDateTime getBeginn() {
        return beginn;
    }

    public void setBeginn(LocalDateTime beginn) {
        this.beginn = beginn;
    }

    @Schema(description = "Ending work that day")
    public LocalDateTime getEnde() {
        return ende;
    }

    public void setEnde(LocalDateTime ende) {
        this.ende = ende;
    }

    @Schema(description = "Time worked on the day in minutes")
    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

}
