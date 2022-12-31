package d.a.a.a.a.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: GPDownLoader.java */
/* loaded from: classes.dex */
public class a implements b {
    private WeakReference<Context> a;
    private com.bytedance.sdk.openadsdk.core.d.b b;
    private h c;

    /* renamed from: d  reason: collision with root package name */
    private String f8497d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8498e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f8499f = new AtomicBoolean(false);

    public a(Context context, h hVar, String str) {
        this.a = new WeakReference<>(context);
        this.c = hVar;
        o.c("GPDownLoader", hVar.Z().toString());
        this.b = hVar.K();
        this.f8497d = str;
        o.c("GPDownLoader", "====tag===" + str);
        if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
            com.bytedance.sdk.openadsdk.core.o.a(context);
        }
    }

    private Context f() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? com.bytedance.sdk.openadsdk.core.o.a() : this.a.get();
    }

    @Override // d.a.a.a.a.a.b
    public void a() {
        if (f() == null || this.b == null || d()) {
            return;
        }
        if (e()) {
            this.f8499f.set(true);
        } else {
            c();
        }
    }

    @Override // d.a.a.a.a.a.b
    public void a(boolean z) {
    }

    public boolean b(Context context, String str) {
        Intent launchIntentForPackage;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        o.c("GPDownLoader", "gotoGooglePlay :market://details?id=" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse("market://details?id=" + str);
        intent.setData(parse);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.equals("com.android.vending") && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending")) != null) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                launchIntentForPackage.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                launchIntentForPackage.setData(parse);
                if (!(context instanceof Activity)) {
                    launchIntentForPackage.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                }
                context.startActivity(launchIntentForPackage);
                return true;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        if (!(context instanceof Activity)) {
            intent2.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
        context.startActivity(intent2);
        return true;
    }

    @Override // d.a.a.a.a.a.b
    public boolean c() {
        this.f8499f.set(true);
        return this.b != null && b(f(), this.b.c());
    }

    @Override // d.a.a.a.a.a.b
    public boolean d() {
        Intent a;
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.b;
        if (bVar == null) {
            return false;
        }
        String c = bVar.c();
        if (TextUtils.isEmpty(c) || !ab.b(f(), c) || (a = ab.a(f(), c)) == null) {
            return false;
        }
        a.putExtra("START_ONLY_FOR_ANDROID", true);
        f().startActivity(a);
        d.f(f(), this.c, this.f8497d, "click_open", null);
        return true;
    }

    public boolean e() {
        if (this.c.L() != null) {
            String a = this.c.L().a();
            if (!TextUtils.isEmpty(a)) {
                Uri parse = Uri.parse(a);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (ab.a(f(), intent)) {
                    if (!(f() instanceof Activity)) {
                        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    }
                    f().startActivity(intent);
                    d.f(com.bytedance.sdk.openadsdk.core.o.a(), this.c, this.f8497d, "open_url_app", null);
                    k.a().a(this.c, this.f8497d);
                    return true;
                }
            }
            if (!this.f8498e || this.f8499f.get()) {
                this.f8498e = true;
                d.f(f(), this.c, this.f8497d, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
