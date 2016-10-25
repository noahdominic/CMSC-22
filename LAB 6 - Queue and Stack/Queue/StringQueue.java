/*
 * authors @noahdominic, @enmargret, @jezamarts
 */


import java.lang.*;

public class StringQueue{
	private String[] elements;
	private int count;
	private int initSize;
	public static final int DEFAULT_SIZE = 2;

	StringQueue(){
		elements = new String[DEFAULT_SIZE];
		count = 0;
		initSize = DEFAULT_SIZE;
	}

	public int size(){return count;}

	public void enqueue (String item){
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

	public String dequeue(){
		String retStr = elements[0];
		for(int n=0; n<count; n++){
			elements[n] = elements[n+1];
		}
		count--;
		return retStr;
	}

	public String dequeue(int n){
		if(n>count){
			throw new IllegalArgumentException("n is larger than no. of items in queue.");
		} else {
			String retStr = "";
			while(n>0){
				retStr = dequeue();
				n--;
			}
			return retStr;
		}
	}

	public String peek(){
		if(size() == 0){
			throw new IllegalArgumentException("Queue is empty.");
		} else {
			return elements[0];
		}
	}

	public void singit(int pos, String name){
		if(count == initSize - 1){
			String[] temp = new String[initSize + DEFAULT_SIZE];
			for(int i = 0; i < initSize; i++){
				temp[i] = elements[i];
			}
			elements = temp;
		}
		if(pos >= size()){
			pos = size() - 1;
		}
		for(int i = size()+1; i > pos-1; i--){
			elements[i] = elements[i-1];
		}
		elements[pos-1] = name;
		count++;
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
