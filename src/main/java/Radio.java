package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationsCount;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.stationsCount = 10;
    }

    // Конструктор с кастомным количеством станций
    public Radio(int stationsCount) {
        this.stationsCount = stationsCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    // Сеттер с проверкой, чтобы номер станции не выходил за пределы (от 0 до stationsCount - 1)
    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationsCount) {
            this.currentStation = currentStation;
        }
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0; // Переход на первую (нулевую) станцию
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1; // Переход на последнюю станцию
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    // Увеличение громкости до максимума 100
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости до минимума 0
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
