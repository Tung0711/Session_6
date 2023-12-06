package RA.bussiness;

import RA.entity.Categories;
import RA.entity.Product;

import java.util.Scanner;

import static RA.ShopManagement.*;

public class CatalogBussiness {
    public void inputListCategories(Scanner scanner, Categories[] arrCategories, int indexCatalog) {
        System.out.println("Nhập vào số lượng danh mục cần nhập thông tin:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrCategories[index.indexCatalog] = new Categories();
            arrCategories[index.indexCatalog].inputDataCatalog(scanner, arrCategories, index.indexCatalog);
            index.indexCatalog++;
        }
    }

    public void displayListCategories(Categories[] arrCategories) {
        System.out.println("THÔNG TIN CÁC DANH MỤC:");
        for (int i = 0; i < index.indexCatalog; i++) {
            arrCategories[i].displayDataCatalog();
        }
    }

    public void updateCategories(Scanner scanner, Categories[] arrCategories) {
        System.out.println("Nhập mã danh mục cần cập nhật:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexById(catalogId, arrCategories);
        if (indexUpdate >= 0) {
            //Tồn tại
            arrCategories[indexUpdate].updateCatalog(scanner, arrCategories, index.indexCatalog, indexUpdate);
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public void deleteCatalog(Scanner scanner, Product[] arrProduct, Categories[] arrCategories) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogIdDelete = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexById(catalogIdDelete, arrCategories);
        if (indexDelete >= 0) {
            boolean hasProduct = false;
            for (int i = 0; i < index.indexProduct; i++) {
                if (arrProduct[i].getCatalogId() == catalogIdDelete) {
                    hasProduct = true;
                    break;
                }
            }
            if (!hasProduct) {
                for (int i = indexDelete; i < index.indexCatalog; i++) {
                    arrCategories[i] = arrCategories[i + 1];
                }
                arrCategories[index.indexCatalog - 1] = null;
                index.indexCatalog--;
            } else {
                System.err.println("Danh mục đã chứa sản phẩm, không thể xóa!");
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public int getIndexById(int catalogId, Categories[] arrCategories) {
        for (int i = 0; i < index.indexCatalog; i++) {
            if (arrCategories[i].getCatalogId() == catalogId) {
                return i;
            }
        }
        return -1;
    }

    public void updateCatalogStatus(Scanner scanner, Categories[] arrCategories) {
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdateStatus = getIndexById(catalogId, arrCategories);
        if (indexUpdateStatus >= 0) {
            arrCategories[indexUpdateStatus].setCatalogStatus(!arrCategories[indexUpdateStatus].isCatalogStatus());
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}

