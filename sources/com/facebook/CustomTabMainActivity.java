package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.t;
import com.facebook.internal.x;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public class CustomTabMainActivity extends Activity {
    public static final String c = CustomTabMainActivity.class.getSimpleName() + ".extra_action";

    /* renamed from: d  reason: collision with root package name */
    public static final String f2238d = CustomTabMainActivity.class.getSimpleName() + ".extra_params";

    /* renamed from: e  reason: collision with root package name */
    public static final String f2239e = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";

    /* renamed from: f  reason: collision with root package name */
    public static final String f2240f = CustomTabMainActivity.class.getSimpleName() + ".extra_url";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2241g = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";

    /* renamed from: h  reason: collision with root package name */
    public static final String f2242h = CustomTabMainActivity.class.getSimpleName() + ".no_activity_exception";
    private boolean a = true;
    private BroadcastReceiver b;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
            intent2.setAction(CustomTabMainActivity.f2241g);
            String str = CustomTabMainActivity.f2240f;
            intent2.putExtra(str, intent.getStringExtra(str));
            intent2.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(intent2);
        }
    }

    private static Bundle a(String str) {
        Uri parse = Uri.parse(str);
        Bundle e0 = x.e0(parse.getQuery());
        e0.putAll(x.e0(parse.getFragment()));
        return e0;
    }

    private void b(int i2, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.b);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(f2240f);
            Intent n = t.n(getIntent(), stringExtra != null ? a(stringExtra) : new Bundle(), null);
            if (n != null) {
                intent = n;
            }
            setResult(i2, intent);
        } else {
            setResult(i2, t.n(getIntent(), null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = CustomTabActivity.b;
        if (str.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(c);
            Bundle bundleExtra = getIntent().getBundleExtra(f2238d);
            boolean b = new com.facebook.internal.d(stringExtra, bundleExtra).b(this, getIntent().getStringExtra(f2239e));
            this.a = false;
            if (!b) {
                setResult(0, getIntent().putExtra(f2242h, true));
                finish();
                return;
            }
            this.b = new a();
            LocalBroadcastManager.getInstance(this).registerReceiver(this.b, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        if (f2241g.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.c));
            b(-1, intent);
        } else if (CustomTabActivity.b.equals(intent.getAction())) {
            b(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.a) {
            b(0, null);
        }
        this.a = true;
    }
}
