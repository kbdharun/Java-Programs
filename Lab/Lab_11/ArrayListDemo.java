/*Create a class called Contact with 2 datamembers - name (String), mobileNo(long int).
Create an ArrayList to store 10 contact objects and do the following
	1. Define a method named search() which takes name as input and it will search inside the ArrayList and return all the contact names which contains an input name.
	2. Another overloaded search() method if you pass name as a input it should return a mobileNo of set of names.
	3. Define comparator class to sort the contacts (ArrayList) based on mobileNo.
	4. Define another comparator class that should sort the ArrayList based on LastName of the person name.*/

import java.util.*;
import java.io.*;

class ComparatorNo implements Comparator<Contact>{
	public int compare(Contact c1, Contact c2){
		return (String.valueOf(c1.mobileNo)).compareTo(String.valueOf(c2.mobileNo));
	}
}

class CompareName implements Comparator<Contact>{
	public int compare(Contact c1, Contact c2){
		int i = (c1.name).lastIndexOf(" ");
		int j = (c2.name).lastIndexOf(" ");
		return ((c1.name).substring(i)).compareTo((c2.name).substring(j));
	}
}

class Contact{
	String name;
	long mobileNo;
	
	Contact(String name, long mobileNo){
		this.name = name;
		this.mobileNo = mobileNo;
	}
}

class ArrayListDemo{

	// Search returning name
	static void search(ArrayList<Contact> al) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name: ");
		String nameInput = br.readLine();
		
		for(var i: al){
			if((i.name).contains(nameInput))
				System.out.println(i.name);
		}
	}

	// Search returning mobileNo
	static void search(String nameInput, ArrayList<Contact> al){
		for(var i: al){
			if((i.name).contains(nameInput))
				System.out.println(i.mobileNo);
		}
	}

	public static void main(String args[]) throws IOException{
		ArrayList<Contact> al = new ArrayList<Contact>();
		System.out.println("0. Enter elements to ArrayList \n1. Search to return name \n2. Search to return mobile number \n3. Exit");
		int ch;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Collections.sort(al, new ComparatorNo());
		Collections.sort(al, new CompareName());
		do{
			System.out.print("Enter your choice: ");
			ch = Integer.parseInt(br.readLine());
			switch(ch){
				case 0:
					System.out.print("Enter name: ");
					String name = br.readLine();
					System.out.print("Enter mobile number: ");
					long mobileNo = Long.parseLong(br.readLine());
					al.add(new Contact(name, mobileNo));
					break;
				case 1:
					search(al);
					break;
				case 2:
					System.out.print("Enter name: ");
					String nameInput = br.readLine();
					search(nameInput, al);
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}while(ch!=3);
	}
}