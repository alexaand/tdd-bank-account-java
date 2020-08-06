package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.xpdojo.bank.Account.createEmptyAccount;

public class AccountTest {

    private final Account account = createEmptyAccount();

    @Test
    public void newAccountShouldHaveZeroBalance() {
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountShouldIncreaseTheBalance() {

        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);

    }

    @Test
    public void depositMultipleDepositsShouldIncreaseTheBalance() {
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void withdrawalFromEmptyAccountShouldNotBeAllowed() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            createEmptyAccount().withdrawal(1);
        });

        String expectedMsg = "Cannot withdraw - no overdraft available";
        String actualMsg = e.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }
}