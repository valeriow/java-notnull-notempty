import javax.validation.constraints.NotEmpty;

public class UserNotEmpty {

    public UserNotEmpty(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Name may not be empty")
    private String name;

    // standard constructors / getters / toString

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}