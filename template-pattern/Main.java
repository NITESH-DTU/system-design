import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ml_pipeline a=new svm();
        ml_pipeline b=new xgboost();
        a.template();
        b.template();

        
       
    }
}

abstract class ml_pipeline {
    abstract void getdata();
    public final void cleandata(){
        System.out.println("common data cleaning");
    }
    abstract void  add_data();
    abstract void collect_result();
    abstract void find_accuracy();
    public final void template(){
        getdata();
        cleandata();
        add_data();
        collect_result();
        find_accuracy();

    }
}
class svm extends ml_pipeline{
    public void getdata(){
        System.out.println("loaded data for svm");
    }
   
    public void add_data(){
        System.out.println("added data for svm");
    }
    public void collect_result(){
        System.out.println("collect result for svm");
    }
    public void find_accuracy(){
        System.out.println("found accuracy for svm");
    }
}
class xgboost extends ml_pipeline{
    public void getdata(){
        System.out.println("loaded data for xgboost");
    }
   
    public void add_data(){
        System.out.println("added data for xgboost");
    }
    public void collect_result(){
        System.out.println("collect result for xgboost");
    }
    public void find_accuracy(){
        System.out.println("found accuracy for xgboost");
    }
}