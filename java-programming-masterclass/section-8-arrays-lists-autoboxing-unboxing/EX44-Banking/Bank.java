import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branch) {

    }

    public boolean addCustomer(String branch, String customer, double transaction) {

    }

    public boolean addCustomerTransaction(String branch, String customer, double transaction) {

    }


    public boolean listCustomers(String branch, boolean transaction) {

    }

    private Branch findBranch(String branch) {

    }

}
