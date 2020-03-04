import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NotEmptyTest {
    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotEmptyName_thenNoConstraintViolations() {
        UserNotEmpty user = new UserNotEmpty("John");
        Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

        assertThat(violations.size(),is(0));
    }

    @Test
    public void whenEmptyName_thenOneConstraintViolation() {
        UserNotEmpty user = new UserNotEmpty("");
        Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

        assertThat(violations.size(),is(1));
    }

    @Test
    public void whenNullName_thenOneConstraintViolation() {
        UserNotEmpty user = new UserNotEmpty(null);
        Set<ConstraintViolation<UserNotEmpty>> violations = validator.validate(user);

        assertThat(violations.size(),is(1));
    }
}
