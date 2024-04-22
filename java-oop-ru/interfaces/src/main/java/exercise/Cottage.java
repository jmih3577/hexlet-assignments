package exercise;

// BEGIN
class Cottage implements Home {
    double area;
    int floorCount;
    Cottage(double dArea, int iFloorCount) {
        this.area = dArea;
        this.floorCount = iFloorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (another.getArea() > getArea()) {
            return -1;
        } else if (another.getArea() < getArea()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
