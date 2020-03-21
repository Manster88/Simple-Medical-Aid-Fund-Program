package academy.learnprogramming;

public class Dependents {

    private String mainMemberName;
    private String name;
    private char gender;
    private int id;

    public Dependents(String mainMemberName, String name, char gender, int id) {
        this.mainMemberName = mainMemberName;
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public Dependents(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name + " :  " + this.gender + " - " + this.id;
    }
}
