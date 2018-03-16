import java.util.*;
import static java.lang.System.out;

public class Test
{
  public static void main(String args[])
  {
    // Test1
    GreedyDynamicAlgorithms.Interval blue1=new GreedyDynamicAlgorithms.Interval(0, 2);
    GreedyDynamicAlgorithms.Interval blue2=new GreedyDynamicAlgorithms.Interval(5, 5);
    GreedyDynamicAlgorithms.Interval blue3=new GreedyDynamicAlgorithms.Interval(7, 10);
    GreedyDynamicAlgorithms.Interval blue4=new GreedyDynamicAlgorithms.Interval(11, 13);
    
    GreedyDynamicAlgorithms.Interval red1=new GreedyDynamicAlgorithms.Interval(1, 4);
    GreedyDynamicAlgorithms.Interval red2=new GreedyDynamicAlgorithms.Interval(5, 7);
    GreedyDynamicAlgorithms.Interval red3=new GreedyDynamicAlgorithms.Interval(7, 8);
    GreedyDynamicAlgorithms.Interval red4=new GreedyDynamicAlgorithms.Interval(9, 10);
    GreedyDynamicAlgorithms.Interval red5=new GreedyDynamicAlgorithms.Interval(9, 11);
    GreedyDynamicAlgorithms.Interval red6=new GreedyDynamicAlgorithms.Interval(10, 12);
    GreedyDynamicAlgorithms.Interval red7=new GreedyDynamicAlgorithms.Interval(11, 12);
    
    ArrayList<GreedyDynamicAlgorithms.Interval> blueIntervals=new ArrayList<GreedyDynamicAlgorithms.Interval>();
    ArrayList<GreedyDynamicAlgorithms.Interval> redIntervals=new ArrayList<GreedyDynamicAlgorithms.Interval>();
    
    blueIntervals.add(blue1);
    blueIntervals.add(blue2);
    blueIntervals.add(blue3);
    blueIntervals.add(blue4);
    
    redIntervals.add(red1);
    redIntervals.add(red2);
    redIntervals.add(red3);
    redIntervals.add(red4);
    redIntervals.add(red5);
    redIntervals.add(red6);
    redIntervals.add(red7);
    
    out.println(GreedyDynamicAlgorithms.optimalIntervals(redIntervals, blueIntervals));
//    
//    int[][] grid=new int[2][3];
//    out.println(grid.length);
//    out.println(grid[0].length);
    
    // Test2
//    int[][] grid=new int[4][3];
//    grid[0][0]=5;
//    grid[0][1]=1;
//    grid[0][2]=1;
//    grid[1][0]=2;
//    grid[1][1]=4;
//    grid[1][2]=7;
//    grid[2][0]=2;
//    grid[2][1]=4;
//    grid[2][2]=5;
//    grid[3][0]=5;
//    grid[3][1]=6;
//    grid[3][2]=3;
//    
//    List<GreedyDynamicAlgorithms.Direction> directionList=GreedyDynamicAlgorithms.optimalGridPath(grid);
//    
//    Iterator<GreedyDynamicAlgorithms.Direction> iterator=directionList.iterator();
//    while(iterator.hasNext())
//    {
//      if(iterator.next()==GreedyDynamicAlgorithms.Direction.DOWN)
//      {
//        out.println("DOWN");
//      }
//      else
//      {
//        out.println("RIGHT");
//      }
//    }
    
    // Test3
//    out.println("aaa"+'b');
//    Huffman huffman=new Huffman("aabc");
//    out.println(huffman.encode());
//    out.println(huffman.decode("110100"));
  }
}
