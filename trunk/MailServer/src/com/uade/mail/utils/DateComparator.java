package com.uade.mail.utils;

import java.util.Comparator;

import com.uade.mail.beans.MailVO;

public class DateComparator implements Comparator<MailVO> {

	@Override
	public int compare(MailVO m2, MailVO m1) {
		if(m2.getSentDate().after(m1.getSentDate()))
			return 0;
		return 1;
	}

}
