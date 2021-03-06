package org.terasology.kallisti.base.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TestKallistiReflect {
    public class A extends C implements B {

    }

    public interface B extends Serializable {

    }

    public class C {

    }

    @Test
    public void classesListing() {
        Iterable<Class> c = KallistiReflect.classes(A.class);
        Set<Class> actual = new HashSet<>();
        c.forEach(actual::add);
        Set<Class> expected = new HashSet<>();
        expected.add(A.class);
        expected.add(B.class);
        expected.add(C.class);
        expected.add(Serializable.class);
        expected.add(Object.class);
        Assert.assertEquals(expected, actual);
    }
}
