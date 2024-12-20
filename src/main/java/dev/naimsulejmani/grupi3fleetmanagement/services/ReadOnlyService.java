package dev.naimsulejmani.grupi3fleetmanagement.services;

public interface ReadOnlyService<Tid, T> extends FindAll<T>, Findable<Tid, T> {
}
