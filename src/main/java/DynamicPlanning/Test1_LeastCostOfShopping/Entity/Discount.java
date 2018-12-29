package DynamicPlanning.Test1_LeastCostOfShopping.Entity;


import java.util.*;

public class Discount {
    public Queue<ShoppingList> sortedDiscount = new PriorityQueue<>(new Comparator<ShoppingList>(){
        @Override
        public int compare(ShoppingList o1, ShoppingList o2) {
            double price1 = 0, price2 = 0;
            for(ShoppingWay shoppingWay : o1.shoppingList){
                price1 += shoppingWay.getPrice();
            }

            for(ShoppingWay shoppingWay : o2.shoppingList){
                price2 += shoppingWay.getPrice();
            }

            double discount1 = discounts.get(o1)/price1;
            double discount2 = discounts.get(o2)/price2;

            return (discount1-discount2) < 0 ? -1 : 1;
        }
    });


    public HashMap<ShoppingList , Double> discounts = new HashMap<>();

    public void addDiscount(ShoppingList shoppingList, Double price){
        discounts.put(shoppingList, price);
    }

    public void sortDiscount(){
        for(HashMap.Entry<ShoppingList, Double> discount : discounts.entrySet()){
            sortedDiscount.add(discount.getKey());
        }
    }
}
