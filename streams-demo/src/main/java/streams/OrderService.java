package streams;

import java.time.LocalDate;
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
        orders.stream().
                flatMap(o -> o.getProducts().stream())
                .filter(e -> e.getPrice() > amount)
                .distinct() // ha csak egyszer akarjuk
                .collect(Collectors.toList());
    }

}
