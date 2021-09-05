package PkgStack;
 
public interface IntStack {
    
    public boolean push(int data);
    public int pop();
    public int peek();
    public boolean isEmpty();
    public boolean isFull();
}