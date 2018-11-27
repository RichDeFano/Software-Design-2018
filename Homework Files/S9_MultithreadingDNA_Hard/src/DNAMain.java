import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class DNAMain {
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService exeService = Executors.newCachedThreadPool();
        Buffer sharedLocation = new blockingBuffer();
        //ArrayBlockingQueue sharedQ = new ArrayBlockingQueue(12);
        exeService.execute(new inputFilter(sharedLocation));
        exeService.execute(new gapFilter(sharedLocation));
        exeService.execute(new reverseComplementor(sharedLocation));
        exeService.execute(new frameBuilder(sharedLocation));
        exeService.execute(new translator(sharedLocation));
        exeService.execute(new orfFinder(sharedLocation));


        exeService.shutdown();
        exeService.awaitTermination(1,TimeUnit.MINUTES);
    }

}
