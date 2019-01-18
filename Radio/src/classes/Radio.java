package classes;

import interfaces.RadioInterface;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase Radio se utiliza para crear las funciones primordiales que contiene un radio.
 */
public class Radio implements RadioInterface {
    private boolean isOn = false;
    private boolean isInFM = false;
    private double station = 550.0;
    private ArrayList<Double> buttons = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));

    private static final double FM_Increment = 0.2;
    private static final double FM_Min = 87.9;
    private static final double FM_Max = 107.9;
    private static final double AM_Increment = 10.0;
    private static final double AM_Min = 530.0;
    private static final double AM_Max = 1610.0;

    /**
     * Cambia el estado del radio (Encendido/apagado)
     */
    @Override
    public void toggle() {
        this.isOn = !this.isOn;
    }

    /**
     * Captura el estado en el que se encuentra el radio
     * @return estado del radio
     */
    @Override
    public boolean getState() {
        return this.isOn;
    }

    /**
     * Cambia la frecuencia del radio
     */
    @Override
    public void changeFrecuency() {
        this.isInFM = !this.isInFM;
        if (this.isInFM) {
            this.station = FM_Min;
        } else {
            this.station = AM_Min;
        }
    }

    /**
     * Captura la frecuencia en la que se encuentra el radio
     * @return la frecuencia actual
     */
    @Override
    public boolean getFrecuency() {
        return this.isInFM;
    }

    /**
     * Cambia de estacion ya sea para subir o bajar de estacion
     * @param up indica si va la estacion puede subir o  bajar
     */
    @Override
    public void changeStation(boolean up) {
        if (this.isInFM) {
            if (up && this.station < FM_Max) {
                this.station += FM_Increment;
            } else if (!up && this.station > FM_Min){
                this.station -= FM_Increment;
            }
        } else {
            if (up && this.station < AM_Max) {
                this.station += AM_Increment;
            } else if (!up && this.station > AM_Min){
                this.station -= AM_Increment;
            }
        }
    }

    /**
     * captura la estacion en la que se encuentra el radio
     * @return estacion actual
     */
    @Override
    public double getStation() {
        return this.station;
    }

    /**
     * Guarda una estacion en cualquiera de los 12 botones
     * @param numButton cual de los 12 botones es
     */
    @Override
    public void saveStation(int numButton) {
        if (numButton <= 12) {
            this.buttons.add((numButton-1), this.station);
        }
    }

    /**
     * Cambia la estacion actual a la estacion guardada en el boton
     * @param numButton cual de los 12 botones presiono
     */
    @Override
    public void changeStationButton(int numButton) {
        if (numButton <= 12) {
            this.station = this.buttons.get(numButton-1);
            this.isInFM = this.station < FM_Max && this.station > FM_Min;
            if (this.buttons.get(numButton-1) != null ){
                this.station = this.buttons.get(numButton-1);
            }
        }
    }

    /**
     * Imprime la interfaz del radio con todas sus propiedades
     * @return radio completo
     */
    @Override
    public String toString() {
        String radio = "Radio: ";
        if (this.isOn) {
            radio += "ON\n";
        } else {
            radio += "OFF\n";
        }
        if (this.isInFM) {
            radio += "Frecuencia: FM\n";
        } else {
            radio += "Frecuencia: AM\n";
        }
        radio += "Estacion: " + this.station;

        return radio;
    }
}
