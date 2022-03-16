import java.util.Scanner;

public class InfoAboutCountriesTwo {
    static Scanner sc;

    public static Country[] setCountry(int count) {
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
        return countries;
    }

    public static void showArray(Country[] countries) {

        for (int i = 0; i < countries.length; i++) {
            System.out.println(countries[i].name + "\t" + countries[i].square);
        }
    }

public static void showCountry(Country country){
        System.out.println(country.name + "\t" + country.square);
}
public static int nomMax(Country[]countries) {
    int indexMax = 0;
    double max = countries[indexMax].square;
    for (int i = 1; i < countries.length; i++) {
        if (countries[i].square > max) {
            indexMax = i;
            max = countries[indexMax].square;
        }
    }
    return indexMax;
}
public static void sortSquare(Country[]countries) {
    for (int i = 0; i < countries.length - 1; i++) {
        for (int j = 0; j < countries.length - 1 - i; j++) {
            if (countries[j].square > countries[j + 1].square) {
                Country temp = countries[j];
                countries[j] = countries[j + 1];
                countries[j + 1] = temp;
            }
        }
    }
}
public static void sortName(Country[]countries){
    for (int i = 0; i < countries.length - 1; i++) {
        for (int j = 0; j < countries.length - 1 - i; j++) {
            if (countries[j].name.compareTo(countries[j+1].name)>0) {
                Country temp = countries[j];
                countries[j] = countries[j + 1];
                countries[j + 1] = temp;
            }
        }
    }
}
public static double avgSquare(Country[]countries){
    double sumSquare = 0;
    for (int i = 0; i < countries.length; i++) {
        sumSquare = sumSquare + countries[i].square;
    }
    double avgSquare = (double) (sumSquare / countries.length);
    return avgSquare;
}

public static void bigger(Country[]countries, double avgSquare){
    for (int i = 0; i < countries.length; i++) {
        if (countries[i].square > avgSquare) {
            showCountry(countries[i]);
        }
    }
}
    public static Country[] biggerCreateArr(Country[]countries, double avgSquare) {
        int kol = 0;
        for ( int i = 0; i < countries.length; i++) {
            if(countries[i].square>avgSquare){
                kol++;
            }
        }
        if(kol!=0){
            Country [] bigCountry = new Country[kol];
            int n =-1;
            for ( int i = 0; i < countries.length; i++) {
                if(countries[i].square>avgSquare){
                    bigCountry[++n] = countries[i];
                }
            }
            return bigCountry;
        }
        else{
            return null;
        }
    }
    public static Country findForName(Country[] countries, String searchName) {
        int indexSearch = -1;
        for (int i = 0; i < countries.length; i++) {
            if(countries[i].name.equalsIgnoreCase(searchName)){
                indexSearch = i;
            }
        }
        if(indexSearch!=-1){
            return countries[indexSearch];
        }
        else{
            return null;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("count");
        int count = sc.nextInt();
        Country[] countries = setCountry(count);
        showArray(countries);
        int indexMax = nomMax(countries);
        System.out.println("Country " + countries[indexMax].name + " with max square = " + countries[indexMax].square);

        System.out.println("Sort by Square");
        sortSquare(countries);
        showArray(countries);

        System.out.println("Sort by Name");
        sortName(countries);
        showArray(countries);

        double avgSquare = avgSquare(countries);
        System.out.println("AvgSquare = " + avgSquare);

        System.out.println("Countries with square > avgSquare");
        biggerPrint(countries, avgSquare);

        System.out.println("Input name");
        String searchName = sc.nextLine();
        Country sfind = findForName(countries, searchName);
        if (sfind != null) {
            showCountry(sfind);
        }
        System.out.println("Not Found");
    }

    private static void biggerPrint(Country[] countries, double avgSquare) {
    }
}
