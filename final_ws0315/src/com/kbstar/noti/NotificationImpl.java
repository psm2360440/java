package com.kbstar.noti;

import com.kbstar.frame.Notification;

public class NotificationImpl implements Notification{

	@Override
	public void sendSMS(String contact, String msg) throws Exception {
		System.out.printf("%s에게 다음 메시지를 전송하였습니다. \n내용: %s \n", contact, msg);
	}

}