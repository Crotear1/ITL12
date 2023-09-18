abstract class Tier {
    private String name;
    private int age;

    public Tier(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void gibLaut();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
}
