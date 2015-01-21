package excepciones;

public class FueraDeCuadricula extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5901197963336001788L;

	public FueraDeCuadricula() {
	}

	public FueraDeCuadricula(String arg0) {
		super(arg0);
	}

	public FueraDeCuadricula(Throwable arg0) {
		super(arg0);
	}

	public FueraDeCuadricula(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FueraDeCuadricula(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}