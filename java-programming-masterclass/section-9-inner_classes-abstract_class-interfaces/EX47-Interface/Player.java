import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public List<String> write() {
        List<String> list = new ArrayList<>();
        list.add(0, getName());
        list.add(1, String.valueOf(getHitPoints()));
        list.add(2, String.valueOf(getStrength()));
        list.add(3, getWeapon());
        return list;
    }

    @Override
    public void read(List<String> list) {
        if (list != null && list.size() > 0) {
            setName(list.get(1));
            setHitPoints(Integer.parseInt(list.get(2)));
            setStrength(Integer.parseInt(list.get(3)));
            setWeapon(list.get(4));
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + this.name + '\'' +
                ", hitPoints=" + this.hitPoints +
                ", strength=" + this.strength +
                ", weapon='" + this.weapon + '\'' +
                '}';
    }
}
