import java.util.HashMap;
import java.util.Map;

public class store {
    private Map<Integer,String> data;

    public store(Map<Integer, String> data) {
        this.data = new HashMap<>();
    }
    public String getIteam(int id){
        return (this.data.get(id));

    }
    public void remove(int id){
        this.data.remove(id);
    }
    public void sell(int id){
        remove(id);

    }
    
    
}
