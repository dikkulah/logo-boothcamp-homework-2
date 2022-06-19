import Model.*;
import Model.Product.IProduct;
import Model.Product.ProductFactory;
import Model.Product.ProductType;
import Service.CustomerImp;
import Service.CustomerService;
import Service.OrderImp;
import Service.OrderService;

import java.util.*;

public class Main {
    static CustomerService customerService = new CustomerImp();
    static OrderService orderService = new OrderImp();



    public static void main(String[] args)  {
        ProductFactory productFactory =  new ProductFactory();
        IProduct elma = productFactory.ProduceProduct(ProductType.Fruit,"Elma",50.);
        IProduct et2 = productFactory.ProduceProduct(ProductType.Meat,"Tavuk",95.);
        IProduct karpuz = productFactory.ProduceProduct(ProductType.Fruit,"Karpuz",50.);
        IProduct telefon = productFactory.ProduceProduct(ProductType.Electronic,"Telefon", 1000.0);
        IProduct et = productFactory.ProduceProduct(ProductType.Meat,"Dana Kıyma", 150.0);

        Customer ufuk = new Customer("Ufuk", "Dikkülah", "Yazılım");
        Customer ahmet = new Customer("Ahmet", "Yılmaz", "Yazılım");
        Customer tugce = new Customer("Tuğçe", "Eren", "Turizm");
        Customer zeynep = new Customer("Zeynep", "Kıran", "Turizm");
        Customer ceyhun = new Customer("Ceyhun", "Melek", "Emlak");
        List<IProduct> productList = new ArrayList<>(5);
        List<IProduct> productList1 = new ArrayList<>(5);
        List<IProduct> productList3 = new ArrayList<>(5);
        List<IProduct> productList2 = new ArrayList<>(5);

        productList3.add(karpuz);
        productList3.add(elma);
        productList3.add(et);

        productList2.add(karpuz);
        productList2.add(karpuz);
        productList2.add(et);
        productList2.add(et);
        productList2.add(et);
        productList2.add(et);
        productList2.add(et);

        productList.add(telefon);
        productList.add(telefon);
        productList.add(karpuz);
        productList.add(karpuz);

        productList1.add(telefon);
        productList1.add(telefon);


        customerService.save(ufuk);
        customerService.save(ahmet);
        customerService.save(tugce);
        customerService.save(ceyhun);
        customerService.save(zeynep); // Yeni Müşteri kayıt
        Order order6 = new Order(ceyhun,productList3,new Date());
        Order order1 = new Order(ufuk, productList);
        Order order4 = new Order(ufuk, productList1);
        Order order2 = new Order(tugce, productList3);
        Order order3 = new Order(ceyhun, productList3);
        Order order5 = new Order(tugce,productList2);

        orderService.save(tugce,order5);
        orderService.save(ufuk, order4);
        orderService.save(ufuk, order1);
        orderService.save(tugce, order2);
        orderService.save(ceyhun, order3);
        orderService.save(ceyhun,order6);


        System.out.println();
        orderService.printAll();
        System.out.println();
        customerService.printAll(); //Tüm müşterileri listeleme
        System.out.println();
        orderService.printOrdersByCustomer(ufuk);
        System.out.println();
        customerService.findByContainsLetter("C"); // C içeren müşterileri listeleme
        System.out.println();
        orderService.findHigherThenX(1500.0); //1500 den büyük faturalar
        System.out.println();
        orderService.findAverageHigherThenX(1500.0); // 1500 den büyük faturaların ortalamas
        System.out.println();
        orderService.findLowerThenX(500.0); // 500 den küçük faturalar
        System.out.println();
        customerService.getSectorFromFiltered(750.0,"Jun");
        System.out.println();

    }
}