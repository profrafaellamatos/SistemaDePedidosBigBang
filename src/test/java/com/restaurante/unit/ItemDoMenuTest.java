package com.restaurante.unit;

import com.restaurante.ItemDoMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDoMenuTest {
    private ItemDoMenu item;

    @BeforeEach
    void setUp(){
        item = new ItemDoMenu("Pizza", 20.00);
    }

    @Test
    void getNome() {
        assertEquals("Pizza", item.getNome());
    }

    @Test
    void getPreco() {
        assertEquals(20.00, item.getPreco(), 0.01);
    }
}