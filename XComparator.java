
class XComparator implements Comparator {
   public boolean comp(XYPoint p1, XYPoint p2){ //compares p1 and p2 based on x-coord
     return (p1.leftof(p2));
   }
}
