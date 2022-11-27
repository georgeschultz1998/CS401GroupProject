package gloomhaven.map;

import java.util.*;

class Main {
    static void createRoom(List < String > row1, List < String > row2, List < String > row3, List < String > row4,
        List < String > row5, List < String > row6, List < String > location) {

        String hex = "⬣";
        String user = "👤";
      String undead = "👻";
      String bandit = "😡";

        
        String[] row1Array = {
          "|   " , "X1", " " ,"X2", " " ,"X3", " " ,"X4", "|" 
        };

        String[] row2Array = {
          "|Y1" + " ", hex + "  ", hex + "  ", hex + "  ", hex + "|"
        };

        String[] row3Array = {
          "|Y2" + " ", hex + "  ", undead + " ", hex + "  ", hex + " |"
        };

        String[] row4Array = {
          "|Y3" + " ", hex + "  ", hex + "  ", undead + " ", hex + " |"
        };

        String[] row5Array = {
          "|Y4" + " ", hex + "  ", hex + "  ", hex + "  ", hex + " |"
        };
      
        String[] row6Array = {
          "|Y5" + " ", user + " ", hex + "  ", hex + "  ", hex + " |"
        };

        Collections.addAll(row1, row1Array);
        Collections.addAll(row2, row2Array);
        Collections.addAll(row3, row3Array);
        Collections.addAll(row4, row4Array);
        Collections.addAll(row5, row5Array);
        Collections.addAll(row6, row6Array);
    }

    static void outputMap(List < List < String >> map) {
      System.out.println("_______________");
      System.out.println("|      MAP     |");
        map.get(0).forEach(System.out::print);
        System.out.println();
        map.get(1).forEach(System.out::print);
        System.out.println();
        map.get(2).forEach(System.out::print);
        System.out.println();
        map.get(3).forEach(System.out::print);
        System.out.println();
        map.get(4).forEach(System.out::print);
      System.out.println();
        map.get(5).forEach(System.out::print);
      System.out.println();
      System.out.println("_______________ ");
    }

    static void updateLocations(List < List < String >> map, String [] mapCord) {
      Integer currentXCord = -1;
      Integer xCord = Integer.parseInt(mapCord[0]);
      Integer yCord = Integer.parseInt(mapCord[1]);
        Scanner scan = new Scanner(System.in); // Create a Scanner object
      //System.out.println(map.get(yCord).get(xCord));
      if (map.get(yCord).get(xCord).equals("⬣  ")){

        for (int i = 0; i < map.size(); i++) {
        currentXCord = map.get(i).indexOf("👤 ");
          if (!(currentXCord.equals(-1))){
            map.get(i).set(currentXCord, "⬣  ");
            i = map.size();
          }
        }
        map.get(yCord).set(xCord, "👤 ");
      }
      else{
         System.out.println("Cannot move there, please choose an empty space.");
      }

        // Removes 
        outputMap(map);
    }

    public static void main(String[] args) {

        List < String > row1 = new ArrayList < > ();
        List < String > row2 = new ArrayList < > ();
        List < String > row3 = new ArrayList < > ();
        List < String > row4 = new ArrayList < > ();
        List < String > row5 = new ArrayList < > ();
        List < String > row6 = new ArrayList < > ();
        List < List < String >> map = new ArrayList < > ();
        List < String > location = new ArrayList < > ();

        map.add(row1);
        map.add(row2);
        map.add(row3);
        map.add(row4);
        map.add(row5);
        map.add(row6);
        createRoom(row1, row2, row3, row4, row5, row6, location);
        outputMap(map);

        Scanner scan = new Scanner(System.in); // Create a Scanner object
        System.out.println("");
        System.out.println("Menu Options:");
        System.out.println("Enter 'M' to move your player.");
        System.out.println("Enter 'Q' to quit.");
      
        String userAnswer = scan.nextLine();
        userAnswer = userAnswer.toUpperCase();
        while (!(userAnswer.equals("Q"))) {
            if (userAnswer.equals("M")) {
                System.out.println("Enter location to move to: (Example: 1,4 would move you to position X1 Y4)");
                userAnswer = scan.nextLine();
                userAnswer = userAnswer.toUpperCase();
                String [] mapCord = userAnswer.split("[,]", 0);
                updateLocations(map, mapCord);
                System.out.println("");
                System.out.println("User has been moved to: " + userAnswer);
            }
            System.out.println("Menu Options:");
            System.out.println("Enter 'M' to move your player.");
            System.out.println("Enter 'Q' to quit.");
            userAnswer = scan.nextLine();
            userAnswer = userAnswer.toUpperCase();
        }

        //Integer locIndex = location.indexOf("|" + userAnswer + "       |");
        //System.out.println("Location index of that is " + locIndex);

    }
}