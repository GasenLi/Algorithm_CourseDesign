package DynamicPlanning.Test1_LeastCostOfShopping.Entity;

import java.util.LinkedList;

public class ShoppingList {
    public LinkedList<ShoppingWay> shoppingList = new LinkedList<>();

    public void addShoppingWay(ShoppingWay shoppingWay){
        shoppingList.add(shoppingWay);
    }

    public ShoppingWay getShoppingWayByID(String goodsID){
        for(ShoppingWay shoppingWay : shoppingList){
            if(shoppingWay.aGoods.goodsID.equals(goodsID)){
                return shoppingWay;
            }
        }

        return null;
    }
}
