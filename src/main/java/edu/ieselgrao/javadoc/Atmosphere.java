package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * Esta clase es la atmósfera de un planeta
 * @author Antonio Espiga Noriega
 */
public class Atmosphere {
    // Constants for error messages
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    /**
     * Este es el constructor de la atmósfera para el planeta
     * @param composition       La composición de la atmósfera
     * @param lastObservation   Fecha de la última vez que se observó la atmósfera
     * @param airQuality        La calidad del aire de la atmósfera
     * @param pressure          La presión de la atmósfera
     * @param density           La densidad de la atmósfera
     * @param hasClouds         Si tiene nubes la atmósfera
     */
    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     * Este método asigna la composición de la atmósfera
     * @param composition               la composición de la atmósfera
     * @throws IllegalArgumentException cuando la composición es nula o está vacía o tiene carácteres especiales
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    /**
     * Este método asigna la fecha de la última observación de la atmósfera
     * @param lastObservation           última vez que se observó la atmósfera
     * @throws IllegalArgumentException si la fecha es nula o está en el futuro
     */
    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     * Este método asigna la calidad del aire
     * @param airQuality    nivel de calidad del aire
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     * Este método asigna la presión de la atmósfera
     * @param pressure                  la presión de la atmósfera
     * @throws IllegalArgumentException si la presión es menor a 0
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }


    /**
     * Este método asigna la densidad de la atmósfera
     * @param density                   la densidad a asignar
     * @throws IllegalArgumentException cuando la densidad es menor que 0
     */
    public void setDensity(double density) {
        if (density < 0) {
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }

    /**
     * Este método indica si tiene nubes o no
     * @return true si tiene y false si no tiene.
     */
    public boolean hasClouds() {
        return hasClouds;
    }

    /**
     * Este método asigna si la atmósfera tiene nubes o no
     * @param hasClouds true si tiene y false si no tiene.
     */
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
