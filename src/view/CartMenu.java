import java.util.Scanner;

public class CartMenu {
    public static Scanner scanner=new Scanner(System.in);
    public BillandCart billandCart=new BillandCart();
    public void run(){
        int choice;
        do {
            menu();
            System.out.println("nhập lựa chọn");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{

                }
                case 2:{
//                    billandCart.createCart();
                }

            }
        }while(choice!=0);
    }
    private void menu(){
        System.out.println("Quản lí giỏ hàng");
        System.out.println("hiển thị danh sách mặt hàng");
        System.out.println("Thêm mặt hàng");
        System.out.println("Xóa mặt hàng");
    }
}
