abstract class Tier {
    // Attributes
    private String name;
    private int age;
    // Constructor
    public Tier(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Methods
    public abstract void gibLaut();
    // Getter and Setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        // Check if name is not null
        if (name != null) {
            this.name = name;
        }
    }
    public void setAge(int age) {
        // Check if age is not negative
        if (age >= 0) {
            this.age = age;
        }
    }
}
