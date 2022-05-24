import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        Branch newBranch = new Branch(branchName);
        if (findBranch(branchName) == null) {
            branches.add(newBranch);
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            for (int i = 0; i < branch.getCustomers().size(); i++) {
                if (branch.getCustomers().get(i).getName().equals(customerName)) {
                    return false;
                }
            }
            branch.newCustomer(customerName, transaction);
            return true;
        } else if (findBranch(branchName) == null) {
            Branch newBranch = new Branch(branchName);
            newBranch.newCustomer(customerName,transaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            for (int i = 0; i < branch.getCustomers().size(); i++) {
                if (branch.getCustomers().get(i).getName().equals(customerName)) {
                    branch.getCustomers().get(i).addTransaction(transaction);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branchName);
            int customerNumber = 1;
            for (int i = 0; i < branch.getCustomers().size(); i++) {
                System.out.println("Customer: " + branch.getCustomers().get(i).getName() + "[" + customerNumber + "]");
                if (transaction) {
                    int transactionNumber = 1;
                    System.out.println("Transactions");
                    for (int j = 0; j < branch.getCustomers().get(i).getTransactions().size(); j++) {
                        System.out.println("[" + transactionNumber + "]  Amount " + branch.getCustomers().get(i).getTransactions().get(j));
                        transactionNumber++;
                    }
                }
                customerNumber++;
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

}
