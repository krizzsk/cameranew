package us.pinguo.interaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: DestinationComponent.java */
/* loaded from: classes4.dex */
public class q extends us.pinguo.foundation.interaction.b {
    public static void i(Context context, String str) {
        Intent intent;
        if (us.pinguo.util.p.d()) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
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
                intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            }
            context.startActivity(intent);
        } catch (Exception unused2) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(Context context, String str, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            if (a.j.b == 0) {
                a.j.a(a.j.a);
            }
            i(context, str);
        }
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public void b(Uri uri, final Context context, Intent intent) {
        String queryParameter = uri.getQueryParameter("pkg");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(queryParameter);
        if (launchIntentForPackage == null) {
            final String queryParameter2 = uri.getQueryParameter("link");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            if (!"1".equals(uri.getQueryParameter("noTip"))) {
                us.pinguo.foundation.utils.w.k(context, Conditions.d() ? R.string.download_app_on_gp : R.string.download_app_msg, R.string.dialog_sure, R.string.dialog_cancel, true, new DialogInterface.OnClickListener() { // from class: us.pinguo.interaction.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        q.j(context, queryParameter2, dialogInterface, i2);
                    }
                });
                return;
            }
            int i2 = a.j.b;
            if (i2 == 0) {
                a.j.a(a.j.a);
            } else if (i2 == 1) {
                a.j.b(a.j.a);
            }
            i(context, queryParameter2);
            return;
        }
        context.startActivity(launchIntentForPackage);
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "component".equals(uri.getScheme());
    }
}
