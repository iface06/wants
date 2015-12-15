package de.as.authorization;

import de.as.authorization.Right;
import de.as.authorization.User;
import de.as.authorization.Doorman;
import java.util.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class DoormanTest {

    User user;
    private Doorman doorman;

    @Test
    public void testHasRight_true() {

        when(user.getRights()).thenReturn(new HashSet<>(Arrays.asList(AccessRight.READ)));
        boolean hasReadRight = doorman.hasUserTheRight(user, AccessRight.READ);
        Assert.assertTrue(hasReadRight);
    }

    @Test
    public void testHasRight_false() {
        when(user.getRights()).thenReturn(new HashSet<>(Arrays.asList(AccessRight.READ)));
        boolean hasReadRight = doorman.hasUserTheRight(user, AccessRight.EDIT);
        Assert.assertFalse(hasReadRight);
    }

    @Test
    public void testHasRight_falseIfUserHasNoRights() {
        when(user.getRights()).thenReturn(new HashSet<>());
        boolean hasReadRight = doorman.hasUserTheRight(user, AccessRight.READ);
        Assert.assertFalse(hasReadRight);
    }

    @Before
    public void before() {
        doorman = new Doorman();
        user = mock(User.class);
    }

    public static enum AccessRight implements Right<UUID> {

        READ(UUID.randomUUID(), "Read", "User has only the right to read data"),
        EDIT(UUID.randomUUID(), "Edit", "User has only the right to edit already exisitng data");

        private UUID id;
        private String name;
        private String description;

        private AccessRight(UUID id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

    }

}
