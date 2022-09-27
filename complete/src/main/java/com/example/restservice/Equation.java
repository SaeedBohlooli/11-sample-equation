package com.example.restservice;

public class Equation {

    public Response resolve(int a, int b, int c) {

        // calculate the determinant (b2 - 4ac)
        double determinant = b * b - 4 * a * c;

        double root1 = 0.0, root2 = 0.0;

        // check if determinant is greater than 0
        if (determinant > 0) {

            // two real and distinct roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

        }

        // check if determinant is equal to 0
        else if (determinant == 0) {

            // two real and equal roots
            // determinant is equal to 0
            // so -b + 0 == -b
            root1 = root2 = -b / (2 * a);
        }

        // if determinant is less than zero
        else {

            // roots are complex number and distinct
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);

        }

        Response r = new Response(root1 , root2);
        return  r;
    }

}
