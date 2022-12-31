package us.pinguo.interaction;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: DestinationApril.java */
/* loaded from: classes4.dex */
public class i extends us.pinguo.foundation.interaction.b {
    private void i(Context context) {
        boolean e2 = us.pinguo.foundation.utils.d.e();
        Intent intent = new Intent("camera360.webview");
        if (e2) {
            intent.putExtra("web_view_url", "http://a.app.qq.com/o/simple.jsp?pkgname=us.pinguo.april_collage");
        } else {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=us.pinguo.april_collage"));
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setAction("android.intent.action.VIEW");
        }
        context.startActivity(intent);
    }

    private Intent j() {
        Context d2 = BaseApplication.d();
        if (HuaweiAgent.isHuaweiSupport()) {
            return us.pinguo.foundation.utils.d.c("us.pinguo.april_collage");
        }
        if (Conditions.d() && us.pinguo.foundation.utils.d.f(d2)) {
            return us.pinguo.foundation.utils.d.b(BaseApplication.d(), "us.pinguo.april_collage");
        }
        return us.pinguo.foundation.utils.d.d("us.pinguo.april_collage");
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        if (us.pinguo.util.s.h("us.pinguo.april_collage", context)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("us.pinguo.april_collage", "us.pinguo.april.MainActivity"));
            return intent;
        }
        return j();
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        if (us.pinguo.util.c.f12475i) {
            Toast makeText = Toast.makeText(context, (int) R.string.sdk_low, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        } else if (intent != null) {
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                i(context);
            } catch (SecurityException unused2) {
                i(context);
            }
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().startsWith("app://pinguo/april");
    }
}
