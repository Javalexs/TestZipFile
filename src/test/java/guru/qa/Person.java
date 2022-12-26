package guru.qa;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;

    private List <String> skills = new ArrayList<>();

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public List<String> getSkills(){
        return skills;
    }

}
