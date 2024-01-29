import java.util.*;

import java.text.*;

/**

* Car shop program.

* Allows a user to store, search for or sort cars.

* Can also sort stock together such as the same manufacturers

*

* Cars can be entered manually or you may use the examples added to make it easier to test

* Storing can be done manually as seen in the main method or done as a user experience (via option 1 in the menu) as seen in the method "storeCar()"

* on lines

* User is asked separately details about the car which are then stored in an ArrayList which is then stored within a list

* for easy access and amending. Every car stored will get it's own unique ID (1 above the last ID)

*

* Search can be accessed via option 2 in the menu

* The code for storing cars can be seen in the method "search()"

* This allows the user to look for any specific detail of a car which will bring up all the options for their query.

* I would have looked at implementing an option which would allow you to search (narrow down) an already searched list but

* unfortunately I did not have enough time to do this.

* Sorting can be seen in the "sort()" method. It's a rather short method which does what it needs to do. For the

* string fields that need to be sorted use the "alphaSort()" method which sorts the chosen field alphabetically using java's

* built in comparator utility.

*

* For the int/double fields I used the "sorting" method which is just a variation of the selection sort algorithm made to work with my code

* I chose this one because it was really simple to implement and it's good for comparison operations which it's trying to compare the different

* fields and output them in the correct order. It may not be the best in extremely large databases but for this purpose it's pretty well suited.

**/


public class CarShop {

	//Below is the list where all added cars will be stored as well
	List < ArrayList<Object>> stock = new ArrayList < ArrayList<Object>>();

	Scanner scan = new Scanner(System.in); //initiating scanner class

	/**

	* Main method

	* Creating an instance of CarShop and intitiates the entire program

	**/

	public static void main(String args[]) {

		CarShop shop = new CarShop();

		/**

		ArrayList<Object> car1 = new ArrayList<Object>();

		car1.add(1);

		car1.add("Honda");

		car1.add("Fit");

		car1.add(2013);

		car1.add(200500);

		car1.add(1.3);

		car1.add("A");

		car1.add(5550.50);

		ArrayList<Object> car2 = new ArrayList<Object>();

		car2.add(2);

		car2.add("Toyota");

		car2.add("Prius");

		car2.add(2012);

		car2.add(88000);

		car2.add(1.8);

		car2.add("A");

		car2.add(8450.00);

		ArrayList<Object> car3 = new ArrayList<Object>();

		car3.add(3);

		car3.add("Volkswagen");

		car3.add("Golf");

		car3.add(2016);

		car3.add(74550);

		car3.add(1.5);

		car3.add("B");

		car3.add(12500.00);

		ArrayList<Object> car4 = new ArrayList<Object>();

		car4.add(4);

		car4.add("Toyota");

		car4.add("Yaris");

		car4.add(2011);

		car4.add(110100);

		car4.add(1.0);

		car4.add("A");

		car4.add(6500.50);

		ArrayList<Object> car5 = new ArrayList<Object>();

		car5.add(5);

		car5.add("Toyota");

		car5.add("Prius");

		car5.add(2015);

		car5.add(52300);

		car5.add(1.8);

		car5.add("C");

		car5.add(9999.95);

		ArrayList<Object> car6 = new ArrayList<Object>();

		car6.add(6);

		car6.add("Volkswagen");

		car6.add("Polo");

		car6.add(2012);

		car6.add(140820);

		car6.add(1.2);

		car6.add("B");

		car6.add(3050.50);

		shop.stock.add(car1);

		shop.stock.add(car2);

		shop.stock.add(car3);

		shop.stock.add(car4);

		shop.stock.add(car5);

		shop.stock.add(car6);
		**/
		shop.menu();

	}

	int idCount = stock.size() + 1; //ID counter, will increase by 1 for each car added/
	public static void Output(List < ArrayList<Object>> list) {

		DecimalFormat priceFormat = new DecimalFormat("#,##0.00");

		System.out.println("ID | Manufacturer | Model | Year | Mileage | Engine Size | Grade | Price ");

		for (ArrayList<Object> info: list) {

			String formattedPrice = "\u00A3" + priceFormat.format(Double.parseDouble(info.get(7).toString()));

			System.out.println(info.get(0) + " | " + info.get(1) + " | " + info.get(2) + " | " + info.get(3) + " | " +

				info.get(4) + " | " + info.get(5) + "L | " + info.get(6) + " | " + formattedPrice);

		}

	}

	/**

	* Error method

	* Will initiated whenever there is a misinput with an entry such as an option that doesn't exist

	* Will also initiated when the wrong data type is entered

	* Will prompt the user to check whether they entered their data correctly then gives them the options to return to sorting, menu or search.

	* Will keep looping until the user enters a correct input (a, b or c).

	**/

