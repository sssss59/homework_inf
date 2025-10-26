import com.sibsutis.devices.Device;

public class Phone extends Device{
    public Phone(int id, int price){
        super(id, price, getIp());
    }
    public Phone(int id, int price, String ip){
        super(id, price, ip);
    }
    public String getDeviceType(){
        return "Phone";
    }
}
