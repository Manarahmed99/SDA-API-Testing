package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PetStorePojo {


    private long id;
    private PetStorePojo_Category category;
    private String name;
    private List<String> photoUrls;
    private List<PetStorePojo_Tag> tags;
    private String status;


    public PetStorePojo() {
    }

    public PetStorePojo(long id, PetStorePojo_Category category, String name, List<String> photoUrls, List<PetStorePojo_Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetStorePojo(long id, PetStorePojo_Category category, String name,  List<PetStorePojo_Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.tags = tags;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetStorePojo_Category getCategory() {
        return category;
    }

    public void setCategory(PetStorePojo_Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<PetStorePojo_Tag> getTags() {
        return tags;
    }

    public void setTags(List<PetStorePojo_Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetStorePojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
