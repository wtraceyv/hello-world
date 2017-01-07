/**
 * example of parent class characterizing people -->
 * will build another file that extends from it and
 * see if they work together (put main in extended class)
 */

public class Person {
   // fields:
   public boolean alive;
   public int age;
   public String name;
   //constructor:
   public Person(boolean currentlyAlive, int currentAge, String preferredName){
      alive = currentlyAlive;
      age = currentAge;
      name = preferredName;
   }
   // methods:
   public void sayName(){
      System.out.println("Hey boi, my name is " + name + "!");
   }
   public void sayAge(){
      System.out.println("I am " + age + " years old.");
   }
}
