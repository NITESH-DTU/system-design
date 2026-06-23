interface character{
    void getabilities();
}
class mario implements character{
    @Override
    public void getabilities() {
        System.out.println("running mario abilities");
    }
}
interface decorator extends character{
    void getabilities();
}
class energy implements decorator{
    private character ch;
    public energy(character c){
        this.ch=c;
    }
    public void getabilities(){
        ch.getabilities();
        System.out.println("running get abilities of energy!");
    }
}
class fire implements decorator{
    private character ch;
    public fire(character c){
        this.ch=c;
    }
    public void getabilities(){
        ch.getabilities();
        System.out.println("running get abilities of fire!");
    }

}
class run implements decorator{
    private character ch;
    public run(character c){
        this.ch=c;
    }
    public void getabilities(){
        ch.getabilities();
        System.out.println("running get abilities of run!");
    }

}
public class Main {

    public static void main(String[] args) {

       character ch=new run(new fire(new energy(new mario())));
       ch.getabilities();
    }
}