	public void error() {

		System.out.println("Please check you have chosen an option correctly.");

		System.out.println("Would you like to:");

		System.out.println("a) Return to sort");

		System.out.println("b) Return to search options");

		System.out.println("c) Return to menu");

		String choice1 = scan.next();

		while (!choice1.toLowerCase().equals("a") && !choice1.toLowerCase().equals("b") && !choice1.toLowerCase().equals("c")) {

			System.out.println("Please enter a valid input (a,b,c)");

			choice1 = scan.next();

		}

		if (choice1.toLowerCase().equals("a")) {

			sort();

		}

		if (choice1.toLowerCase().equals("b")) {

			search();

		}

		if (choice1.toLowerCase().equals("c")) {

			menu();

		}

	}

	/**

	* After a result comes up (no result or any number of them) it will

	* give the user the option to return to menu or leave completely.

	* Created this to stop me having to repeat this for every option and rather can just be called here simply.

	**/

	public void Result() {

		System.out.println("Would you like to: \n1) Return to menu \n2) Leave?");

		int op = scan.nextInt();

		if (op == 1) {

			menu();

		} else if (op == 2) {} else {

		}

	}

	/**

	* Menu method

	* This is the initial method which is called to run the program

	* user is given options of what they want to do which will call the relevant method

	* depending on their option

	**/

	public void menu() {

		System.out.println("Welcome to the car shop! What would you like to do? ");

		System.out.println("1) Store a new car ");

		System.out.println("2) Search for a car ");

		System.out.println("3) Sort cars ");

		System.out.println("4) Leave");

		int choice = scan.nextInt();

		if (choice == 1) {

			storeCar();

		}

		if (choice == 2) {

			search();

		}

		if (choice == 3) {

			sort();

		}

		if (choice == 4) {

			System.out.println("Thanks for visiting. Please come again!");

		}

		if (choice < 1 || choice > 3); {

		}

	}

	/**

	* storeCar method

	* Allows the user to store a new car

	* Each bit of information is entered separately to make it simple on the user.

	**/

	public void storeCar() {

		try {

			System.out.println("Please enter the manufacturer of the car:");

			String manufacturer = scan.next();

			System.out.println("Please enter the model of the car:");

			String model = scan.next();

			System.out.println("Please enter the year the car was made:");

			int year = scan.nextInt();

			System.out.println("Please enter the mileage of the car:");

			int mileage = scan.nextInt();

			System.out.println("Please enter the engine size of the car:");

			double engineSize = scan.nextDouble();

			System.out.println("Please enter the grade of the car:");

			System.out.println(" ");

			System.out.println("A=Excellent - Very slightly used, virtually as good as new.");

			System.out.println("B=Good - Good condition but with visible flaws.");

			System.out.println("C=Average - Average condition, with minor damage.");

			System.out.println("D=Poor - Poor condition with significant damage, but the car is functional.");

			char grade = scan.next().charAt(0);

			System.out.println("Please enter the price of the car:");

			double price = scan.nextDouble();

			/**

			* Below the information entered will be added to an ArrayList

			* which will then be added to the stock ArrayList

			**/

			ArrayList<Object> newCar = new ArrayList<Object>();

			newCar.add(idCount);

			newCar.add(manufacturer);

			newCar.add(model);

			newCar.add(year);

			newCar.add(mileage);

			newCar.add(engineSize);

			newCar.add(grade);

			newCar.add(price);

			stock.add(newCar);

			System.out.println("New car added.");

			menu();

			idCount++;

		} catch (Exception e) {

			error();

		}

	}

	/**

	* Search method

	* Is called upon if user chooses search option.

	* Will ask the user what specific they would like to search for and then bring up all of the relevant searches.

	* If no results come up the Result method will be called upon.

	**/

