package by.yauheni.domain;

import java.util.Objects;

public class Operation {
    private double x;
    private double y;
    private double result;
    private String opType;

    @Override
    public String toString() {
        return "Operation{" +
                "x=" + x +
                ", y=" + y +
                ", result=" + result +
                ", opType='" + opType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.x, x) == 0 &&
                Double.compare(operation.y, y) == 0 &&
                Double.compare(operation.result, result) == 0 &&
                Objects.equals(opType, operation.opType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, result, opType);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public Operation() {
    }

    public Operation(double x, double y, double result, String opType) {
        this.x = x;
        this.y = y;
        this.result = result;
        this.opType = opType;
    }
}
