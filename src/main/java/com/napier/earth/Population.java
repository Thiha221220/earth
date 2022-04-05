package com.napier.earth;

public class Population {
    private String Name;
    private Long Total;
    private Integer Living;
    private Integer Notliving;

    public String getName() {
        return Name;
    }

    public Long getTotal() {
        return Total;
    }

    public Integer getLiving() {
        return Living;
    }

    public Integer getNotliving() {
        return Notliving;
    }
    public Population(String name, Long total, Integer living, Integer notliving) {
        Name = name;
        Total = total;
        Living = living;
        Notliving = notliving;
    }

}
