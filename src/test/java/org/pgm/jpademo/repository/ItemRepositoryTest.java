package org.pgm.jpademo.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.pgm.jpademo.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testInsert() {
//        Item item = new Item();
//        item.setPrice(2222);
//        item.setStockNumber(222);
//        item.setItemNn("2222");
//        item.setItemDetail("2222");
//        itemRepository.save(item);
        Item item = Item.builder()
                .itemNn("공책")
                .price(5000)
                .itemDetail("알림장 노트")
                .stockNumber(30)
                .build();
        itemRepository.save(item);
    }

    @Test
    public void getListTest() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            log.info(item);
        }
    }
    @Test
    public void getOneTest() {
        Item item = itemRepository.findById(2L).get();
        log.info(item);
    }
    @Test
    public void updateItemTest() {
        Item item = itemRepository.findById(52L).get();
        item.setPrice(20000);
        item.setStockNumber(50);
        item.setItemNn("볼펜");
        itemRepository.save(item);
    }

    @Test
    public void deleteBoardTest() {
        itemRepository.deleteById(1L);
    }
}
