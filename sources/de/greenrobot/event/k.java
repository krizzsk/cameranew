package de.greenrobot.event;
/* compiled from: Subscription.java */
/* loaded from: classes3.dex */
final class k {
    final Object a;
    final i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Object obj, i iVar) {
        this.a = obj;
        this.b = iVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.a == kVar.a && this.b.equals(kVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f8627d.hashCode();
    }
}
