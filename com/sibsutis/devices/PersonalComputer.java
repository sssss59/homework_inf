package com.sibsutis.devices;

import java.util.Objects;

public class PersonalComputer extends Device {
    
    public PersonalComputer(int id, int price) {
        super(id, price, null);
    }
    
    public PersonalComputer(int id, int price, String ip) {
        super(id, price, ip);
    }
    
    @Override
    public String getDeviceType() {
        return "PersonalComputer";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        return getClass() == obj.getClass();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDeviceType());
    }
}