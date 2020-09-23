package utility.logger;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class CustomeRequestLoggingFilter extends CommonsRequestLoggingFilter{

	public CustomeRequestLoggingFilter() {
		// TODO Auto-generated constructor stub
		 	super.setMaxPayloadLength(10000);
	        super.setIncludePayload(true);
	        super.setIncludeQueryString(true);
	        super.setIncludeHeaders(true);
	        super.setIncludeClientInfo(true);
	        super.setBeforeMessagePrefix("REQUEST DATA : ");
	        super.setAfterMessagePrefix("RESPONSE DATA : ");
	}
}
