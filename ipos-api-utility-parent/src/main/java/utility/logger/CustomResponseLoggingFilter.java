package utility.logger;

import java.util.Map;

public class CustomResponseLoggingFilter {

	private String method;
	private String path;
	private String clientIP;
	private Map<String, String> responseHeader;
	private Map<String, Object> responseBody;
	private int responseCode;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public Map<String, String> getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(Map<String, String> responseHeader) {
		this.responseHeader = responseHeader;
	}
	public Map<String, Object> getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(Map<String, Object> responseBody) {
		this.responseBody = responseBody;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	
}
