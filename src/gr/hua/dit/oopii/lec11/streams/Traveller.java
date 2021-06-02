package gr.hua.dit.oopii.lec11.streams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Traveller class sums up all the traveller's preferences.
 * Every Traveller object created represents a unique traveller
 * and stores his/her list of key points for a great destination along with the traveller's current latitude and longitude.
 */
public class Traveller implements Comparable<Traveller> , Serializable {
    private static final long serialVersionUID = 1L;
    public static final int MAX_CITIES = 5;
    private String name;
    private int age;
    String visit;

    private int[] criteria = new int[8];
    private String[] candidate_cities = new String[MAX_CITIES];


    //constructor 1

    /**
     * Constructor for Traveller
     *
     * @param name     The full name of the Traveller
     * @param age      The age of the Traveller
     * @param museum   If the Traveller wants museums.
     * @param sight    If the Traveller wants sightseeing.
     * @param bar      If the Traveller wants bars
     * @param forest   If the Traveller wants to visit forests or not
     * @param lake     If the Traveller wants to see any lakes
     * @param zoo      if the Traveller wants to visit zoos
     * @param seaside  If the Traveller wants to visit a city near the seaside or not
     * @param mountain If the Traveller wants to visit a city of a higher altitude or not
     */
    public Traveller(String name, int age, int museum, int sight, int bar, int forest, int lake, int zoo, int seaside,
                     int mountain) {
        criteria[0] = museum; //museum
        criteria[1] = sight; //sight
        criteria[2] = bar; //bar
        criteria[3] = forest; //forest
        criteria[4] = lake; //lake
        criteria[5] = zoo; //zoo
        criteria[6] = seaside; //seaside
        criteria[7] = mountain; //mountain

        this.name = name;
        this.age = age;
    }
    //constructor 2

    /**
     * This constructor only sets the preferred cities of the Traveller
     *
     * @param name   The full name of the Traveller
     * @param age    The age of the Traveller
     * @param cities The preferred cities parsed in a String array
     */
    public Traveller(String name, int age, String[] cities) {
        this.name = name;
        this.age = age;
        this.candidate_cities = cities;
    }


    //part of cosine implementation (A=city,B=traveller)
    public int checkOnlyA(int city_attr, int traveller_attr, int counter) {
        if (traveller_attr == 0 && city_attr > 0) {
            return counter + 1;
        }
        return counter;
    }

    public int checkOnlyB(int city_attr, int traveller_attr, int counter) {
        if (traveller_attr == 1 && city_attr <= 0) {
            return counter + 1;
        }
        return counter;
    }

    public int checkNeitherAB(int city_attr, int traveller_attr, int counter) {
        if (traveller_attr == 0 && city_attr <= 0) {
            return counter + 1;
        }
        return counter;
    }

    /**
     * Used to check if one of the traveller's preferences will be satisfied by the city
     *
     * @param city_attr      the boolean value of one of city's getters
     * @param traveller_attr the boolean value of the corresponding traveller's getter
     * @param similarity     the degree of similarity up to now
     * @return the degree of similarity or the degree of similarity + 1
     */
    public static int checkBothAB(int city_attr, int traveller_attr, int similarity) { //bothAB
        if (traveller_attr == 1 && city_attr > 0) {
            return similarity + 1;
        }
        return similarity;
    }




    @Override //compare with age
    public int compareTo(Traveller traveller) {
        return this.age - traveller.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traveller traveller = (Traveller) o;
        return age == traveller.age && name.equals(traveller.name);
    }


    @Override
    public String toString() {
        return "Traveller{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", visit='" + visit + '\'' +
                ", criteria=" + Arrays.toString(criteria) +
                ", candidate_cities=" + Arrays.toString(candidate_cities) +
                '}';
    }


    //getters and setters

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the firstName to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Returns if the Traveller cares about the selected filter from the criteria array
     *
     * @param no The number of the filter you want to check for
     * @return The integer value of the chosen filter
     */
    public int get_Criteria_No(int no) {
        return criteria[no];
    }

    /**
     * Sets the value of the selected filter
     *
     * @param criteria The value to set the filter to
     * @param no       The number of the filter you want to set
     */
    public void set_Criteria_No(int criteria, int no) {
        this.criteria[no] = criteria;
    }

    /**
     * Sets the Traveller's preferred cities
     *
     * @param candidate_cities The cities to set
     */
    public void setCandidate_cities(String[] candidate_cities) {
        this.candidate_cities = candidate_cities;
    }

    /**
     * Returns The preferred cities of the Traveller
     *
     * @return The String array of the cities
     */
    public String[] getCandidate_cities() {
        return candidate_cities;
    }

    /**
     * Set all criteria values at once [Not in use]
     *
     * @param criteria The integer array to set criteria values to
     */
    public void setCriteria(int[] criteria) {
        this.criteria = criteria;
    }

    /**
     * Returns all the criteria at once in an integer array
     *
     * @return The integer array of criteria
     */
    public int[] getCriteria() {
        return criteria;
    }

    /**
     * Returns The visited city of the Traveller
     *
     * @return A String visited city
     */
    public String getVisit() {
        return visit;
    }

