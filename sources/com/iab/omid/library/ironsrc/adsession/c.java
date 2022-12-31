package com.iab.omid.library.ironsrc.adsession;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private final Owner a;
    private final Owner b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final CreativeType f5300d;

    /* renamed from: e  reason: collision with root package name */
    private final ImpressionType f5301e;

    private c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        this.f5300d = creativeType;
        this.f5301e = impressionType;
        this.a = owner;
        if (owner2 == null) {
            this.b = Owner.NONE;
        } else {
            this.b = owner2;
        }
        this.c = z;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        d.d.a.a.a.g.e.c(creativeType, "CreativeType is null");
        d.d.a.a.a.g.e.c(impressionType, "ImpressionType is null");
        d.d.a.a.a.g.e.c(owner, "Impression owner is null");
        d.d.a.a.a.g.e.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z);
    }

    public boolean b() {
        return Owner.NATIVE == this.a;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        d.d.a.a.a.g.b.g(jSONObject, "impressionOwner", this.a);
        d.d.a.a.a.g.b.g(jSONObject, "mediaEventsOwner", this.b);
        d.d.a.a.a.g.b.g(jSONObject, "creativeType", this.f5300d);
        d.d.a.a.a.g.b.g(jSONObject, "impressionType", this.f5301e);
        d.d.a.a.a.g.b.g(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.c));
        return jSONObject;
    }
}
