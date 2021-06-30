/**
 * ProxyLogin class - concrete class implementing Login interface
 */

public class ProxyLogin implements Login {
	private RealLogin realLogin;

	/**
	 * displayLogin() will create a new RealLogin object if it does not exist and
	 * use it to display the login frame
	 */
	@Override
	public void displayLogin() {
		if (realLogin == null) {
			realLogin = new RealLogin();
		}
		realLogin.displayLogin();
	}
}