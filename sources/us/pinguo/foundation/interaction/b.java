package us.pinguo.foundation.interaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import us.pinguo.foundation.base.InspireRedirectActivity;
/* compiled from: DefaultActionRule.java */
/* loaded from: classes4.dex */
public class b implements a {
    /* JADX INFO: Access modifiers changed from: protected */
    public static Bundle g(Uri uri) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Bundle bundle = new Bundle();
        for (String str : queryParameterNames) {
            bundle.putString(str, uri.getQueryParameter(str));
        }
        return bundle;
    }

    private static String h(Uri uri) {
        return uri.getAuthority() + uri.getPath().replaceAll("/", ".");
    }

    @Override // us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        if (!c(uri, bundle)) {
            return new Intent();
        }
        String h2 = h(uri);
        boolean z = !TextUtils.isEmpty(uri.getQuery());
        if (!TextUtils.isEmpty(h2)) {
            Intent intent = new Intent(h2);
            if (z) {
                intent.putExtras(g(uri));
            }
            return intent;
        }
        return new Intent();
    }

    @Override // us.pinguo.foundation.interaction.a
    public void b(Uri uri, Context context, Intent intent) {
        if (intent != null) {
            try {
                context.startActivity(intent);
            } catch (Throwable th) {
                us.pinguo.foundation.e.e(th);
            }
        }
    }

    @Override // us.pinguo.foundation.interaction.a
    public boolean c(Uri uri, Bundle bundle) {
        return true;
    }

    @Override // us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return true;
    }

    public void e(Uri uri, Activity activity, Intent intent, int i2) {
        if (intent != null) {
            try {
                activity.startActivityForResult(intent, i2);
            } catch (Throwable th) {
                us.pinguo.foundation.e.e(th);
            }
        }
    }

    public void f(Uri uri, InspireRedirectActivity inspireRedirectActivity, Intent intent, us.pinguo.foundation.proxy.c cVar) {
        if (intent != null) {
            try {
                inspireRedirectActivity.startActivityForResult(intent, cVar);
            } catch (Throwable th) {
                us.pinguo.foundation.e.e(th);
            }
        }
    }
}
