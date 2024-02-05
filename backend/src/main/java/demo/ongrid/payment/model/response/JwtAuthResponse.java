package demo.ongrid.payment.model.response;

import java.util.HashMap;
import java.util.Map;

public class JwtAuthResponse {

    private Map<String, String> user = new HashMap<>();
    private Map<String, String> programme = new HashMap<>();

    private Map<String, String> payment = new HashMap<>();
    private Map<String, String> accessToken = new HashMap<>();


    public JwtAuthResponse() {

    }

    public JwtAuthResponse(Map<String, String> user, Map<String, String> programme, Map<String, String> payment, Map<String, String> accessToken) {
        this.user = user;
        this.programme = programme;
        this.payment = payment;
        this.accessToken = accessToken;
    }

    public Map<String, String> getUser() {
        return user;
    }

    public void setUser(Map<String, String> user) {
        this.user = user;
    }

    public Map<String, String> getProgramme() {
        return programme;
    }

    public void setProgramme(Map<String, String> programme) {
        this.programme = programme;
    }

    public Map<String, String> getPayment() {
        return payment;
    }

    public void setPayment(Map<String, String> payment) {
        this.payment = payment;
    }

    public Map<String, String> getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Map<String, String> accessToken) {
        this.accessToken = accessToken;
    }
}