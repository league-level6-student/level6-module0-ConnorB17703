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
import static org.mockito.Mockito.*;

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
    	myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
    	
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    	boolean expectedResults = true;
    	
    	//NOTE: why isn't when method working and what kind of data should be returned to test?
    	
        //when
    	when(deliveryService.scheduleDelivery(order)).thenReturn(true);
    	Order actualResults = myDonutShop.addOrder(order);
    	
        //then
    	
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given

        //when

        //then
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

        //when

        //then
    }

}