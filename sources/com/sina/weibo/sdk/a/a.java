package com.sina.weibo.sdk.a;

import android.content.Context;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.b;
import com.weibo.ssosdk.c;
/* loaded from: classes3.dex */
public final class a {
    public String c = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.sina.weibo.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0254a {

        /* renamed from: e  reason: collision with root package name */
        private static final a f7169e = new a();
    }

    public static void a(Context context, String str) {
        c cVar = new c();
        cVar.j(context.getApplicationContext());
        cVar.i(str);
        cVar.k("1478195010");
        cVar.l("1000_0001");
        WeiboSsoSdk.i(cVar);
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = C0254a.f7169e;
        }
        return aVar;
    }

    public final String c(Context context, String str) {
        a(context, str);
        try {
            WeiboSsoSdk.getInstance().m(new b() { // from class: com.sina.weibo.sdk.a.a.2
                @Override // com.weibo.ssosdk.b
                public final void handler(WeiboSsoSdk.e eVar) {
                    if (eVar != null) {
                        try {
                            a.this.c = eVar.a();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public final synchronized void b(Context context, String str) {
        a(context, str);
        try {
            WeiboSsoSdk.getInstance().m(new b() { // from class: com.sina.weibo.sdk.a.a.1
                @Override // com.weibo.ssosdk.b
                public final void handler(WeiboSsoSdk.e eVar) {
                    if (eVar != null) {
                        try {
                            a.this.c = eVar.a();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
