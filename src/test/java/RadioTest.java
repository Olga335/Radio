package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    // --- Тесты для конструкторов и станций ---

    @Test
    void shouldCreateRadioWithDefaultStationsCount() {
        Radio radio = new Radio();
        // По умолчанию 10 станций (от 0 до 9). Проверим переключение с 9 на 0.
        radio.setCurrentStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldCreateRadioWithCustomStationsCountAndSwitchNext() {
        Radio radio = new Radio(5); // 5 станций (от 0 до 4)
        radio.setCurrentStation(4); // Устанавливаем последнюю
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation()); // Должно перекинуть на 0
    }

    @Test
    void shouldSwitchToPreviousStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToLastStationFromZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationOutsideBoundaries() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        Assertions.assertEquals(0, radio.getCurrentStation()); // Остается прежней

        radio.setCurrentStation(10);
        Assertions.assertEquals(0, radio.getCurrentStation()); // Остается прежней
    }

    // --- Тесты для громкости ---

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume(); // Пытаемся сделать 101-й раз
        Assertions.assertEquals(100, radio.getCurrentVolume()); // Должно остаться 100
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume(); // Делаем громкость 1
        radio.decreaseVolume(); // Уменьшаем обратно
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();
        radio.decreaseVolume(); // Пытаемся уменьшить с 0
        Assertions.assertEquals(0, radio.getCurrentVolume()); // Должно остаться 0
    }
}
