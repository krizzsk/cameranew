package us.pinguo.smaatoapi.network;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.smaatoapi.R;
/* compiled from: SslManager.java */
/* loaded from: classes6.dex */
public final class b {
    private static List<String> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SslManager.java */
    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        final /* synthetic */ SslErrorHandler a;
        final /* synthetic */ String b;

        a(SslErrorHandler sslErrorHandler, String str) {
            this.a = sslErrorHandler;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -1) {
                this.a.proceed();
                if (TextUtils.isEmpty(this.b) || b.a.contains(this.b)) {
                    return;
                }
                b.a.add(this.b);
                return;
            }
            this.a.cancel();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("qq.com");
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getAuthority();
    }

    private static String c(String str) {
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

    public static AlertDialog d(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(charSequence)) {
            builder.setTitle(charSequence);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            builder.setMessage(charSequence2);
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            builder.setPositiveButton(charSequence3, onClickListener);
        }
        if (!TextUtils.isEmpty(charSequence4)) {
            builder.setNegativeButton(charSequence4, onClickListener);
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
        VdsAgent.showDialog(create);
        return create;
    }

    public static void e(Activity activity, String str, SslErrorHandler sslErrorHandler) {
        if (TextUtils.isEmpty(str)) {
            sslErrorHandler.proceed();
            return;
        }
        String b = b(str);
        String c = c(b);
        if (!TextUtils.isEmpty(c) && a.contains(c)) {
            sslErrorHandler.proceed();
            return;
        }
        if (b == null) {
            b = "unknow";
        }
        AlertDialog d2 = d(activity, activity.getString(R.string.ssl_trust_title), activity.getString(R.string.ssl_trust_content, new Object[]{b}), activity.getString(R.string.ssl_trust_continue), activity.getString(R.string.ssl_trust_cancel), new a(sslErrorHandler, c));
        d2.setCanceledOnTouchOutside(false);
        try {
            d2.show();
            VdsAgent.showDialog(d2);
        } catch (Exception unused) {
        }
    }
}
