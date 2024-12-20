package dev.naimsulejmani.grupi3fleetmanagement.services;

import java.util.List;

@FunctionalInterface
public interface FindAll<T> {
    public List<T> findAll();
}
