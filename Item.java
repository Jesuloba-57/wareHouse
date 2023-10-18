import java.util.Objects;

public class Item {
    private Product product;
    private Member member;
    private int quantity;

    public Item(Product product, Member member, int quantity) {
        this.product = product;
        this.member = member;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Member getMember() {
        return member;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item that = (Item) obj;
        return Objects.equals(product, that.product) &&
                Objects.equals(member, that.member) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, member, quantity);
    }
}