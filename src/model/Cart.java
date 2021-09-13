public class Cart extends Common {
    private Product product;
    private int quantity;

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Cart(String id, String name, Product product, int quantity) {
        super(id, name);
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long realMoney() {
        return product.getPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return "- Mã đơn hàng : " + getId() + "\n- Tên đơn hàng : Sản phẩm " + product.getName() +
                "\n- Mã sản phẩm : " + product.getId() + "\n- Giá sản phẩm : " + product.getPrice() + " VNĐ" +
                "\n- Số lượng : " + getQuantity() + "\n- Thành tiền : " + realMoney();
    }
}
