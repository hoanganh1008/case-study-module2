import java.util.Scanner;

public class ProductMenu {
    public static Scanner scanner=new Scanner(System.in);
    private ProductManagement productManagement=new ProductManagement();
    public void run(){
        int choice;
        do{
            menu();
            System.out.println("nhập lựa chọn");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                {
                    productManagement.showAll();
                    break;
                }
                case 2:{
                    addNewProduct();
                    break;
                }
                case 3:{
                    editProduct();
                    break;
                }
                case 5:{
                    sortProduct();
                    break;
                }
                case 6:
                {
                    menuFindProduct();
                    findProductWithPrice();
                }
                default:
                {
                    System.out.println("Mời nhập lại");
                }
            }
        }while(choice!=0);
    }

    private void editProduct(){
        Product product=initProduct();
        System.out.println("nhập mã sản phẩm");
        String id=scanner.nextLine();
        productManagement.updateById(id,product);
    }
    private void addNewProduct() {
        Product product=initProduct();
        productManagement.addNew(product);
    }

    private Product initProduct() {
        System.out.println("nhập mã sản phẩm");
        String id=scanner.nextLine();
        System.out.println("nhập tên sản phẩm");
        String name=scanner.nextLine();
        System.out.println("nhập mô tả");
        String description= scanner.nextLine();
        System.out.println("nhập giá");
        int price= scanner.nextInt();
        scanner.nextLine();
        System.out.println("nhập danh mục");
        String category= scanner.nextLine();
        return new Product(id,name,description,price,category);
    }

    public static void menu(){
        System.out.println("QUẢN LÍ SẢN PHẨM");
        System.out.println("1.Hiển thị danh sách sản phẩm");
        System.out.println("2.Thêm sản phẩm mới");
        System.out.println("3. Chỉnh sửa thông tin sản phẩm");
        System.out.println("4.Xóa sản phẩm");
        System.out.println("5.Sắp xếp sản phẩm");
        System.out.println("6. Tìm kiếm sản phẩm theo giá");
        System.out.println("0. Quay lại");
    }
    private void sortProduct() {
        int choice = -1;
        do {
            menuSort();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    productManagement.sortSmallToBig();
                    break;
                }
                case 2: {
                    productManagement.sortBigToSmall();
                    break;
                }
                case 3: {
                    productManagement.sortNameAToZ();
                    break;
                }
                case 4: {
                    productManagement.sortNameZToA();
                    break;
                }

                case 0: {
                    break;
                }
                default: {
                    System.out.println("SỐ BẠN NHẬP KHÔNG ĐÚNG VỚI MEMU MỜI NHẬP LẠI");
                    choice = -1;
                    break;
                }
            };
        } while (choice == -1);
        productManagement.showAll();
    }

    private void menuSort() {
        System.out.println("SẮP XẾP SẢN PHẨM");
        System.out.println("1. Sắp xếp theo giá bé -> lớn ");
        System.out.println("2. Sắp xếp theo giá lớn -> bé ");
        System.out.println("3. Sắp xếp theo tên A -> Z ");
        System.out.println("4. Sắp xếp theo tên Z - A");

        System.out.println("0. Quay lại");
    }
    private void findProductWithPrice() {
        int choice;
        do {
            menuFindProduct();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    productManagement.sortBigToSmall();
                    System.out.println("SẢN PHẨM ĐẮT NHẤT");
                    System.out.println(productManagement.getProductList().get(0));
                    break;
                }
                case 2: {
                    productManagement.sortSmallToBig();
                    System.out.println("SẢN PHẨM RẺ NHẤT");
                    System.out.println(productManagement.getProductList().get(0));
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("SỐ NHẬP VÀO KHÔNG HỢP LỆ MỜI NHẬP LẠI");
                }
            }
        } while (choice != 0);
    }

    private void menuFindProduct() {
        System.out.println("TÌM SẢN PHẨM THEO GIÁ");
        System.out.println("1. Sản phẩm có giá đắt nhất");
        System.out.println("2. Sản phẩm có giá rẻ nhất");
        System.out.println("0. Thoát");
    }
    }