/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.util;

import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    Point testpoint;

    @Before
    public void setUp() throws Exception {
        this.testpoint = new Point(1, 2);
    }

    @Test
    public void test() {
        Assert.assertEquals((long)this.testpoint.getX(), (long)1);
        Assert.assertEquals((long)this.testpoint.getY(), (long)2);
        Point refpoint = new Point(1, 2);
        Assert.assertEquals((Object)this.testpoint.equals(refpoint), (Object)true);
        refpoint = new Point(1, 1);
        Assert.assertEquals((Object)this.testpoint.equals(refpoint), (Object)false);
        refpoint = new Point(3, 1);
        Assert.assertEquals((Object)this.testpoint.equals(refpoint), (Object)false);
        refpoint = new Point(3, 4);
        Assert.assertEquals((Object)this.testpoint.equals(refpoint), (Object)false);
        refpoint = new Point(1, 1);
        Assert.assertEquals((Object)this.testpoint.equals(refpoint), (Object)false);
    }
}

