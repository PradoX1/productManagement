import service.ProductManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement service = new ProductManagement();
        while (true) {
            System.out.println("---- Quản lý sản phẩm ----");
            System.out.println("1 - Xem danh sách sản phẩm");
            System.out.println("2 - Tìm sản phẩm theo tên");
            System.out.println("3 - Tìm sản phẩm theo id");
            System.out.println("4 - Tìm các sản phẩm có số lượng dưới 5");
            System.out.println("5 - Tìm sản phẩm theo mức giá");
            System.out.println("0 - Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    service.showProducts();
                    break;
                case 2:
                    System.out.print("Nhập tên sản phẩm: ");
                    String nameToFind = scanner.nextLine();
                    service.findProductByName(nameToFind);
                    break;
                case 3:
                    System.out.print("Nhập id sản phẩm: ");
                    int idToFind = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    service.findProductById(idToFind);
                    break;
                case 4:
                    service.findProductsBelowQuantity(5);
                    break;
                case 5:
                    service.searchProductByPriceRange();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}