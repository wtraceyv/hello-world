/**
 * class for example of inheriting class;
 * extends from Person and hopefully works correctly
 */

public class Programmer extends Person {
   // fields that aren't in Person:
   public String mainLanguage;
   public int yearsEducation;
   // constructor w/ super:
   public Programmer(boolean currentlyAlive,
                     int currentAge,
                     String preferredName,
                     String currentLanguage,
                     int currentYearsEducation){
      super(currentlyAlive,currentAge,preferredName);// same as params for super
      mainLanguage = currentLanguage; // treat the extras just like they are in the super
      yearsEducation = currentYearsEducation;
   }
   // extra extended methods:
   public void sayLanguage(){
      System.out.println("My favorite language is definitely " + mainLanguage + ", at least at the moment.");
   }
   public void sayEducation(){
      System.out.println("Currently I have " + yearsEducation + " years\' worth of education right now.");
   }
}
