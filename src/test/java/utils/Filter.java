package utils;

public class Filter {
    private String brand;
    private String camera;
    private String year;
    private String lowerPriceBound;
    private String upperPriceBound;

    // Constructor
    public Filter(String brand, String camera, String year, String lowerPriceBound, String upperPriceBound) {
        this.brand = brand;
        this.camera = camera;
        this.year = year;
        this.lowerPriceBound = lowerPriceBound;
        this.upperPriceBound = upperPriceBound;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getCamera() {
        return camera;
    }

    public String getYear() {
        return year;
    }

    public String getLowerPriceBound() {
        return lowerPriceBound;
    }

    public String getUpperPriceBound() {
        return upperPriceBound;
    }
}
