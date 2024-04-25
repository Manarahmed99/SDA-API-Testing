package pojos;

public class PetStorePojo_Tag {

    private int id;
    private String name;


    public PetStorePojo_Tag() {
    }

    public PetStorePojo_Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetStorePojo_Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
