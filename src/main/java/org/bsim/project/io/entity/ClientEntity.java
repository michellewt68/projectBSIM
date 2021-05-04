package org.bsim.project.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientTBL")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID= 6134700235434807047L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String clientid;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)", length = 100)
    private String clientname;

    @Column(nullable = false)
    private String clientaddress;

    @Column(nullable = false)
    private String clientphonenumber;

    @Column(nullable = false)
    private LocalDate clientdob;

    @Column(nullable = false)
    private long clientnik;

    @Column(nullable = false)
    private String clientmothername;

    @Column(nullable = false)
    private String clientpassword;

    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RekeningEntity> rekeningEntities = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientaddress() {
        return clientaddress;
    }

    public void setClientaddress(String clientaddress) {
        this.clientaddress = clientaddress;
    }

    public String getClientphonenumber() {
        return clientphonenumber;
    }

    public void setClientphonenumber(String clientphonenumber) {
        this.clientphonenumber = clientphonenumber;
    }

    public LocalDate getClientdob() {
        return clientdob;
    }

    public void setClientdob(LocalDate clientdob) {
        this.clientdob = clientdob;
    }

    public long getClientnik() {
        return clientnik;
    }

    public void setClientnik(long clientnik) {
        this.clientnik = clientnik;
    }

    public String getClientmothername() {
        return clientmothername;
    }

    public void setClientmothername(String clientmothername) {
        this.clientmothername = clientmothername;
    }

    public String getClientpassword() {
        return clientpassword;
    }

    public void setClientpassword(String clientpassword) {
        this.clientpassword = clientpassword;
    }

    public List<RekeningEntity> getRekeningEntities() {
        return rekeningEntities;
    }

    public void setRekeningEntities(List<RekeningEntity> rekeningEntities) {
        this.rekeningEntities = rekeningEntities;
    }
}
