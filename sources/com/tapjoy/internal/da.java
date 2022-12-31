package com.tapjoy.internal;
/* loaded from: classes3.dex */
public enum da {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    

    /* renamed from: e  reason: collision with root package name */
    private final String f7361e;

    da(String str) {
        this.f7361e = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f7361e;
    }
}
