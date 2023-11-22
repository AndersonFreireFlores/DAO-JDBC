package Application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDao();


        System.out.println("===Test seller by Id ===");
        Seller seller = sellerDAO.findById(8);
        System.out.println(seller);

        System.out.println("===Test seller by department===");
        Department department = new Department(2,null);
        List<Seller> list1 = sellerDAO.findByDepartment(department);
        for (Seller obj :  list1) {
            System.out.println(obj);
        }

        System.out.println("===Test seller find all===");

        List<Seller> list2 = sellerDAO.findAll();
        for (Seller obj :  list2) {
            System.out.println(obj);
        }

        System.out.println("===Test seller insert===");
        Seller seller2 = new Seller(null,"Greg","Greg@gmail.com",new Date(),2000.0,department);
        sellerDAO.insert(seller2);
        System.out.println("Inserted! New ID = "+ seller2.getId());

        System.out.println("===Test seller update===");
        seller = sellerDAO.findById(1);
        seller.setName("Zé");
        sellerDAO.update(seller);

    }
}
