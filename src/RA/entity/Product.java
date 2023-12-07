package RA.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Lớp Product chứa các thông tin về các sản phẩm
public class Product {
    //Thuộc tính của sản phẩm
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    //Khởi tạo các constructor
    public Product() {
    }

    public Product(String productId, String productName, float price, String description,
                   Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    //Cac phương thuc getter/setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputDataProduct(Scanner scanner, Product[] arrProduct, int indexProduct,
                                 Categories[] arrCategories, int indexCatalog) {
        //Nhập dữ liệu của product
        this.productId = inputProductId(scanner, arrProduct, indexProduct);
        this.productName = inputProductName(scanner, arrProduct, indexProduct);
        this.price = inputPrice(scanner);
        this.description = inputDescription(scanner);
        this.created = inputCreated(scanner);
        this.catalogId = inputCatalogId(scanner, arrCategories, indexCatalog);
        this.productStatus = inputProductStatus(scanner);

    }

    public void displayDataProduct() {
        //Hiển thị dữ liệu Product
        System.out.printf("\nMã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %.2f - Mô tả sản phẩm: %s\n",
                this.productId, this.productName, this.price, this.description);
        System.out.printf("Ngày nhập: %s - Mã danh mục của sản phẩm: %d - trạng thái sản phẩm: %s\n", this.created, this.catalogId,
                (this.productStatus == 0) ? "Đang bán" : (this.productStatus == 1) ? "Hết hàng" : "Không bán");
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct, int indexProduct) {
        //Nhập mã sản phẩm
        System.out.println("Nhập mã sản phẩm: ");
        do {
            String productId = scanner.nextLine();
            if (productId.length() == 4) {
                if (productId.charAt(0) == 'A' || productId.charAt(0) == 'C' || productId.charAt(0) == 'S') {
                    boolean isExit = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProduct[i].getProductId().equals(productId)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (isExit) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại!");
                    } else {
                        return productId;
                    }
                } else {
                    System.err.println("Mã sản phẩm bắt đầu là A,C,S, Vui lòng nhập lại!");
                }
            } else {
                System.err.println("Mã sản phẩm gồm 4 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct, int indexProduct) {
        //Nhập tên sản phẩm
        System.out.println("Nhập tên sản phẩm: ");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại!");
                } else {
                    return productName;
                }
            } else {
                System.err.println("Tên sản phẩm có độ dài từ 10 đến 50 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập giá sản phẩm: ");
        do {
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá sản phẩm phải có giá trị lớn hơn 0, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm: ");
        return scanner.nextLine();
    }

    public Date inputCreated(Scanner scanner) {
        System.out.println("Nhập vào ngày tạo của sản phẩm: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                Date created = sdf.parse(scanner.nextLine());
                return created;
            } catch (Exception e) {
                System.err.println("Ngày tháng nhập vào không đúng định dạng, vui lòng nhập lại!");
            }
        } while (true);
    }

    public int inputCatalogId(Scanner scanner, Categories[] arrCategories, int indexCatalog) {
        System.out.println("chọn danh mục của sản phẩm: ");
        for (int i = 0; i < indexCatalog; i++) {
            System.out.printf("%d.%s\n", i + 1, arrCategories[i].getCatalogName());
        }
        System.out.println("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        return arrCategories[choice - 1].getCatalogId();
    }

    public int inputProductStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái sản phẩm: ");
        do {
            int status = Integer.parseInt(scanner.nextLine());
            if (status >= 0 || status <= 2) {
                return status;
            } else {
                System.err.println("Trạng thái sản phẩm chỉ nhận giá trị 0,1,2. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public void updateProduct(Scanner scanner, Product[] arrProduct, int indexProduct, int indexUpdate) {
        //Cập nhật danh mục
        boolean isExit = true;
        do {
            System.out.println("1. Cập nhật tên sản phẩm: ");
            System.out.println("2. Cập nhật mô tả sản phẩm: ");
            System.out.println("3. Cập nhật trạng thái sản phẩm: ");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    this.productName = inputProductName(scanner, arrProduct, indexProduct);
                    break;
                case 2:
                    this.description = inputDescription(scanner);
                    break;
                case 3:
                    this.productStatus = inputProductStatus(scanner);
                    break;
                default:
                    isExit = false;
            }
        } while (isExit);
    }
}
