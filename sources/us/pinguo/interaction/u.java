package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.HuaweiAgent;
/* compiled from: DestinationMarket.java */
/* loaded from: classes4.dex */
public class u extends us.pinguo.foundation.interaction.b {
    private static void i(Context context, String str) {
        Intent intent;
        if (us.pinguo.util.p.d()) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (HuaweiAgent.isHuaweiSupport()) {
                    intent2.setPackage("com.huawei.appmarket");
                }
                context.startActivity(intent2);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean h2 = us.pinguo.util.s.h("com.android.vending", context);
        boolean z = str.startsWith("market://") || str.startsWith("https://play.google.com");
        try {
            if (h2 && z) {
                intent = context.getPackageManager().getLaunchIntentForPackage("com.android.vending");
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
            } else {
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (HuaweiAgent.isHuaweiSupport() && str.startsWith("market://")) {
                    intent3.setPackage("com.huawei.appmarket");
                }
                intent = intent3;
            }
            context.startActivity(intent);
        } catch (Exception unused2) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused3) {
            }
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        i(context, uri.toString());
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        if (uri.toString().startsWith("https://play.google.com")) {
            return true;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            String uri2 = uri.toString() == null ? "NULL" : uri.toString();
            us.pinguo.foundation.e.e(new Exception("Empty Scheme URL:" + uri2));
        }
        return "market".equals(scheme);
    }
}
