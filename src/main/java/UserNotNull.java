import javax.validation.constraints.NotNull;

public class UserNotNull {

    public UserNotNull(String name) {
        this.name = name;
    }

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
