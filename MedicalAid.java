package academy.learnprogramming;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MedicalAid {

    private LinkedList<MainMember> mainMembersList;
    private MainMember mainMember;
    private Scanner scanner;

    public MedicalAid(){
        this.mainMembersList = new LinkedList<MainMember>();
        scanner = new Scanner(System.in);
    }
    //Method that display all the elements in the linkList (mainMemberList).
    public void displayMainMembers(){
        Iterator<MainMember> iterator = this.mainMembersList.iterator();
        System.out.println("======== List of the MainMembers ========");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("==========================================");
    }

    //Method that display each main member with his dependents.
    public void displayMainMemberPerFamily(){
        Iterator<MainMember> iterator = this.mainMembersList.iterator();
        ListIterator<MainMember> listIterator;
        int position = 0;
        while(iterator.hasNext()) {
            System.out.println("======== List of the MainMember + Dependents ========");
            listIterator = this.mainMembersList.listIterator(position);
            System.out.println(listIterator.next());
            iterator.next().displayDependents();
            position++;
            System.out.println("==========================================\n");
        }
    }

    //Method that add a new family to the Medical Aid program, by create new a mainMember with his dependents.
    public void addNewFamily(){
        System.out.println("Please enter the new main member name: ");
        String mainMemberName = scanner.nextLine();

        if(findMainMember(mainMemberName) == null) {
            System.out.println("Please enter the new main member gender 'M' - Male, 'F' - Female : ");
            char mainMemberGender = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.println("Please enter the new main member first 6 digits of ID: ");
            int mainMemberId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the new member membership number: ");
            int membershipNumber = scanner.nextInt();
            scanner.nextLine();

            mainMember = new MainMember(mainMemberName, mainMemberGender, mainMemberId, membershipNumber);

            System.out.println("Please enter the number the dependents for " + mainMemberName + ": ");
            int numberDependents = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberDependents; i++) {
                System.out.println("Please enter dependent " + (i + 1) + " name: ");
                String dependentName = scanner.nextLine();
                System.out.println("Please enter dependent " + (i + 1) + " gender 'M' - Male, 'F' - Female : ");
                char dependentGender = scanner.next().charAt(0);
                scanner.nextLine();
                System.out.println("Please enter dependent " + (i + 1) + " first 6 digits of ID: ");
                int dependentId = scanner.nextInt();
                scanner.nextLine();

                mainMember.addDependent(mainMemberName, dependentName, dependentGender, dependentId);
            }
            mainMembersList.add(mainMember);
            System.out.println("Main member " + mainMemberName + " is added to the list.");
        } else{
            System.out.println("Main member " + mainMemberName + " is already in the list, can`t add member.");
        }
    }

    //Method that check if a specific name appear in the mainMemberList (linkList).
    private MainMember findMainMember(String name){
        for(MainMember checkedMember : this.mainMembersList){
            if(checkedMember.getName().equals(name)){
                return checkedMember;
            }
        }
        return null;
    }

    //This Method use removeMainMember(String mainMemberName) method to delete the entire mainMember with his dependents.
    public void removeFamily(){
        System.out.println("Enter the name of the main member that you like to remove the list: ");
        String mainMemberName = scanner.nextLine();
        removeMainMember(mainMemberName);
    }

    //Method to delete the entire mainMember with his dependents. The method is private for more security.
    private void removeMainMember(String mainMemberName){
        if(findMainMember(mainMemberName) != null){
            int position = mainMembersList.indexOf(findMainMember(mainMemberName));
            mainMembersList.remove(position);
            System.out.println(mainMemberName + " is remove with his dependents from the medical aid.");
        } else{
            System.out.println(mainMemberName + " is not in the maim members list of the medical aid.");
        }
    }

    //Method to remove a dependent from the specified main member dependent list.
    public void removeDependent(){
        System.out.println("Please enter the dependent main member name: ");
        String mainMemberName = scanner.nextLine();
        if(findMainMember(mainMemberName) != null){
            System.out.println("Please enter the name of the dependent that you like to remove: ");
            String dependentName = scanner.nextLine();
            findMainMember(mainMemberName).removeDependent(mainMemberName, dependentName);

        } else{
            System.out.println(mainMemberName + " is not in the maim members list of the medical aid.");
        }
    }

    //Method to add new dependent to existing main member dependent list.
    public void addNewDependent(){
        System.out.println("Please enter the main member name that you like to add dependent: ");
        String mainMemberName = scanner.nextLine();
        if(findMainMember(mainMemberName)!= null){

        System.out.println("Please enter the new dependent name: ");
            String newDependName = scanner.nextLine();
            System.out.println("Please enter the new dependent gender - Male - 'M', Female - 'F' : ");
            char newDependentGender = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.println("Please enter the new dependent first 6 digits of his ID: ");
            int newDependentID = scanner.nextInt();
            scanner.nextLine();
            findMainMember(mainMemberName).addDependent(mainMemberName,newDependName, newDependentGender, newDependentID);
        } else{
            System.out.println(mainMemberName + " is not in the maim members list of the medical aid.");
        }
    }
}
