import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RadioTest {

    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    // ===== Конструкторы =====

    @Test
    public void shouldCreateWithDefaultTenStations() {
        assertEquals(10, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldCreateWithCustomStationsCount() {
        Radio custom = new Radio(30);
        assertEquals(30, custom.getStationsCount());
        assertEquals(0, custom.getCurrentStation());
    }

    @Test
    public void shouldCreateWithSingleStation() {
        Radio single = new Radio(1);
        assertEquals(1, single.getStationsCount());
        assertEquals(0, single.getCurrentStation());
    }

    @Test
    public void shouldThrowOnZeroStationsCount() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
    }

    @Test
    public void shouldThrowOnNegativeStationsCount() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }

    // ===== Сеттер станции при 10 станциях =====

    @Test
    public void shouldSetValidStation() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetMaxStationNine() {
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowZero() {
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationZero() {
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    // ===== Сеттер станции при 30 станциях =====

    @Test
    public void shouldSetStationInThirtyStationRadio() {
        Radio custom = new Radio(30);
        custom.setCurrentStation(29);
        assertEquals(29, custom.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationThirtyInThirtyStationRadio() {
        Radio custom = new Radio(30);
        custom.setCurrentStation(5);
        custom.setCurrentStation(30);
        assertEquals(5, custom.getCurrentStation());
    }

    // ===== next() при 10 станциях =====

    @Test
    public void shouldSwitchToNextStation() {
        radio.setCurrentStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromEightToNine() {
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapFromNineToZero() {
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    // ===== prev() при 10 станциях =====

    @Test
    public void shouldSwitchToPrevStation() {
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromOneToZero() {
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapFromZeroToNine() {
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // ===== next()/prev() при 1 станции =====

    @Test
    public void shouldStayOnZeroWhenNextInSingleStationRadio() {
        Radio single = new Radio(1);
        single.next();
        assertEquals(0, single.getCurrentStation());
    }

    @Test
    public void shouldStayOnZeroWhenPrevInSingleStationRadio() {
        Radio single = new Radio(1);
        single.prev();
        assertEquals(0, single.getCurrentStation());
    }

    // ===== next()/prev() при 30 станциях =====

    @Test
    public void shouldWrapFromTwentyNineToZeroInThirtyStationRadio() {
        Radio custom = new Radio(30);
        custom.setCurrentStation(29);
        custom.next();
        assertEquals(0, custom.getCurrentStation());
    }

    @Test
    public void shouldWrapFromZeroToTwentyNineInThirtyStationRadio() {
        Radio custom = new Radio(30);
        custom.setCurrentStation(0);
        custom.prev();
        assertEquals(29, custom.getCurrentStation());
    }

    // ===== Громкость =====

    @Test
    public void shouldStartWithZeroVolume() {
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeUpToHundred() {
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveHundred() {
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowZero() {
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseFromHundredToNinetyNine() {
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
    }
}