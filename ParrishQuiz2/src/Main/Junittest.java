package Main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junittest {
//tests the loan method and ensures the value is compounded properly
	@Test
	public void testLoan() {
		assertTrue("MethodFailed",TutionRepayment.Loan(12520,.05,.08)==58142.88);
	}
//tests the payment amount and ensures the monthly payment is correct
	@Test
	public void testPaymentamount(){
		assertTrue("method failed",TutionRepayment.Paymentamount(.08,10,58142.88)==-705.4335759292243);
	}

}
