import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Return a list of all the unique characters for a list of words?
    * For example, given the list of words ["Hello", "World"] 
    * you’d like to return the list ["H", "e", "l", "o","W", "r", "d"]
    */
public class UniqueCharacter {

  
    public static void main(String [] args){
    
    List<String> words = Arrays.asList("Hello", "World");

List<String> uniqueChars = words.stream() // 1. Stream the list of words
    .map(word -> word.split("")) // 2. Split each word into an array of characters
    .flatMap(Arrays::stream)     // 3. Flatten the stream of arrays into a single stream of characters
    .distinct()                  // 4. Keep only the unique characters
    .collect(Collectors.toList()); // 5. Collect them into a list

System.out.println(uniqueChars); // Output: [H, e, l, o, W, r, d]
    }
    
}
