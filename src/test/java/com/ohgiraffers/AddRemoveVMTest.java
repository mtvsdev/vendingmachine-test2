package com.ohgiraffers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddRemoveVMTest {


    VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        this.vendingMachine = new VendingMachine();
    }

    @DisplayName("콜라라는 품목을 추가하였을 때 정상적으로 추가 되었는지")
    @Test
    public void testAddVM(){
        vendingMachine.addObjectToVM("콜라");
        Assertions.assertEquals(true, vendingMachine.foundItemToVM("콜라"));
    }

    @DisplayName("사이다라는 기본 상품을 제거 하였을때 정상적으로 제거 되었는지")
    @Test
    public void testRemoveVM() {
        vendingMachine.removeObjectToVM("사이다");
        Assertions.assertEquals(false, vendingMachine.foundItemToVM("사이다"));
    }
}
