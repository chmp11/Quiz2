package Main;
//import Scanner
import java.util.Scanner;
//import finacelib to use the pmt method
import org.apache.poi.ss.formula.functions.FinanceLib;

public class TutionRepayment {
	//since it's only printing a string, we don't want the class
	//to return anything
	public static void main(String[] args) {
		//define variables
		Scanner input = new Scanner(System.in);
		//asks the user to create the repayapr variable amount
		System.out.print("What is the apr on the loan repayment?");
		double repayapr=input.nextDouble();
		//asks the user to create the tution variable amount
		System.out.print("What is the cost of tution without room and board?");
		double tution=input.nextDouble();
		//asks the user to create the years variable amount
		System.out.print("In how many years do you expect to pay the loan back?");
		double years=input.nextDouble();
		//asks the user to create the rateinc variable amount
		System.out.print("What is the annual rate increase as a decimal?");
		double rateinc=input.nextDouble();
		//calculate the totloan value with the loan method
		double Totloan=Loan(tution,rateinc,repayapr);
		//calculate the monthly payment with the Paymentamount method
		double monthpay=Paymentamount(repayapr,years,Totloan);
		System.out.printf("Your monthly payment amount will be $%.2f",monthpay);
		
	}
	
	public static double Loan(double tution, double rateinc,double repayapr){ 
		double loan2=0;
		//use a for loop to get the compound loan amount with increase and apr
		for (int y=0; y<4; y++){
			double tution2=tution+(rateinc*y*tution);
			loan2=loan2+tution2+(tution2*repayapr);
			} 
		return loan2;
	}
	public static double Paymentamount(double repayapr, double years, double Totloan){
		//rate needs to be a monthly rate so we divide repayapr by 12
		double rate=(repayapr/12);
		//pmt function needs months so multiply years by 12
		double months=(years*12);
		//the present value is the value of the loan after college
		double PV=Totloan;
		//type is false because we want pmt to run after the variables are defined
		boolean type=false;
		//fv is zero because we want to pay off the loan and owe 0 dollars
		double FV=0;
		//use the finance lib pmt method to create monthly payment
		double PMT=FinanceLib.pmt(rate,months,PV,FV,type);
		return PMT;
		
	}
	
}
