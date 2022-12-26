package dev_java2.array;

public class AccountSample {
    ButtonArray1_copy bac = null;

    public AccountSample(ButtonArray1_copy bac) {
        this.bac = bac;
    }

    public String account() {
        return "낮춰";
    }

    public void account2() {
        String msg = "낮춰";
        bac.jta_display.append(msg + "\n");
    }

}
