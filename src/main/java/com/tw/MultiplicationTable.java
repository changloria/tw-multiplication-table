package com.tw;

public class MultiplicationTable {
    public String create(int start, int end) {
        return isValid(start,end) ? generateTable(start,end) : null;
    }

    public Boolean isValid(int start, int end) {
        return isInRange(start) && isInRange(end) && isStartNotBiggerThanEnd(start, end);
    }

    public Boolean isInRange(int number) {
        return number>=1 && number<=1000;
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end) {
        return start <= end;
    }

    public String generateTable(int start, int end) {
        StringBuilder tmpTable = new StringBuilder();
        for(int i=start; i<=end; i++){
            tmpTable.append(generateLine(start, i)).append("\r\n");
        }
        return tmpTable.substring(0, tmpTable.length()-2);
    }

    public String generateLine(int start, int row) {
        StringBuilder tmp = new StringBuilder();
        while(start <= row){
            if(start!=row){
                tmp.append(generateSingleExpression(start, row)).append("  ");
            }else{
                tmp.append(generateSingleExpression(start, row));
            }
            start++;
        }
        return tmp.toString();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        int result = multiplicand * multiplier;
        return multiplicand+"*"+multiplier+"="+result;
    }
}
