package lec5_streams;

import java.io.Serializable;
import java.util.Date;

public class Foo implements Serializable {
private int v1=5;
private static double v2=8;

private transient int v3 = 10;
public String printObj() {
	
	return "The values are v1: " + Integer.toString(v1) + ", v2: " +Double.toString(v2) + ", v3:  "+Integer.toString(v3); 
}
}
