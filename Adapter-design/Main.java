public class Main {
    public static void main(String[] args) {
        adapter middleware=new json(new xml());
        middleware.data_in_json();
    }
}
interface adapter{
    void data_in_json();
}
class json implements adapter{
    xml im;
    public json(xml im){
        this.im=im;
    }
    public void data_in_json(){
        im.xml_data();
        System.out.println("data converted in json from xml collected json");
    }
}
class xml{
    public void xml_data(){
        System.out.println("data collected in xml");
    }
}
