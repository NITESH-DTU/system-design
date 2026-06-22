abstract interface Burgers{
    abstract void creating();
}
class simple_burger implements Burgers{
    public void creating(){
        System.out.println("creating burger using simple_burger");
    }
}
class simple_burgres_with_chesse implements Burgers{
    public void creating(){
        System.out.println("creating burger using simple_burger_with_chesse");
    }

}
class simple_burgres_with_ketchup implements Burgers{
    public void creating(){
        System.out.println("creating burger using simple_burger_with_ketchup");
    }

}
class premium_burger implements Burgers{
    public void creating(){
        System.out.println("creating burger using premium_burger");
    }
}
class premium_burgres_with_chesse implements Burgers{
    public void creating(){
        System.out.println("creating burger using premium_burger_with_chesse");
    }

}
abstract interface Fries{
    abstract void creating();
}
class simple_Fries implements Fries{
    public void creating(){
        System.out.println("creating Friesusing simple_Fries");
    }
}
class simple_Fries_with_chesse implements Fries{
    public void creating(){
        System.out.println("creating Friesusing simple_Fries_with_chesse");
    }

}
class simple_Fries_with_ketchup implements Fries{
    public void creating(){
        System.out.println("creating Friesusing simple_Fries_with_ketchup");
    }

}
class premium_Fries implements Fries{
    public void creating(){
        System.out.println("creating Friesusing premium_Fries");
    }
}
class premium_Fries_with_chesse implements Fries{
    public void creating(){
        System.out.println("creating Fries using premium_Fries_with_chesse");
    }

}
class premium_Fries_with_ketchup implements Fries{
    public void creating(){
        System.out.println("creating Fries using premium_Fries_with_ketchup");
    }

}
abstract interface bfactory{
    abstract Fries Fries(String s);
    abstract Burgers create(String s);
}
class singh_burger implements bfactory{
    public Burgers create(String s){
        if(s=="simple_burgers"){
            return new simple_burger();
        }else if(s=="simple_burgers_with_chesse"){
            return new simple_burgres_with_chesse();
        }else{
            return new simple_burgres_with_ketchup();
        }
    }
    public Fries Fries(String s){
        if(s=="simple_Fries"){
            return new simple_Fries();
        }else if(s=="simple_Fries_with_chesse"){
            return new simple_Fries_with_chesse();
        }else{
            return new simple_Fries_with_ketchup();
        }
    }
}
class king_burger implements bfactory{
    public Burgers create(String s){
        if(s=="premium_burgers"){
            return new premium_burger();
        }else if(s=="premium_burgers_with_chesse"){
            return new premium_burgres_with_chesse();
        }else{
            return new premium_burgres_with_ketchup();
        }
    }
     public Fries Fries(String s){
        if(s=="premium_Fries"){
            return new premium_Fries();
        }else if(s=="premium_Fries_with_chesse"){
            return new premium_Fries_with_chesse();
        }else{
            return new premium_Fries_with_ketchup();
        }
    }
    
}


public class Main {

    public static void main(String[] args) {
        

        bfactory bg=new king_burger();
        bfactory fr=new singh_burger();
        Fries f=fr.Fries("fries");
        f.creating();
        Burgers b=bg.create("premium_burgers");
        b.creating();


    }
}