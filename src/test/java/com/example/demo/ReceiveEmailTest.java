package com.example.demo;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.example.demo.util.MailUtil;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

/**
 * 使用imap协议获取未读邮件数
 *
 * @author w
 *
 */
public class ReceiveEmailTest {


    public static void main(String[] args) throws Exception {
        String user = "396881692@qq.com";// 邮箱的用户名
        String password = "tvytmcgbqiukbhjb"; // 邮箱的密码

        Properties prop = System.getProperties();
        prop.put("mail.store.protocol", "imap");
        prop.put("mail.imap.host", "imap.qq.com");

        Session session = Session.getInstance(prop);

        int total = 0;
        IMAPStore store = (IMAPStore) session.getStore("imap"); // 使用imap会话机制，连接服务器
        store.connect(user, password);
        IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
        folder.open(Folder.READ_WRITE);
        // 获取总邮件数
        total = folder.getMessageCount();
        System.out.println("-----------------共有邮件：" + total
                + " 封--------------");
        System.out.println("---------------共有未读邮件: " + folder.getUnreadMessageCount() + "封-------------");
        // 得到收件箱文件夹信息，获取邮件列表
        System.out.println("未读邮件数：" + folder.getUnreadMessageCount());
        Message[] messages = folder.getMessages(folder.getMessageCount()-folder.getUnreadMessageCount()+1,folder.getMessageCount());
        for (int i = 0, count = messages.length; i < count; i++) {
            MimeMessage msg = (MimeMessage) messages[i];
            Flags flags = messages[i].getFlags();
            if (!flags.contains(Flags.Flag.SEEN)) {
                // 设置邮件已读
                msg.setFlag(Flags.Flag.SEEN, true);
                System.out.println("------------------解析第" + msg.getMessageNumber() + "封未读邮件-------------------- ");
                System.out.println("主题: " + MailUtil.getSubject(msg));
                System.out.println("发件人: " + MailUtil.getFrom(msg));
                System.out.println("收件人：" + MailUtil.getReceiveAddress(msg, null));
                System.out.println("发送时间：" + MailUtil.getSentDate(msg, null));
                System.out.println("邮件优先级：" + MailUtil.getPriority(msg));
                System.out.println("是否需要回执：" + MailUtil.isReplySign(msg));
                System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
                boolean isContainerAttachment = MailUtil.isContainAttachment(msg);
                System.out.println("是否包含附件：" + isContainerAttachment);
                if (isContainerAttachment) {
                    MailUtil.saveAttachment(msg, "f:\\mailTest\\"+msg.getSubject() + "_"+i+"_"); //保存附件
                }
                StringBuffer content = new StringBuffer(30);
                MailUtil.getMailTextContent(msg, content);
                System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0,100) + "..." : content));
                System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
                System.out.println();
            }


        }

        // 释放资源
        if (folder != null)
            folder.close(true);
        if (store != null)
            store.close();
    }

}
