package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.a.a;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c {
    private String a;
    private WeakReference<Activity> b;

    public c(Activity activity, String str) {
        this.b = new WeakReference<>(activity);
        this.a = str;
    }

    public void a(String str, String str2, String str3, ShareToContact.Request request) {
        if (TextUtils.isEmpty(str2) || request == null || this.b.get() == null || !request.checkArgs()) {
            return;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(a.InterfaceC0045a.c, this.a);
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(a.InterfaceC0045a.f1288k, this.b.get().getPackageName() + "." + str);
        }
        Bundle bundle2 = request.extras;
        if (bundle2 != null) {
            bundle.putBundle(a.InterfaceC0045a.f1282e, bundle2);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, AppUtil.buildComponentClassName(str2, str3)));
        intent.putExtras(bundle);
        intent.addFlags(32768);
        this.b.get().startActivityForResult(intent, 101);
    }
}
