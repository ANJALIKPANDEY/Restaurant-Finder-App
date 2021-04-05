import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        for(Restaurant rest: restaurants){
            if(rest.getName().equals(restaurantName)){
                return rest;
            }
            else{
                throw new restaurantNotFoundException(restaurantName);
            }
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);

        //The method was missing the exception part of the code, thus implemented without instructions
        if (restaurantToBeRemoved == null)
            throw new restaurantNotFoundException(restaurantName);

        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
