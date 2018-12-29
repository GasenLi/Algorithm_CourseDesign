package DynamicPlanning.Test1_LeastCostOfShopping;

import DynamicPlanning.Test1_LeastCostOfShopping.Entity.Discount;
import DynamicPlanning.Test1_LeastCostOfShopping.Entity.Goods;
import DynamicPlanning.Test1_LeastCostOfShopping.Entity.ShoppingList;
import DynamicPlanning.Test1_LeastCostOfShopping.Entity.ShoppingWay;

public class ShoppingTest {
    public static void main(String[] args) {
        //Step one : 设置物品
        Goods goods1 = new Goods("花瓶", 5.0);
        Goods goods2 = new Goods("花", 2.0);
        Goods goods3 = new Goods("馒头", 3.0);

        //Step two : 设置购买的物品
        ShoppingWay shoppingWay1 = new ShoppingWay(goods1,6);
        ShoppingWay shoppingWay2 = new ShoppingWay(goods2,6);
        ShoppingWay shoppingWay3 = new ShoppingWay(goods3,6);


        //Step three : 设置优惠方案
        Discount discounts = new Discount();
        ShoppingWay discountWay1 = new ShoppingWay(goods1,3);
        ShoppingWay discountWay2 = new ShoppingWay(goods1,2);
        ShoppingWay discountWay3 = new ShoppingWay(goods2,1);
        ShoppingWay discountWay4 = new ShoppingWay(goods3,1);

        ShoppingList discountList1 = new ShoppingList(); discountList1.addShoppingWay(discountWay1);discountList1.addShoppingWay(discountWay4);
        ShoppingList discountList2 = new ShoppingList(); discountList2.addShoppingWay(discountWay2);discountList2.addShoppingWay(discountWay3);
        discounts.addDiscount(discountList1, 8.0);
        discounts.addDiscount(discountList2, 10.0);



        //初始化参数
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addShoppingWay(shoppingWay1);
        shoppingList.addShoppingWay(shoppingWay2);
        shoppingList.addShoppingWay(shoppingWay3);

        discounts.sortDiscount();

        //开始
        Shopping shopping = new Shopping(shoppingList, discounts);
        shopping.bestShopping();
        shopping.speak();

    }

}
