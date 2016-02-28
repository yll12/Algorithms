package algo.chapter1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import algo.chapter1.ArraysAndStrings;

public class ArraysAndStringsTest {

    @Test
    public void stringCompressionTest1() {
        
        String actual = ArraysAndStrings.stringCompress("aabcccccaaa");
        String expected = "a2b1c5a3";
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void stringCompressionTest2() {
        
        String actual = ArraysAndStrings.stringCompress("zzc");
        String expected = "zzc";
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void stringCompressionTest3() {
        
        String actual = ArraysAndStrings.stringCompress("czzzzzzc");
        String expected = "c1z6c1";
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void stringRotationTest1() {
        
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        
        assertTrue(ArraysAndStrings.isRotation(s1, s2));
    }
    
    @Test
    public void stringRotationTest2() {
        
        String s1 = "waterbottle";
        String s2 = "erbowatttle";
        
        assertFalse(ArraysAndStrings.isRotation(s1, s2));
    }
    
    @Test
    public void stringRotationTest3() {
        
        String s1 = "abcbac";
        String s2 = "cabcba";
        
        assertTrue(ArraysAndStrings.isRotation(s1, s2));
    }
    
    @Test
    public void stringRotationTest4() {

        String s1 = "";
        String s2 = "";
        
        assertFalse(ArraysAndStrings.isRotation(s1, s2));
    }
    
    @Test
    public void zeroMatrixTest1() {
        int[][] expected =
            { { 1, 0, 3, 4 }, 
              { 0, 0, 0, 0 }, 
              { 9, 0, 11, 12 } };
        int[][] actual = 
            { { 1, 2, 3, 4 }, 
              { 5, 0, 7, 8 }, 
              { 9, 10, 11, 12 } };
        actual = ArraysAndStrings.zeroMatrix(actual);
        
        assertTrue(Arrays.deepEquals(expected, actual));
    }
    
    @Test
    public void zeroMatrixTest2() {
        int[][] expected =
            { { 0, 0, 0 }, 
              { 1, 0, 0 }, 
              { 0, 0, 0 } };
        int[][] actual = 
            { { 3, 0, 4 }, 
                { 1, 2, 3 }, 
                { 4, 0, 0 } };
        actual = ArraysAndStrings.zeroMatrix(actual);
        
        assertTrue(Arrays.deepEquals(expected, actual));
    }
}
