import java.util.*;

class Main {
  static void createRoom(List<String> row1, List<String> row2, List<String> row3, List<String> row4,
      List<String> row5, List<String>  location) {

    String[] empty = { "-----------", "|         |", "|         |", "|         |", "|         |", "|         |",
        "-----------" };
    String[] bandit = { "-----------", "|    O    |", "|   /|\\   |", "|   / \\   |", "|  BANDIT |", "|         |",
        "-----------" };
    String[] livingUndead = { "-----------", "|    O    |", "|   /|\\   |", "|   / \\   |", "|  LIVING |",
        "|  UNDEAD |", "-----------" };
    String[] user = { "-----------", "|    O    |", "|   /|\\   |", "|   / \\   |", "|   USER  |", "|         |",
        "-----------" };

    String [] locationArray = {"|A1       |", "|A2       |", "|A3       |", "|A4       |", "|A5       |" , "|B1       |", "|B2       |", "|B3       |", "|B4       |" , "|B5       |", "|C1       |", "|C2       |", "|C3       |" , "|C4       |", "|C5       |", "|D1       |", "|D2       |" , "|D3       |", "|D4       |", "|D5       |", "|E1       |" , "|E2       |", "|E3       |", "|E4       |", "|E5       |"};
    Collections.addAll(location, locationArray);
    String [] row1Array = {
          empty[0] , empty[0] , empty[0] , empty[0] , empty[0] , "\n"
        , location.get(0) , location.get(1) , location.get(2) , location.get(3) , location.get(4) , "\n"
        , empty[1] , empty[1] , empty[1] , empty[1] , empty[1] , "\n"
        , empty[2] , empty[2] , empty[2] , empty[2] , empty[2] , "\n"
        , empty[3] , empty[3] , empty[3] , empty[3] , empty[3] , "\n"
        , empty[4] , empty[4] , empty[4] , empty[4] , empty[4] , "\n"
        , empty[5] , empty[5] , empty[5] , empty[5] , empty[5] , "\n"
        , empty[6] , empty[6] , empty[6] , empty[6] , empty[6]};

   String [] row2Array = {
          empty[0] , empty[0] , empty[0] , empty[0] , empty[0] , "\n"
        , location.get(5) , location.get(6) , location.get(7) , location.get(8) , location.get(9) , "\n"
        , bandit[1] , empty[1] , empty[1] , bandit[1] , empty[1] , "\n"
        , bandit[2] , empty[2] , empty[2] , bandit[2] , empty[2] , "\n"
        , bandit[3] , empty[3] , empty[3] , bandit[3] , empty[3] , "\n"
        , bandit[4] , empty[4] , empty[4] , bandit[4] , empty[4] , "\n"
        , bandit[5] , empty[5] , empty[5] , bandit[5] , empty[5] , "\n"
        , bandit[6] , empty[6] , empty[6] , bandit[6] , empty[6]};

    String [] row3Array = {
          empty[0] , empty[0] , livingUndead[0] , empty[0] , empty[0] , "\n"
        , location.get(10) , location.get(11) , location.get(12) , location.get(13) , location.get(14) , "\n"
        , empty[1] , empty[1] , livingUndead[1] , empty[1] , empty[1] , "\n"
        , empty[2] , empty[2] , livingUndead[2] , empty[2] , empty[2] , "\n"
        , empty[3] , empty[3] , livingUndead[3] , empty[3] , empty[3] , "\n"
        , empty[4] , empty[4] , livingUndead[4] , empty[4] , empty[4] , "\n"
        , empty[5] , empty[5] , livingUndead[5] , empty[5] , empty[5] , "\n"
        , empty[6] , empty[6] , livingUndead[6] , empty[6] , empty[6]};

    String [] row4Array = {
          empty[0] , empty[0] , empty[0] , empty[0] , empty[0] , "\n"
        , location.get(15) , location.get(16) , location.get(17) , location.get(18) , location.get(19) , "\n"
        , empty[1] , empty[1] , empty[1] , empty[1] , empty[1] , "\n"
        , empty[2] , empty[2] , empty[2] , empty[2] , empty[2] , "\n"
        , empty[3] , empty[3] , empty[3] , empty[3] , empty[3] , "\n"
        , empty[4] , empty[4] , empty[4] , empty[4] , empty[4] , "\n"
        , empty[5] , empty[5] , empty[5] , empty[5] , empty[5] , "\n"
        , empty[6] , empty[6] , empty[6] , empty[6] , empty[6]};

    String [] row5Array = {
          empty[0] , empty[0] , user[0] , empty[0] , empty[0] , "\n"
        , location.get(20) , location.get(21) , location.get(22) , location.get(23) , location.get(24) , "\n"
        , empty[1] , empty[1] , user[1] , empty[1] , empty[1] , "\n"
        , empty[2] , empty[2] , user[2] , empty[2] , empty[2] , "\n"
        , empty[3] , empty[3] , user[3] , empty[3] , empty[3] , "\n"
        , empty[4] , empty[4] , user[4] , empty[4] , empty[4] , "\n"
        , empty[5] , empty[5] , user[5] , empty[5] , empty[5] , "\n"
        , empty[6] , empty[6] , user[6] , empty[6] , empty[6]};
    
    Collections.addAll(row1, row1Array);
    Collections.addAll(row2, row2Array);
    Collections.addAll(row3, row3Array);
    Collections.addAll(row4, row4Array);
    Collections.addAll(row5, row5Array);
  }
  

  static void outputRoom(List<String> row1, List<String> row2, List<String> row3, List<String> row4,
      List<String> row5) {
    row1.forEach(System.out::print);
    System.out.println();
    row2.forEach(System.out::print);
    System.out.println();
    row3.forEach(System.out::print);
    System.out.println();
    row4.forEach(System.out::print);
    System.out.println();
    row5.forEach(System.out::print);
  }

  public static void main(String[] args) {

    List<String> row1 = new ArrayList<>();
    List<String> row2 = new ArrayList<>();
    List<String> row3 = new ArrayList<>();
    List<String> row4 = new ArrayList<>();
    List<String> row5 = new ArrayList<>();
    List<String>  location = new ArrayList<>();

    createRoom(row1, row2, row3, row4, row5, location);
    outputRoom(row1, row2, row3, row4, row5);
    Scanner scan = new Scanner(System.in); // Create a Scanner object
    System.out.println("\nWhere would you like to move to?");
    String userAnswer = scan.nextLine();
    System.out.println("User will move to: " + userAnswer); // Output user input

  }
}