package com.restaurante.integration;

import com.restaurante.ItemDoMenu;
import com.restaurante.ItemDoPedido;
import com.restaurante.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoIntegrationTest {
    private ItemDoMenu itemPizza;
    private ItemDoMenu itemRefrigerante;
    private ItemDoPedido itemPedido1;
    private ItemDoPedido itemPedido2;
    private Pedido pedido;

    @BeforeEach
    void setUp(){
        itemPizza = new ItemDoMenu("Pizza", 20.00);
        itemRefrigerante = new ItemDoMenu("Refrigerante", 7.00);
        itemPedido1 = new ItemDoPedido(itemPizza, 1);
        itemPedido2 = new ItemDoPedido(itemRefrigerante, 2);
        pedido = new Pedido(new ArrayList<>());
    }

    @Test
    void adicionarUmItemTest(){
        pedido.adicionarItem(itemPedido1);
        assertEquals(1, pedido.getItens().size());
        assertTrue(pedido.getItens().contains(itemPedido1));


    }

    @Test
    void adicionarDoisItensTest(){
        pedido.adicionarItem(itemPedido1);
        pedido.adicionarItem(itemPedido2);
        assertEquals(2, pedido.getItens().size());
        assertTrue(pedido.getItens().contains(itemPedido2));
    }

    @Test
    void getItensTest(){
        pedido.adicionarItem(itemPedido1);
        pedido.adicionarItem(itemPedido2);

        List<ItemDoPedido> itensDoPedido = pedido.getItens();

        assertEquals(2, itensDoPedido.size());
        assertTrue(itensDoPedido.contains(itemPedido1));
        assertTrue(itensDoPedido.contains(itemPedido2));
    }

    @Test
    void calcularTotalComItensTest(){
        pedido.adicionarItem(itemPedido1);
        pedido.adicionarItem(itemPedido2);

        double total = pedido.calcularTotal();

        assertEquals(34.00, total, 0.01);
    }

    @Test
    void calcularTotalSemItensTest(){

        double total = pedido.calcularTotal();

        assertEquals(0.00, total, 0.01);
    }

}