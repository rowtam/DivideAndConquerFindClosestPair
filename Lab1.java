import java.util.Date;
import java.awt.*;

//=================================== Lab1 ===============================
//
// Input: n the number of points
//
// Output: A pair of closest points and their distance
//
//========================================================================

public class Lab1 {

   //================================ main ===============================
   //
   // You can use command line arguments to have the output and/or input
   // come from a file versus the command line.
   //
   // If there are two arguments then the first one is the file from where
   //   the input is read and the second is the file where a transcript is
   //   saved.
   //
   // If there is just one argument then it is the file where a transcript
   //   is saved.

   public static void main(String args[]){
   	  if (args.length == 2) {
   	  	 Terminal.readInputFromFile(args[0]);
         Terminal.startTranscript(args[1]);
      }
      else if (args.length == 1) {
      	Terminal.startTranscript(args[0]);
      }

   // You can change "1699" to something else when testing, but it MUST
   //   be "1699" for your submitted output!

      java.util.Random randseq = new java.util.Random(1699);

   // Use this line if you want a different random set of points for each
   //   run.  What this does is use the system clock as the seed to the
   //   random number generator
   //
   // java.util.Random randseq = new java.util.Random();

      //Terminal.println("How many points? ");
      //int n = Terminal.readInt();
      int n = 9000;
      XYPoint[] ptsByX = new XYPoint[n];      //points sorted by x-coord
      XYPoint[] ptsByY = new XYPoint[n];      //points sorted by y-coord

      for (int i=0; i<=n-1; i++){              //initialize ptsByX and ptsByY
	XYPoint p = new XYPoint();             //  to contain the same set of
	p.x = makeInt(randseq.nextDouble(),1,100000);  //set x and y coords to a
	p.y = makeInt(randseq.nextDouble(),1,100000);  //random int from 1-100000
	ptsByX[i] = p;
	ptsByY[i] = p;
      }

      Date startTime = new Date();      //start clock since data is created

      XComparator xcomp = new XComparator();
      YComparator ycomp = new YComparator();
      Sort.msort(ptsByX,xcomp);        //sort by x-coord to get ptsByX
      Sort.msort(ptsByY,ycomp);        //sort by y-coord to get ptsByY

// ********** CALL YOUR CLOSEST PAIR ALGORITHM HERE **********
      float g = FastClosestPair.findClosestPairDist(ptsByX,ptsByY);
      Date endTime = new Date();       //stop clock since closest pair computed

      Terminal.println("\nUtilizing Divide And Conquer Closest Pair Algorithm:");
      Terminal.println("For n = " + n + " points, the elapsed time of this method is " +
		       (endTime.getTime() - startTime.getTime()) + " milliseconds.");
      Terminal.println("The closest two points are: "+g+" units apart.\n");

      Date startTime2 = new Date();
      float q = FastClosestPair.CheckAllPairs(ptsByX);
      Date endTime2 = new Date();
      Terminal.println("Utilizing Brute Force/Naive Algorithm:");
      Terminal.println("For n = " + n + " points, the elapsed time of this method is " +
		       (endTime2.getTime() - startTime2.getTime()) + " milliseconds.");
      Terminal.println("The closest two points are: "+q+" units apart.\n");

      if (n <= 25){
	Terminal.println("The points sorted by xcoord are:");
	for (int i=0; i<=n-1; i++)
	  Terminal.println("   " + ptsByX[i]);

	Terminal.println("The points sorted by ycoord are:");
	for (int i=0; i<=n-1; i++)
	  Terminal.println("   " + ptsByY[i]);


   }

//  THESE LINES DEMONSTRATES HOW TO USE THE PROVIDED PLOTTER ROUTINE.   Use these
//     as you want for debugging purposes.  Please also use them in your
//     closest pair routine.  You could, as an example, color all points in
//     the left half red and all points in the right half blue and then visually
//     check that you divided them properly by calling the plotter before
//     you recurse.  Note that if you make several calls, all the plots will
//     initially be on top of each other -- just move them so you can see
//     everything.

// In this call it prints the points sorted by x-coordinate with each point
//     labeled by it's index in sortedX

	new Plotter(ptsByX,0,0,100000,100000,true,"Sorted by X-coordinate");

//   Here the points are plotted and labelled based on sortedY

	new Plotter(ptsByY,0,0,100000,100000,true,"Sorted by Y-coordinate");

//   Here's a call to the plot routine in which the points aren't labeled
//   A nice thing to do at this point (if you computed the two closest points)
//   would be to color the two closest points a different color
//   For a XYPoint p, you could color p (say red) with the line:
//      p.color = Color.red;

      new Plotter(ptsByX,0,0,100000,100000,false,"Output");

//   Finally, here is a line demonstrating how you compute (and print) the
//     execution time.
//
//   ***** For your SUBMITTED OUTPUT you MUST print out the distance between *****
//   *****  the  closest pair and also the two points (if you computed them).*****

   }

  //============================ makeInt ================================
  //
  // Converts a double between 0 and 1 to an integer between lo and hi
  //
  static int makeInt(double rand, int lo, int hi){
     return lo + ((int) Math.floor(rand * (hi + 1 - lo)));
  }
}
