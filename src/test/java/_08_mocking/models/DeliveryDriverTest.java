package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.GasTank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    @Mock
	DeliveryDriver deliveryDriver;
    
    @Mock
    Car car;
    
    @Mock
    CellPhone cellphone;
    
    @Mock
    GasTank gasTank;

    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	//cellphone = new CellPhone();
    	deliveryDriver = new DeliveryDriver("John", car, cellphone);
    	
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expectedResponse = true;
        //when
    	when(cellphone.browseCatMemes()).thenReturn(true);
    	boolean actualResponse  = deliveryDriver.wasteTime();
        
    	//then
    	assertEquals(expectedResponse, actualResponse);
    	
    }

    @Test
    void itShouldRefuel() {
        //given
    	boolean expectedResponse = true;
    	int octane = 85;
    	
        //when
    	when(car.fillTank(octane)).thenReturn(true);
    	boolean actualResponse = car.fillTank(octane);
    	
        //then
    	assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void itShouldContactCustomer() {
        //given
    	boolean expectedCall = true;
    	String number = "6198854024";
    	
        //when
    	when(deliveryDriver.contactCustomer(number)).thenReturn(true);
    	boolean actualCall = deliveryDriver.contactCustomer(number);
    	
        //then
    	assertEquals(expectedCall, actualCall);
    }

}