package model;

public class Circle {
    private String name;

    public String getName() {
        return name;
    }

    public String setName(String name) {
        System.out.println("The setter inside the circle Class");
        this.name = name;
        return name;
//        throw new RuntimeException();
    }
}
