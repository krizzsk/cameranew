package us.pinguo.user.request;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import us.pinguo.foundation.utils.p;
import us.pinguo.user.LoginConfig;
import us.pinguo.user.t0;
/* compiled from: WebviewLogin.java */
/* loaded from: classes6.dex */
abstract class o<V> extends j.a.c.a.a<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    public o(Context context) {
        super(context);
    }

    private void a(String str, String str2, boolean z) {
        String str3;
        HashMap hashMap = new HashMap();
        LoginConfig.b(this.mContext, hashMap);
        hashMap.put("siteCode", p.a(str));
        hashMap.put("source", p.a(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE));
        hashMap.put("redirect", p.a("1"));
        us.pinguo.foundation.m.d.b(hashMap);
        try {
            str3 = p.c(str2, hashMap);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str3 = "";
        }
        us.pinguo.common.log.a.m("test", "第三方登录的地址:" + str3, new Object[0]);
        Intent intent = new Intent();
        intent.setClassName(this.mContext, "us.pinguo.user.ui.PGLoginWebActivity");
        intent.putExtra("WEB_PATH", str3);
        intent.putExtra("success_url", "/api/third/login/callbackResult");
        intent.putExtra("loginmode", str);
        intent.putExtra("bind_account", z);
        this.mContext.startActivity(intent);
    }

    public void b(String str) {
        a(str, t0.z, false);
    }
}
