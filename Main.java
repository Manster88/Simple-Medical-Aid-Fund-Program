/*
* Developer: Hermanus Steyn.
* Created - 21 March 2020.
*
This program 'MEDICAL AID' is a plain program that is design to manage the maim members and dependents of a medical aid fund.
* The program has the following functions: 1) Create a new Main Member with his dependents list and add to the medical aid fund list.
*  2) Add new dependent to existing specified mainMember. 3) Display all main members that in the medical fund list. 4) Display each
* main member with his dependents that in the medical aid fund list. 5) Remove a main member with his entire dependents that on his
* dependents list from the medical aid fund list. 6) Remove a dependent from a specified main member dependent list.
*
* PROGRAMMING FUNCTIONS:
* Main Member list is a linkList<mainMember>
* When new main member is created the mainMember(element) is added to the linkList<MainMember>
* When new main member is created the mainMember(element) is link to a new ArrayList<Dependents> that is created for
* his dependents.
* When new dependent is added to existing mainMember(element), a new element is added to the ArrayList<Dependents>.
* When a dependent is deleted from the a existing mainMember(element), a element is removed from the ArrayList<Dependents>.
* When existing mainMember is deleted, the mainMember element is removed from the linkList<MainMember> plus the entire
  ArrayList<Dependents> that is link to mainMember element will be deleted.   */

package academy.learnprogramming;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static MedicalAid medicalAid = new MedicalAid();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int selectOption = 0;

        while(!quit){
            displayMenu();
            System.out.println("Select a Option: ");
            try {
                selectOption = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong Selection, Please try again. ");
                quit = true;
            }
            switch (selectOption){
                case 0:
                    quit = true;
                    break;
                case 1:
                    medicalAid.addNewFamily();
                    break;
                case 2:
                    medicalAid.addNewDependent();
                    break;
                case 3:
                    medicalAid.displayMainMembers();
                    break;
                case 4:
                    medicalAid.displayMainMemberPerFamily();
                    break;
                case 5:
                    medicalAid.removeFamily();
                    break;
                case 6:
                    medicalAid.removeDependent();
                    break;
                default:
                    System.out.println("Wrong Selection, Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu(){
        System.out.println("\n********************MEDICAL AID MENU********************");
        System.out.println("Press: \n" +
                "0 - Quit Medical Aid Program\n" +
                "1 - Add new Family to the Medical Aid\n" +
                "2 - Add a new dependent under Main Member Name\n" +
                "3 - Display all Main Members of this Medical Aid\n" +
                "4 - Display Main Member with his dependents\n" +
                "5 - Remove a Family from the Medical Aid\n" +
                "6 - Remove a dependent under Main Member Name");
        System.out.println("********************************************************\n");
    }
}
