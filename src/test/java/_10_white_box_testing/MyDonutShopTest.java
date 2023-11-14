package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class MyDonutShopTest {

	@Mock
    MyDonutShop myDonutShop;
	
	@Mock
	BakeryService bakeryService;
	
	@Mock
	PaymentService paymentService;
	
	@Mock
	DeliveryService deliveryService;

	@Mock
	Order order;
	
    @BeforeEach
    void setUp() {
    	
    	MockitoAnnotations.openMocks(this);
    	
    	
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    	order  = new Order ("John", "6195177937", 5, 6, "12323", true);
    
    	myDonutShop.openForTheDay();
    	when(bakeryService.getDonutsRemaining()).thenReturn(50);
        //when
    	myDonutShop.takeOrder(order);
    	
        //then
    	verify(myDonutShop, times(1)).takeOrder(order);
    }

    //NOTE: you are verifying how many times method is being called and using the when to stub (force) outcomes on methods
    
    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException(){
        //given
    	myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
    	order = new Order("John", "6195177937", 5, 6, "12323", true);
    	
        //when
    	myDonutShop.openForTheDay();
    	bakeryService.setDonutsRemaining(3);
    	
        //then
    	//Why is it saying that there's nothing being thrown in???
    	
    	Throwable exceptionThrown = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
    	//assertEquals(exceptionThrown.getMessage(), "Insufficient donuts remaining");
    	//verify(myDonutShop, never()).takeOrder(any());
    	
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
    	myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
    	order = new Order("John", "6195177937", 5, 6, "12323", true);
    	
        //when
    	myDonutShop.closeForTheDay();
    	    	
        //then
    	Throwable exceptionThrown = assertThrows(Exception.class, ()-> myDonutShop.takeOrder(order));
    	 
    	
    }

}