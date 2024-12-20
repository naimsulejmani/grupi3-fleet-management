package dev.naimsulejmani.grupi3fleetmanagement.services;

@FunctionalInterface
public interface Findable<Tid, T> {
    public T findById(Tid id);
}
