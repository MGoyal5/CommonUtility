package utility.logger;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
//import lombok.extern.log4j.Log4j2;

@Component
@Log
public class LoggingServiceImpl implements LoggingService {

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void logRequest(HttpServletRequest httpServletRequest, Object body) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("REQUEST  ");

		Map<String, Object> requestBody = buildBodyMap(body);

		Map<String, String> parameters = buildParametersMap(httpServletRequest);
		Map<String, String> headers = buildHeadersMap(httpServletRequest);

		CustomRequestLoggerAttributes requestAttribute = new CustomRequestLoggerAttributes();

		if (!parameters.isEmpty() || parameters != null)
			requestAttribute.setParameter(parameters);

		if (httpServletRequest.getMethod() != null)
			requestAttribute.setMethod(httpServletRequest.getMethod());

		if (httpServletRequest.getRequestURL().toString() != null)
			requestAttribute.setPath(httpServletRequest.getRequestURL().toString());

		if (headers != null)
			requestAttribute.setRequestHeader(headers);

		if (httpServletRequest.getRemoteAddr() != null)
			requestAttribute.setClientIP(httpServletRequest.getRemoteAddr());

		if (requestBody != null)
			requestAttribute.setRequestBody(requestBody);

		stringBuilder.append(converToJson(requestAttribute));

		LogHelper.info(this.getClass(), stringBuilder.toString());
	}

	@Override
	public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object body) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("RESPONSE ");

		Map<String, Object> responseBody = buildBodyMap(body);
		Map<String, String> headers = buildHeadersMap(httpServletResponse);

		CustomResponseLoggingFilter responseAttribute = new CustomResponseLoggingFilter();

		if (httpServletRequest.getMethod() != null)
			responseAttribute.setMethod(httpServletRequest.getMethod());

		if (httpServletRequest.getRequestURL().toString() != null)
			responseAttribute.setPath(httpServletRequest.getRequestURL().toString());

		if (headers != null)
			responseAttribute.setResponseHeader(headers);

		if (httpServletRequest.getRemoteAddr() != null)
			responseAttribute.setClientIP(httpServletRequest.getRemoteAddr());

		if (responseBody != null)
			responseAttribute.setResponseBody(responseBody);

		if (httpServletResponse.getStatus() != 0)
			responseAttribute.setResponseCode(httpServletResponse.getStatus());

		stringBuilder.append(converToJson(responseAttribute));
		LogHelper.info(this.getClass(), stringBuilder.toString());
	}

	private Map<String, String> buildParametersMap(HttpServletRequest httpServletRequest) {
		Map<String, String> resultMap = new HashMap<>();
		Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = httpServletRequest.getParameter(key);
			resultMap.put(key, value);
		}

		return resultMap;
	}

	private Map<String, Object> buildBodyMap(Object obj) {
		if (obj != null) {
			Map<String, Object> resultMap = mapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
			});
			return resultMap;
		}

		return null;
	}

	private Map<String, String> buildHeadersMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}

		return map;
	}

	private Map<String, String> buildHeadersMap(HttpServletResponse response) {
		Map<String, String> map = new HashMap<>();

		Collection<String> headerNames = response.getHeaderNames();
		for (String header : headerNames) {
			map.put(header, response.getHeader(header));
		}

		return map;
	}

	private String converToJson(Object obj) {
		String jsonObj = null;
		try {
			jsonObj = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}
}