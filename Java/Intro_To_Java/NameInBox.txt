public class NameInBox {

    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println("+" + repeat(s.length(), "-") + "+");
        System.out.println("|" + s + "|");
        System.out.println("+" + repeat(s.length(), "-") + "+");
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public static String repeat(int count) {
        return repeat(count, " ");
    }
}