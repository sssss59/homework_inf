import com.sibsutis.devices.Device;

public class PersonalComputer extends Device{
    public PersonalComputer(int id,int price){
        super(id, price, "");
    }
    public PersonalComputer(int id, int price, String ip){
        super(id, price, ip);
    }
    @Override
    public String getDeviceType() {
        return "Personal Computer";
    }
}
