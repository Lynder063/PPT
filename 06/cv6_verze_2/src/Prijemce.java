public class Prijemce {
    private final String jmeno;
    private final String prijmeni;
    private final String ulice;
    private final String mesto;
    private final String psc;
    private final String telefon;
    private final String email;

    public Prijemce(String jmeno, String prijmeni, String ulice, String mesto, String psc, String telefon, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.telefon = telefon;
        this.email = email;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getUlice() {
        return ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public String getPsc() {
        return psc;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + "\n" +
                ulice + "\n" +
                mesto + ", " + psc + "\n" +
                "Tel: " + telefon + ", Email: " + email;
    }
}