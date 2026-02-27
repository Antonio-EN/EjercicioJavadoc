package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * Esta clase es el planeta de un sistema solar.
 * @author Antonio Espiga Noriega
 */
public class Planet {
    // Constants for error messages
    public static final String INVALID_NAME = "[ERROR] Name cannot be null or empty";
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;

    // Basic constructor
    /**
     * Este es el constructor del planeta básico para el sistema solar.
     * @param name                  el nombre del planeta
     * @param numberOfMoons         el número de lunas del planeta
     * @param mass                  la masa del planeta
     * @param radius                el radio del planeta
     * @param gravity               la gravedad del planeta
     * @param lastAlbedoMeasurement el albedo del planeta
     * @param hasRings              si tiene anillos el planeta
     * @param type                  el tipo de planeta que es
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    // Detailed constructor with atmosphere
    /**
     * Este es el constructor del planeta con su atmósfera.
     * @param name                  el nombre del planeta
     * @param numberOfMoons         el número de lunas del planeta
     * @param mass                  la masa del planeta
     * @param radius                el radio del planeta
     * @param gravity               la gravedad del planeta
     * @param lastAlbedoMeasurement el albedo del planeta
     * @param hasRings              si tiene anillos el planeta
     * @param type                  el tipo de planeta que es
     * @param composition           la composición de la atmósfera
     * @param lastObservation       fecha de la última vez que se observó la atmósfera
     * @param airQuality            la calidad del aire de la atmósfera
     * @param pressure              la presión de la atmósfera
     * @param density               la densidad de la atmósfera
     * @param hasClouds             si tiene nubes la atmósfera
     */
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (IllegalArgumentException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    /**
     * Este método asigna el nombre del planeta.
     * @param name                      el nombre del planeta
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * Este método asigna el número de lunas.
     * @param numberOfMoons             el número de lunas del planeta
     * @throws IllegalArgumentException si el número de lunas es menor a 0
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    /**
     *Este método asigna la masa del planeta.
     * @param mass                      la masa del planeta
     * @throws IllegalArgumentException si la masa es menor al mínimo
     */
    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new IllegalArgumentException(INVALID_MASS);
        }
        this.mass = mass;
    }
    public double getRadius() {
        return radius;
    }

    /**
     *Este método asigna el radio del planeta.
     * @param radius                    el radio del planeta
     * @throws IllegalArgumentException si el radio es menor al mínimo
     */
    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }
    public double getGravity() {
        return gravity;
    }

    /**
     * Este método asigna la gravedad del planeta.
     * @param gravity                   la gravedad del planeta
     * @throws IllegalArgumentException si la gravedad es menor o igual a 0
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new IllegalArgumentException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     * Este método asigna el albedo del planeta.
     * @param lastAlbedoMeasurement el albedo del planeta
     * @throws IllegalArgumentException si el albedo es nulo o está en el futuro
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }
    public boolean hasRings() {
        return hasRings;
    }

    /**
     * Este método asigna si tiene o no anillos el planeta.
     * @param hasRings si tiene anillos del planeta
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     * Este método asigna la atmósfera del planeta
     * @param composition           la composición de la atmósfera
     * @param lastObservation       fecha de la última vez que se observó la atmósfera
     * @param airQuality            la calidad del aire de la atmósfera
     * @param pressure              la presión de la atmósfera
     * @param density               la densidad de la atmósfera
     * @param hasClouds             si tiene nubes la atmósfera
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate IllegalArgumentException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }

    /**
     * Este método asigna el tipo de planeta
     * @param type                      tipo de planeta
     * @throws IllegalArgumentException si el tipo es nulo
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new IllegalArgumentException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }





}
