package streams;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long countOrderByStatus(String pending) {
        return orders.stream().filter(e -> e.getStatus().equals(pending)).count();
    }

    public List<Order> collectOrdersWithProductCategory(String category) {
        return orders.stream().filter(o -> o.getProducts().stream().anyMatch(e -> e.getCategory().equals(category))).collect(Collectors.toList());
    }

    public List<Product> productsOverAmountPrice(int amount) {
       return orders.stream().
                flatMap(o -> o.getProducts().stream())
                .filter(e -> e.getPrice() > amount)
                .distinct() // ha csak egyszer akarjuk
                .collect(Collectors.toList());
    }
    
//     public long getRevenueBetweenDates(LocalDate date1, LocalDate date2){
//         orders.stream().filter(o -> o.getOrderDate().isAfter(date1) && o.getOrderDate().isBefore(date2))
//             .flatMap(o -> o.getProducts().stream())
//             .mapToInt(p -> p.getPrice()).sum();

            
//    Órán megoldott feladatok:
//    Határozd meg a rendelések darabszámát egy paraméterként kapott státusz alapján
//    Gyűjtsd össze azokat a rendeléseket, amelyekben van egy paraméterként kapott kategóriájú termék
//    Gyűjtsd össze azokat a termékeket a rendelések közül, amelyeknek egy paraméteról kapott összegnél magasabb az áruk
//    További gyakorló feladatok:
//    Írj egy metódust ami paraméterként vár két dátumot, és adjuk vissza a két dátum közötti árbevételt, vagyis a két dátum közötti rendelések termékeinek az összértékét!
//    Keressünk meg egy terméket a neve alapján, amit paraméterként lehet megadni.
//    Adjuk vissza azt a rendelést, ami a legdrágább terméket tartalmazza. Ha több ilyen van bármelyiket!

}
