public class PointPair {
    public XYPoint p1;
    public XYPoint p2;
    public float dist;

    public final static double MAXDOUBLE = 200000.0;

    PointPair(XYPoint p1, XYPoint p2) {
        this.p1 = p1;
        this.p2 = p2;
        dist = (float) p1.dist(p2);
    }

    PointPair() {
        p1 = null;
        p2 = null;
        dist = (float) MAXDOUBLE;
    }

    public PointPair Closer(PointPair closer) {
        if (closer.dist <= dist)
            return closer;
        else
            return this;
    }

    public String toString() {
        return ("Points: "+p1+","+p2+"\nDistance: "+dist);
    }
}