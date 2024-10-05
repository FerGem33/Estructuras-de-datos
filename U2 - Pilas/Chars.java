public class Chars {
    public static void main(String[] args) {
        System.out.println((char)0x0);
        System.out.println((char) 0);
        System.out.println('\0');
        System.out.println((char) 0 == '\0');
        System.out.println(Character.MAX_VALUE == (char) 0xFFFF);
        System.out.println(Character.MAX_VALUE == (char) '\uFFFF');
        System.out.println(Character.MAX_VALUE == (char) 0x10FFFF);
        System.out.println(Character.MAX_VALUE == (char) '\uFFFF');
        System.out.println(Character.MAX_VALUE == (char) 65535);
        System.out.println(Character.MAX_VALUE == (char) 0b1111111111111111);
        System.out.println(Character.MAX_VALUE == (char) 0177777);
    }
}
