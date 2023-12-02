package com.example.tp1.controller;
import com.example.tp1.model.Location;
import com.example.tp1.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LocationRestControllerTest {

    @InjectMocks
    private LocationRestController locationRestController;

    @Mock
    private LocationService locationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return OK when saving a valid location")
    void shouldReturnOkWhenSavingValidLocation() {
        Location location = new Location();
        when(locationService.saveLocation(any(Location.class))).thenReturn(location);

        ResponseEntity<Location> response = locationRestController.saveLocation(location);

        assertEquals(200, response.getStatusCodeValue());
        verify(locationService, times(1)).saveLocation(location);
    }

    @Test
    @DisplayName("Should return BadRequest when saving a location throws exception")
    void shouldReturnBadRequestWhenSavingLocationThrowsException() {
        Location location = new Location();
        when(locationService.saveLocation(any(Location.class))).thenThrow(new RuntimeException());

        ResponseEntity<Location> response = locationRestController.saveLocation(location);

        assertEquals(400, response.getStatusCodeValue());
        verify(locationService, times(1)).saveLocation(location);
    }
}