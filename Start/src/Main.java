public class Main {
    public static void main(String[] args) {
        Person myPerson = new Person();
        myPerson.setName("Max Mustermann");
        System.out.println(myPerson.getName());

        Student myStudent = new Student();
        myStudent.setName("Max Mustermann");
        System.out.println(myStudent.getName());

        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Aufruf der makeSound-Methode von Dog
        myCat.makeSound(); // Aufruf der makeSound-Methode von Cat
    }
}