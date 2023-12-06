package RA.entity;

import java.util.Scanner;

import static RA.ShopManagement.*;

//Lớp Categories chứa các thông tin về danh mục
public class Categories {
    //Thuộc tinh của danh mục
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    //Khoi tao constructor ko tham so
    public Categories() {
    }

    //Khoi tao constructor co tham so
    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    //Cac phuong thuc getter/setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputDataCatalog(Scanner scanner, Categories[] arrCategories, int indexCatalog) {
        //Phương thức nhập dữ liệu của categories
        this.catalogId = generateIdentityValue(arrCategories, indexCatalog);
        this.catalogName = inputCatalogName(scanner, arrCategories, indexCatalog, -1);
        this.descriptions = inputDescription(scanner);
        this.catalogStatus = inputCatalogStatus(scanner);
    }

    public void displayDataCatalog() {
        //Phương thức hiển thị dữ liệu
        System.out.printf("\nMã danh mục: %d - Tên danh mục: %s\n", this.catalogId, this.catalogName);
        System.out.printf("Mô tả danh mục: %s - Trạng thái danh mục: %s\n", this.descriptions,
                this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }

    public int generateIdentityValue(Categories[] arrCategories, int indexCatalog) {
        //Ma danh muc tu dong tang
        if (indexCatalog == 0) {
            return 1;
        } else {
            int max = arrCategories[0].getCatalogId();
            for (int i = 1; i < indexCatalog; i++) {
                if (max < arrCategories[i].getCatalogId()) {
                    max = arrCategories[i].getCatalogId();
                }
            }
            return max + 1;
        }
    }

    public String inputCatalogName(Scanner scanner, Categories[] arrCategories, int indexCatalog, int indexUpdate) {
        //nhap vao ten danh muc
        System.out.println("Nhập vào tên danh mục: ");
        do {
            String catalogName = scanner.nextLine();
            //kt do dai < 50
            if (catalogName.length() < 50) {
                //kt trung lap
                boolean isExist = false;
                for (int i = 0; i < indexCatalog; i++) {
                    if (arrCategories[i].getCatalogName().equals(catalogName) && i != indexUpdate) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, Vui lòng nhập lại!");
                } else {
                    return catalogName;
                }
            } else {
                System.err.println("Tên danh mục có độ dài tối đa 50 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        //Nhập mô tả danh mục
        System.out.println("Nhập mô tả danh mục: ");
        return scanner.nextLine();
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        //Nhập trạng thái danh mục
        System.out.println("Nhập trạng thái danh mục: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void updateCatalog(Scanner scanner, Categories[] arrCategories, int indexCatalog, int indexUpdate) {
        //Cập nhật danh mục
        boolean isExit = true;
        do {
            System.out.println("1. Cập nhật tên danh mục: ");
            System.out.println("2. Cập nhật mô tả danh mục: ");
            System.out.println("3. Cập nhật trạng thái danh mục: ");
            System.out.println("4. Thoát.");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    this.catalogName = inputCatalogName(scanner, arrCategories, indexCatalog, indexUpdate);
                    break;
                case 2:
                    this.descriptions = inputDescription(scanner);
                    break;
                case 3:
                    this.catalogStatus = inputCatalogStatus(scanner);
                    break;
                default:
                    isExit = false;
            }
        } while (isExit);
    }
}
