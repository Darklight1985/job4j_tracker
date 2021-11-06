package ru.job4j.stream;

public class Pipe {
    private String material;
    private Double outDiameter;
    private Double insideDiameter;
    private Integer length;
    private String color;

    @Override
    public String toString() {
        return "Pipe{"
                + "material='" + material + '\''
                + ", outDiameter=" + outDiameter
                + ", insideDiameter=" + insideDiameter
                + ", length=" + length
                + ", color='" + color + '\''
                + '}';
    }

    static class Builder {
        private String material;
        private Double outDiameter;
        private Double insideDiameter;
        private Integer length;
        private String color;

        Builder buildMaterial(String material) {
            this.material = material;
            return this;
        }

        Builder buildOutDiameter(Double outDiameter) {
            this.outDiameter = outDiameter;
            return this;
        }

        Builder buildInsideDiameter(Double insideDiameter) {
            this.insideDiameter = insideDiameter;
            return this;
        }

        Builder buildLength(Integer length) {
            this.length = length;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Pipe build() {
            Pipe pipe = new Pipe();
            pipe.material = material;
            pipe.length = length;
            pipe.outDiameter = outDiameter;
            pipe.insideDiameter = insideDiameter;
            pipe.color = color;
            return  pipe;
        }
    }

    public static void main(String[] args) {
        Pipe pipe = new Builder().buildMaterial("Steel")
                .buildOutDiameter(219.1)
                .buildInsideDiameter(200.0)
                .buildLength(1)
                .buildColor("Red")
                .build();
        System.out.println(pipe);
    }

}
