package ua.lviv.lgs15;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class ZooClub {
    static Map<Person, List<Animal>> map = new HashMap<>();
    static Set<Entry<Person, List<Animal>>> entrySet = map.entrySet();

    public static void main(String[] args) {

        ZooClub zoo = new ZooClub();
        zoo.addAll();

        // Set<Entry<Person, List<Animal>>> entrySet = map.entrySet();

        for (Entry<Person, List<Animal>> entry : entrySet) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        while (true) {
            String text = "\nEnter values:"

                    + "\n 1-Add club member, " + "\n 2-Add a pet to a club member, "
                    + "\n 3-Remove the animal from the club member, " + "\n 4-Delete a member from the club, "
                    + "\n 5-Remove a specific pet from all owners, " + 
                    "\n 6-Display the zoo club, "
                    + "\n 7-Exit the program, \n";

            int choice = readText(text);

            switch (choice) {
            case 1:
                zoo.addMember();
                break;
            case 2:
                zoo.addPet();
                break;

            case 3:
                zoo.removePet();
                break;

            case 4:
                zoo.removeMember();
                break;
            case 5:
                zoo.removeSpecificPet();
                break;
            case 6:
                zoo.displayZooClub();
                break;
            case 7:
                zoo.exit();
                break;
//            case 8:
//                product.displayElement();
//                break;
//            case 9:
//                product.exit();
//                break;

            }
        }
    }

    public void addAll() {

        map.put(new Person("Denis", 23), new ArrayList<>());
        map.put(new Person("Oleg", 45), new ArrayList<>());
        map.put(new Person("Igor", 33), new ArrayList<>());
        map.put(new Person("Ula", 36), new ArrayList<>());

        Animal am1 = new Animal("dog", "Dingo");
        Animal am2 = new Animal("cat", "Fidor");
        Animal am3 = new Animal("dog", "Trudo");
        Animal am4 = new Animal("cat", "Barsic");
        Animal am5 = new Animal("dog", "Dina");
        Animal am6 = new Animal("cat", "Fargo");
        Animal am7 = new Animal("dog", "Bubi");
        Animal am8 = new Animal("cat", "Pups");

        Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Person, List<Animal>> next = iterator.next();
            if (next.getKey().getName().equalsIgnoreCase("Denis")) {
                List<Animal> value = next.getValue();
                value.add(am1);
                value.add(am2);
                value.add(am7);
                next.setValue(value);

            } else if (next.getKey().getName().equalsIgnoreCase("Oleg")) {
                List<Animal> value = next.getValue();
                value.add(am3);
                value.add(am4);
                value.add(am7);
                next.setValue(value);

            } else if (next.getKey().getName().equalsIgnoreCase("Igor")) {
                List<Animal> value = next.getValue();
                value.add(am5);
                value.add(am6);
                next.setValue(value);

            } else if (next.getKey().getName().equalsIgnoreCase("Ula")) {
                List<Animal> value = next.getValue();
                value.add(am7);
                value.add(am8);
                next.setValue(value);

            }
        }

    }

    public void addMember() {

        int age = getRandomValue(18, 87);

        String text = "Enter the owner's name (the rest of the data will be generated randomly): ";
        String name = readText2(text);

        map.put(new Person(name, age), new ArrayList<>());

        System.out.println("After the element is added :");
        for (Entry<Person, List<Animal>> entry : entrySet) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    public void addPet() {

        String text = "Enter the owner's name (the rest of the data will be generated randomly): ";
        String name = readText2(text);
        String text1 = "Enter type of pet: ";
        String type = readText2(text1);
        String text2 = "Enter the name of pet: ";
        String petName = readText2(text2);

        Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Person, List<Animal>> next = iterator.next();
            if (next.getKey().getName().equals(name)) {
                List<Animal> value = next.getValue();
                value.add(new Animal(type, petName));
                next.setValue(value);

            }

            System.out.println("After the element is added :");
            for (Entry<Person, List<Animal>> entry : entrySet) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }
    }

    public void removePet() {

        String text = "Enter the owner's name (the rest of the data will be generated randomly): ";
        String name = readText2(text);
        String text2 = "Enter the name of pet: ";
        String petName = readText2(text2);

        Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Person, List<Animal>> next = iterator.next();
            if (next.getKey().getName().equalsIgnoreCase(name)) {

                List<Animal> value = next.getValue();
                Iterator<Animal> iterator2 = value.iterator();

                while (iterator2.hasNext()) {
                    Animal next2 = iterator2.next();
                    if (next2.getPetName().equalsIgnoreCase(petName)) {

                        iterator2.remove();
                    }
                }
            }

            System.out.println("After :");
            for (Entry<Person, List<Animal>> entry : entrySet) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }

    }

    public void removeMember() {

        String text = "Enter the owner's name (the rest of the data will be generated randomly): ";
        String name = readText2(text);

        Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Person, List<Animal>> next = iterator.next();
            if (next.getKey().getName().equalsIgnoreCase(name)) {

                iterator.remove();
            }

            System.out.println("After :");
            for (Entry<Person, List<Animal>> entry : entrySet) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }
    }
    public void removeSpecificPet() {
 
        String text = "Enter the name of pet: ";
        String petName = readText2(text);

        Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Person, List<Animal>> next = iterator.next();

                List<Animal> value = next.getValue();
                Iterator<Animal> iterator2 = value.iterator();

                while (iterator2.hasNext()) {
                    Animal next2 = iterator2.next();
                    if (next2.getPetName().equalsIgnoreCase(petName)) {

                        iterator2.remove();
                    }
                
            }

            System.out.println("After :");
            for (Entry<Person, List<Animal>> entry : entrySet) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }

    }
    
    public void displayZooClub() {
        
        System.out.println("ZooClub :");
        for (Entry<Person, List<Animal>> entry : entrySet) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
    
    public void exit() {
        System.out.println("exit...");
        System.exit(0);
    }
    public static int readText(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        int input = scan.nextInt();
        return input;
    }

    public String readText2(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        String input = scan.next();
        return input;
    }

    public int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}