	public void search() {

		/**

		* Results count

		* (if it stays on zero on a search option no results found will be returned)

		* (if only 1 option is found a custom output if "1 result found" is given out)

		* where as all other number of results will say " results".

		* Is reset to 0 every time the search method is called.

		**/

		int n = 0;

		if (stock.size() == 0) {

			System.out.println("No cars available ");

			Result();

		}

		/**

		* User asked which option they'd like to search for

		**/

		System.out.println("What would you like to search for?");

		System.out.println("1) ID");

		System.out.println("2) Manufacturer");

		System.out.println("3) Model");

		System.out.println("4) Year");

		System.out.println("5) Mileage");

		System.out.println("6) Engine Size");

		System.out.println("7) Grade");

		System.out.println("8) Price");

		System.out.println("9) List all cars");

		System.out.println("10) Lowest mileage car");

		System.out.println("11) Cheapest car");

		/**

		* try catch block to give out custom errors and not have the program completely terminate

		* mainly used to give misinput messages for users that try entering any other data type than

		* int for inputs that take integer inputs

		* if wrong data type is entered it will initiate the catch block which intiates the error method

		**/

		try {

			/**

			* input for above ask of user

			**/

			int entry = scan.nextInt();

			if (entry == 1) {

				System.out.println("Please enter the ID you are looking for.");

				int id = scan.nextInt();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				/**

				* for loop to search for the specific ID looked for and output it accordingly

				**/

				for (int i = 0; i < stock.size(); i++) {

					int x = (Integer) stock.get(i).get(0);

					if (id == x) {

						temp.add(stock.get(i));

						n++;

						Output(temp);

						Result();

						/**

						* Once the correct ID is found the loop will break

						* n++ to let the program know a result was found

						**/

						break;

					}

				}

				/**

				* If ID number is not found it will tell the user so and the Result method is inititated

				**/

				if (n == 0) {

					System.out.println("No results found");

					Result();

				}

			}

			/**

			* Allows user to search for the manufacturer they would like

			* Will output all cars from said manufacturer in stock.

			* If they do not exist it will tell the user no results were found

			**/

			if (entry == 2) {

				System.out.println("Please enter the manufacturer you are looking for.");

				String manufacturer = scan.next();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				for (int i = 0; i < stock.size(); i++) {

					String conv = (String) stock.get(i).get(1);

					if (manufacturer.toLowerCase().equals(conv.toLowerCase())) {

						temp.add(stock.get(i));

						n++;

					}

				}

				Output(temp);

				if (n == 0) {

					System.out.println("No results found.");

					Result();

				} else {

					System.out.println(n + " result(s) found.");

					Result();

				}

			}

			/**

			* Allows user to search for the model they would like

			* Will output all cars of said model in stock.

			* If they do not exist it will tell the user no results were found

			**/

			if (entry == 3) {

				System.out.println("Please enter the model you are looking for.");

				String model = scan.next();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				for (int i = 0; i < stock.size(); i++) {

					String conv = (String) stock.get(i).get(2);

					if (model.equals(conv.toLowerCase())) {

						temp.add(stock.get(i));

						n++;

					}

				}

				Output(temp);

				if (n == 0) {

					System.out.println("No results found");

					Result();

				} else {

					System.out.println(n + " result(s) found.");

					Result();

				}

			}

			/**

			* Allows user to search for cars from a certain year they would like

			* User can choose to output all options of exactly that year or newer/older cars (inclusive)

			* If no cars of the requested options are available no result will come up.

			**/

			if (entry == 4) {

				System.out.println("Please enter the year you are looking for.");

				int year = scan.nextInt();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				System.out.println("Would you like:");

				System.out.println("1) All cars from " + year);

				System.out.println("2) All cars newer than " + year);

				System.out.println("3) All cars older than " + year);

				int option = scan.nextInt();

				if (option == 1) {

					for (int i = 0; i < stock.size(); i++) {

						int y = (Integer) stock.get(i).get(3);

						if (year == y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

					if (n == 0) {

						System.out.println("No results found");

						Result();

					} else {

						System.out.println(n + " result(s) found.");

						Result();

					}

				}

				/**

				* Outputs all cars with years above entered years (inclusive)

				**/
				else if (option == 2) {

					for (int i = 0; i < stock.size(); i++) {

						int y = (Integer) stock.get(i).get(3);

						if (year <= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

					if (n == 0) {

						System.out.println("No results found");

						Result();

					} else {

						System.out.println(n + " result(s) found.");

						Result();

					}

				}

				/**

				* Outputs all cars with years below entered years (inclusive)

				**/
				else if (option == 3) {

					for (int i = 0; i < stock.size(); i++) {

						int y = (Integer) stock.get(i).get(4);

						if (year >= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

					if (n == 0) {

						System.out.println("No results found");

					} else {

						System.out.println(n + " result(s) found.");

					}

				}

				if (option < 1 || option > 3) {

					error();

				}

				/**

				* Allows user to search for cars from a certain mileage they would like

				* User can choose to output all options of cars with more or less miles than entered (inclusive)

				* If no cars of the requested options are available no result will come up.

				**/

			}

			if (entry == 5) {

				System.out.println("Please enter the mileage you are looking for.");

				int mileage = scan.nextInt();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				System.out.println("Would you like:");

				System.out.println("1) All cars with mileage above " + mileage);

				System.out.println("2) All cars with mileage below " + mileage);

				int option1 = scan.nextInt();

				/**

				* All cars with mileage above the entered are output (inclusive)

				**/

				if (option1 == 1) {

					for (int i = 0; i < stock.size(); i++) {

						int y = (Integer) stock.get(i).get(4);

						if (mileage <= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

				}

				/**

				* All cars with mileage below entered are output (inclusive)

				**/
				else if (option1 == 2) {

					for (int i = 0; i < stock.size(); i++) {

						int y = (Integer) stock.get(i).get(4);

						if (mileage >= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

					/**

					* if int number is entered outside of the available options error will be triggered

					* since try catch block does not pick up these errors

					**/

				}

				if (option1 < 1 || option1 > 2) {

					error();

				}

				if (n == 0) {

					System.out.println("No results found");

				} else {

					System.out.println(n + " result(s) found.");

				}

				Result();

				/**

				* Allows user to search for cars from a certain engine sizes they would like

				* User can choose to output all options of cars exactly at the engine size entered

				* Or higher or lower that that engine size (inclusive)

				* If no cars of the requested options are available no result will come up.

				**/

			} else if (entry == 6) {

				System.out.println("Please enter the engine size you are looking for.");

				double engineSize = scan.nextDouble();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				System.out.println("Would you like:");

				System.out.println("1) All cars with engine size " + engineSize + "L");

				System.out.println("2) All cars with an engine size bigger than " + engineSize + "L");

				System.out.println("3) All cars with an engine size smaller than " + engineSize + "L");

				int option = scan.nextInt();

				if (option == 1) {

					for (int i = 0; i < stock.size(); i++) {

						double e = (double) stock.get(i).get(5);

						if (engineSize == e) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

				} else if (option == 2) {

					for (int i = 0; i < stock.size(); i++) {

						double y = (double) stock.get(i).get(5);

						if (engineSize <= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

				} else if (option == 3) {

					for (int i = 0; i < stock.size(); i++) {

						double y = (double) stock.get(i).get(5);

						if (engineSize >= y) {

							temp.add(stock.get(i));

							n++;

						}

					}

					Output(temp);

				}

				if (option < 1 || option > 3) {

					error();

				}

				if (n == 0) {

					System.out.println("No results found");

				} else {

					System.out.println(n + " result(s) found.");

				}

				Result();

			}

			/**

			* Allows user to search for cars from a certain grade they would like

			* User can choose to output all options of cars at a certain grade or higher or lower (inclusive)

			* If no cars of the requested options are available no result will come up.

			**/
			else if (entry == 7) {

				System.out.println("Please enter the grade you are looking for.");

				System.out.println("");

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				/**

				* Grades explained for user

				**/

				System.out.println("A=Excellent - Very slightly used, virtually as good as new.");

				System.out.println("B=Good - Good condition but with visible flaws.");

				System.out.println("C=Average - Average condition, with minor damage.");

				System.out.println("D=Poor - Poor condition with significant damage, but the car is functional.");

				String grade = scan.next();

				/**

				* Check to see if correct grade input is done

				**/

				if (!grade.toLowerCase().equals("a") && !grade.toLowerCase().equals("b") && !grade.toLowerCase().equals("c") && !grade.toLowerCase().equals("d")) {

					error();

				}

				for (int i = 0; i < stock.size(); i++) {

					String g = (String) stock.get(i).get(6);

					if (grade.toLowerCase().equals(g.toLowerCase())) {

						temp.add(stock.get(i));

						n++;

					}

				}

				if (n == 0) {

					System.out.println("No results found");

					Result();

				} else {

					Output(temp);

					System.out.println(n + " result(s) found.");

					Result();

				}

				/**

				* Allows user to search for cars which are more or less expensive than the price they would enter

				**/

				Result();

			}

			if (entry == 8) {

				System.out.println("Please enter the price you are looking for.");

				double a = scan.nextDouble();

				double price = (double) Math.round(a * 100) / 100;

				NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(Locale.UK);

				String priceOutput = defaultFormat.format(a);

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				System.out.println("Would you like:");

				System.out.println("1) All cars that are cheaper than \u00A3" + priceOutput);

				System.out.println("2) All cars that are more expensive than \u00A3" + priceOutput);

				int option2 = scan.nextInt();

				if (option2 == 1) {

					for (int i = 0; i < stock.size(); i++) {

						double p = (double) stock.get(i).get(7);

						if (price >= p) {

							temp.add(stock.get(i));

							n++;

						}

					}

					if (n == 0) {

						System.out.println("No results found");

						Result();

					} else {

						Output(temp);

						System.out.println(n + " result(s) found.");

						Result();

					}

				} else if (option2 == 2) {

					for (int i = 0; i < stock.size(); i++) {

						double p = (double) stock.get(i).get(7);

						if (price <= p) {

							temp.add(stock.get(i));

							n++;

						}

					}

					if (n == 0) {

						System.out.println("No results found");

						Result();

					} else {

						Output(temp);

						System.out.println(n + " result(s) found.");

						Result();

					}

				}

				Result();

			}

			/**

			* Simply outputs all cars in stock

			**/

			if (entry == 9) {

				Output(stock);

				Result();

			}

			if (entry == 10) {

				double mileage = Double.POSITIVE_INFINITY;

				ArrayList<Object> lowestMileage = new ArrayList<Object>();

				for (int i = 0; i < stock.size(); i++) {

					int conv = (Integer) stock.get(i).get(4);

					if (conv < mileage) {

						mileage = conv;

						lowestMileage = stock.get(i);

					}

				}

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				temp.add(lowestMileage);

				Output(temp);

				Result();

			}

			if (entry == 11) {

				double price = Double.POSITIVE_INFINITY;

				ArrayList<Object> lowestPrice = new ArrayList<Object>();

				List < ArrayList<Object>> temp = new ArrayList < ArrayList<Object>>();

				for (int i = 0; i < stock.size(); i++) {

					double conv = (double) stock.get(i).get(7);

					if (conv < price) {

						price = conv;

						lowestPrice = stock.get(i);

					}

				}

				temp.add(lowestPrice);

				Output(temp);

				Result();

			} else if (entry < 1 || entry > 11) {

				error();

			}

		} catch (Exception e) {

			error();

		}

	}

	public static void sortStr(List < ArrayList<Object>> list, int col) {

		Collections.sort(list, new Comparator < ArrayList<Object>>() {

			@Override

			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {

				String firComp = (String) o1.get(col);

				String secComp = (String) o2.get(col);

				return firComp.compareTo(secComp);

			}

		});

	}

	public static void sortDou(List < ArrayList<Object>> list, int col) {

		Collections.sort(list, new Comparator < ArrayList<Object>>() {

			@Override

			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {

				Double firComp = (Double) o1.get(col);

				Double secComp = (Double) o2.get(col);

				return firComp.compareTo(secComp);

			}

		});

	}

	public static void sortInt(List < ArrayList<Object>> list, int col) {

		Collections.sort(list, new Comparator < ArrayList<Object>>() {

			@Override

			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {

				Integer firComp = (Integer) o1.get(col);

				Integer secComp = (Integer) o2.get(col);

				return firComp.compareTo(secComp);

			}

		});

	}

	public void sort() {

		if (stock.size() == 0) {
			System.out.println("No cars available");
			Result();
		}

		System.out.println("What would you like to sort for?");

		System.out.println("1) ID");

		System.out.println("2) Manufacturer");

		System.out.println("3) Model");

		System.out.println("4) Year");

		System.out.println("5) Mileage");

		System.out.println("6) Engine Size");

		System.out.println("7) Grade");

		System.out.println("8) Price");

		try {

			int sortEntry = scan.nextInt();

			List < ArrayList<Object>> temp1 = new ArrayList < ArrayList<Object>>();

			if (sortEntry == 1) {

				for (int i = 0; i < stock.size(); i++) {

					temp1.add(stock.get(i));

				}

				Output(temp1);

				Result();

			} else if (sortEntry == 2 || sortEntry == 3 || sortEntry == 7) {

				List < ArrayList<Object>> temp = stock;

				sortStr(temp, sortEntry - 1);

				for (int i = 0; i < temp.size(); i++) {

					temp1.add(temp.get(i));

				}

				Output(temp1);

				Result();

			} else if (sortEntry == 6 || sortEntry == 8) {

				List < ArrayList<Object>> temp = stock;

				sortDou(temp, sortEntry - 1);

				for (int i = 0; i < temp.size(); i++) {

					temp1.add(temp.get(i));

				}

				Output(temp1);

				Result();

			} else if (sortEntry == 4 || sortEntry == 5) {

				List < ArrayList<Object>> temp = stock;

				sortInt(temp, sortEntry - 1);

				for (int i = 0; i < temp.size(); i++) {

					temp1.add(temp.get(i));

				}

				Output(temp1);

				Result();

			}

		}

		/**

		* Catch block

		* if wrong input is done, more specifically a wrong data type which would usually

		* cause the program to terminate it will instead trigger the error method

		**/
		catch (Exception e) {

			error();

		}

	}

}