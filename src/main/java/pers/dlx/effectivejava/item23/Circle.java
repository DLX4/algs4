package pers.dlx.effectivejava.item23;

class Circle extends Figure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
