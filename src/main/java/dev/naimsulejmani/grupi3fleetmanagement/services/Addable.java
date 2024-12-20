package dev.naimsulejmani.grupi3fleetmanagement.services;

@FunctionalInterface
public interface Addable<T> {
    public T add(T entity);
}
