package CST323.KaraokeMachine.exception;

public class DatabaseException extends RuntimeException{
	//default serial version UID
	private static final long serialVersionUID = 8383092451958523986L;

	//constructor to throw exception with stack trace
	public DatabaseException(Throwable e) {
		//calls parent class constructor
		super(e); 
	}
}
