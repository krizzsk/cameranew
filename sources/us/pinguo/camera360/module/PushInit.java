package us.pinguo.camera360.module;

import android.content.Context;
import com.pinguo.camera360.k.b.a;
import us.pinguo.push.b;
import us.pinguo.push.f;
/* loaded from: classes3.dex */
public class PushInit {

    /* loaded from: classes3.dex */
    private static class b implements f.a {
        private b() {
        }

        private boolean c(String str) {
            return str.startsWith("d//") || str.startsWith("APA") || str.length() == 32 || str.length() == 44 || str.length() > 64 || str.matches("[0-9A-Za-z]+=?/*//");
        }

        @Override // us.pinguo.push.f.a
        public void a(String str, String str2, boolean z) {
            a.C0243a.i(str);
            a.g.a(str2, str);
        }

        @Override // us.pinguo.push.f.a
        public void b(String str, String str2) {
            boolean c = c(str2);
            if (!c) {
                us.pinguo.foundation.e.e(new Throwable(str + ", cid:" + str2));
            }
            us.pinguo.foundation.statistics.b.a(c);
        }
    }

    private PushInit() {
    }

    public static void initPushSDK(Context context) {
        b.C0432b c0432b = new b.C0432b();
        c0432b.a(1, com.pinguo.camera360.n.b.d.class);
        c0432b.a(2, com.pinguo.camera360.n.b.g.class);
        c0432b.a(3, com.pinguo.camera360.n.b.b.class);
        c0432b.a(7, com.pinguo.camera360.n.b.e.class);
        c0432b.a(8, com.pinguo.camera360.n.b.f.class);
        us.pinguo.pgpush.a.a(context, c0432b.b());
        us.pinguo.push.f.d(new b());
    }
}
