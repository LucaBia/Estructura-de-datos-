package interfaces;

public interface RadioInterface {
    void toggle();
    boolean getState();
    void changeFrecuency();
    boolean getFrecuency();
    void changeStation(boolean up);
    double getStation();
    void saveStation(int numButton);
    void changeStationButton(int numButton);
}
