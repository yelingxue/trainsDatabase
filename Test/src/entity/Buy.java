package entity;

public class Buy {
    public String CityName,goTime,GNo;
    public int remaining,price,CityNo,counts,id;

    public String getGNo() {return GNo;}
    public String getCityName() {return CityName;}
    public int getCityNo(){
        return CityNo;
    }
    public String getGoTime(){
        return goTime;
    }
    public int getRemaining(){
        return remaining;
    }
    public int getPrice(){
        return price;
    }
}
