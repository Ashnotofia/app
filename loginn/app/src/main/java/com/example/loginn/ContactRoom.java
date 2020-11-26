package com.example.loginn;

public class ContactRoom {

    private String etC1;
    private String etC2;
    private String etC3;

    private String etCN1;
    private String etCN2;
    private String etCN3;

    public ContactRoom(){

    }

    public ContactRoom(String etCN1,String etC1,String etCN2,String etC2,String etCN3,String etC3){
        this.etCN1 =etCN1;
        this.etC1 =etC1;
        this.etCN2 =etCN2;
        this.etC2 =etC2;
        this.etCN3 =etCN3;
        this.etC3 =etC3;
    }
    public String getetCN1(){return etCN1;}
    public void setetCN1(String etCN1){this.etCN1=etCN1;}

    public String getetCN2(){return etCN2;}
    public void setetCN2(String etCN2){this.etCN2=etCN2;}

    public String getetCN3(){return etCN3;}
    public void setetCN3(String etCN3){this.etCN3=etCN3;}

    public String getetC2(){return etC2;}
    public void setetC2(String etCN2){this.etC2=etC2;}

    public String getetC1(){return etC1;}
    public void setetC1(String etCN1){this.etC1=etC1;}

    public String getetC3(){return etC3;}
    public void setetC3(String etCN3){this.etC3=etC3;}






}
