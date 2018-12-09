import org.junit.Test;

public class Palindrome {


    @Test
    public void palidrome(){
        System.out.println(istPalindrom("AsasA".toCharArray()));
        System.out.println(istPalindrom("AsasF".toCharArray()));
    }

    public static boolean istPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }


}
