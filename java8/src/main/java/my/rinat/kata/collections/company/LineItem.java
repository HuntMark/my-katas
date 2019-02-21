package my.rinat.kata.collections.company;

/**
 * An Item has a name and a value.
 */
public class LineItem {

    private String name;
    private final double value;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public LineItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + " $ " + this.getValue();
    }
}
