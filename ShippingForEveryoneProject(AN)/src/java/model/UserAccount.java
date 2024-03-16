package model;

public class UserAccount {
    private Account account;
    private People people;

    public UserAccount() {
    }

    public UserAccount(Account account) {
        this.account = account;
    }

    public UserAccount(Account account, People people) {
        this.account = account;
        this.people = people;
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
