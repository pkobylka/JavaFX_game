package com.example.rpgfxmaven.logic;

    public class Vector
    {
        public double x;
        public double y;

        public Vector(double x, double y)
        {
            this.set(x,y);
        }

        public void set(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        public void add(double x, double y)
        {
            this.x += x;
            this.y += y;
        }
       public void add(Vector other)
        {
            this.add(other.x, other.y);
        }

        public void multiply(double number)
        {
        this.x *= number/60;
        this.y *= number/60;
        }
    }

