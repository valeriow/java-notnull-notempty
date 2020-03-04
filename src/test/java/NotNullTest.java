import org.junit.BeforeClass;
import org.junit.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NotNullTest {
    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenNotNullName_thenNoConstraintViolations() {
        UserNotNull user = new UserNotNull("João");
        Set<ConstraintViolation<UserNotNull>> violations = validator.validate(user);

        assertThat(violations.size(),is(0));
    }

    @Test
    public void whenNullName_thenOneConstraintViolation() {
        UserNotNull user = new UserNotNull(null);
        Set<ConstraintViolation<UserNotNull>> violations = validator.validate(user);

        assertThat(violations.size(),is(1));
    }

    @Test
    public void whenEmptyName_thenNoConstraintViolations() {
        UserNotNull user = new UserNotNull("");
        Set<ConstraintViolation<UserNotNull>> violations = validator.validate(user);

        assertThat(violations.size(),is(0));
    }

}
