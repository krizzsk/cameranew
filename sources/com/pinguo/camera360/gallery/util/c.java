package com.pinguo.camera360.gallery.util;

import android.content.IntentSender;
import kotlin.jvm.internal.s;
/* compiled from: GalleryDeleteUtil.kt */
/* loaded from: classes3.dex */
public final class c {
    private final String a;
    private final IntentSender b;

    public c(String type, IntentSender sender) {
        s.h(type, "type");
        s.h(sender, "sender");
        this.a = type;
        this.b = sender;
    }

    public final IntentSender a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return s.c(this.a, cVar.a) && s.c(this.b, cVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "IntentSenderWrapper(type=" + this.a + ", sender=" + this.b + ')';
    }
}
