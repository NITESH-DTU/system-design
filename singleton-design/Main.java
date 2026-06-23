class singleton{
    public static singleton single=new singleton(); //eager initalization
    private singleton(){

    }
    public static singleton instance(){
        return single;
    }
}

class singleton2{
    public static singleton2 single;
    private singleton2(){

    }
    public static synchronized singleton2 instance(){ //synchronized prevent the multiple threads to enter at once
        if(single==null){
            return new singleton2();
        }
        return single;
    }
}


class singleton3{
    public static singleton3 single;
    private singleton3(){

    }
    public static singleton3 instance(){
        if(single==null){               //no safety from the multi thread inital -operations
            return new singleton3();
        }
        return single;
    }
}






public class Main {
    public static void main(String[] args) {
        singleton s=singleton.instance();
        singleton2 s2=singleton2.instance();
        singleton3 s3=singleton3.instance();
        singleton s4=singleton.instance();
        singleton2 s5=singleton2.instance();
        singleton3 s6=singleton3.instance();
        System.out.println(s==s4);
        System.out.println(s5==s2);

        System.out.println(s6==s3);


    }
}
