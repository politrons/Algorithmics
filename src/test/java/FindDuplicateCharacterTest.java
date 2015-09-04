import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Pablo Perez
 */
public class FindDuplicateCharacterTest {

    private  static Multimap<Character, Character> dupChars = ArrayListMultimap.create();


    @Test
    public void findDuplicateCharacter() {
        String text="abcagtbx";
        for (char c : text.toCharArray()){
            dupChars.put(Character.valueOf(c), Character.valueOf(c));
        }
        for (Character character : dupChars.keySet()) {
            if(dupChars.get(character).size() > 1){
                System.out.println(String.format("Character %s duplicated", character));
            }
        }
    }
}
