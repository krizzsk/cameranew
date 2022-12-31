package j.a.f;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import org.json.JSONObject;
import us.pinguo.common.b;
import us.pinguo.common.j;
import us.pinguo.common.k;
import us.pinguo.common.l;
/* compiled from: StatInit.java */
/* loaded from: classes6.dex */
public class g {
    private static boolean a = true;
    private static boolean b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StatInit.java */
    /* loaded from: classes6.dex */
    public static class b extends k {
        private b() {
        }

        @Override // us.pinguo.common.i
        public void b(Context context, String str, j... jVarArr) {
            if (g.b) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < jVarArr.length; i2++) {
                    j jVar = jVarArr[i2];
                    sb.append(jVar.b());
                    sb.append("=");
                    String c = jVar.c();
                    if (c == null) {
                        c = "";
                    }
                    sb.append(c);
                    if (i2 < jVarArr.length - 1) {
                        sb.append(",");
                    }
                }
                e.onEvent(str, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StatInit.java */
    /* loaded from: classes6.dex */
    public static class c extends k {
        private c() {
        }

        @Override // us.pinguo.common.i
        public void b(Context context, String str, j... jVarArr) {
            if (g.a) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (j jVar : jVarArr) {
                        jSONObject.put(jVar.b(), jVar.c());
                    }
                    AbstractGrowingIO.getInstance().track(str, jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StatInit.java */
    /* loaded from: classes6.dex */
    public static class d extends k {
        private d() {
        }

        @Override // us.pinguo.common.i
        public void b(Context context, String str, j... jVarArr) {
            if (g.b) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < jVarArr.length; i2++) {
                    j jVar = jVarArr[i2];
                    sb.append(jVar.b());
                    sb.append("=");
                    String c = jVar.c();
                    if (c == null) {
                        c = "";
                    }
                    sb.append(c);
                    if (i2 < jVarArr.length - 1) {
                        sb.append(",");
                    }
                }
                String sb2 = sb.toString();
                Log.d("C360_STAT", str + " " + sb2);
            }
        }
    }

    public static void c(Application application) {
        d(application, true, true);
    }

    public static void d(Application application, boolean z, boolean z2) {
        a = z;
        b = z2;
        b.C0374b c0374b = new b.C0374b();
        c0374b.b(new d());
        c0374b.d(false);
        c0374b.a(1, new b());
        c0374b.a(4, new c());
        l.a().b(application, c0374b.c(), null);
    }

    public static void e(boolean z) {
        a = z;
    }

    public static void f(boolean z) {
        b = z;
    }
}
