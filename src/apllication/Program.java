package apllication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contributors;
import entities.LegalPerson;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contributors> list = new ArrayList<>();
		
		System.out.print("Enter de number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Tax Payer #" + (i+1) + "Data: ");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income");
			double annualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthSpending = sc.nextDouble();
				list.add(new PhysicalPerson(name, annualIncome, healthSpending));
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new LegalPerson(name, annualIncome, numberOfEmployees));
			}
			
		}
		
		double sum = 0;
		System.out.println();
		System.out.println("TAXED PAID: ");
		for(Contributors co : list) {
			double tax = co.tax();
			System.out.println(co.getName() + ": $" + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));

		sc.close();
	}

}
