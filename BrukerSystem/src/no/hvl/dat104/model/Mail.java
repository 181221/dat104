package no.hvl.dat104.model;

/**
 * Created by Peder on 24.09.2017.
 */
public class Mail {
    private static String FRAMAIL;
    private static String PASSORD;

    private String til;
    private String msg;
    private String subject;
    private String result;

    public Mail(String til, String msg, String subject) {
        this.til = til;
        this.msg = msg;
        this.subject = subject;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public static void setFRAMAIL(String FRAMAIL) {
        Mail.FRAMAIL = FRAMAIL;
    }

    public static void setPASSORD(String PASSORD) {
        Mail.PASSORD = PASSORD;
    }

    public static String getFRAMAIL() {
        return FRAMAIL;
    }

    public static String getPASSORD() {
        return PASSORD;
    }

    public String getTil() {
        return til;
    }

    public void setTil(String til) {
        this.til = til;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
