package us.pinguo.inspire.a0;
/* compiled from: ObjectCacheImpl.java */
/* loaded from: classes4.dex */
public abstract class g<T> implements f<T> {
    private h<T> mWrapper;

    public h<T> wrap() {
        if (this.mWrapper == null) {
            this.mWrapper = new h<>(this);
        }
        return this.mWrapper;
    }
}
