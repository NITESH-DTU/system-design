import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        filesystem f=new folder("photos", 100);
        f.addfile(new file("nikhil",200));
        f.ls();
        System.out.println(f.getname());
        System.out.println(f.getsize());
       
    }
}
interface filesystem{
    void ls();
    
    int getsize();
    String getname();
    void addfile(filesystem f);

}
class file implements filesystem{
    String name;
    int size;
    public file(String name,int size){
        this.name=name;
        this.size=size;
    }
    public void ls(){
        System.out.println(name);
        return ;
    }
    
    public int getsize(){
        return  size;
    }
    public String getname(){
        
        return  name;
    }
    public void addfile(filesystem f){
        System.out.println("file found not folder");
    }
}
class folder implements filesystem{
    String name;
    int size;
    ArrayList<filesystem> arr;
    public folder(String name,int size){
        this.name=name;
        this.size=size;
        arr=new ArrayList<>();
    }
    public void ls(){
        System.out.println(name);
        for(int i=0;i<arr.size();i++){
            arr.get(i).ls();
        }
        return ;
    }
    public void addfile(filesystem f){
        arr.add(f);
    }
   
    public int getsize(){
        int s=size;
        for(int i=0;i<arr.size();i++){
            s+=arr.get(i).getsize();
        }
        return s ;
    }
    public String getname(){
        return   name;
    }
}