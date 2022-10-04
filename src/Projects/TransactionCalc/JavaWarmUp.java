package Projects.TransactionCalc;

import java.util.Scanner;

public class JavaWarmUp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of transactions that will be entered: ");
        String transStr = s.nextLine();
        int transInt = Integer.parseInt(transStr);
        ShopperData[] data = new ShopperData[transInt];
        int index = 0;
        int trans = 1;
        while (index < transInt) {
            ShopperData singleShopper = new ShopperData();
            System.out.println("Please enter transaction number " + trans);
            String item = s.nextLine();
            //fixing type problems and separating data
            String[] listAns = item.split(" ");
            String changeType = listAns[4];
            int listAns4 = Integer.parseInt(changeType);
            double listAns6 = Float.parseFloat(listAns[6]);
            double price = Float.parseFloat(listAns[3]);
            double rating = Float.parseFloat(listAns[5]);

            //moving data into ShopperData object
            singleShopper._date = listAns[0];
            singleShopper._time = listAns[1];
            singleShopper._category = listAns[2];
            singleShopper._price = price;
            singleShopper._quantity = listAns4;
            singleShopper._rating = rating;
            singleShopper._duration = listAns6;
            data[index] = singleShopper;
            index++;
            trans++;
        }
        highestByUnitSale(data);
        lowestByUnitSale(data);
        averagesByItem(data);
        s.close();
    }

    public static void lowestByUnitSale(ShopperData[] data) {
        double lowest = data[0]._price;
        int integer = 0;
        int counter = 0;
        while (counter < data.length) {
            if ((data[counter]._price) <= lowest) {
                lowest = data[counter]._price;
                integer = counter;
            }
            counter++;
        }

        String printPrice = String.format("%.2f", (data[integer]._price));
        String printRating = String.format("%.1f", (data[integer]._rating));
        System.out.println("Lowest per unit sale:");
        System.out.println("\tWhen: " + data[integer]._date + " " + data[integer]._time);
        System.out.println("\tCategory: " + data[integer]._category);
        System.out.println("\tPrice: " + printPrice);
        System.out.println("\tRating: " + printRating);
    }

    public static void highestByUnitSale(ShopperData[] data) {
        double highest = data[0]._price;
        int integer = 0;
        int counter = 0;
        while (counter < data.length) {
            if ((data[counter]._price) >= highest) {
                highest = (data[counter]._price);
                integer = counter;
            }
            counter++;
        }

        String printPrice = String.format("%.2f", (data[integer]._price));
        String printRating = String.format("%.1f", (data[integer]._rating));
        System.out.println("Highest per unit sale:");
        System.out.println("\tWhen: " + data[integer]._date + " " + data[integer]._time);
        System.out.println("\tCategory: " + data[integer]._category);
        System.out.println("\tPrice: " + printPrice);
        System.out.println("\tRating: " + printRating);
    }

    public static void averagesByItem(ShopperData[] data) {
        String[] categories = new String[3];
        categories[0] = "phone";
        categories[1] = "jewelry";
        categories[2] = "book";
        int x = categories.length - 1;
        for (; x > -1; x--){
            int totalQuantity = 0;
            double totalPrice = 0;
            double totalRating = 0;
            double totalDuration = 0;
            double numInCat = 0;
            for (ShopperData datum : data) {
                if (categories[x].equals(datum._category)) {
                    totalQuantity += datum._quantity;
                    totalPrice += datum._price * datum._quantity;
                    totalRating += datum._rating;
                    totalDuration += datum._duration;
                    numInCat += 1;
                }
            }
            String printPrice = String.format("%.2f", totalPrice/totalQuantity);
            String printRating = String.format("%.2f", totalRating/numInCat);
            String printDuration = String.format("%.2f", totalDuration/numInCat);

            System.out.println("Averages by " + categories[x]);
            System.out.println("\tQuantity: " + totalQuantity);
            System.out.println("\tPrice: " + printPrice);
            System.out.println("\tRating: " +printRating);
            System.out.println("\tDuration: " +printDuration);
        }
    }
}
