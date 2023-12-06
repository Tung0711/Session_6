package RA.bussiness;

import RA.entity.Categories;
import RA.entity.Product;

import java.util.Objects;

import static RA.ShopManagement.*;

import java.util.Scanner;

public class ProductBussiness {
    public void inputListProduct(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        System.out.println("Nhập vào số lượng sản phẩm cần nhập thông tin:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrProduct[index.indexProduct] = new Product();
            arrProduct[index.indexProduct].inputDataProduct(scanner, arrProduct, index.indexProduct, arrCategories, index.indexCatalog);
            index.indexProduct++;
        }
    }

    public void displayListProduct(Product[] arrProduct) {
        System.out.println("THÔNG TIN CÁC SẢN PHẨM:");
        for (int i = 0; i < index.indexProduct; i++) {
            arrProduct[i].displayDataProduct();
        }
    }

    public void sortListProduct(Product[] arrProduct) {
        Product temp;
        System.out.println("Sắp xếp các sản phẩm theo giá:");
        for (int i = 0; i < index.indexProduct - 1; i++) {
            for (int j = i + 1; j < index.indexProduct; j++) {
                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }

    public void updateProduct(Scanner scanner, Product[] arrProduct) {
        System.out.println("Nhập mã sản phẩm cần cập nhật:");
        String productId = scanner.nextLine();
        int indexUpdate = getIndexById(productId, arrProduct);
        if (indexUpdate >= 0) {
            //Tồn tại
            arrProduct[indexUpdate].updateProduct(scanner, arrProduct, index.indexProduct, indexUpdate);
        } else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }

    public int getIndexById(String productId, Product[] arrProduct) {
        for (int i = 0; i < index.indexProduct; i++) {
            if (arrProduct[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteProduct(Scanner scanner, Product[] arrProduct) {
        System.out.println("Nhập vào mã sản phẩm cần xóa:");
        String productIdDelete = scanner.nextLine();
        int indexDelete = getIndexById(productIdDelete, arrProduct);
        if (indexDelete >= 0) {
            for (int i = indexDelete; i < index.indexProduct; i++) {
                arrProduct[i] = arrProduct[i + 1];
            }
            arrProduct[index.indexProduct - 1] = null;
            index.indexProduct--;
        } else {
            System.err.println("Mã sản phẩm không tồn tại!");
        }
    }

    public void findForProductByName(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập sản phẩm bạn muốn tìm theo tên: ");
        String nameProductLookFor = scanner.nextLine();
        System.out.println("Sản phẩm theo tên bạn tìm:");
        boolean checkLookForProduct = false;
        for (int i = 0; i < index.indexProduct; i++) {
            if (arrProduct[i].getProductName().contains(nameProductLookFor)) {
                checkLookForProduct = true;
                arrProduct[i].displayDataProduct();
            }
        }
        if (!checkLookForProduct) {
            System.out.print("Không có sản phẩm theo tên bạn cần tìm!");
        }
    }

    public void findForProductByMoney(Scanner scanner, Product[] arrProduct) {
        System.out.println("Nhập khoảng giá tiền (a - b) để tìm kiếm sản phẩm: ");
        System.out.print("Giá tiền a:");
        float money1 = Float.parseFloat(scanner.nextLine());
        System.out.print("Giá tiền b:");
        float money2 = Float.parseFloat(scanner.nextLine());
        boolean checkLookForProduct = false;
        for (int i = 0; i < index.indexProduct; i++) {
            if (arrProduct[i].getPrice() >= money1 && arrProduct[i].getPrice() <= money2) {
                checkLookForProduct = true;
                arrProduct[i].displayDataProduct();
            }
        }
        if (!checkLookForProduct) {
            System.out.print("Không có sản phẩm theo giá tiền bạn cần tìm!");
        }
    }
}
