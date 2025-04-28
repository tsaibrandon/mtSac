package test;

import interfaces.Cloneable;

public class MtsacInteger implements Comparable<MtsacInteger>, Cloneable<MtsacInteger> {
    public int i;

    public MtsacInteger(int integer) {
        this.i = integer;
    }

    @Override
    public int compareTo(MtsacInteger other) {
        return i - other.i;
    }

    @Override
    public MtsacInteger copy() { return new MtsacInteger(i); }
    
}
