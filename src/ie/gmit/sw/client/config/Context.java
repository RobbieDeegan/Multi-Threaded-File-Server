package ie.gmit.sw.client.config;

public class Context {
	public static final String CONFIG_FILE="config.xml";
	private String host;
	private int port;
	
	public Context() {
		super();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Context [host=" + host + ", port=" + port + "]";
	}
}

