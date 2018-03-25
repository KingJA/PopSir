package sample.kingja.popsir;

/**
 * Description:TODO
 * Create Time:2018/3/24 19:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopItem {
    private String itemName;
    private int itemId;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public PopItem(String itemName, int itemId) {
        this.itemName = itemName;
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "PopItem{" +
                "itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
