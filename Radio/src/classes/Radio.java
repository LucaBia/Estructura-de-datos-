package classes;

import interfaces.RadioInterface;

import java.util.ArrayList;

public class Radio implements RadioInterface {
    private boolean isOn = false;
    private boolean isInFM = false;
    private double station;
    private ArrayList<Double> buttons;

    private static final double FM_Increment = 0.2;
    private static final double FM_Min = 87.9;
    private static final double FM_Max = 107.9;
    private static final double AM_Increment = 10.0;
    private static final double AM_Min = 530.0;
    private static final double AM_Max = 1610.0;

    @Override
    public void toggle() {
        this.isOn = !this.isOn;
    }

    @Override
    public boolean getState() {
        return this.isOn;
    }

    @Override
    public void changeFrecuency() {
        this.isInFM = !this.isInFM;
        if (this.isInFM) {
            this.station = FM_Min;
        } else {
            this.station = AM_Min;
        }
    }

    @Override
    public boolean getFrecuency() {
        return this.isInFM;
    }

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

    @Override
    public double getStation() {
        return this.station;
    }

    @Override
    public void saveStation(int numButton) {
        if (numButton <= 12) {
            this.buttons.add((numButton-1), this.station);
        }
    }

    @Override
    public void changeStationButton(int numButton) {
        if (numButton <= 12) {
            this.station = this.buttons.get(numButton-1);
        }
    }
}
