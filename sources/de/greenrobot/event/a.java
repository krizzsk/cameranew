package de.greenrobot.event;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPoster.java */
/* loaded from: classes3.dex */
public class a implements Runnable {
    private final g a = new g();
    private final c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.b = cVar;
    }

    public void a(k kVar, Object obj) {
        this.a.a(f.a(kVar, obj));
        c.f8616l.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f b = this.a.b();
        if (b != null) {
            this.b.e(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
