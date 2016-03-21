package demoview.duongkk.com.demoview.Models;

/**
 * Created by DuongKK on 3/18/2016.
 */
public class Card  {
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String number;

    public Card(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
