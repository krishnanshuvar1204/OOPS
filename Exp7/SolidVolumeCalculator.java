abstract class Solid {
    abstract double calculateVolume();
}

class Cuboid extends Solid {
    double length, width, height;

    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateVolume() {
        return length * width * height;
    }
}

class Sphere extends Solid {
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

public class SolidVolumeCalculator {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid(5, 3, 4);
        Sphere sphere = new Sphere(6);

        System.out.println("Cuboid Volume: " + cuboid.calculateVolume());
        System.out.println("Sphere Volume: " + sphere.calculateVolume());
    }
}
