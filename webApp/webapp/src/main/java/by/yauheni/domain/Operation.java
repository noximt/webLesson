package by.yauheni.domain;

import java.util.Date;
import java.util.Objects;

public class Operation {
    long id;
    long userID;
    private double x;
    private String opType;
    private double y;
    private double result;
    private Date date;

    public Operation(long id, long userID, double x, String opType, double y, double result, Date date) {
        this.id = id;
        this.userID = userID;
        this.x = x;
        this.opType = opType;
        this.y = y;
        this.result = result;
        this.date = date;
    }

    public Operation(double x, double y, double result, String opType, long userID) {
        this.x = x;
        this.y = y;
        this.result = result;
        this.opType = opType;
        this.userID = userID;
        this.date = new Date();
    }

    public Operation(double x, double y, double result, String opType, long id, long userID) {
        this.x = x;
        this.y = y;
        this.result = result;
        this.opType = opType;
        this.id = id;
        this.userID = userID;
        this.date = new Date();
    }

    public Operation() {
    }

    @Override
    public String toString() {
        return "Operation{" +
                "x=" + x +
                ", y=" + y +
                ", result=" + result +
                ", opType='" + opType + '\'' +
                ", date=" + date +
                ", id=" + id +
                ", userID=" + userID +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
