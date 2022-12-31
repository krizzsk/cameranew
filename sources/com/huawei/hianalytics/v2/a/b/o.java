package com.huawei.hianalytics.v2.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.hmacgen.HmacGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements HmacGenerator.HmacCallback {
        private com.huawei.hianalytics.v2.a.a.g a;

        public a(com.huawei.hianalytics.v2.a.a.g gVar) {
            this.a = gVar;
        }

        @Override // com.huawei.hianalytics.hmacgen.HmacGenerator.HmacCallback
        public void onGenerate(long j2, byte[] bArr) {
            this.a.e(String.valueOf(j2));
            this.a.d(com.huawei.hianalytics.util.h.a(bArr));
        }
    }

    private static com.huawei.hianalytics.v2.a.a.b a(com.huawei.hianalytics.a.c cVar, Context context) {
        com.huawei.hianalytics.v2.a.a.b bVar = new com.huawei.hianalytics.v2.a.a.b();
        a(bVar, cVar, context);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.huawei.hianalytics.v2.a.a.f a(List<c> list, Context context) {
        String q;
        String p;
        com.huawei.hianalytics.a.c d2 = h.a().d();
        long r = d2.r();
        if (r == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            q = com.huawei.hianalytics.util.d.a();
            p = com.huawei.hianalytics.util.d.c(q);
            com.huawei.hianalytics.util.e.a(currentTimeMillis, q, p, d2);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - r > 43200000) {
                String a2 = com.huawei.hianalytics.util.d.a();
                String c = com.huawei.hianalytics.util.d.c(a2);
                com.huawei.hianalytics.util.e.a(currentTimeMillis2, a2, c, d2);
                q = a2;
                p = c;
            } else {
                q = d2.q();
                p = d2.p();
            }
        }
        com.huawei.hianalytics.v2.a.a.f fVar = new com.huawei.hianalytics.v2.a.a.f(q);
        fVar.a(a(p));
        fVar.a(a(d2));
        fVar.a(a(d2, context));
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis3 = System.currentTimeMillis();
        for (c cVar : list) {
            if (!cVar.a(currentTimeMillis3)) {
                arrayList.add(cVar.a(q));
            }
        }
        fVar.a(arrayList);
        return fVar;
    }

    private static com.huawei.hianalytics.v2.a.a.g a(String str) {
        String str2;
        com.huawei.hianalytics.v2.a.a.g gVar = new com.huawei.hianalytics.v2.a.a.g();
        gVar.a(str);
        m a2 = h.a();
        gVar.c(a2.d().o());
        try {
            HmacGenerator.a(gVar.a(), a2.d().v(), new a(gVar));
        } catch (UnsatisfiedLinkError unused) {
            str2 = "generateHeadData(): UnsatisfiedLinkError";
            com.huawei.hianalytics.b.b.c("HiAnalytics", str2);
            return gVar;
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "generateHeadData(): NoSuchAlgorithmException";
            com.huawei.hianalytics.b.b.c("HiAnalytics", str2);
            return gVar;
        }
        return gVar;
    }

    private static com.huawei.hianalytics.v2.a.a.h a(com.huawei.hianalytics.a.c cVar) {
        com.huawei.hianalytics.v2.a.a.h hVar = new com.huawei.hianalytics.v2.a.a.h();
        a(hVar, cVar);
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<c> a(com.huawei.hianalytics.v2.a.a.e[] eVarArr, com.huawei.hianalytics.v2.a.a.a[] aVarArr) {
        ArrayList arrayList = new ArrayList(eVarArr.length + aVarArr.length);
        for (com.huawei.hianalytics.v2.a.a.e eVar : eVarArr) {
            arrayList.add(new d(eVar));
        }
        for (com.huawei.hianalytics.v2.a.a.a aVar : aVarArr) {
            arrayList.add(new com.huawei.hianalytics.v2.a.b.a(aVar));
        }
        return arrayList;
    }

    private static void a(com.huawei.hianalytics.v2.a.a.b bVar, com.huawei.hianalytics.a.c cVar, Context context) {
        String str;
        if (bVar == null) {
            return;
        }
        String str2 = "";
        if (!TextUtils.isEmpty(cVar.m())) {
            str = cVar.m();
        } else if (!TextUtils.isEmpty(cVar.t())) {
            str2 = cVar.t();
            str = "";
        } else if (!TextUtils.isEmpty(cVar.h())) {
            str = com.huawei.hianalytics.util.e.a(cVar);
            if (TextUtils.isEmpty(str)) {
                str2 = com.huawei.hianalytics.util.e.a(cVar, context);
            }
        } else if (TextUtils.isEmpty(cVar.h()) && cVar.d() && cVar.c()) {
            str = cVar.n();
            if (TextUtils.isEmpty(str)) {
                str = com.huawei.hianalytics.util.o.c();
                cVar.i(str);
            }
        } else {
            str = "";
        }
        bVar.c(com.huawei.hianalytics.util.e.b(cVar, context));
        bVar.f(cVar.v());
        bVar.d(str2);
        bVar.b(cVar.f());
        bVar.a(str);
        bVar.e(cVar.g());
    }

    private static void a(com.huawei.hianalytics.v2.a.a.h hVar, com.huawei.hianalytics.a.c cVar) {
        hVar.b(cVar.h());
        hVar.f(cVar.i());
        hVar.g(cVar.j());
        hVar.c(cVar.k());
        hVar.d(cVar.l());
        hVar.a(cVar.s());
        hVar.e(cVar.a());
    }
}
