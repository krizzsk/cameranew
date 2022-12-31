package us.pinguo.edit2020.bean;

import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: SkinRefreshItem.kt */
/* loaded from: classes4.dex */
public final class i extends n0 {

    /* renamed from: d  reason: collision with root package name */
    private final BeautyEditData f10202d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10203e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10204f;

    public /* synthetic */ i(BeautyEditData beautyEditData, boolean z, boolean z2, int i2, kotlin.jvm.internal.o oVar) {
        this(beautyEditData, z, (i2 & 4) != 0 ? false : z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return kotlin.jvm.internal.s.c(this.f10202d, iVar.f10202d) && this.f10203e == iVar.f10203e && this.f10204f == iVar.f10204f;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f10202d.hashCode() * 31;
        boolean z = this.f10203e;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.f10204f;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final BeautyEditData i() {
        return this.f10202d;
    }

    public final boolean j() {
        return this.f10203e;
    }

    public final boolean k() {
        return this.f10204f;
    }

    public final void l(boolean z) {
        this.f10204f = z;
    }

    public String toString() {
        return "BeautyOperationItem(data=" + this.f10202d + ", isManual=" + this.f10203e + ", isSelectedErasing=" + this.f10204f + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BeautyEditData data, boolean z, boolean z2) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        this.f10202d = data;
        this.f10203e = z;
        this.f10204f = z2;
    }
}
