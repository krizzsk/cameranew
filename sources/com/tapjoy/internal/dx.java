package com.tapjoy.internal;

import com.tapjoy.internal.dy;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class dx extends dy {
    protected final HashSet a;
    protected final JSONObject b;
    protected final long c;

    public dx(dy.b bVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(bVar);
        this.a = new HashSet(hashSet);
        this.b = jSONObject;
        this.c = j2;
    }
}
