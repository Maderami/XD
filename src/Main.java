import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int c = 0;
    public static List<EntityDocument> list;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        List<String> listChoose = new ArrayList<>();

        listChoose.add("Посмотреть спсиок документов");
        listChoose.add("Подсчет количества согласованных докуентов");
        listChoose.add("Подсчет общего количества документов");
        System.out.println("Выбирите действия над документами:");


        {
            for (int i = 0; i < listChoose.size(); i++) {
                System.out.println(String.format(i+1+" "+listChoose.get(i)));
            }

            c = in.nextInt();
            OperationDoc operationDoc = new OperationDoc();
            switch (c) {

                case 1:
                    StreamDataFromFile streamDataFromFile = new StreamDataFromFile();
                    list = streamDataFromFile.description();
                    System.out.println(list);
                    streamDataFromFile.getStatistics(list);
                    break;
                case 2:
                    operationDoc.getCountApprove();
                    break;
                case 3:
                    operationDoc.getCountDeflect();
                    break;

            }
        }while ( c != 0);
        //StreamAPI
        //double averageCostOfProducts = shop.getProducts().stream()
        //        .filter(p -> p.getPrice() > 40)
        //        .collect(averagingDouble(Product::getPrice));
        //double averageCostOfBuyedProducts = shop.getPurchases().stream().collect(averagingDouble(Buy::getFinalPrice));

        //System.out.println("\n Средняя стоимость продуктов: " + averageCostOfProducts);
        //System.out.println("\n Средняя стоимость купленных продуктов: " + averageCostOfBuyedProducts);
        //customers.stream()
         //       .filter(p -> "Male".equals(p.getSex()))
          //      .forEach(System.out::println);
        //customers.stream()
         //       .map(Customer::getName)
          //      .forEach(System.out::println);
    }
}
