package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    Flat(double dArea, double dBalconyArea, int iFloor) {
        this.area = dArea;
        this.balconyArea = dBalconyArea;
        this.floor = iFloor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
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
        return "Квартира площадью " + getArea() + " метров на " + floor + "этаже";
    }
}
// END
