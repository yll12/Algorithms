package algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
    
}
