package org.tests.threads;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.interrupted;
@Slf4j
public class CustomThread extends Thread {
    private final String threadName;

    public CustomThread(final String  threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        log.info(this.threadName + " - begin");
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        log.info(this.threadName + " - finished");
    }
}
