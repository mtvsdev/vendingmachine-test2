package com.ohgiraffers;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ChangeAndRandom {
    static List<Drink> list = new LinkedList<>();
    public static class Drink{
        int num;
        String name;
        int price;
        int cnt;

        Drink(int n, String str, int p, int c){
            this.num = n;
            this.name = str;
            this.price = p;
            this.cnt = c;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("물품 목록 초기화 ..\n");
        inputDrinks();
        System.out.println("\n돈을 넣어주세요 ..!");
        int money = sc.nextInt();


        while(true) {
            if(money < 200){
                System.out.println("잔액이 부족합니다. 현금을 더 투입하시겠습니까 ? ? ? \n 1.예 2. 아니오 >> 번호 입력 :\n");
                int select = sc.nextInt();
                switch(select){
                    case 1:
                        System.out.println("추가할 금액을 입력해주세요.");
                        int getMoney = sc.nextInt();
                        money += getMoney;
                        break;
                    case 2:
                        retMsg(money);
                        System.exit(0);
                        break;
                }
            }
            System.out.println("\n메뉴를 선택해주세요.");
            System.out.println("--- 메뉴 ---");
            for (int i = 0; i < list.size(); i++) {
                Drink tmp = list.get(i);
                System.out.print(tmp.num + ". " + tmp.name + " : " + tmp.price + "원 /재고:" + tmp.cnt);
                if (money < tmp.price || tmp.cnt <= 0)
                    System.out.print("   <<<  X X 구 매 불 가 X X ");
                System.out.println();
            }
            System.out.printf("\n## 현재 잔액 : %d원 ##\n", money);

            System.out.println("구매할 음료의 숫자를 입력하세요. >> ");
            int choice = sc.nextInt();
            Drink drk = list.get(choice-1);
            if(drk.num == 6){
                while(true) {
                    Random random = new Random();
                    random.setSeed(System.currentTimeMillis());
                    int rnum = random.nextInt(5);
                    if (0 < list.get(rnum).cnt && list.get(rnum).price <= money) {
                        money -= 800;
                        list.get(rnum).cnt--;
                        list.get(5).cnt--;
                        break;
                    } else {
                        boolean flag = check(money);
                        if(!flag){
                            retMsg(money);
                            System.exit(0);
                        }
                    }
                }
            }
            else if(drk.price <= money && 0 < drk.cnt){
                money -= drk.price;
                drk.cnt--;
            }
            else{
                System.out.println("\n현재 구매하실 수 없습니다.\n");
            }

            if(!check(money)){
                retMsg(money);
                System.exit(0);
            }
        }
    }
    public static boolean check(int money){
        for(int i = 0; i < list.size(); i++){
            Drink tmp = list.get(i);
            if(tmp.price <= money && 0 < tmp.cnt)
                return true;
        }
        return false;
    }
    public static void inputDrinks(){
        list.add(new Drink(1,"콜라", 1000, 5));
        list.add(new Drink(2,"사이다", 700, 5));
        list.add(new Drink(3,"커피", 200, 3));
        list.add(new Drink(4,"밀키스", 500, 5));
        list.add(new Drink(5, "제로 콜라", 1000, 2));
        list.add(new Drink(6, "랜덤", 800, 20));
    }
    public static boolean retMsg(int money){
        if(money <= 0){
            System.out.println("안녕히 가세요..");
            return false;
        }
        else {
            System.out.printf("잔액 %d원을 거슬러 받았습니다.\n", money);
            return true;
        }
    }
}
