package RA;

import RA.entity.Categories;
import RA.entity.Product;
import RA.presentation.categoriesMenu;
import RA.presentation.productMenu;

import java.util.Scanner;

public class ShopManagement {
    public static class index {
        //Khai bao chi so index
        public static int indexCatalog = 0;
        public static int indexProduct = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Khai báo mảng
        Categories[] arrCategories = new Categories[100];
        Product[] arrProduct = new Product[100];
        //Khoi tao doi tuong
        categoriesMenu catalogMenu = new categoriesMenu();
        productMenu productMenu = new productMenu();
        //Hien thi menu
        do {
            System.out.println("************ SHOP MENU ************");
            System.out.println("1. Quản lý danh mục sản phẩm.");
            System.out.println("2. Quản lý sản phẩm.");
            System.out.println("3.Thoát.");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    catalogMenu.displayMenuCategories(scanner, arrCategories, arrProduct, index.indexCatalog);
                    break;
                case 2:
                    productMenu.displayMenuProduct(scanner, arrProduct, index.indexProduct, arrCategories, index.indexCatalog);
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc. Xin tạm biệt!");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp. Vui lòng nhập lại!");
            }
        } while (true);
    }
}
