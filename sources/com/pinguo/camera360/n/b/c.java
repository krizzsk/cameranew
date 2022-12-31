package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.foundation.interaction.AppGoto;
/* compiled from: PushNoProxy.java */
/* loaded from: classes3.dex */
public class c {
    public Intent a(Context context, String str) {
        us.pinguo.common.log.a.m("PushNoProxy", str, new Object[0]);
        if (str.contains("pcmessagelist")) {
            Intent intent = new Intent();
            intent.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageNoticeActivity");
            intent.putExtra("select_notice_tab", 2);
            return intent;
        } else if (str.equals("app://inspire/comment")) {
            Intent intent2 = new Intent();
            intent2.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageCommentActivity");
            intent2.putExtra("KEY_MESSAGE_TYPE", MessageType.COMMENT);
            return intent2;
        } else if (str.equals("app://inspire/at")) {
            Intent intent3 = new Intent();
            intent3.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageCommentActivity");
            intent3.putExtra("KEY_MESSAGE_TYPE", MessageType.AT);
            return intent3;
        } else if (str.equals("app://inspire/like")) {
            Intent intent4 = new Intent();
            intent4.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageCommentActivity");
            intent4.putExtra("KEY_MESSAGE_TYPE", MessageType.LIKE);
            return intent4;
        } else if (str.equals("app://inspire/vote")) {
            Intent intent5 = new Intent();
            intent5.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageNoticeActivity");
            intent5.putExtra("select_notice_tab", 1);
            return intent5;
        } else if (str.equals("app://inspire/award")) {
            Intent intent6 = new Intent();
            intent6.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageNoticeActivity");
            intent6.putExtra("select_notice_tab", 2);
            return intent6;
        } else if (str.equals("app://inspire/attention")) {
            Intent intent7 = new Intent();
            intent7.setClassName(context, "us.pinguo.inspire.module.message.category.activity.InspireMessageFansActivity");
            return intent7;
        } else if (str.equals("app://inspire/system")) {
            return AppGoto.getInstance().c("app://camera360/portal/message").a(context);
        } else {
            return null;
        }
    }
}
