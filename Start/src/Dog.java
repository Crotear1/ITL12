class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public double add(double x, double y) {
        return x + y;
    }
}
