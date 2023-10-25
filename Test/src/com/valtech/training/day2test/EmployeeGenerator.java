package com.valtech.training.day2test;

import java.util.Random;

public class EmployeeGenerator {
   
    public static void main(String[] args) {
        String name = generateName();
        int age = generateAge();
        int experience = calculateExperience(age);
        String level = assignLevel(experience);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Level: " + level);
    }

    private static String generateName() {
        Random random = new Random();
        int nameLength = random.nextInt(8) + 3;
        StringBuilder nameBuilder = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            char letter = (char) (random.nextInt(26) + 'a');
            nameBuilder.append(letter);
        }

        nameBuilder.setCharAt(0, Character.toUpperCase(nameBuilder.charAt(0)));

        return nameBuilder.toString();
    }

    private static int generateAge() {
        Random random = new Random();
        int age = random.nextInt(40) + 20;
        return age;
    }

    private static int calculateExperience(int age) {
        int experience = age - 20;
        return experience;
    }

    private static String assignLevel(int experience) {
        if(experience < 5) {
        	return "Junior";
        	
        }else if(experience<10) {
        	return "Intermediate";
        }
        else {
        	return "Senior";
        }
    }
}
