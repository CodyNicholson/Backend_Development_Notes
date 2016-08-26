package patterns.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//Algorithm interface
interface CheckStrategy {
    public boolean check(String s);
}

//Algorithm instances
class All implements CheckStrategy {
    @Override
    public boolean check(String s) {
        return true;
    }
}

class StartWithT implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if( s == null || s.length() == 0) {
            return false;
        }
        return s.charAt(0) == 't';
    }
}

class LongerThan5 implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if(s == null) {
            return false;
        }
        return s.length() > 5;
    }
}

class Palindrome implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if(s == null) {
            return false;
        }
        int length = s.length();
        if(length < 2) {
            return true;
        }
        int half = length/2;
        for(int i = 0; i < half; ++i) {
            if(s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

class Context {
    private CheckStrategy strategy;

    public Context() {
        this.strategy = new All();
    }

    public void changeStrategy(CheckStrategy strategy) {
        this.strategy = strategy;
    }

    public void filter(String filename) throws IOException {
        BufferedReader infile = new BufferedReader(new FileReader(filename));
        String buffer = null;
        while((buffer = infile.readLine()) != null) {
            StringTokenizer words = new StringTokenizer(buffer);
            while( words.hasMoreTokens() ) {
                String word = words.nextToken();
                if (strategy.check(word)) {
                    System.out.println(word);
                }
            }
        }
    }
}

public class StrategyPattern {

    public static void main(String[] args) throws IOException {
        Context context = new Context();
        String filename = "foo.txt";

        System.out.println("\n* Default:");
        context.filter(filename);

        System.out.println("\n* Longer than 5:");
        context.changeStrategy(new LongerThan5());
        context.filter(filename);

        System.out.println("\n*Palindromes:");
        context.changeStrategy(new Palindrome());
        context.filter(filename);
    }
}
