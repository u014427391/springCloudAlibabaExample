package com.example.springcloud.api;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ArtifactDubboSampleApiApplicationTests
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ArtifactDubboSampleApiApplicationTests(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ArtifactDubboSampleApiApplicationTests.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
