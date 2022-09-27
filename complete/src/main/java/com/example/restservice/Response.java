package com.example.restservice;

public class Response
{
    double root1;
    double root2;

    public Response(double root1, double root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public double getRoot1() {
        return root1;
    }

    public void setRoot1(double root1) {
        this.root1 = root1;
    }

    public double getRoot2() {
        return root2;
    }

    public void setRoot2(double root2) {
        this.root2 = root2;
    }

    @Override
    public String toString() {
        return "Response{" +
                "root1=" + root1 +
                ", root2=" + root2 +
                '}';
    }
}
