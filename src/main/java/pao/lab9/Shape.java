package pao.lab9;

public sealed abstract class Shape permits Circle, Rectangle, Triangle {

    public abstract double area();
}

