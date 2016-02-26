package com.bsb.valise.utils;

public class ValiseRequestUtils {
/*
	// private static Gson gson = new Gson();
	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	private static final String jsonContentType = "application/json";
	private static Logger logger = LoggerFactory.getLogger(ValiseRequestUtils.class.getCanonicalName());

	public static <T> HttpServletResponse sendMyAirtelAppThirdPartyErrorResponse() {

		ValiseResponseCodes resCode = ValiseResponseCodes.THIRD_PARTY_ERROR;
		HttpServletResponse response = sendErrorResponse(resCode, null);
		return response;
	}


	public static <T> HttpServletResponse sendErrorResponse(String responseCode, String responseMessage, T data) {

		String responseStr = gson.toJson(APIResponse.getErrorResponse(responseCode, responseMessage, data));
		HttpServletResponse response = logAndSendResponse(responseStr, jsonContentType, HttpResponseStatus.OK, responseCode,
				responseMessage);
		return response;
	}

	@SuppressWarnings("rawtypes")
	public static <T> HttpServletResponse sendSuccessResponse(T obj) {
		APIResponse apiResponse = APIResponse.getSuccessResponse(obj);
		HttpServletResponse response = logAndSendResponse(gson.toJson(apiResponse), jsonContentType, HttpServletResponse.SC_OK,
				"0", "success");
		return response;

	}
	
	public static <T> HttpServletResponse sendErrorResponse(ValiseResponseCodes resCode) {

		return sendErrorResponse(resCode, null);
	}

	public static <T> HttpServletResponse sendErrorResponse(ValiseResponseCodes resCode, T data) {

		String responseStr = gson
				.toJson(APIResponse.getErrorResponse(resCode.getResponseCode(), resCode.getResponseMessage(), data));
		HttpResponse response = logAndSendResponse(responseStr, jsonContentType, HttpResponseStatus.OK,
				resCode.getResponseCode(), resCode.getResponseMessage());
		return setResponseHeaders(false, response);
	}

	public static <T> HttpResponse sendErrorResponseWithoutLog(ValiseResponseCodes resCode, T data) {

		String responseStr = gson
				.toJson(APIResponse.getErrorResponse(resCode.getResponseCode(), resCode.getResponseMessage(), data));
		HttpResponse response = Utils.createResponse(responseStr, jsonContentType, HttpResponseStatus.OK);
		return setResponseHeaders(false, response);
	}

	public static <T> String getApiResponseString(APIResponse<T> apiResponse) {
		String response = gson.toJson(apiResponse);
		return response;
	}

	public static <T> String getResponseString(T apiResponse) {
		String response = gson.toJson(apiResponse);
		return response;
	}

	*/

}
