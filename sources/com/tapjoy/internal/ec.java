package com.tapjoy.internal;

import android.text.TextUtils;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ec extends dx {
    public ec(dy.b bVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.dy, android.os.AsyncTask
    /* renamed from: a */
    public final void onPostExecute(String str) {
        dd a;
        if (!TextUtils.isEmpty(str) && (a = dd.a()) != null) {
            for (cz czVar : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(czVar.f7355f)) {
                    ds dsVar = czVar.c;
                    if (this.c >= dsVar.f7370e) {
                        dsVar.f7369d = ds.a.b;
                        dg.a().b(dsVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (dm.b(this.b, this.f7389e.a())) {
            return null;
        }
        this.f7389e.a(this.b);
        return this.b.toString();
    }
}
