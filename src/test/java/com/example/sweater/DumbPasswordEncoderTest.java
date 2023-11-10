package com.example.sweater;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class DumbPasswordEncoderTest extends TestCase {

    public void testEncode() {
        DumbPasswordEncoder encoder = new DumbPasswordEncoder();

        Assert.assertEquals("secret: 'mypwd'", encoder.encode("mypwd"));
        Assert.assertThat(encoder.encode("mypwd"), Matchers.containsString("mypwd"));
    }
}