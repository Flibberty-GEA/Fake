/**
 * Created by yevgen on 13.12.16.
 */
public class Foo {


    public static void main(String[] args) {
        StringBuilder sbStack = new StringBuilder();
        sbStack.append(" ");
        sbStack.append("+");
        sbStack.append("(");
//        if (sbStack.contains("(-")) sbStack=sbStack.replace("(-", "(0-");

        System.out.println(sbStack);
        sbStack.setLength(sbStack.length()-1);
        System.out.println(sbStack);
//        System.out.println(sbStack.length()-1);
//        System.out.println(sbStack.substring(sbStack.length()-1));
//        System.out.println(sbStack.substring(sbStack.length()-1).charAt(0));
    }
}
