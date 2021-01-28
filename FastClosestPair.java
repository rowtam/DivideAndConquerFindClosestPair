public class FastClosestPair {

   //============================ closestPair =========================
   //
   // This procedures takes as input an array X of the points sorted
   // in non-decreasing order of x-coordinate and an array Y of the points
   // sorted in non-decreasing order of y-coordinate.   It returns a PointPair
   // that holds a pair of closest points along with their distance.
   //===========================================================================

   public final static double MAXDOUBLE = 200000.0;

   public static float findClosestPairDist(XYPoint[] PtsbyX, XYPoint[] PtsbyY) {
        int n = PtsbyX.length;
        int mid = (int)(n/2);
        XYPoint[] xl,yl,xr,yr, Ystrip;
        xl = new XYPoint[mid];
        xr = new XYPoint[n-mid];
        yl = new XYPoint[mid];
        yr = new XYPoint[n-mid];
        float sl, sr, m, dist;
        int j;
        if (n == 1)
            return (float) MAXDOUBLE;
        if (n == 2)
            return (float)PtsbyX[0].dist(PtsbyX[1]);
        //begin-create and construct xl,yl,xr,yr
        int i = 0;
        while (i < xl.length) {
            xl[i] = PtsbyX[i];
            i++;
        }
        j = 0;
        while (j < xr.length) {
            xr[j] = PtsbyX[i];
            i++;
            j++;
        }
        int k = 0;
        int l = 0;
        i=0;
        while (i < PtsbyY.length) {
            if (PtsbyY[i].leftof(PtsbyX[mid])) {
                yl[l] = PtsbyY[i];
                l++;
                i++;
            } else {
                yr[k] = PtsbyY[i];
                i++;
                k++;
            }
        }
        /*if (l == mid)
            Terminal.println("left is okay");
        if (k == n-mid)
            Terminal.println("right is okay");*/
        //end-create and construct xl,yl,xr,yr
        sl = findClosestPairDist(xl, yl);
        sr = findClosestPairDist(xr, yr);
        m = Math.min(sl,sr);
        //begin-create and construct Ystrip
        i=0;
        int arrayindex = 0;
        while (i < PtsbyY.length) {
            if ((PtsbyY[i].x < (xr[0].x + m)) && (PtsbyY[i].x > (xr[0].x - m)))
                arrayindex++;
            i++;
        }
        Ystrip= new XYPoint[arrayindex];
        i=0;
        arrayindex=0;
        while (arrayindex < Ystrip.length) {
            if (PtsbyY[i].x <= (xr[0].x + m) && PtsbyY[i].x >= (xr[0].x - m)) {
                Ystrip[arrayindex] = PtsbyY[i];
                arrayindex++;
            }
            i++;
        }
        //end-create and construct Ystrip
        for(i = 0; i <= Ystrip.length-2; i++) {
                j = i+1;
                while(j <= Ystrip.length - 1 && Ystrip[j].y - Ystrip[j].y < m) {
                    dist = (float)Ystrip[i].dist(Ystrip[j]);
                    m = Math.min(m,dist);
                    j++;
                }
        }
        return m;
   }

   public static PointPair findClosestPointPairDist(XYPoint[] PtsbyX, XYPoint[] PtsbyY) {
        int n = PtsbyX.length;
        int mid = (int)(n/2);
        XYPoint[] xl,yl,xr,yr, Ystrip;
        xl = new XYPoint[mid];
        xr = new XYPoint[n-mid];
        yl = new XYPoint[mid];
        yr = new XYPoint[n-mid];
        PointPair sl, sr, m, dist;
        int j;
        if (n == 1)
            return new PointPair();
        if (n == 2)
            return new PointPair(PtsbyX[0],PtsbyX[1]);
        //begin-create and construct xl,yl,xr,yr
        int i = 0;
        while (i < xl.length) {
            xl[i] = PtsbyX[i];
            i++;
        }
        j = 0;
        while (j < xr.length) {
            xr[j] = PtsbyX[i];
            i++;
            j++;
        }
        int k = 0;
        int l = 0;
        i=0;
        while (i < PtsbyY.length) {
            if (PtsbyY[i].leftof(PtsbyX[mid])) {
                yl[l] = PtsbyY[i];
                l++;
                i++;
            } else {
                yr[k] = PtsbyY[i];
                i++;
                k++;
            }
        }
        /*if (l == mid)
            Terminal.println("left is okay");
        if (k == n-mid)
            Terminal.println("right is okay");*/
        //end-create and construct xl,yl,xr,yr
        sl = findClosestPointPairDist(xl, yl);
        sr = findClosestPointPairDist(xr, yr);
        m = sl.Closer(sr);
        //begin-create and construct Ystrip
        i=0;
        int arrayindex = 0;
        while (i < PtsbyY.length) {
            if ((PtsbyY[i].x < (xr[0].x + m.dist)) && (PtsbyY[i].x > (xr[0].x - m.dist)))
                arrayindex++;
            i++;
        }
        Ystrip= new XYPoint[arrayindex];
        i=0;
        arrayindex=0;
        while (arrayindex < Ystrip.length) {
            if (PtsbyY[i].x <= (xr[0].x + m.dist) && PtsbyY[i].x >= (xr[0].x - m.dist)) {
                Ystrip[arrayindex] = PtsbyY[i];
                arrayindex++;
            }
            i++;
        }
        //end-create and construct Ystrip
        for(i = 0; i <= Ystrip.length-2; i++) {
                j = i+1;
                while(j <= Ystrip.length - 1 && Ystrip[j].y - Ystrip[j].y < m.dist) {
                    dist = new PointPair(Ystrip[i],Ystrip[j]);
                    m = m.Closer(dist);
                    j++;
                }
        }
        return m;
   }

   public static float CheckAllPairs(XYPoint[] points) {
        int j;
        float dist, minDist;
        XYPoint p1, p2;
        minDist = (float) MAXDOUBLE;
        float numdist = (float) MAXDOUBLE;
        int n = points.length;
        for(int i = 0; i<=n-2; i++) {
            for(j = i+1; j <= n-1; j++) {
                dist = (float) points[i].dist(points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        return minDist;
   }
}
