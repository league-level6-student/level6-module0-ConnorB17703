package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;
    
    Car car;
    
    CellPhone cellphone;

    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	deliveryDriver = new DeliveryDriver("John", car, cellphone);
    	
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expectedResponse = true;
        //when
    	when(cellphone.browseCatMemes()).thenReturn(true);
    	
    	//figure out why wasteTime() method not coming out as true
    	boolean actualResponse  = deliveryDriver.wasteTime();
        
    	//then
    	assertEquals(expectedResponse, actualResponse);
    	
    }

    @Test
    void itShouldRefuel() {
        //given

        //when

        //then
    }

    @Test
    void itShouldContactCustomer() {
        //given

        //when

        //then
    }

}