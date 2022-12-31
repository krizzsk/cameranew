package us.pinguo.camera2020.module;

import kotlin.jvm.internal.s;
/* compiled from: AfterCaptureModule.kt */
/* loaded from: classes3.dex */
public final class c {
    private final String a;
    private final PhotoState b;

    public c(String str, PhotoState state) {
        s.h(state, "state");
        this.a = str;
        this.b = state;
    }

    public final String a() {
        return this.a;
    }

    public final PhotoState b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return s.c(this.a, cVar.a) && this.b == cVar.b;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SaveResult(destPath=" + ((Object) this.a) + ", state=" + this.b + ')';
    }
}
