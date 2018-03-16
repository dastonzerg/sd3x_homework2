
import java.util.*;

public class GreedyDynamicAlgorithms 
{

	/**
	 * Goal: find the smallest number of red intervals to select, such that
	 * every blue interval overlaps with at least one of the selected red intervals.
	 * Output this number
	 * 
	 * @param red - the list of red intervals
	 * @param blue - the list blue intervals
	 * @return
	 */
	public static int optimalIntervals(ArrayList<Interval> red, ArrayList<Interval> blue) 
	{
	  if(blue.isEmpty())
	  {
	    return 0;
	  }
	  
	  Interval.sortByFinishTime(blue);
	  Interval currentBlue=blue.remove(0);
	  
	  ArrayList<Interval> pickedRedIntervals=new ArrayList<Interval>();
	  for(Interval interval:red)
	  {
	    if(interval.start<=currentBlue.finish && interval.finish>=currentBlue.start)
	    {
	      pickedRedIntervals.add(interval);
	    }
	  }
	  
	  if(pickedRedIntervals.size()==0)
	  {
	    return -1;
	  }
	  
	  Interval.sortByFinishTime(pickedRedIntervals);
	  int length=pickedRedIntervals.size();
	  Interval currentRed=pickedRedIntervals.get(length-1);
	  red.remove(currentRed);
	  
	  Iterator<Interval> iterator=blue.iterator();
	  while(iterator.hasNext())
	  {
	    Interval current=iterator.next();
	    if(current.start<=currentRed.finish)
	    {
	      iterator.remove();
	    }
	  }
	  
	  int restCount=optimalIntervals(red, blue);
	  if(restCount==-1)
	  {
	    return -1;
	  }
	  else
	  {
	    return 1+restCount;
	  }
	}
	
	/**
	 * Goal: find any path of lowest cost from the top-left of the grid (grid[0][0])
	 * to the bottom right of the grid (grid[m-1][n-1]).  Output this sequence of directions
	 * 
	 * @param grid - the 2d grid containing the cost of each location in the grid.
	 * @return
	 */
	
	public static List<Direction> optimalGridPath(int[][] grid) 
	{
	  int rows=grid.length;
    int cols=grid[0].length;
    int[][] costGrid=new int[rows][cols];
    LinkedList<Direction> directionList=new LinkedList<Direction>();
    
    costGrid[0][0]=grid[0][0];
    for(int col=1; col<=cols-1; ++col)
    {
      costGrid[0][col]=costGrid[0][col-1]+grid[0][col];
    }
    
    for(int row=1; row<=rows-1; ++row)
    {
      costGrid[row][0]=costGrid[row-1][0]+grid[row][0];
    }
    
    for(int row=1; row<=rows-1; ++row)
    {
      for(int col=1; col<=cols-1; ++col)
      {
        if(costGrid[row][col-1]<costGrid[row-1][col])
        {
          costGrid[row][col]=costGrid[row][col-1]+grid[row][col];
        }
        else
        {
          costGrid[row][col]=costGrid[row-1][col]+grid[row][col];
        }
      }
    }
    
    int row=rows-1;
    int col=cols-1;
    while(!(row==0 && col==0))
    {
      if(row==0)
      {
        --col;
        directionList.addFirst(Direction.RIGHT);
      }
      else if(col==0)
      {
        --row;
        directionList.addFirst(Direction.DOWN);
      }
      else
      {
        if(costGrid[row][col-1]<costGrid[row-1][col])
        {
          --col;
          directionList.addFirst(Direction.RIGHT);
        }
        else
        {
          --row;
          directionList.addFirst(Direction.DOWN);
        }
      }
    }
    
    return directionList;
	}

	/**
	 * A simple Direction enum
	 * directions can be either DOWN or RIGHT
	 * You will output a list of these in the grid-path problem
	 */
	public static enum Direction 
	{
		DOWN, RIGHT
	}

	/**
	 * A private Interval class to help with the interval question
	 */
	public static class Interval 
	{
		
		int start;
		int finish;
		
		public Interval(int start, int finish) 
		{
			this.start = start;
			this.finish = finish;
		}
		
		/**
		 * sorts a list of intervals by start time, you are free to use this on the first question
		 */
		public static void sortByStartTime(ArrayList<Interval> l) 
		{
			Collections.sort(l, new Comparator<Interval>() 
			{
				public int compare(Interval o1, Interval o2) 
				{
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.start - i2.start;
				}
			});
		}
		
		/**
		 * sorts a list of intervals by finish time, you are free to use this on the first question
		 */
		public static void sortByFinishTime(ArrayList<Interval> l) 
		{
			Collections.sort(l, new Comparator<Interval>() 
			{
				public int compare(Interval o1, Interval o2) 
				{
					Interval i1 = (Interval) o1;
					Interval i2 = (Interval) o2;
					return i1.finish - i2.finish;
				}
			});
		}
	}
	
}
