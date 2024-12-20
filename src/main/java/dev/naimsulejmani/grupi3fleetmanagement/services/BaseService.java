package dev.naimsulejmani.grupi3fleetmanagement.services;

public interface BaseService<Tid, T> extends ReadOnlyService<Tid, T>, WriteOnlyService<Tid, T> {
}
