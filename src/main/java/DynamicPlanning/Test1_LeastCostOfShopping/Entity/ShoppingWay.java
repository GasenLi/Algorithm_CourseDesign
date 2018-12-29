package DynamicPlanning.Test1_LeastCostOfShopping.Entity;

public class ShoppingWay {
    public Goods aGoods;
    public int number;

    public ShoppingWay(Goods aGoods, int number){
        this.aGoods = aGoods;
        this.number = number;
    }

    public double getPrice(){
        return  aGoods.goodsPrice*number;
    }
}
