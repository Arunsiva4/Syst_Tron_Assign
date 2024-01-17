  import java.util.Scanner;
  public class R_P_S_Arun {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          String[] choices = {"rock", "paper", "scissors"};
          while (true) {
              System.out.print("Enter your choice (rock, paper, or scissors) or 'quit' to stop: ");
              String playerChoice = scanner.next().toLowerCase(); // Case-insensitive comparison
              if (playerChoice.equals("quit")) {
                  break;
              }
              if (!isValidChoice(playerChoice)) {
                  System.out.println("Invalid choice. Please enter rock, paper, scissors, or quit.");
                  continue;
              }
              int computerChoice = (int) (Math.random() * choices.length);
              String result = determineWinner(playerChoice, choices[computerChoice]);
              System.out.println("Computer chose: " + choices[computerChoice]);
              System.out.println("Result: " + result);
          }
          System.out.println("Game ended!");
          scanner.close();
      }
      public static String determineWinner(String player, String computer) {
          if (player.equals(computer)) {
              return "It's a tie!";
          } else if ((player.equals("rock") && computer.equals("scissors")) ||
                     (player.equals("paper") && computer.equals("rock")) ||
                     (player.equals("scissors") && computer.equals("paper"))) {
              return "You win!";
          } else {
              return "Computer wins!";
          }
      }
      public static boolean isValidChoice(String choice) {
          return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
      }
  }
