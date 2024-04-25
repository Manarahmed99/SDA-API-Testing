package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStorePojo_Category  {

    private int id;
    private String name;

    public PetStorePojo_Category() {
    }

    public PetStorePojo_Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetStorePojo_Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
