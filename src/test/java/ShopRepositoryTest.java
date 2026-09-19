import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {

    @Test
    public void shouldFindById() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Ноутбук", 50_000);

        repository.add(product1);
        repository.add(product2);

        Product expected = product2;
        Product actual = repository.findById(2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWhenProductNotFound() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Ноутбук", 50_000);

        repository.add(product1);
        repository.add(product2);

        Product expected = null;
        Product actual = repository.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Ноутбук", 50_000);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] expected = {product2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenRemoveProductNotFound() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Ноутбук", 50_000);

        repository.add(product1);
        repository.add(product2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}