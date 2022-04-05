package com.napier.earth;

public class Population {
    private String Name;
    private Long Total;
    private Long Living;
    private Long Notliving;

    public String getName() {
        return Name;
    }

    public Long getTotal() {
        return Total;
    }

    public Long getLiving() {
        return Living;
    }

    public Long getNotliving() {
        return Notliving;
    }
    public Population(String name, Long total, Long living, Long notliving) {
        Name = name;
        Total = total;
        Living = living;
        Notliving = notliving;
    }

}
