package service;

import entities.Product;

import java.util.Arrays;
import java.util.Scanner;

public class ProductManagement {
    Scanner scanner = new Scanner(System.in);
    Product iPhone = new Product(Product.getNextID(), "Iphone", "Original", 100, 36000, "chiếc");
    Product iPad = new Product(Product.getNextID(), "Ipad", "Original", 4, 86000, "chiếc");
    Product products[] = {iPhone, iPad};

    public void showProducts() {
        System.out.println("---- Danh sách sản phẩm ----");
        System.out.println(Arrays.toString(products));
    }

    public void findProductByName(String name) {
        System.out.println("---- Kết quả tìm kiếm theo tên ----");
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                displayProductDetails(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào có tên \"" + name + "\".");
        }
    }


    public void findProductById(int id) {
        System.out.println("---- Kết quả tìm kiếm theo id ----");
        boolean found = false;
        for (Product product : products) {
            if (product.getId() == id) {
                displayProductDetails(product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào có id \"" + id + "\".");
        }
    }

    public void findProductsBelowQuantity(int quantityThreshold) {
        System.out.println("---- Kết quả tìm kiếm theo số lượng dưới " + quantityThreshold + " ----");
        boolean found = false;
        for (Product product : products) {
            if (product.getQuantity() < quantityThreshold) {
                displayProductDetails(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào có số lượng dưới " + quantityThreshold + ".");
        }
    }

    public void searchProductByPriceRange() {
        System.out.println("---- Tìm kiếm sản phẩm theo mức giá ----");
        System.out.println("1 - Dưới 50.000");
        System.out.println("2 - Từ 50.000 đến dưới 100.000");
        System.out.println("3 - Từ 100.000 trở lên");
        System.out.print("Nhập lựa chọn của bạn: ");
        int priceChoice = scanner.nextInt();
        scanner.nextLine();
        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;

        switch (priceChoice) {
            case 1:
                maxPrice = 50000;
                break;
            case 2:
                minPrice = 50000;
                maxPrice = 100000;
                break;
            case 3:
                minPrice = 100000;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }

        System.out.println("---- Kết quả tìm kiếm theo mức giá ----");
        boolean found = false;
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() < maxPrice) {
                displayProductDetails(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào trong mức giá đã chọn.");
        }
    }

    public void displayProductDetails(Product product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Tên sản phẩm: " + product.getName());
        System.out.println("Mô tả: " + product.getDescription());
        System.out.println("Số lượng: " + product.getQuantity());
        System.out.println("Giá bán: " + product.getPrice());
        System.out.println("Đơn vị tính: " + product.getUnit());
        System.out.println("---------------------------");
    }

}

