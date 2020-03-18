package lec4_exceptions;
//lec 4  slide 10

public class MyException extends Exception { //The exception is just an object that extends the class Exception.
	private static final long serialVersionUID = 1L;

public MyException() {
	System.out.println("1st Exception constructor.");
}

public MyException(String in_expr) {
	System.out.println("2nd Exception constructor with argument: "+in_expr);
}

public void specific_method() {
	System.out.println("Exception method.");
}

}
