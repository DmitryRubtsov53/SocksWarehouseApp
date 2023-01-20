package dn.rubtsov.sockswarehouseapp.service;

import dn.rubtsov.sockswarehouseapp.model.Color;
import dn.rubtsov.sockswarehouseapp.model.Size;

public class SocksRequest {  // DATA TRANSFER OBJECT
    private Color color;
    private Size size;
    private int cotton;
    private int quantity;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCotton() { return cotton; }

    public void setCotton(int cotton) {
        this.cotton = cotton;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
