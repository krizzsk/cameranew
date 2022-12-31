package us.pinguo.edit2020.bean;

import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: SkinRefreshItem.kt */
/* loaded from: classes4.dex */
public final class d0 extends n0 {

    /* renamed from: d  reason: collision with root package name */
    private final BeautyEditData f10182d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(BeautyEditData data) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        this.f10182d = data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d0) && kotlin.jvm.internal.s.c(this.f10182d, ((d0) obj).f10182d);
    }

    public int hashCode() {
        return this.f10182d.hashCode();
    }

    public String toString() {
        return "ManualSkinRefreshItem(data=" + this.f10182d + ')';
    }
}
