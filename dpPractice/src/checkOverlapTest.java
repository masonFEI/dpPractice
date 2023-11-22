public class checkOverlapTest {


    public static void main(String[] args) {
        int radius = 43;
        int xCenter = 450;
        int yCenter = 919;
        int x1 = 334;
        int y1 = 18;
        int x2 = 497;
        int y2 = 142;
        boolean res = checkOverlap(radius,xCenter,yCenter,x1,y1,x2,y2);

        System.out.println(res);
    }


    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int minRadiusX = xCenter-radius;
        int maxRadiusX = xCenter+radius;
        int minRadiusY = yCenter-radius;
        int maxRadiusY = yCenter+radius;

        if ((maxRadiusX>=x1 && maxRadiusY<=y2 && minRadiusY>=y1)
                || ( maxRadiusY<=y2 && maxRadiusY>=y1 && maxRadiusX<=x2 && minRadiusX>=x1)
                || (x1 <=minRadiusX && x2>=maxRadiusX && y2<=maxRadiusY && y1>=minRadiusY)
                || (y1 <=minRadiusY && y2>=maxRadiusY && x2<=maxRadiusX && x1>=minRadiusX)) {
            return true;
        }


        double disRes = PointToSegDist( xCenter,  yCenter,  x1,  y2,  x2,  y2);

        if(disRes<=radius){
            return true;
        }

        disRes = PointToSegDist( xCenter,  yCenter,  x1,  y1,  x1,  y2);

        if(disRes<=radius){
            return true;
        }

        disRes = PointToSegDist( xCenter,  yCenter,  x1,  y1,  x2,  y1);

        if(disRes<=radius){
            return true;
        }

        disRes = PointToSegDist( xCenter,  yCenter,  x2,  y2,  x2,  y1);

        if(disRes<=radius){
            return true;
        }

        return false;
    }


    public static double PointToSegDist(double x, double y, double x1, double y1, double x2, double y2)
    {
        double cross = (x2 - x1) * (x - x1) + (y2 - y1) * (y - y1);
        if (cross <= 0) return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));

        double d2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        if (cross >= d2) return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));

        double r = cross / d2;
        double px = x1 + (x2 - x1) * r;
        double py = y1 + (y2 - y1) * r;
        return Math.sqrt((x - px) * (x - px) + (y - py) * (y - py));
    }

}
