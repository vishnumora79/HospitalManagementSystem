package Phase1;
public class Doctor {
    private static int doctorIdCounter = 1;
    private int ID;
    private String name, gender;
    private int age;

    public int getId() {
        return this.ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Doctor(String name, String gender, int age) {
        this.ID = doctorIdCounter++;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
