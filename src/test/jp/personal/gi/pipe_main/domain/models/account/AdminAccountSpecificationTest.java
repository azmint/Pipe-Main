package jp.personal.gi.pipe_main.domain.models.account;

import org.junit.*;
import org.omg.PortableInterceptor.*;

import static org.junit.Assert.*;

public class AdminAccountSpecificationTest {
    private static final AdminAccountSpecification ADMIN_ACCOUNT_SPECIFICATION = new AdminAccountSpecification();
    private static final Account ADMIN_ACCOUNT = new Account(new AccountId("1"), new MailAddress(""), new Password(""), Authority.ADMIN);
    private static final Account NON_ADMIN_ACCOUNT = new Account(new AccountId("2"), new MailAddress(""), new Password(""), Authority.GENERAL);

    @Test
    public void isSatisfiedByTest() {
        assertTrue(ADMIN_ACCOUNT_SPECIFICATION.isSatisfiedBy(ADMIN_ACCOUNT));
        assertFalse(ADMIN_ACCOUNT_SPECIFICATION.isSatisfiedBy(NON_ADMIN_ACCOUNT));
    }

    @Test
    public void createTest() {
        final Account account = ADMIN_ACCOUNT_SPECIFICATION.create(new AccountId("1"), new MailAddress(""), new Password(""));
        assertEquals(account.getId(), ADMIN_ACCOUNT.getId());
        assertEquals(account.getMailAddress(), ADMIN_ACCOUNT.getMailAddress());
        assertEquals(account.getPassword(), ADMIN_ACCOUNT.getPassword());
        assertSame(account.getAuthority(), ADMIN_ACCOUNT.getAuthority());
    }
}