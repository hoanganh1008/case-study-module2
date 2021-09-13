import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement implements IGeneralManagement<Product> {
    private List<Product> productList=new ArrayList<>();

    public ProductManagement(){
        productList.add(new Product("1","cá","ngon",20000,"cá"));
        productList.add(new Product("2","thịt","tươi",300000,"thịt"));
        productList.add(new Product("3","Trửng","gà",5000,"Trứng"));
        productList.add(new Product("4","gà","thịt",10000,"thịt"));
    }
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void showAll() {
        for(Product product:productList)
        {
            System.out.println(product);
        }
    }

    @Override
    public void addNew(Product product) {
        productList.add(product);
    }

    @Override
    public void updateById(String id, Product product) {
        int index = findById(id);
        if (index != -1) {
            productList.set(index, product);
        } else {
            System.out.println("Không tồn tại mã sản phẩm này!");
        }
    }
    @Override
    public void removeById(String id) {
        int index = findById(id);
        if (index != -1) {
            productList.remove(index);
        } else {
            System.out.println("Không tồn tại mã sản phẩm này!");
        }
    }

    @Override
    public int findById(String id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public List<Product> readFile(String path) {
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            productList = (List<Product>) ois.readObject();
            ois.close();
            is.close();
        } catch (EOFException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void writeFile(String path) {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(productList);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortBigToSmall() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getPrice() > productList.get(position - 1).getPrice())) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }
    public void sortSmallToBig() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getPrice() < productList.get(position - 1).getPrice())) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }
    public void sortNameZToA() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getName().compareTo(productList.get(position - 1).getName()) > 0)) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }
    public void sortNameAToZ() {
        Product product;
        int position;
        for (int i = 1; i < productList.size(); i++) {
            product = productList.get(i);
            position = i;
            while (position > 0 && (product.getName().compareTo(productList.get(position - 1).getName()) < 0)) {
                productList.set(position, productList.get(position - 1));
                position--;
            }
            productList.set(position, product);
        }
    }

}
