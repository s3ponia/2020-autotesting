package classes;

public class Dog {
    public String name;
    public int age;
    public boolean isSleepy;
    public boolean sex;
    public String favoriteFood;

    public Dog(String name, int age, boolean isSleepy, boolean sex, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.isSleepy = isSleepy;
        this.sex = sex;
        this.favoriteFood = favoriteFood;
    }

    public Dog() {
    }
}
