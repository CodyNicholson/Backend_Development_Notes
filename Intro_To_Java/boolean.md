# Boolean

boolean variables hold either true or false values

A method can return a boolean value, as seen below

Booleans are useful for checking different conditions

Example:

```java
public class Word
{
    private String letters;

    public Word(String letters)
    {
        this.letters = letters.toLowerCase();
    }

    /** Checks whether the ith letter is a vowel.
     *  @return true if the ith letter is a vowel, false otherwise.
     */
    public boolean isVowel(int i)
    {
        String letter = letters.substring(i, i+1);
        return letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u");
    }

    /** Checks whether the ith letter is a consonant.
     *  @return true if the ith letter is a consonant, false otherwise.
     */
    public boolean isConsonant(int i)
    {
        return !isVowel(i);
    }
}
```
