package service;

import model.Category;
import model.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> list = new ArrayList<>();
    public ArrayList<Category> categories = new ArrayList<>();


    public ProductService(){
        categories.add(new Category("Dien Thoai"));
        categories.add(new Category("Tivi"));
        list.add(new Product(1, "Iphone 13", "1000", categories.get(0).getTen()));
        list.add(new Product(2, "tivi SamSung", "900", categories.get(1).getTen()));

    }

    public void save(Product product){
        list.add(product);
    }
    public void edit(int index, Product product){
        list.set(index,product);
    }
    public void delete(int index){
        list.remove(index);
    }
}
