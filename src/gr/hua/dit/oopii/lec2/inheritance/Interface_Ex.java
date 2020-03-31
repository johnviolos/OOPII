package gr.hua.dit.oopii.lec2.inheritance;
//slide 58
interface IFace{
void drawFace();
}
class RealFace implements IFace {
public void drawFace(){
System.out.println("I'm drawing a beautiful face");
}
}
public class Interface_Ex {
public static void callIFace(IFace face) { // Argument type is interface.
face.drawFace();
}
public static void main(String[] args) {
IFace face = new RealFace();
callIFace(face);

Module[] instances = new Module[20];
instances[0] = new Module() {
	 public void actions() { System.out.println("The action of an object that implements an interface");}
	 public void init() {}
	};
	instances[0] .actions();
	
}

public interface Module {
    void init();
    void actions();
}

}

