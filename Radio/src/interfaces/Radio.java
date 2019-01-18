package interfaces;

/**
 * Interfaz que contiene los elementos basicos para crear un radio
 */
public interface Radio {
    void toggle();
    boolean getState();
    void changeFrecuency();
    boolean getFrecuency();
    void changeStation(boolean up);
    double getStation();
    void saveStation(int numButton);
    void changeStationButton(int numButton);
}
