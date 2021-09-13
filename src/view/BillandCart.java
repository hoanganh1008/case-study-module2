import java.util.List;
import java.util.Scanner;

public class BillandCart {
    public static Scanner scanner=new Scanner(System.in);
    public static BillManagement billManagement=new BillManagement();
    public static CartManagement cartManagement=new CartManagement();
    public static ProductManagement productManagement=new ProductManagement();
    public void runBillandCart(){

    }
    public Cart createCart(){
        System.out.println("nhập mã sản phẩm");
        String productID=scanner.nextLine();
        int index= productManagement.findById(productID);
        List<Cart> carts=cartManagement.getCarts();
        String id="0"+(carts.size()+1);
        String name=carts.get(index).getName();
        Product product=productManagement.getProductList().get(index);
        int quantity= inputQuantity();
        return new Cart(id,name,product,quantity);
    }
    private int inputQuantity(){
        int quantity=-1;
        try{
            System.out.println("nhập vào số lượng sản phẩm");
            String inputQuantity=scanner.nextLine();
            quantity=Integer.parseInt(inputQuantity);
        }catch (NumberFormatException e){
            System.out.println("phải nhập dạng số");
        }
        return quantity;
    }
}
