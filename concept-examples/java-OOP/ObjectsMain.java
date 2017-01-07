/**
 * separate class holds the main
 * that I'll use to test the other two...
 */

public class ObjectsMain {
   public static void main(String[] args){
      Programmer me = new Programmer(true,18,"Walter","Java",2);
      Programmer noah = new Programmer(true,16,"Noah","Python",2);
      me.sayName();
      me.sayAge();
      me.sayLanguage();
      me.sayEducation();
      noah.sayName();
      noah.sayAge();
      noah.sayLanguage();
      System.out.println("Goodbye now!");
   }
}
