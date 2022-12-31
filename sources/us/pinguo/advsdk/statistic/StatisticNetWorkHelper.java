package us.pinguo.advsdk.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.advsdk.utils.d;
/* loaded from: classes3.dex */
public class StatisticNetWorkHelper {

    /* renamed from: d  reason: collision with root package name */
    private static StatisticNetWorkHelper f9104d;
    private Context a;
    private String b;
    private long c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            StatisticNetWorkHelper.this.b = d.e(context);
            StatisticNetWorkHelper.this.c = System.currentTimeMillis();
        }
    }

    private void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.registerReceiver(new b(), intentFilter);
    }

    public static StatisticNetWorkHelper getInstance() {
        if (f9104d == null) {
            f9104d = new StatisticNetWorkHelper();
        }
        return f9104d;
    }

    public String c() {
        if (this.a == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = d.e(this.a);
        }
        return "mnc:_mcc:_netType:" + this.b + "_content:";
    }

    public void d(Context context) {
        if (this.a != null) {
            return;
        }
        this.a = context;
        f();
    }

    public boolean e() {
        if (System.currentTimeMillis() - this.c > 600000) {
            this.b = d.e(this.a);
            this.c = System.currentTimeMillis();
        }
        return !"NONETWORK".equals(this.b);
    }
}
