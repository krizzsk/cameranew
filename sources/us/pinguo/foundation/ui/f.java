package us.pinguo.foundation.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.R;
import us.pinguo.foundation.utils.w;
/* compiled from: SslManager.java */
/* loaded from: classes4.dex */
public final class f {
    private static List<String> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("qq.com");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getAuthority();
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        int i2 = 1;
        if (split.length <= 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i2 <= split.length - 2) {
            sb.append(split[i2]);
            sb.append('.');
            i2++;
        }
        sb.append(split[i2]);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(SslErrorHandler sslErrorHandler, String str, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            sslErrorHandler.proceed();
            if (TextUtils.isEmpty(str) || a.contains(str)) {
                return;
            }
            a.add(str);
            return;
        }
        sslErrorHandler.cancel();
    }

    public static void d(Activity activity, String str, final SslErrorHandler sslErrorHandler) {
        if (TextUtils.isEmpty(str)) {
            sslErrorHandler.proceed();
            return;
        }
        String a2 = a(str);
        final String b = b(a2);
        if (!TextUtils.isEmpty(b) && a.contains(b)) {
            sslErrorHandler.proceed();
            return;
        }
        if (a2 == null) {
            a2 = "unknow";
        }
        AlertDialog h2 = w.h(activity, activity.getString(R.string.ssl_trust_title), activity.getString(R.string.ssl_trust_content, new Object[]{a2}), activity.getString(R.string.ssl_trust_continue), activity.getString(R.string.ssl_trust_cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.foundation.ui.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                f.c(sslErrorHandler, b, dialogInterface, i2);
            }
        });
        h2.setCanceledOnTouchOutside(false);
        try {
            h2.show();
            VdsAgent.showDialog(h2);
        } catch (Exception unused) {
        }
    }
}
