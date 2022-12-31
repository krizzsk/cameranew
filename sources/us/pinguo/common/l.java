package us.pinguo.common;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
/* compiled from: StatManager.java */
/* loaded from: classes4.dex */
public final class l {

    /* renamed from: f  reason: collision with root package name */
    private static final l f9929f = new l();
    private b a;
    private SparseArray<i> b = null;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9930d = false;

    /* renamed from: e  reason: collision with root package name */
    private Context f9931e;

    private l() {
    }

    public static l a() {
        return f9929f;
    }

    public void b(Application application, b bVar, Object obj) {
        this.f9931e = application.getApplicationContext();
        this.a = bVar;
        SparseArray<i> sparseArray = bVar.a;
        this.b = sparseArray;
        this.c = sparseArray.size();
        this.f9930d = this.a.b;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.valueAt(i2).a(application, obj);
        }
    }

    public void c(int i2, String str, j[] jVarArr) {
        for (int i3 = 0; i3 < this.c; i3++) {
            int keyAt = this.b.keyAt(i3);
            if (keyAt == 0 || (keyAt & i2) > 0) {
                this.b.valueAt(i3).b(this.f9931e, str, jVarArr);
            }
        }
        if (this.f9930d) {
            for (j jVar : jVarArr) {
                jVar.a();
            }
        }
    }
}
