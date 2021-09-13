import java.util.ArrayList;
import java.util.List;

public class BillManagement implements ICommonManagement<Bill> {
    List<Bill> bills=new ArrayList<>();

    public BillManagement(){

    }
    public BillManagement(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }


    @Override
    public void addNew(Bill bill) {
        bills.add(bill);
    }

    @Override
    public void delete(int index) {
        bills.remove(index);
    }

    @Override
    public void displayAll() {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    @Override
    public void update(int index, Bill bill) {
        bills.set(index, bill);
    }

    @Override
    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < bills.size(); i++) {
            if (id.equals(bills.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
