package management;

import products.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<Brand> brands;
    private ArrayList<Product> products;

    public Store() {
        this.brands = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addBrand(Brand brand) {
        if (brand == null) {
            System.out.println("Invalid brand object");
            return;
        }
        for (Brand b : brands) {
            if (brand.getId() == b.getId()) {
                System.out.println("Brand already exits int the system");
                return;
            }
        }
        this.brands.add(brand);
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Invalid product object");
            return;
        }
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                System.out.println("Product already exits int the system");
                return;
            }
        }
        this.products.add(product);
        System.out.println("Product added successfully");
    }


    public void removeProduct(int id) {
        Product productToRemove = null;
        for (Product p : products) {
            if (p.getId() == id) {
                productToRemove = p;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product not found in the system");
        }
    }
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found in the system");
            return;
        }
        String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s | %-15s |\n";
        System.out.format(format, "ID", "Name", "Price", "Discount", "Stock", "Brand", "Type");
        for (Product p : products) {
            System.out.format(format, p.getId(), p.getName(), p.getPrice() + " TL", p.getDiscountRate(), p.getStock(),
                    p.getBrand().getName(), p.getClass().getSimpleName());
        }
    }


    public void displayMenu() {
        System.out.println("#######################################");
        System.out.println("PatikaStore Product Management Panel!");
        System.out.println("1 - Notebook Operations");
        System.out.println("2 - Smartphone Operations");
        System.out.println("3 - List all brands");
        System.out.println("4 - List all products");
        System.out.println("5 - Filter products by brandName");
        System.out.println("0 - Exit");
        System.out.println("#######################################");
        System.out.print("Enter your choice : ");
    }

    public void listNotebook() {
        String format = "| %-5s | %-20s | %-15s | %-8s | %-8s | %-15s | %-8s | %-8s | %-15s |\n";
        System.out.format(format, "ID", "Name", "Price", "Discount", "Stock", "Brand", "RAM", "Storage", "Screen Size");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for (Product p : products) {
            if (p instanceof Notebook n) {
                System.out.format(format, n.getId(), n.getName(), n.getPrice() + " TL", n.getDiscountRate(), n.getStock(),
                        n.getBrand().getName(), n.getRam(), n.getMemory(), n.getScreenSize());
            }

        }
    }

    public void listSmartphones() {
        String format = "| %-5s | %-20s | %-15s | %-8s | %-8s | %-15s | %-8s | %-8s | %-8s | %-8s | %-8s |\n";
        System.out.format(format, "ID", "Name", "Price", "Discount", "Stock", "Brand", "Memory", "Screen Size",
                "Battery", "RAM", "Color");
        for (Product p : products) {
            if (p instanceof Smartphone s) {
                System.out.format(format, s.getId(), s.getName(), s.getPrice() + " TL", s.getDiscountRate(), s.getStock(),
                        s.getBrand().getName(), s.getMemory(), s.getScreenSize(), s.getBattery(), s.getRam(),
                        s.getColor());
            }
        }
    }

    public void filterProducts(String brandName) {
        if (brandName == null || brandName.trim().isEmpty()) {
            System.out.println("Invalid brand name");
            return;
        }
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getBrand().getName().equalsIgnoreCase(brandName)) {
                filteredProducts.add(p);
            }
        }
        if (filteredProducts.isEmpty()) {
            System.out.println("No products found with the given brand name");
            return;
        }
        String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s | %-15s |\n";
        System.out.format(format, "ID", "Name", "Price", "Discount", "Stock", "Brand", "Type");
        for (Product p : filteredProducts) {
            System.out.format(format, p.getId(), p.getName(), p.getPrice() + " TL", p.getDiscountRate(), p.getStock(),
                    p.getBrand().getName(), p.getClass().getSimpleName());
        }
    }

    public void listBrands() {
        if (brands.isEmpty()) {
            System.out.println("No brands found in the system");
            return;
        }
        brands.sort((b1, b2) -> b1.getName().compareTo(b2.getName()));
        String format = "| %-5s | %-15s |\n";
        System.out.format(format, "ID", "Name");
        for (Brand b : brands) {
            System.out.format(format, b.getId(), b.getName());
        }
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<Brand> brands) {
        this.brands = brands;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
