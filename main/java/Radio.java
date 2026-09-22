public class Radio {

    private int currentStation;   // от 0 до 9
    private int currentVolume;    // от 0 до 100

    // ===== Радиостанции =====

    public int getCurrentStation() {
        return currentStation;
    }

    /**
     * Установка номера радиостанции с проверкой допустимости.
     * Если номер вне диапазона 0..9 — значение не меняется.
     */
    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station;
        }
    }

    /**
     * Переключение на следующую радиостанцию.
     * Если текущая 9 — становится 0. Иначе +1.
     */
    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }

    /**
     * Переключение на предыдущую радиостанцию.
     * Если текущая 0 — становится 9. Иначе -1.
     */
    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation = currentStation - 1;
        }
    }

    // ===== Громкость =====

    public int getCurrentVolume() {
        return currentVolume;
    }

    /**
     * Увеличение громкости на 1, но не более 100.
     */
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    /**
     * Уменьшение громкости на 1, но не менее 0.
     */
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}
