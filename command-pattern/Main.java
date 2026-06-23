public class Main {
     public static void main(String[] args) {
        remote r=new remote();
        r.setcommand(new wfan());
        r.press();
        r.close();
    }
}
class remote{
    private command c;
    
    public void setcommand(command c){
        this.c=c;
    }
    public void press(){
        c.execute();
    }
    public void close(){
        c.undo();
    }
}
interface command{
    void execute();
    void undo();
}
class fan{
    void on(){
        System.out.println("fan running");
    }
    void off(){
        System.out.println("fan stopped");
    };
}
class wfan implements command{
    private fan f;
    public wfan(){
        this.f=new fan();
    }
    public void execute(){
        f.on();
    }
    public void undo(){
        f.off();
    }

}
