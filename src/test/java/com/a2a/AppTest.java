package com.a2a;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.a2a.commandcenter.A2aWorkflow;
import com.a2a.commandcenter.IA2aWorkflow.IA2aCCDelegates;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
        testApp();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(A2aWorkflow.class);
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp() {
        IA2aCCDelegates delegates = new TestA2aCCDelegates();
        A2aWorkflow.getInstance(delegates).handle();
    }

    public static void main(String[] args) {
        IA2aCCDelegates delegates = new TestA2aCCDelegates();
        A2aWorkflow instance = A2aWorkflow.getInstance(delegates);
        instance.handle();
        try {
            CompletableFuture.allOf(instance.getThreads().toArray(new CompletableFuture[instance.getThreads().size()]))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
