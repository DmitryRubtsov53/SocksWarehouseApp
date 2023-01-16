package dn.rubtsov.sockswarehouseapp.model;



import java.util.Objects;

public class Socks {

    private final Color color;
    private final Size size;
    private final int cotton;

    public Socks(Color color, Size size, int cotton) {
        this.color = color;
        this.size = size;
        this.cotton = cotton;
    }

    public Color getColor() { return color; }

    public Size getSize() { return size;   }

    public Integer getCotton() { return cotton;  }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return color == socks.color && size == socks.size && Objects.equals(cotton, socks.cotton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, cotton);
    }
}
