import java.util.*;

public class TestStack{
    public static void main(String[] args){
        StringStack stack = new StringStack();
        stack.push("papel");
        stack.push("plastik");
        stack.push("tisyu");
        stack.push("papel15");
        stack.push("papel14");
        stack.push("papel13");
        stack.push("papel12");
        stack.push("papel11");
        stack.push("papel10");
        stack.push("papel9");
        stack.push("papel8");
        stack.push("papel7");
        stack.push("papel6");
        stack.push("papel5");
        stack.push("papel4");
        stack.push("papel3");
        stack.push("papel1");
        stack.push("papel2");


        System.out.println(stack);
        System.out.println(stack.size());

        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();

        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
