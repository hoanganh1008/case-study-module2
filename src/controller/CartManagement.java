import java.util.ArrayList;
import java.util.List;

public class CartManagement implements ICommonManagement<Cart>{
    List<Cart> carts=new ArrayList<>();

    public CartManagement(){

    }
    public CartManagement(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    @Override
    public void addNew(Cart cart) {
        carts.add(cart);
    }

    @Override
    public void delete(int index) {
        carts.remove(index);
    }

    @Override
    public void displayAll() {
        if (carts.size() == 0){
            System.out.println("CHƯA CÓ ĐƠN HÀNG NÀO TRONG GIỎ");
        } else {
            System.out.println("GIỎ HÀNG\n" );
            for (Cart cart : carts) {
                System.out.println(cart);
            }
        }
    }

    @Override
    public void update(int index, Cart cart) {
        carts.set(index, cart);
    }

    @Override
    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i< carts.size(); i++) {
            if (id.equals(carts.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }
}

