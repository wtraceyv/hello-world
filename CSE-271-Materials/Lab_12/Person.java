package edu.miamioh.traceywd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class to model custom implementation of java Comparable interface. 
 * @author Walter Tracey 
 * Instructor: Dr. Stephan
 * CSE 271, B
 * 28 April, 2017
 */
public class Person implements Comparable{

	private String name; 
	
	public Person(String name) {
		setName(name); 
	}
	
	public static void main(String[] args){
		Scanner user = new Scanner(System.in); 
		String[] stringFormPeople = new String[10]; 
		ArrayList<Person> people = new ArrayList<Person>();
		
		// take some names...make some names into Persons...sort dem...
		System.out.println("Gimme 10 names! (one per line)");
		for (int i = 0; i < stringFormPeople.length; i++){
			stringFormPeople[i] = user.nextLine(); 
		}
		for (int i = 0; i < stringFormPeople.length; i++){
			people.add(new Person(stringFormPeople[i])); 
		}
		Collections.sort(people);
		
		// print the stuff as promised...
		System.out.println("First person in sorted list: " + people.get(0).getName());
		System.out.println("Last person in sorted list: " + people.get(people.size()-1).getName());
		
		user.close(); 
	}
	
	/**
	 * "smart" set name of Person so it can't just 
	 * @param name, desired name of Person object. 
	 */
	public void setName(String name){
		if (name.length()>0){
			this.name = name; 
		} else {
			this.name = "Mr. Name"; 
		}
	}
	
	/**
	 * Get this Person object's name. 
	 * @return this Person object's name. 
	 */
	public String getName(){
		return name; 
	}

	/**
	 * Overridden compareTo() method to satisfy implementing 
	 * Comparable interface and compare Person objects by name
	 * for the purposes of automated java sorting. 
	 */
	@Override
	public int compareTo(Object o) {
		Person object = (Person) o; 
		return this.name.compareTo(object.getName());
	}
	
	/**
	 * Override toString() to better represent a Person object. 
	 */
	@Override
	public String toString(){
		return name; 
	}

}
