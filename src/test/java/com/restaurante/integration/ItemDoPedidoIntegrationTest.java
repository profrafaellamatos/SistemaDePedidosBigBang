package com.restaurante.integration;

import com.restaurante.ItemDoMenu;
import com.restaurante.ItemDoPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDoPedidoIntegrationTest {
    private ItemDoMenu itemPizza;
    private ItemDoMenu itemRefrigerante;
    private ItemDoPedido itemPedido1;
    private ItemDoPedido itemPedido2;

    @BeforeEach
    void setUp(){
        itemPizza = new ItemDoMenu("Pizza", 20.00);
        itemRefrigerante = new ItemDoMenu("Refrigerante", 7.00);
        itemPedido1 = new ItemDoPedido(itemPizza, 1);
        itemPedido2 = new ItemDoPedido(itemRefrigerante, 2);


    }

    @Test
    @DisplayName("Deveria estar recuperando os itens do menu")
    void getItemDoMenuTest(){
        assertNotNull(itemPizza);
        assertEquals(itemPizza, itemPedido1.getItemDoMenu());
        assertEquals("Pizza", itemPedido1.getItemDoMenu().getNome());
        assertEquals(20.00, itemPedido1.getItemDoMenu().getPreco());
        assertNotNull(itemRefrigerante);
        assertEquals(itemRefrigerante, itemPedido2.getItemDoMenu());
        assertEquals("Refrigerante", itemPedido2.getItemDoMenu().getNome());
        assertEquals(7.00, itemPedido2.getItemDoMenu().getPreco());

    }

    @Test
    @DisplayName("Deveria estar retornando as quantidades dos itens pedidos")
    void getQuantidadeTest(){
        assertEquals(1, itemPedido1.getQuantidade());
        assertEquals(2, itemPedido2.getQuantidade());
    }

    @Test
    @DisplayName("Deveria calcular o preço de cada item do pedido com base na quantidade")
    void calcularPrecoTotalPorItemTest(){
        assertEquals(20.00, itemPedido1.calcularPrecoTotalPorItem(), 0.01);
        assertEquals(14.00, itemPedido2.calcularPrecoTotalPorItem(), 0.01);
    }

}