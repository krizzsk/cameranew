package us.pinguo.picker.image.gallery;
/* compiled from: MediaObject.java */
/* loaded from: classes5.dex */
public abstract class n {
    private static long c;
    protected long a;
    protected final Path b;

    public n(Path path, long j2) {
        path.g(this);
        this.b = path;
        this.a = j2;
    }

    public static synchronized long d() {
        long j2;
        synchronized (n.class) {
            j2 = c + 1;
            c = j2;
        }
        return j2;
    }

    public long a() {
        return this.a;
    }

    public Path c() {
        return this.b;
    }
}
