import org.example.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringListImplTest {
    private StringListImpl stringListImpl;

    @BeforeEach
    public void setUp() {
        stringListImpl = new StringListImpl();
    }

    @Test
    public void add() {

        String item1 = "Item1";
        String item2 = "Item2";
        String item3 = "Item3";

        stringListImpl.add(item1);
        stringListImpl.add(item2);
        String result = stringListImpl.add(item3);

        // Проверяем, что возвращенный элемент равен добавленному
        assertEquals(item3, result);

        //Проверяем, что все элементы действительно добавлены в массив
        String[] items = stringListImpl.getItems();

        assertEquals(3, items.length);
        assertEquals(item1, items[0]);
        assertEquals(item2, items[1]);
        assertEquals(item3, items[2]);
    }

    @Test
    public void addForIndex() {

        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        String item = "TestItem";
        String result = stringListImpl.add(1, item);

        assertEquals(item, result);

        String[] items = stringListImpl.getItems();
        assertEquals(3, items.length);
        assertEquals("Item1", items[0]);
        assertEquals(item, items[1]);
        assertEquals("Item2", items[2]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringListImpl.add(15, "TestItem");
        });

    }

    @Test
    public void set() {
        stringListImpl.add(0, "Item1");
        stringListImpl.add(1, "Item2");
        String item = "TestItem";
        String result = stringListImpl.set(0, item);
        assertEquals(item, result);

        String[] items = stringListImpl.getItems();
        assertEquals(2, items.length);
        assertEquals(item, items[0]);
        assertEquals("Item2", items[1]);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stringListImpl.set(2, "TestItem");
        });
    }
}
