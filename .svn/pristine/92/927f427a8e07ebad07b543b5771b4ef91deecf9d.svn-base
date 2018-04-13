package jp.terasoluna.thin.tutorial.web.common.controller;

import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;

public class Message {
	public static BLogicResult getMessage(String message, int num) {
		BLogicResult result = new BLogicResult();
		if (num == 0) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message));
			result.setErrors(messages);
			result.setResultString("failure");
		} else if (num == 1) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message));
			result.setMessages(messages);
			result.setResultString("success");
		}
		return result;
	}
	public static BLogicResult getMessage1(String message, int num,
			String value1) {
		BLogicResult result = new BLogicResult();
		if (num == 0) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message, value1));
			result.setErrors(messages);
			result.setResultString("failure");
		} else if (num == 1) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message, value1));
			result.setMessages(messages);
			result.setResultString("success");
		}
		return result;
	}

	public static BLogicResult getMessage2(String message, int num,
			String value1, String value2) {

		BLogicResult result = new BLogicResult();
		if (num == 0) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message, value1, value2));
			result.setErrors(messages);
			result.setResultString("failure");
		} else if (num == 1) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(message, value1, value2));
			result.setMessages(messages);
			result.setResultString("success");
		}

		return result;
	}
}
