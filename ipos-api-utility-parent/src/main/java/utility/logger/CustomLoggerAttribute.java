package utility.logger;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CustomLoggerAttribute {

	private String method;
	private String path;
	private String clientIP;
	private Map<String,String> requestHeader;
	private String responseHeader;
	private Map<String,String> parameter;
	private String requestBody;
	private String responseBody;
	private String responseCode;

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

	public Map<String,String> getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(Map<String,String> requestHeader) {
		this.requestHeader = requestHeader;
	}

	public String getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
	}

	public Map<String,String> getParameter() {
		return parameter;
	}

	public void setParameter(Map<String,String> parameter) {
		this.parameter = parameter;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

}
