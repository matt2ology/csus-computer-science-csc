public class mainTest {

	public static void main(String[] args) {
		/**************************************\
		|           Main Test Stub             |
		***************************************/
			Employee emp1 = new Employee("Bob", "Jones", 2875.00);
			Employee emp2 = new Employee("Susan", "Baker", 3150.75);
			Employee emp3 = new Employee("John", "Lin", -5000.00);

			emp1.displayWarning();
			emp2.displayWarning();
			emp3.displayWarning();
			emp1.display();
			emp2.display();
			emp3.display();
			System.out.format("%nIncreasing employee salaries by 10%% %n");
			emp1.displayRaise();
			emp2.displayRaise();
			emp3.displayRaise();

		}//End of mainTestStub
		/***************************************\
		|       End Main Test Stub              |
		\***************************************/
	}

