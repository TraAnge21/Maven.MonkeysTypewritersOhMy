package io.zipcoder;

import java.util.Random;


/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    public SafeCopier (String toCopy) {

        super(toCopy);
    }

    public void run() {

        Random rand = new Random();
        int randSleep = rand.nextInt((322-43) + 1)+43;
        while(stringIterator.hasNext()){
            try {
                {
                    synchronized (stringIterator) {
                        String currentHolder = stringIterator.next() + " ";
                        Thread.sleep(randSleep);
                        System.out.println(Thread.currentThread().getName() + " " + currentHolder);
                        copied = copied + currentHolder;
                    }
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
        copied = copied.trim();
    }


}

