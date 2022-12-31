package com.pinguo.camera360.camera.options;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.growingio.android.sdk.collection.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: FeedbackLauncher.kt */
/* loaded from: classes3.dex */
public final class l0 {
    public static final l0 a = new l0();

    private l0() {
    }

    private final String a(String str, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("avatar=");
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append("&");
            sb.append("nickname=");
            sb.append(URLEncoder.encode(str2, "UTF-8"));
            sb.append("&");
            sb.append("openid=");
            sb.append(str3);
            sb.append("&");
            sb.append("clientInfo=");
            sb.append(Build.MODEL);
            sb.append("&");
            Context d2 = BaseApplication.d();
            sb.append("clientVersion=");
            sb.append(us.pinguo.foundation.utils.h0.d(d2));
            sb.append("&");
            sb.append("os=");
            sb.append(Constants.PLATFORM_ANDROID);
            sb.append("&");
            sb.append("osVersion=");
            sb.append(kotlin.jvm.internal.s.q("", Build.VERSION.RELEASE));
            sb.append("&");
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "dataBuilder.toString()");
            return sb2;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final void b(Context context) {
        String str;
        String str2;
        kotlin.jvm.internal.s.h(context, "context");
        if (!Conditions.d() && !Conditions.e() && !Conditions.c()) {
            l0 l0Var = a;
            String string = context.getString(R.string.temp_name_feedback);
            if (User.d().n()) {
                str2 = User.d().e();
                str = User.d().h().nickname;
            } else {
                str = string;
                str2 = "https://phototask.c360dn.com/FjgkR7aACTnAn8lbOE-WQmJe1of2";
            }
            String openId = j.a.f.e.a(BaseApplication.d());
            kotlin.jvm.internal.s.g(openId, "openId");
            String a2 = l0Var.a(str2, str, openId);
            Intent intent = new Intent();
            intent.setClassName(context, "com.pinguo.camera360.lib.ui.WebViewActivity");
            intent.putExtra("web_view_url", "https://support.qq.com/product/17528");
            intent.putExtra("web_view_data", a2);
            intent.putExtra("web_view_back_finsih", false);
            intent.putExtra("web_view_can_go_back", false);
            context.startActivity(intent);
            return;
        }
        k.a.a.b(context);
    }
}
