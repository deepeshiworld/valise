package com.bsb.valise.common;

import java.util.HashMap;
import java.util.Map;

public enum ValiseResponseCodes {
	
	//app errors
	BAD_REQUEST("-1","BAD REQUEST"),
	BAD_REQUEST_NO_MSISDN("-101","BAD REQUEST NO MSISDN FOUND"),
	
	//IBM errors
	THIRD_PARTY_ERROR("-200","Something seems to have gone wrong. Please try again later."),
	//THIRD_PARTY_ERROR("-200","Dear Customer, our servers are being upgraded and hence are unavailable till 4 pm today. Inconvenience is regretted."),

	OTP_FAILED("-201","ERROR: Otp verification failed. Please retry"),
	ERROR_FETCHING_SSO_RESPONSE("-202","ERROR: SSO response fetch issue"),
	ERROR_FINDING_PRODUCT_RESPONSE("-203","ERROR: Product is not found"),
	ERROR_GETTING_PRODUCT_DETAILS_RESPONSE("-204","ERROR: Product details are not found"),
	ERROR_IN_LEEDS_RESPONSE("-205","ERROR: Processing request failed."),
	ERROR_PRODUCT_ADDED_BUT_FETCH_FAILED("-206", "Product has been added successfully. Product info will reflect after some time."),
	
	//back end errors
	ERROR_INTERNAL_SERVER("-300", "ERROR: Something went wrong while processing request."),
	ERROR_USER_NOT_FOUND("-301", "ERROR: No records found for user."),
	ERROR_UPDATING_USER("-302", "ERROR: user updation issues."),
	ERROR_CREATING_USER("-303", "ERROR: user creation issues."),
	ERROR_UPDATING_FROM_S3("-304", "ERROR: updation issue from s3."),
	ERROR_UPDATING("-305", "ERROR: updation."),
	ERROR_SMARTBYTE_DISABLED("-306", "Sorry! No data packs available for your region." ),
	ERROR_INVALID_RESPONSE("-307", "ERROR: Response recieved is invalid."),
	ERROR_NO_RECORDS("-308", "No Records found"),
	ERROR_PROCESSING_REQUEST("-309", "Error Processing request."),
	
	//user errors
	ERROR_PRODUCT_ALREADY_ADDED("-400", "Product already added."),
	ERROR_DOB_ALREADY_ADDED("-401", "Thanks. We have already received your details."),
	
	//promo code erros
	PROMO_CODE_INVALID("-501","Invalid Promo Code"),
	PROMO_TYPE_INVALID("-502","Invalid Promo Type"),
	NUMBER_INVALID("-503","Invalid Number"),
	
	// REFERER
	REFERRER_ERROR_PARSING("-600","Error while parsing Referral Logs. Please contact the Tech Team."),
	REFERRER_NOT_FOUND("-601","Sorry! No referrer history for you."),
	REFERRER_CAMPAIGN_ENDS("-602","Refferal Campaign was live for limited period , we will come back soon. !"),
	
	//Night CashBack
	NIGHT_CASHBACK_ACTIVATION_FAILED("-700","Dear Customer, your request to activate Night Cashback offer could not be processed at this moment. Please retry after some time."),
	NIGHT_CASHBACK_ALREADY_ACTIVE("-701","Dear Customer, Night cashback offer is already active on your airtel number."),
	DISABLED_POSTPAID_NIGHT_CASHBACK("-702","This service for postpaid will be launching soon. Please try again later."),
	
	MYPLAN_PLANS_NOT_FOUND("-720", "Sorry! No Plans found for your circle."),
	MYPLAN_FREEPACK_NOT_FOUND("-721", "Sorry! No Freepack found for this plan."),
	MYPLAN_BOOSTERS_NOT_FOUND("-722", "Sorry! No Boosters found for you."),
	FREEPACK_BOOSTER_DIFFERENT_TYPE("-723", "Selected internet pack in freepack and booster should be of same type."),
		
	ERROR_PACKS_NOT_AVAILABLE("-740", "Sorry! No packs available"),
    ERROR_PACKS_NOT_AVAILABLE_FOR_AMOUNT("-741", "Currently no pack available for this amount.");

	public enum MessageTypes{
		
		OTP_SENT("OTP sent."),
		OTP_FAILED("OTP failed."),
		OTP_EXPIRED("OTP expired."),
		
		SUCCESSFULLY_UPLOADED("Successfully uploaded"),
		SUCCESSFULLY_DOWNLOADED("Successfully downloaded"),
		
		INVALID_REQUEST_FIELDS("Request fields missing or invalid."),
		ERROR_PARSING_PAYLOAD("Failed to parse request payload."),
		ERROR_IN_LOB("Lob not supported."),
		ERROR_IN_PRODUCT_DETAILS("Product details are not found."),
		DEVICE_CLIENT_ID_MISING("No User or device client id found. Please re register."),
		MSISDN_NOT_FOUND("Msisdn not found in request header or payload."),
		MSISDN_NOT_FOUND_IN_CONTEXT("Msisdn is not found in context"),
		SUCCESSFUL_IN_UPDATING("Successfully updated"),
		FAILURE_IN_UPDATING("Failure in updating"),
		ALREADY_UPDATED("Already updated"),
		
		//Payment gateway specific
		TOKEN_NOT_FOUND("Payment gateway Token not found"),
		LOB_NOT_FOUND("LOB not found"),
		MANDATORY_PARAMETER_MISSING("MANDATORY PARAMETER MISSING"),
		RESPONSE_PARSING_ERROR("ERROR PARSING PAYMENT GATEWAY RESPONSE"),
		RESPONSE_FETCHING_ERROR("ERROR FETCHING PAYMENT GATEWAY RESPONSE"),
		RESPONSE_FAILURE_STATUS("FAILURE RESPONSE RECIEVED FROM PAYMENT GATEWAY"),
		
		//Offer specific
		NO_SUCH_OFFER_CODE("NO SUCH OFFER CODE"),
		NO_SUCH_OFFER_TYPE("NO SUCH OFFER TYPE"),
		INVALID_MSISDN("INVALID MSISDN"),
		INVALID_OFFER("INVALID OFFER"),
		
		//Night cashback
		INVALID_SERVICE_TYPE("Invalid Service Type"),
		
		//prepaid circle issues
		NO_CIRCLE_FOUND("This does not seem to be an Airtel Number.");
		
		
		private final String name;
		
		private MessageTypes(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
	}
	
	private final String responseCode;
	private final String responseMessage;
	
	private static Map<String, String> responseCodeToMessageMap = new HashMap<String, String>();
	
	static {
        for(ValiseResponseCodes responseCodeEnum : ValiseResponseCodes.values()) {
        	responseCodeToMessageMap.put(responseCodeEnum.getResponseCode(),responseCodeEnum.responseMessage);
        }
    }
	
	private ValiseResponseCodes(String responseCode,  String responseMessage){
		this.responseCode = responseCode;
        this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
	

}
