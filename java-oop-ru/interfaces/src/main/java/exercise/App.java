package exercise;

import java.util.Comparator;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartList, int flatNum) {
        //List<String> result = apartList.stream().sorted(Comparator.comparingDouble(Home::getArea))
        // .map(Home::toString).limit(flatNum).toList();
        return apartList.stream().sorted(Comparator.comparingDouble(Home::getArea))
                .map(Home::toString).limit(flatNum).toList();
    }
}
// END
