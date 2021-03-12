//**slide 58 Interface */
package gr.hua.dit.oopii.lec2.inheritance;
interface IFace{
	static final float  pi =3.14f;
void drawFace();
}
class RealFace implements IFace {
public void drawFace(){		//We implement the abstract method of the interface.
System.out.println("I'm drawing a beautiful face");

}
}

public class Interface_Ex {
public static void callIFace(IFace face) { // Argument type is interface.
face.drawFace();
}

public static void main(String[] args) {
IFace face = new RealFace();
System.out.println("The Interface can have static-final attributes: "+ IFace.pi);
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

