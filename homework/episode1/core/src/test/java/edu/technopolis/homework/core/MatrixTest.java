package edu.technopolis.homework.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testHelloMatrix() {
        Matrix matrix = new Matrix();
        assertEquals("Hello, Matrix!!!", matrix.helloMatrix());
    }

}
