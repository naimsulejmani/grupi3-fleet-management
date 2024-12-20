package dev.naimsulejmani.grupi3fleetmanagement.services;

@FunctionalInterface
public interface Removable<Tid> {
    public void remove(Tid id);
}
