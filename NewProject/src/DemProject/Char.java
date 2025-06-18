package DemProject;

public class Char {
	public static void main(String[] args) {
		public int publicVar = 10;
		protected int protectedVar = 20;
		int defaultVar = 30;
		private int privateVar = 40;

	 
		public void publicMethod() {
		    System.out.println("Public Method: Accessible from anywhere");
		}
		protected void protectedMethod() {
	        System.out.println("Protected Method: Accessible within package & subclasses");
	    }
		void defaultMethod() {
	        System.out.println("Default Method: Accessible within the package");
	    }
		private void privateMethod() {
	        System.out.println("Private Method: Accessible only within this class");
	    }
		public void accessPrivateMethod() {
	        privateMethod();
	    }
	
		
		
	
	
}



















//Subclass to show protected access
	/*	class SubClass extends SuperClass {
		    public void accessProtected() {
		        System.out.println("Accessing Protected Variable: " + protectedVar);
		        protectedMethod();
		    }
		}

		public class AccessModifiersDemo {
		    public static void main(String[] args) {
		        SuperClass obj = new SuperClass();

		        // Accessing public members
		        System.out.println("Public Variable: " + obj.publicVar);
		        obj.publicMethod();

		        // Accessing default members (same package)
		        System.out.println("Default Variable: " + obj.defaultVar);
		        obj.defaultMethod();

		        // Accessing protected members (same package)
		        SubClass subObj = new SubClass();
		        subObj.accessProtected();

		        // Accessing private members is NOT possible outside the class
		        // System.out.println("Private Variable: " + obj.privateVar); // Error
		        // obj.privateMethod(); // Error

		        // Access private method through a public method within the same class
		        obj.accessPrivateMethod();
		    }
		}

	}
	}  */
