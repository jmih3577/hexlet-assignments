package exercise;

// BEGIN
class Segment {
    Point point1;
    Point point2;
    public Segment(Point p1, Point p2) {
        this.point1 = p1;
        this.point2 = p2;
    }

    public Point getStartPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }
    public Point getMidPoint() {
        return new Point((point1.x + point2.x) / 2,(point1.y + point2.y) / 2);
    }
}
// END
