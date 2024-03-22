package agh.ii.prinjava.lab04.lst04_04;

/**
 * <i>Unconstrained parametric polymorphism</i>
 * <p>{@code GenClass0<T>} - the "T" represents all reference types
 */
class GenClass0<T> {
    void m1(T p) {
        // p is treated as having type Object -> only methods defined in the Object are available
    }
}
