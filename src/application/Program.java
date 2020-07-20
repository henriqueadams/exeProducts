//ler os dados de um produto e mostrar seus dados

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'c') {
				Product product = new Product(name, price);
				products.add(product);
			}
			else if (ch == 'u') {
				System.out.print("Manufactured date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product product = new UsedProduct(name,price, date);
				products.add(product);
			}
			else if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				products.add(product);
			}
		}	
			
			System.out.println();
			System.out.println("PRICE TAGS: ");
			
			for (Product product : products) {
				System.out.println(product.priceTag());
			}
			
		sc.close();
	}

}
