package ru.avalon.devj.model.table;

import java.sql.Timestamp;

public class DomainTable {
    private final Integer id;
    private final String webName;
    private final String domainName;
    private final String ip;
    private final Timestamp registerDate;
    private final String country;

    public DomainTable(Integer id, String webName, String domainName, String ip, Timestamp registerDate, String country) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.registerDate = registerDate;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getWebName() {
        return webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIp() {
        return ip;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public String getCountry() {
        return country;
    }
}
