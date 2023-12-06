package RA.presentation;

import RA.bussiness.ProductBussiness;
import RA.entity.Product;
import RA.entity.Categories;

import static RA.ShopManagement.*;

import java.util.Scanner;

public class productMenu {
    ProductBussiness pro = new ProductBussiness();

    public void displayMenuProduct(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        boolean isExit = true;
        do {
            System.out.println("********** PRODUCT MANAGEMENT **********");
            System.out.println("1. Nhập thông tin các sản phẩm.");
            System.out.println("2. Hiển thị thông tin các sản phẩm.");
            System.out.println("3. Sắp xếp các sản phẩm theo giá.");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm.");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm.");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm.");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a - b");
            System.out.println("8. Thoát.");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    pro.inputListProduct(scanner, arrProduct, index.indexProduct, arrCategories, index.indexCatalog);
                    break;
                case 2:
                    pro.displayListProduct(arrProduct);
                    break;
                case 3:
                    pro.sortListProduct(arrProduct);
                    break;
                case 4:
                    pro.updateProduct(scanner, arrProduct);
                    break;
                case 5:
                    pro.deleteProduct(scanner, arrProduct);
                    break;
                case 6:
                    pro.findForProductByName(scanner, arrProduct);
                    break;
                case 7:
                    pro.findForProductByMoney(scanner, arrProduct);
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.err.println("Lựa chọn không phù hợp. Vui lòng nhập lại!");
            }
        } while (isExit);
    }
}
