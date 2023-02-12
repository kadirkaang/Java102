package products;

public class Notebook extends Product {
    private int ram;
    private int memory;
    private double screenSize;

    public Notebook(int id, double price, double discountRate, int stock, String name, Brand brand, int ram, int memory, double screenSize) {
        super(id, price, discountRate, stock, name, brand);
        this.ram = ram;
        this.memory = memory;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
