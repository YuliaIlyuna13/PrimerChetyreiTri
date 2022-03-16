









import java.util.Scanner;

class Country{
    String name;
    double square;
}
public class InfoAboutCountries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Count");


        int count = sc.nextInt();
        Country[] countries = new Country[count];
        sc.nextLine();
        for (int i = 0; i < countries.length; i++) {
            countries[i] = new Country();
            System.out.println("Input name " + (i + 1));
            countries[i].name = sc.nextLine();
            System.out.println("Input square " + (i + 1));
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        System.out.println("Info about countries");
        for (int i = 0; i < count; i++) {
            System.out.println(countries[i].name + "\t" + countries[i].square);
        }

        int indexMax = 0;
        double max = countries[indexMax].square;
        for (int i = 1; i < count; i++) {
            if (countries[i].square > max) {
                indexMax = i;
                max = countries[indexMax].square;
            }

        }
        System.out.println("Country " + countries[indexMax].name + "with max square = " + countries[indexMax].square);
        for (int i = 0; i < countries.length - 1; i++) {
            for (int j = 0; j < countries.length - 1 - i; j++) {
                if (countries[j].square > countries[j + 1].square) {
                    Country temp = countries[j];
                    countries[j] = countries[j + 1];
                    countries[j + 1] = temp;
                }
            }
        }
        System.out.println("Sort by Square");
        for (int i = 0; i < count; i++) {
            System.out.println(countries[i].name + "\t" + countries[i].square);
        }

        for (int i = 0; i < countries.length - 1; i++) {
            for (int j = 0; j < countries.length - 1 - i; j++) {
                if (countries[j].name.compareTo(countries[j+1].name)>0) {
                    Country temp = countries[j];
                    countries[j] = countries[j + 1];
                    countries[j + 1] = temp;
                }
            }
        }
        System.out.println("Sort by name");
        for (int i = 0; i < count; i++) {
            System.out.println(countries[i].name + "\t" + countries[i].square);
        }



        double sumSquare = 0;
        for (int i = 0; i < countries.length; i++) {
            sumSquare = sumSquare + countries[i].square;
        }
        double avgSquare = (double) (sumSquare / count);
        System.out.println("AvgSquare = " + avgSquare);
        System.out.println("Countries with square ");
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].square > avgSquare) {
                System.out.println(countries[i].name + "\t" + countries[i].square);
            }
        }

        sc.nextLine();
        System.out.println("Input name");
        String searchName = sc.nextLine();
        int indexSearch = -1;
        for (int i = 0; i < count; i++) {
            if (countries[i].name.equalsIgnoreCase(searchName)) {
                indexSearch = i;
            }
        }

        if (indexSearch!=-1){
            System.out.println("Country is found");
            System.out.println(countries[indexSearch].name + "\t" + countries[indexSearch].square);
        }
        else{
            System.out.println("Not found");
        }
    }
}



