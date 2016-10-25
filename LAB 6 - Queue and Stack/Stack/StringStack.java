/*
 * authors @noahdominic, @enmargaret, @jezamarts
 */


import java.lang.*;

public class StringStack{
	private String[] elements;
	private int count;
	private int initSize;
	public static final int DEFAULT_SIZE = 10;

	StringStack(){
		elements = new String[DEFAULT_SIZE];
		count = 0;
		initSize = DEFAULT_SIZE;
	}

	public int size(){return count;}

	public void push (String item){
		if(count == initSize - 1){
			String[] temp = new String[initSize + DEFAULT_SIZE];
			for(int i = 0; i < initSize; i++){
				temp[i] = elements[i];
			}
			initSize += DEFAULT_SIZE;
			elements = temp;
		}
		elements[count] = item;
		count++;
	}

	public String pop(){
		if(count==0)
			throw new ArrayIndexOutOfBoundsException();
		else{
			String pop= elements[count-1];
			elements[count-1]="";
			count--;
			return pop;
		}
	}

	public String pop(int n){
		String returnStr = "";
		if(n>count){
			throw new IllegalArgumentException("n exceeds no. of items");
		} else {
			while(n > 0	){
				returnStr = pop();
				n--;
			}
			return returnStr;
		}
	}

	public String peek(){
		if(count == 0){
			throw new IllegalArgumentException("Empty stack");
		} else {
			return elements[count - 1];
		}
	}

	public String toString(){
		String print = "";
		if(count > 0){
			for(int i = 0; i < count - 1; i++){
				print += elements[i] + ", ";
			}
			print += elements[count - 1];
		} else {
			print = "EMPTY";		
		}
		return print;
	}
}
