public class Radio {

    private final int stationsCount;
    private int currentStation;
    private int currentVolume;

    public Radio() {
        this(10);
    }

    public Radio(int stationsCount) {
        if (stationsCount < 1) {
            throw new IllegalArgumentException("stationsCount must be positive");
        }
        this.stationsCount = stationsCount;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationsCount) {
            this.currentStation = station;
        }
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}