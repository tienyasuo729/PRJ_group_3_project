package org.example.shipping_services_for_everyone.model;

public class UserAccount {
    private Account account;
    private People people;

    public UserAccount() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
