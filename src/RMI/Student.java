package RMI;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String email;

    public Student(String id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }

    public String toFileString() {
        return id + "," + name + "," + age + "," + email;
    }

    public static Student fromString(String line) {
        String[] p = line.split(",");
        return new Student(p[0], p[1], Integer.parseInt(p[2]), p[3]);
    }
}
