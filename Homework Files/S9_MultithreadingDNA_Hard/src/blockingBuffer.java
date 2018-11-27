import java.util.concurrent.ArrayBlockingQueue;

/***
 * Class blockingBuffer implements buffer for an ArrayBlockingQueue
 */
public class blockingBuffer implements Buffer{
    /***
     * ArrayBlockingQueue of characters buffer will hold the incoming data.
     */
    private final ArrayBlockingQueue<Character> buffer;

    /***
     * Constructor blockingBuffer will create this new array(only for testing purposes. should be created from read in data.)
     */
    public blockingBuffer()
    {
        buffer = new ArrayBlockingQueue<>(36);
    }

    /***
     * Overrided method returnSize gives the size of the queue.
     * @return size.
     * @throws InterruptedException
     */
    @Override
    public int returnSize() throws InterruptedException
    {
        return buffer.size();
    }

    /***
     * Overrided method blockingPut will add a value to the end of the queue.
     * @param value is the value to be entered into the queue.
     * @throws InterruptedException
     */
    @Override
    public void blockingPut(char value) throws InterruptedException
    {
        buffer.put(value);
    }

    /***
     * Overrided method blockingGet will return the value at the top of the queue.
     * @return the value being taken from the top of the queue.
     * @throws InterruptedException
     */
    @Override
    public char blockingGet() throws InterruptedException
    {
        char readValue = buffer.take();
        return readValue;
    }


}