    /**
     * Sets the Traveller's visited city
     *
     * @param visit The city Traveller has visited
     */
    public void setVisit(String visit) {
        this.visit = visit;
    }
    /**
     * Will return the degree of similarity between a given city and the travellers's interests.
     *
     * @param city the candidate destination to check for similarity
     * @return the degree of similarity between Traveller and given City
     */
   /* public double estimateSimilarity(City city) { //Euclidean implementation
        int bothAB = 0, onlyA = 0, onlyB = 0, neitherAB = 0;

        //bothAB
        bothAB = checkBothAB(city.getZoo(), get_Criteria_No(5), bothAB);
        bothAB = checkBothAB(city.getBar(), get_Criteria_No(2), bothAB);
        bothAB = checkBothAB(city.getForest(), get_Criteria_No(3), bothAB);
        bothAB = checkBothAB(city.getSight(), get_Criteria_No(1), bothAB);
        bothAB = checkBothAB(city.getLake(), get_Criteria_No(4), bothAB);
        bothAB = checkBothAB(city.getMountain(), get_Criteria_No(7), bothAB);
        bothAB = checkBothAB(city.getMuseum(), get_Criteria_No(0), bothAB);
        bothAB = checkBothAB(city.getSeaside(), get_Criteria_No(6), bothAB);
        //System.out.println("Traveller bothAB Variable is: "+bothAB);

        //onlyA
        onlyA = checkOnlyA(city.getZoo(), get_Criteria_No(5), onlyA);
        onlyA = checkOnlyA(city.getBar(), get_Criteria_No(2), onlyA);
        onlyA = checkOnlyA(city.getForest(), get_Criteria_No(3), onlyA);
        onlyA = checkOnlyA(city.getSight(), get_Criteria_No(1), onlyA);
        onlyA = checkOnlyA(city.getLake(), get_Criteria_No(4), onlyA);
        onlyA = checkOnlyA(city.getMountain(), get_Criteria_No(7), onlyA);
        onlyA = checkOnlyA(city.getMuseum(), get_Criteria_No(0), onlyA);
        onlyA = checkOnlyA(city.getSeaside(), get_Criteria_No(6), onlyA);
        //System.out.println("Traveller onlyA Variable is: "+onlyA);

        //onlyB
        onlyB = checkOnlyB(city.getZoo(), get_Criteria_No(5), onlyB);
        onlyB = checkOnlyB(city.getBar(), get_Criteria_No(2), onlyB);
        onlyB = checkOnlyB(city.getForest(), get_Criteria_No(3), onlyB);
        onlyB = checkOnlyB(city.getSight(), get_Criteria_No(1), onlyB);
        onlyB = checkOnlyB(city.getLake(), get_Criteria_No(4), onlyB);
        onlyB = checkOnlyB(city.getMountain(), get_Criteria_No(7), onlyB);
        onlyB = checkOnlyB(city.getMuseum(), get_Criteria_No(0), onlyB);
        onlyB = checkOnlyB(city.getSeaside(), get_Criteria_No(6), onlyB);
        //System.out.println("Traveller onlyB Variable is: "+onlyB);

        //neitherAB
        neitherAB = checkNeitherAB(city.getZoo(), get_Criteria_No(5), neitherAB);
        neitherAB = checkNeitherAB(city.getBar(), get_Criteria_No(2), neitherAB);
        neitherAB = checkNeitherAB(city.getForest(), get_Criteria_No(3), neitherAB);
        neitherAB = checkNeitherAB(city.getSight(), get_Criteria_No(1), neitherAB);
        neitherAB = checkNeitherAB(city.getLake(), get_Criteria_No(4), neitherAB);
        neitherAB = checkNeitherAB(city.getMountain(), get_Criteria_No(7), neitherAB);
        neitherAB = checkNeitherAB(city.getMuseum(), get_Criteria_No(0), neitherAB);
        neitherAB = checkNeitherAB(city.getSeaside(), get_Criteria_No(6), neitherAB);
        //System.out.println("Traveller neither Variable is: "+neitherAB);

        return Math.sqrt((bothAB + neitherAB) / (double) (onlyA + onlyB + bothAB + neitherAB));
    }

    *//**
     * @param cities is the ArrayList containing all given cities
     * @return the position in the ArrayList of the city with the highest degree of similarity
     *//*
    public City compareCities(ArrayList<City> cities) {
        double highestSimilarity = -1;
        int i, array_index = -1;
        for (i = 0; i < cities.size(); i++) {
            if (estimateSimilarity(cities.get(i)) > highestSimilarity) {
                highestSimilarity = estimateSimilarity(cities.get(i));
                array_index = i;
            }
        }
        return cities.get(array_index);
    }

    *//**
     * This method overrides the method CompareCities in cases where we want to exclude cities that have rainy weather
     *
     * @param cities array list of all the cities
     * @param rain   boolean value containing if rain occurs
     * @return the position in the ArrayList of the city with the highest degree of similarity
     *//*
    public City compareCities(ArrayList<City> cities, boolean rain) {
        double highestSimilarity = -1;
        int i, array_index = -1;
        for (i = 0; i < cities.size(); i++) {
            if (estimateSimilarity(cities.get(i)) > highestSimilarity && !rain) {
                highestSimilarity = estimateSimilarity(cities.get(i));
                array_index = i;
            }
        }
        return cities.get(array_index);
    }*/

}