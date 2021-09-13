import java.time.LocalDate;

public class Bill extends Common {
    private LocalDate dateBillOut;
    private Product product;
    private User user;
    private int quantity;
    private Cart cart;

    public Bill() {

    }

    public Bill(LocalDate dateBillOut, Product product, User user, int quantity, Cart cart) {
        this.dateBillOut = dateBillOut;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.cart = cart;
    }

    public Bill(String id, String name, LocalDate dateBillOut, Product product, User user, int quantity, Cart cart) {
        super(id, name);
        this.dateBillOut = dateBillOut;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.cart = cart;
    }

    public LocalDate getDateBillOut() {
        return dateBillOut;
    }

    public void setDateBillOut(LocalDate dateBillOut) {
        this.dateBillOut = dateBillOut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long realMoney(){
        return product.getPrice()*quantity;
    }

    @Override
    public String toString() {
        return "Thông tin đơn hàng \n -Mã đơn hàng" +getId() +
                "\n Tên đơn hàng:Bán sản phẩm" + getProduct().getName()+"\n Tên sản phẩm" +getProduct().getName()
                +"\n Ngày xuất đơn:" +getDateBillOut()+"\n Thành tiền:"+realMoney();
    }
}
