package dev.naimsulejmani.grupi3fleetmanagement.services;

public interface WriteOnlyService<Tid, T> extends Addable<T>, Modifiable<Tid, T>, Removable<Tid> {
}
