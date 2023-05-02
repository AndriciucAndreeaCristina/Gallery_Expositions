package pao;

public class User {
    private String name;
    private int age;

    public User(String name, int age) throws InvalidAgeException {
        this.name = name;
        if (age < 18) {
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be 18 or above.");
        }
        this.age = age;
    }

    public static void main(String[] args) throws InvalidAgeException {
        try {
            User user = new User("name", 10);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
