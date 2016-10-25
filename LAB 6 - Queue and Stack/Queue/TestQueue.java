import java.util.*;

public class TestQueue{
    public static void main(String[] args){
        StringQueue myQueue=new StringQueue();
        myQueue.enqueue("potatoes");
        myQueue.enqueue("tomatoes");
        myQueue.enqueue("cabbage");
        System.out.println(myQueue);    
        System.out.println(myQueue.dequeue(2));
        myQueue.enqueue("tomatoessss");
        myQueue.enqueue("cabbagessss");
        myQueue.enqueue("lettucesss");
        myQueue.enqueue("flowers");
        myQueue.enqueue("carrotssss");
        myQueue.enqueue("ketchuo");
        System.out.println(myQueue);
        myQueue.singit(2,"meat");
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
    }

}
