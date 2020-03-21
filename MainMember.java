package academy.learnprogramming;

import java.util.ArrayList;

public class MainMember {

    private String name;
    private char gender;
    private long id;
    private int membershipNumber;
    private ArrayList<Dependents> dependentsList;

    public MainMember(String name, char gender, int id, int membershipNumber) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.membershipNumber = membershipNumber;
        this.dependentsList = new ArrayList<Dependents>();
    }

    public String getName(){
        return name;
    }

    public char getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    //Method to add dependent to main member dependent list.
    public boolean addDependent( String mainMemberName, String name, char gender, int id){
       if(findDependent(name) == null){
           this.dependentsList.add(new Dependents(mainMemberName, name, gender, id));
           System.out.println(name + " is successfully added to " + mainMemberName + " dependent list.");
           return true;
       }
        System.out.println(name + " is already in the dependent list.");
       return false;
    }

    //Method to remove a dependent from main member dependent list.
    public void removeDependent(String mainMemberName, String name){
        if(findDependent(name) != null){
            int position = dependentsList.indexOf(findDependent(name));
            this.dependentsList.remove(position);
            System.out.println(name + " is successfully removed from "+ mainMemberName + " dependent list.");
        } else{
            System.out.println(name + " is not in " + mainMemberName + " dependents list");
        }
    }

    //Method to whether the a name of a dependent appear in the main member dependent list.
    private Dependents findDependent(String name){
       for(Dependents checkedDependents : this.dependentsList){
           if(checkedDependents.getName().equals(name)){
               return checkedDependents;
           }
       }
       return null;
    }

    //Method to display all elements in the dependent ArrayList.
    public void displayDependents(){
        for(int i = 0; i < dependentsList.size(); i++){
            System.out.println((i + 1) + " " + dependentsList.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return this.name + " :  " + this.membershipNumber + " " + this.gender + " - " + this.id;
    }

}
