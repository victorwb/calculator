package com.example.differntiation;

public class FunctionModel {
    private int id;
    private String function;
    private boolean isActive;

    public FunctionModel(String fuction, boolean isActive) {
        this.function = fuction;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "FunctionModel{" +
                "fuction='" + function + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public FunctionModel() {
    }
    //setters and getters


    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    //calculate derivative
    public String calculate(){
        String ans, function3;
        StringBuilder sb = new StringBuilder("answer = ");
        int p = function.indexOf('+');
        int s = function.indexOf('-');
        int n;

        if(function.indexOf('+')!=-1 || function.indexOf('-')!= -1 ){

            String function2, sign;
            if(p<s){
                n = p;
                sign = " + ";
            }else{
                n = s;
                sign = " - ";
            }
            //string to differentiate
           function2 = function.substring(1,n);
            ans = calc(function2);
            sb.append(ans+sign);
            //string to recompte
            function = function.substring(n+1);
        }else{
        ans = calc(function);
        sb.append(ans);}

        return sb.toString();

    }

    private String calc(String function) {
        if(function.indexOf('x')==-1){
            return " 0 ";
        }else if(function.indexOf('^')==-1){
            int l = function.length()-1;
            if(l==0){
                return " 1 ";
            }
            return function.substring(0,l);
        }else{
            String power = function.substring(function.indexOf('^')+1,function.length());
            int p = Integer.parseInt(power);
            String coef = function.substring(0,function.indexOf('^')-1);
            int c = Integer.parseInt(coef);
            int y = p*c;
            String ans = y+ " x^ " + (p-1) ;
            return ans;
        }
    }


}
