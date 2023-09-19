package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
    	int hourlyWage = 18;
    	int hoursWorked = 8;
    	int expected = 144;
    	
        //when
    	double paycheck = payroll.calculatePaycheck(hourlyWage, hoursWorked);
        
    	//then
    	assertEquals(expected, paycheck);
    	
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
    	int milesTraveled = 35;
    	double expected = 20.125;
    	
        //when
    	double reimbursement = payroll.calculateMileageReimbursement(milesTraveled);
    	
        //then
    	assertEquals(expected, reimbursement);
    	
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
    	String employeeName = "John";
    	double hourlyWage = 15;
    	String expected = "Hello John, We are pleased to offer you an hourly wage of " + hourlyWage;
    	
        //when
    	String letter = payroll.createOfferLetter(employeeName, hourlyWage);
    	
        //then
    	assertEquals(expected, letter);
    	
    }

}