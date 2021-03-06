package my.rinat.kata.collections.company;

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.collection.mutable.CollectionAdapter;
import org.eclipse.collections.impl.utility.Iterate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Has a number, a {@link Customer}, a {@link List} of {@link LineItem}s, and a boolean that states whether or not the order
 * has been delivered. There is a class variable that contains the next order number.
 */
public class Order {

    private static final AtomicInteger NEXT_ORDER_NUMBER = new AtomicInteger(1);

    private final int orderNumber;
    private final List<LineItem> lineItems = new ArrayList<>();
    private boolean isDelivered;

    public Order() {
        this.orderNumber = NEXT_ORDER_NUMBER.getAndIncrement();
    }

    public static void resetNextOrderNumber() {
        NEXT_ORDER_NUMBER.set(1);
    }

    public void deliver() {
        this.isDelivered = true;
    }

    public boolean isDelivered() {
        return this.isDelivered;
    }

    public void addLineItem(LineItem aLineItem) {
        this.lineItems.add(aLineItem);
    }

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }

    @Override
    public String toString() {
        return "order " + this.orderNumber + " items: " + this.lineItems.size();
    }

    /**
     * Refactor to use {@link org.eclipse.collections.api.RichIterable#sumOfDouble(DoubleFunction)}.
     */
    public double getValue() {
        Collection<Double> itemValues = Iterate.collect(this.lineItems, LineItem::getValue);

        return CollectionAdapter.adapt(itemValues).injectInto(0.0, AddFunction.DOUBLE_TO_DOUBLE);
    }
}
