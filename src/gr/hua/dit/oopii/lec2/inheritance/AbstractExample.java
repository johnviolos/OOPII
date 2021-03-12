package gr.hua.dit.oopii.lec2.inheritance;
//slide 54
abstract class A{
    abstract void tell();
}

class B extends A{
    void tell(){
            System.out.println("I am B Telling");
    }
}

public class AbstractExample{

    public static void whoTold(A a)			//the type of the argument is an abstract class.
    {
            a.tell();
    }

    public static void main(String[] args){
            A b = new B(); //We cannot instantiate objects of abstract classes i.e. new A() 
            whoTold(b);
   }
}