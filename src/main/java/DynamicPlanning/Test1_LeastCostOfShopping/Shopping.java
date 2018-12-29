package DynamicPlanning.Test1_LeastCostOfShopping;

import DynamicPlanning.Test1_LeastCostOfShopping.Entity.Discount;
import DynamicPlanning.Test1_LeastCostOfShopping.Entity.ShoppingList;
import DynamicPlanning.Test1_LeastCostOfShopping.Entity.ShoppingWay;

import java.util.LinkedList;

public class Shopping {
    public Discount discount = new Discount();
    public ShoppingList shoppingList = new ShoppingList();
    public double leastPrice = 0.0;


    public Shopping(ShoppingList shoppingList, Discount discount) {
        this.shoppingList = shoppingList;
        this.discount = discount;
    }


    public void bestShopping() {
        ShoppingList shoppingListTemp = new ShoppingList();
        shoppingListTemp.shoppingList = (LinkedList<ShoppingWay>) shoppingList.shoppingList.clone();

        //遍历打折计划
        for (ShoppingList discountList : discount.sortedDiscount) {

            Boolean hasLeft = true;
            ShoppingWay shoppingWay;
            while (hasLeft) {
                for (ShoppingWay discountWay : discountList.shoppingList) {
                    shoppingWay = shoppingListTemp.getShoppingWayByID(discountWay.aGoods.goodsID);
                    if (shoppingWay.number < discountWay.number) {
                        hasLeft = false;
                        break;
                    }
                }

                if (hasLeft) {
                    for (ShoppingWay discountWay : discountList.shoppingList) {
                        shoppingWay = shoppingListTemp.getShoppingWayByID(discountWay.aGoods.goodsID);
                        shoppingWay.number -= discountWay.number;
                    }

                    leastPrice += discount.discounts.get(discountList);
                }
            }
        }

        //剩下的用单价买
        for (ShoppingWay shoppingWay : shoppingListTemp.shoppingList) {
            if (shoppingWay.number > 0) {
                leastPrice += shoppingWay.getPrice();
                shoppingWay.number = 0;
            }
        }

    }

    public void speak() {
        System.out.println("最低价格 ： " + leastPrice);
    }
}
