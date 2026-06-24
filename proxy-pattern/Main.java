public class Main {
    public static void main(String[] args) {

        dataservice ds=new proxy();
        ds.fetchdata();
    }
    
}
interface dataservice{
    void fetchdata();
}
class proxy implements dataservice{
    dataproxy ds;
    public void fetchdata(){
        if(ds==null){
            ds=new dataproxy();
        }
        
        ds.fetchdata();
        System.out.println("proxy service::::::fetching data from the 3rd party service");
    }
}
class dataproxy implements dataservice{
    public void fetchdata(){
        System.out.println("3rd party service:::::fetching data for user");
    }
}