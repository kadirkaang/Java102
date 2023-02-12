import management.Store;
import products.*;

import java.util.Scanner;

public class StoreBuild {
    private Store store;
    private final Scanner input = new Scanner(System.in);
    private String[] brandsName;
    private int Id;

    public StoreBuild() {
        store = new Store();
        brandsName = new String[]{"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        Id = 1;
    }

    public void run() {
        for (int i = 0; i < brandsName.length; i++) {
            store.addBrand(new Brand(i + 1, brandsName[i]));
        }
        int choice = -1;
        while (choice != 0) {
            store.displayMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1 - Add notebook ");
                    System.out.println("2 - Remove notebook");
                    System.out.println("3 - List all notebook");
                    System.out.print("Enter your choice : ");
                    int notebookChoice = input.nextInt();
                    switch (notebookChoice) {
                        case 1:
                            printBrand();
                            while (true) {
                                System.out.print("Enter your notebook brand ID : ");
                                int brandID = input.nextInt();
                                if (brandID < 1 || brandID > brandsName.length) {
                                    System.out.println("Invalid brand ID, Please try again.");
                                } else {
                                    Brand notebookBrand = new Brand(brandID, brandsName[brandID - 1]);
                                    System.out.print("Enter notebook name : ");
                                    String notebookName = input.nextLine();
                                    notebookName = input.nextLine();
                                    System.out.print("Enter notebook price : ");
                                    double notebookPrice = input.nextDouble();
                                    System.out.print("Enter notebook discount : ");
                                    double discount = input.nextDouble();
                                    System.out.print("Enter notebook stock : ");
                                    int stock = input.nextInt();
                                    System.out.print("Enter notebook RAM : ");
                                    int RAM = input.nextInt();
                                    System.out.print("Enter notebook memory : ");
                                    int memory = input.nextInt();
                                    System.out.print("Enter notebook screen size : ");
                                    double screenSize = input.nextDouble();
                                    Notebook notebook = new Notebook(Id, notebookPrice,
                                            discount, stock, notebookName.toUpperCase(), notebookBrand, RAM, memory, screenSize);
                                    store.addProduct(notebook);
                                    Id++;
                                    if (store.getProducts().size() == 0) {
                                        Id = 1;
                                    }
                                    break;
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Enter notebook ID : ");
                            int notebookID = input.nextInt();
                            store.removeProduct(notebookID);
                            break;
                        case 3:
                            store.listNotebook();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1 - Add Smartphone");
                    System.out.println("2 - Remove Smartphone by ID");
                    System.out.println("3 - List all smartphones");
                    System.out.print("Enter your choice: ");
                    int smartphoneChoice = input.nextInt();
                    switch (smartphoneChoice) {
                        case 1:
                            System.out.print("Enter smartphone brand ID: ");
                            int brandId = input.nextInt();
                            Brand smartphoneBrand = null;
                            for (Brand b : store.getBrands()) {
                                if (b.getId() == brandId) {
                                    smartphoneBrand = b;
                                    break;
                                }
                            }
                            if (smartphoneBrand == null) {
                                System.out.println("Invalid brand ID. Please try again.");
                                break;
                            }
                            System.out.print("Enter smartphone name: ");
                            input.nextLine(); // to consume the remaining newline character
                            String smartphoneName = input.nextLine();
                            System.out.print("Enter smartphone price: ");
                            double smartphonePrice = input.nextDouble();
                            System.out.print("Enter smartphone discount: ");
                            double smartphoneDiscount = input.nextDouble();
                            System.out.print("Enter smartphone stock: ");
                            int smartphoneStock = input.nextInt();
                            System.out.print("Enter smartphone memory: ");
                            int smartphoneMemory = input.nextInt();
                            System.out.print("Enter smartphone screen size: ");
                            double smartphoneScreenSize = input.nextDouble();
                            System.out.print("Enter smartphone battery: ");
                            int smartphoneBattery = input.nextInt();
                            System.out.print("Enter smartphone RAM: ");
                            int smartphoneRam = input.nextInt();
                            System.out.print("Enter smartphone color: ");
                            input.nextLine(); // to consume the remaining newline character
                            String smartphoneColor = input.nextLine();
                            Smartphone smartphone = new Smartphone(store.getProducts().size() + 1, smartphonePrice,
                                    smartphoneDiscount, smartphoneStock, smartphoneName.toUpperCase(),
                                    smartphoneBrand,
                                    smartphoneMemory, smartphoneScreenSize, smartphoneBattery, smartphoneRam,
                                    smartphoneColor);
                            store.addProduct(smartphone);
                            break;
                        case 2:
                            System.out.print("Enter smartphone ID: ");
                            int smartphoneId = input.nextInt();
                            store.removeProduct(smartphoneId);
                            break;
                        case 3:
                            store.listSmartphones();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 3:
                    store.listBrands();
                    break;
                case 4:
                    store.listProducts();
                    break;
                case 5:
                    System.out.print("Enter brand name : ");
                    input.nextLine();
                    String brandName = input.nextLine();
                    store.filterProducts(brandName);
                    break;
                case 0:
                    System.out.println("Have a nice day");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        input.close();
    }


    public void printBrand() {
        System.out.println("| ID | Brand");
        System.out.println("-------------");
        for (Brand b : store.getBrands()) {
            System.out.printf("| %d | %s\n", b.getId(), b.getName());
        }
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String[] getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String[] brandsName) {
        this.brandsName = brandsName;
    }
}
