package algo.prorgammingchallenge;

import org.junit.Assert;
import org.junit.Test;

import algo.programmingchallenge.FindNumberOfIslands_DFS;

public class IslandTest {

    @Test
    public void islandTest1() {
        int[][] Map = {{0, 0, 0, 0, 0, 0, 0},
                       {0, 1, 1, 1, 1, 1, 0},
                       {0, 1, 0, 0, 0, 1, 0},
                       {0, 1, 0, 1, 0, 1, 0},
                       {0, 1, 0, 0, 0, 1, 0},
                       {0, 1, 1, 1, 1, 1, 0},
                       {0, 0, 0, 0, 0, 0, 0}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void islandTest2() {
        int Map[][]=  new int[][] {{1, 1, 0, 0, 0},
                                   {0, 1, 0, 0, 1},
                                   {1, 0, 0, 1, 1},
                                   {0, 0, 0, 0, 0},
                                   {1, 0, 1, 0, 1}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest3() {
        int[][] Map = {{0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 1, 0, 1, 0, 0},
                       {0, 0, 1, 0, 1, 0, 0},
                       {0, 0, 1, 1, 1, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest4() {
        int[][] Map = {{0}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest5() {
        int[][] Map = {{1}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest6() {
        int[][] Map = {{1, 0}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest7() {
        int[][] Map = {{1, 1}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void islandTest8() {
        int[][] Map = {{1, 0},
                       {0, 1}};
        FindNumberOfIslands_DFS I = new FindNumberOfIslands_DFS(Map.length, Map[0].length);
        int actual = I.countIsland(Map);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }
}
