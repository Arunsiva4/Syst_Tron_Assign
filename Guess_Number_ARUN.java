import java.util.Scanner;
import java.util.Random;
class Guess_Number_ARUN
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    String play= "y";  
    while(play.equals("y")){
      Random rand = new Random();
      int randArun = rand.nextInt(10);
      int guess = -1;      int cnt = 0;
      while(guess != randArun){
        System.out.println("Guess a number between 1 and 10");
        guess = input.nextInt();        cnt++;
        if(guess == randArun){
          System.out.println("Great, The Number generated randomly can be guessed.");
          System.out.println("The Number can be guessed in " + cnt + " tries");
          System.out.println("Want to play again? (y / n) ");   play = input.next();   
        }
        else if(guess < randArun){
          System.out.println("The guess is too low. Try Again");
        }
        else{
          System.out.println("The guess is too High. Try Again");
          }
        }
      }
    input.close();
    }
  }