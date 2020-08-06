package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private final Account account = Account.createEmptyAccount();

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
}