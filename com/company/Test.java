package com.company;

public class Test {

    public static void main(String[] args) {
        new Test().go();
    }

    void go(){

        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};

        System.out.println("\ntakeAnimals(animals); invoked");
        takeAnimals(animals);

        System.out.println("\ntakeAnimals(dogs); invoked");
        takeAnimals(dogs);
    }


    void takeAnimals(Animal[] animals) {
        for(Animal a: animals) {
            a.eat();
        }

        int size = animals.length;
        Animal[] newAnimals = new Animal[size + 3];

        for(int i = 0; i < animals.length; i++)
            newAnimals[i] = animals[i];

        newAnimals[size + 1] = new Cat();

        System.out.println("Second LOOP");
        for(Animal a: newAnimals) {
            a.eat();
        }
    }

    abstract class Animal {
        void eat() {
            System.out.println("Animal Eating");
        }
    }

    class Dog extends Animal {
        void bark() {
            System.out.println("Dog Barking");
        }
    }

    class Cat extends Animal {
        void meow() {
            System.out.println("Cat meowing");
        }
    }
}
