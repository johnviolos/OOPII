package gr.hua.dit.oopii.lec11.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamsDemo {

   public static void main(String args[]) {
      System.out.println("Using Java 7: ");
		
      // Count empty strings
      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
      System.out.println("List: " +strings);
      
      long count = getCountEmptyStringUsingJava7(strings);
      System.out.println("Empty Strings: " + count);
      
      count = getCountLength3UsingJava7(strings);		
      System.out.println("Strings of length 3: " + count);
		
      //Eliminate empty string
      List<String> filtered = deleteEmptyStringsUsingJava7(strings);
      System.out.println("Filtered List: " + filtered + "\n");
		
      //It merges all elements into one String.
      String mergedString = getMergedStringUsingJava7(strings,", ");	//It transforms the List collection into a String and separate each element with an underscore.
      System.out.println("Merged String: " + mergedString);
      
      List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);		//A new List with Integers.
      //get list of square of distinct numbers
      List<Integer> squaresList = getSquares(numbers);
      System.out.println("Squares List: " + squaresList + "\n");
      
      List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);	
      System.out.println("List: " +integers);
      System.out.println("Highest number in List : " + getMax(integers));
      System.out.println("Lowest number in List : " + getMin(integers));
      System.out.println("Sum of all numbers : " + getSum(integers));
      System.out.println("Average of all numbers : " + getAverage(integers));
     
		
      Random random = new Random();
      System.out.print("Random Numbers: ");
      for(int i = 0; i < 10; i++) {
         System.out.println(random.nextInt()+" ");
      }
		
      System.out.println("\nUsing Java 8: ");
      System.out.println("List: " +strings);
		
      count = strings.stream().filter(string->string.isEmpty()).count(); //How many nodes-objs satisfy the filter condition which is string.isEmpty()
      System.out.println("Empty Strings: " + count);
		
      count = strings.stream().filter(string -> string.length() == 3).count();
      System.out.println("Strings of length 3: " + count);
		
      filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList()); // We make a new String Collection (List) with nodes that satisfy string.isEmpty()
      System.out.println("Filtered List: " + filtered);
		
      mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining("_"));  //We make a new String variable with nodes that satisfy string.isEmpty()
      System.out.println("Merged String: " + mergedString);
		
      squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());// i to i*i, distinct and make a collection.
      System.out.println("Squares List: " + squaresList);
      System.out.println("List: " +integers);
		
      IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();	//Returns an IntStream consisting of the results of applying the given function to the elements of this stream.
      																						//Returns an IntSummaryStatistics describing various summary data about the elements of this stream. This is a special case of a reduction.

		
      System.out.println("Highest number in List : " + stats.getMax());
      System.out.println("Lowest number in List : " + stats.getMin());
      System.out.println("Sum of all numbers : " + stats.getSum());
      System.out.println("Average of all numbers : " + stats.getAverage());
      System.out.println("Random Numbers: ");
		
      random.ints().limit(10).sorted().forEach(System.out::println); //Returns an effectively unlimited stream of pseudorandom int values. Sort and forEach(prinnt)
		
      //parallel processing
      count = strings.parallelStream().filter(string -> string.isEmpty()).count();
      System.out.println("Empty Strings: " + count);
   }
	
   private static int getCountEmptyStringUsingJava7(List<String> strings) {
      int count = 0;

      for(String string: strings) {
		
         if(string.isEmpty()) {
            count++;
         }
      }
      return count;
   }
	
   private static int getCountLength3UsingJava7(List<String> strings) {
      int count = 0;
		
      for(String string: strings) {
		
         if(string.length() == 3) {
            count++;
         }
      }
      return count;
   }
	
   private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
      List<String> filteredList = new ArrayList<String>();
		
      for(String string: strings) {
		
         if(!string.isEmpty()) {
             filteredList.add(string);
         }
      }
      return filteredList;
   }
	
   private static String getMergedStringUsingJava7(List<String> strings, String separator) {
      StringBuilder stringBuilder = new StringBuilder();
		
      for(String string: strings) {
		
         if(!string.isEmpty()) {
            stringBuilder.append(string);
            stringBuilder.append(separator);
         }
      }
      String mergedString = stringBuilder.toString();
      return (mergedString.substring(0, mergedString.length()-2)).replace(", ","_");
   }
	
   private static List<Integer> getSquares(List<Integer> numbers) {
      List<Integer> squaresList = new ArrayList<Integer>();
		
      for(Integer number: numbers) {
 
		int square = number.intValue() * number.intValue();
			
         if(!squaresList.contains(square)) {
            squaresList.add(square);
         }
      }
      return squaresList;
   }
	
   private static int getMax(List<Integer> numbers) {
      int max = numbers.get(0);
		
      for(int i = 1;i < numbers.size();i++) {
		
         Integer number = numbers.get(i);
			
         if(number.intValue() > max) {
            max = number.intValue();
         }
      }
      return max;
   }
	
   private static int getMin(List<Integer> numbers) {
      int min = numbers.get(0);
		
      for(int i= 1;i < numbers.size();i++) {
         Integer number = numbers.get(i);
		
         if(number.intValue() < min) {
            min = number.intValue();
         }
      }
      return min;
   }
	
   private static int getSum(List numbers) {
      int sum = (int)(numbers.get(0));
		
      for(int i = 1;i < numbers.size();i++) {
         sum += (int)numbers.get(i);
      }
      return sum;
   }
	
   private static int getAverage(List<Integer> numbers) {
      return getSum(numbers) / numbers.size();
   }
}