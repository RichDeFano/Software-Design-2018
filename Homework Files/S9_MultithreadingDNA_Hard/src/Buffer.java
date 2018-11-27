/***
 * Interface buffer gives the methods for blockingBuffer to follow.
 */
public interface Buffer {
    public int returnSize() throws InterruptedException;
    public void blockingPut(char value) throws InterruptedException;
    public char blockingGet() throws InterruptedException;

}