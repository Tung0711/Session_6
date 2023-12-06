package RA.presentation;

import RA.bussiness.CatalogBussiness;
import RA.entity.Categories;
import RA.entity.Product;

import static RA.ShopManagement.*;

import java.util.Scanner;

public class categoriesMenu {
    CatalogBussiness catalog = new CatalogBussiness();
    public void displayMenuCategories(Scanner scanner, Categories[] arrCategories, Product[] arrProduct, int indexCatalog) {
        boolean isExit = true;
        do {
            System.out.println("********** CATEGORIES MENU **********");
            System.out.println("1. Nhập thông tin các danh mục.");
            System.out.println("2. Hiển thị thông tin các danh mục.");
            System.out.println("3. Cập nhật thông tin danh mục.");
            System.out.println("4. Xóa danh mục.");
            System.out.println("5. Cập nhật trạng thái danh mục.");
            System.out.println("6. Thoát.");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    catalog.inputListCategories(scanner, arrCategories, index.indexCatalog);
                    break;
                case 2:
                    catalog.displayListCategories(arrCategories);
                    break;
                case 3:
                    catalog.updateCategories(scanner, arrCategories);
                    break;
                case 4:
                    catalog.deleteCatalog(scanner, arrProduct, arrCategories);
                    break;
                case 5:
                    catalog.updateCatalogStatus(scanner, arrCategories);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Lựa chọn không phù hợp. Vui lòng nhập lại!");
            }
        } while (isExit);
    }
}
