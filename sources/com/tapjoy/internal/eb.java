package com.tapjoy.internal;

import com.tapjoy.internal.ds;
import com.tapjoy.internal.dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class eb extends dx {
    public eb(dy.b bVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.dy, android.os.AsyncTask
    /* renamed from: a */
    public final void onPostExecute(String str) {
        dd a = dd.a();
        if (a != null) {
            for (cz czVar : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(czVar.f7355f)) {
                    ds dsVar = czVar.c;
                    if (this.c >= dsVar.f7370e) {
                        int i2 = dsVar.f7369d;
                        int i3 = ds.a.c;
                        if (i2 != i3) {
                            dsVar.f7369d = i3;
                            dg.a().b(dsVar.c(), str);
                        }
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.b.toString();
    }
}
