package pao;

public sealed abstract class Shape permits Circle, Rectangle, Triangle {

    public abstract double area();
}

