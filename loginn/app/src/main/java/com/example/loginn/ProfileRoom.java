package com.example.loginn;

public class ProfileRoom {

    private String proName;
    private String proMyphone;
    private String proGName;
    private String proGphone;
    private String proDOB;
    private String proAge;
    private String proEmail;
    private String proAddress;


    public ProfileRoom() {
    }

    public ProfileRoom (String proName, String proMyphone, String proGName, String proGphone, String proDOB, String proAge, String proEmail, String proAddress) {
        this.proName = proName;
        this.proMyphone = proMyphone;
        this.proGName = proGName;
        this.proGphone = proGphone;
        this.proDOB = proDOB;
        this.proAge = proAge;
        this.proEmail = proEmail;
        this.proAddress = proAddress;
    }


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProMyphone() {
        return proMyphone;
    }

    public void setProMyphone(String proMyphone) {
        this.proMyphone = proMyphone;
    }

    public String getProGName() {
        return proGName;
    }

    public void setProGName(String proGName) {
        this.proGName = proGName;
    }

    public String getProGphone() {
        return proGphone;
    }

    public void setProGphone(String proGphone) {
        this.proGphone = proGphone;
    }

    public String getProDOB() {
        return proDOB;
    }

    public void setProDOB(String proDOB) {
        this.proDOB = proDOB;
    }

    public String getProAge() {
        return proAge;
    }

    public void setProAge(String proAge) {
        this.proAge = proAge;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

}
