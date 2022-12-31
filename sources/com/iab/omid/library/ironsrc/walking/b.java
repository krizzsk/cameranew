package com.iab.omid.library.ironsrc.walking;

import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.walking.a;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a.c.b {
    private JSONObject a;
    private final a.d b;

    public b(a.d dVar) {
        this.b = dVar;
    }

    public void a() {
        this.b.c(new a.e(this));
    }

    @Override // com.iab.omid.library.ironsrc.walking.a.c.b
    @VisibleForTesting
    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.iab.omid.library.ironsrc.walking.a.c.b
    @VisibleForTesting
    public JSONObject b() {
        return this.a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.b.c(new a.g(this, hashSet, jSONObject, j2));
    }

    public void c(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.b.c(new a.f(this, hashSet, jSONObject, j2));
    }
}
