package by.yauheni.service;

public class CaclService {
    private double sum(double x, double y){
        return x + y;
    }

    private double sub(double x, double y){
        return x - y;
    }

    private double div(double x, double y){
        return x / y;
    }

    private double mul(double x, double y){
        return x * y;
    }

    public double calculate(String optype, double x, double y){
        double result = 0;
        switch (optype){
            case "sum":
                result = sum(x, y);
                break;
            case "sub":
                result = sub(x, y);
                break;
            case "mul":
                result = mul(x, y);
                break;
            case "div":
                result = div(x, y);
                break;
        }
        return result;
    }
}
