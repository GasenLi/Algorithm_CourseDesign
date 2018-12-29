package DynamicPlanning.Test2_LeastCostOfRent;

public class Chartering {
    int rentalStations;
    int[][] rentals;

    public Chartering(int rentalStations) {
        this.rentalStations = rentalStations;
        rentals = new int[rentalStations][rentalStations];

        randomInitialRentals();
    }

    public void randomInitialRentals() {
        for (int i = 0; i < rentals.length; i++) {
            for (int j = i; j < rentals[i].length; j++) {
                if (i == j) {
                    rentals[i][j] = 0;
                } else if (j > i) {
                    rentals[i][j] = (int) (Math.random() * 20 + 5);
                    rentals[j][i] = rentals[i][j];
                }
            }
        }
    }

    public void chartering(){
        for(int l=0; l<rentals.length; l++){

            //遍历二维数组
            for(int i=0; i<rentals.length; i++){
                if(i == l){
                    continue;
                }
                for(int j=0; j<rentals.length ;j++){
                    if(j == l){
                        continue;
                    }
                    rentals[i][j] = Math.min(rentals[i][l] + rentals[l][j], rentals[i][j]);
                }
            }
        }
    }

    public void speak(){
        System.out.println("从1号出租站到" + rentalStations + "号出租站的最少租金为 ：" + rentals[0][rentalStations-1]);
    }
}
