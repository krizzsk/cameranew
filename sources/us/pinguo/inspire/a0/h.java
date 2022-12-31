package us.pinguo.inspire.a0;
/* compiled from: ObjectCacheWrapper.java */
/* loaded from: classes4.dex */
public class h<T> {
    private f<T> a;

    public h(f<T> fVar) {
        this.a = fVar;
    }

    public synchronized T a() {
        try {
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
        return this.a.getObject();
    }

    public synchronized void b(T t) {
        try {
            this.a.putObject(t);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
