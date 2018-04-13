package jp.terasoluna.thin.tutorial.web.common.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Mail {

	public static boolean send(String from, String password, String sendTo,
			String ccTo, String bccTo, String subject, String content,
			String fileAffix) {

		// 配置发�?邮件�?���?���?
		final Properties props = new Properties();
		/*
		 * 可用�?���???mail.store.protocol / mail.transport.protocol / mail.host /
		 * mail.user / mail.from
		 */
		// 表示SMTP发�?邮件?�需要进行身份验�?
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.host", "smtp.trans-cosmos.com.cn");
		// 发件人�?��号
		props.put("mail.user", from);
		// 访问SMTP服务时�?��提供的�??
		props.put("mail.password", password);

		// �?��授权信息?�用于进行SMTP进行身份验�?
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名�?�??
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环�?���?和授�?��息?��?建邮件会�?
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消�?
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form;
		try {
			Multipart mp = new MimeMultipart();

			form = new InternetAddress(props.getProperty("mail.user"));

			message.setFrom(form);

			// 设置收件人
			InternetAddress to = new InternetAddress(sendTo);
			message.setRecipient(RecipientType.TO, to);

			// 设置�??
			if (null != ccTo) {
				InternetAddress cc = new InternetAddress(ccTo);
				message.setRecipient(RecipientType.CC, cc);
			}

			// 设置�???��?他的收件人不�?看到�??�?��件地�?
			if (null != bccTo) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.setRecipient(RecipientType.BCC, bcc);
			}
			// 设置邮件�?�?
			try {
				String subjectText = MimeUtility.encodeText(subject,MimeUtility.mimeCharset("UTF-8"), null);
				message.setSubject(subjectText);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + content, "text/html;charset=utf-8");
			mp.addBodyPart(bp);
			if (null != fileAffix) {
				FileDataSource fileds = new FileDataSource(fileAffix);
				bp = new MimeBodyPart();
				bp.setDataHandler(new DataHandler(fileds));
				bp.setFileName(fileds.getName());
				mp.addBodyPart(bp);
			}
			// 设置邮件�??容�?
			message.setContent(mp);

			// 发�?邮件
			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			return false;
		}
	}

	//收件人和cc人为多个的时候，用此方法
	public static boolean sendAll(String from, String password, InternetAddress[] sendTo,
			InternetAddress[] ccTo, String bccTo, String subject, String content,
			String fileAffix) {

		// 配置发�?邮件�?���?���?
		final Properties props = new Properties();
		/*
		 * 可用�?���???mail.store.protocol / mail.transport.protocol / mail.host /
		 * mail.user / mail.from
		 */
		// 表示SMTP发邮件需要进行身份验证
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.host", "smtp.trans-cosmos.com.cn");
		// 发件人�?��号
		props.put("mail.user", from);
		// 访问SMTP服务时�?��提供的�??
		props.put("mail.password", password);

		// 授权信息用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名�?�??
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环�?���?和授�?��息?��?建邮件会�?
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消�?
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form;
		try {
			Multipart mp = new MimeMultipart();

			form = new InternetAddress(props.getProperty("mail.user"));

			message.setFrom(form);

			// 设置收件人
			message.setRecipients(RecipientType.TO, sendTo);

			// 设置�??
			if (null != ccTo) {
				message.setRecipients(RecipientType.CC, ccTo);
			}

			// 设置�???��?他的收件人不�?看到�??�?��件地�?
			if (null != bccTo) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.setRecipient(RecipientType.BCC, bcc);
			}
			// 设置邮件�?�?
			try {
				String subjectText = MimeUtility.encodeText(subject,MimeUtility.mimeCharset("UTF-8"), null);
				message.setSubject(subjectText);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			BodyPart bp = new MimeBodyPart();
			bp.setContent("" + content, "text/html;charset=utf-8");
			mp.addBodyPart(bp);
			if (null != fileAffix) {
				FileDataSource fileds = new FileDataSource(fileAffix);
				bp = new MimeBodyPart();
				bp.setDataHandler(new DataHandler(fileds));
				bp.setFileName(fileds.getName());
				mp.addBodyPart(bp);
			}
			// 设置邮件�??容�?
			message.setContent(mp);

			// 发�?邮件
			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
}
