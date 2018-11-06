package com.racic.homeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    private String output;
    private Writer writerMock = new Writer() {
        //class anonyme writer
        @Override
        public void start() {
        output="";
        }

        @Override
        public void writeLine(String line) {
        output += line + "%n";
        }

        @Override
        public void stop() {

        }
    };

    private Product cafe1 = new Product("Philips HD123","senseo quadrante",79.99);
    private Television tv1 = new Television("TV Samsung 123","Smart TV LED", 599,49,"LED");
    private Fridge fridge1 = new Fridge("BEKO TS2", "BEKO CLasse A+",189,130,false);
    private Client client1 = new Client("George Lukas", "151 Rue Carnot,Paris");
    private Delivery lowCostRelayDelivery = new RelayDelivery(27);


    @Test
    public void Given_2productsAndDelivery_When_GeneratingBill_Then_getGoodLineNumber() {
        Bill bill1 = new Bill(client1,lowCostRelayDelivery);
        bill1.addProduct(cafe1, 1);
        bill1.addProduct(tv1, 1);
        bill1.generate(writerMock);
        int lineNumber = output.split("%n").length;
        assertEquals(20,lineNumber);
    }

    @Test
    public void Given_3productsAndDelivery_When_generatingBill_Then_getGoodTotal() {
        Bill bill = new Bill(client1, lowCostRelayDelivery);
        bill.addProduct(cafe1, 1);
        bill.addProduct(tv1, 1);
        bill.addProduct(fridge1, 1);
        assertEquals(867.99, bill.getTotal(), 0.01);
    }

    @Test
    public void Given_emptyProductList_When_generatingList_Then_throwException() {
        Bill bill = new Bill(client1, lowCostRelayDelivery);
        assertThrows(NoProductInBillException.class,() -> bill.generate(writerMock));

    }
}