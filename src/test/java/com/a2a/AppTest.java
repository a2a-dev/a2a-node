package com.a2a;

import com.a2a.commandcenter.A2aOrchestrator;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;

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
        return new TestSuite(A2aOrchestrator.class);
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp() {
        IA2aCCDelegates delegates = new TestA2aCCDelegates();
        A2aOrchestrator.getInstance(delegates).handle();
    }

    public static void main(String[] args) {
        IA2aCCDelegates delegates = new TestA2aCCDelegates();
        A2aOrchestrator.getInstance(delegates).handle();
    }
}
