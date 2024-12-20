package dev.naimsulejmani.grupi3fleetmanagement.services;

@FunctionalInterface
public interface Modifiable<Tid, T> {
    public T modify(Tid id, T entity);
}
