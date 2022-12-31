package d.f.a.a.b.c;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
/* compiled from: FuzzyKeyMemoryCache.java */
/* loaded from: classes3.dex */
public class a implements d.f.a.a.b.a {
    private final d.f.a.a.b.a a;
    private final Comparator<String> b;

    public a(d.f.a.a.b.a aVar, Comparator<String> comparator) {
        this.a = aVar;
        this.b = comparator;
    }

    @Override // d.f.a.a.b.b
    public Collection<String> a() {
        return this.a.a();
    }

    @Override // d.f.a.a.b.b
    /* renamed from: b */
    public Bitmap get(String str) {
        return this.a.get(str);
    }

    @Override // d.f.a.a.b.b
    /* renamed from: c */
    public boolean put(String str, Bitmap bitmap) {
        synchronized (this.a) {
            String str2 = null;
            Iterator<String> it = this.a.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.a.remove(str2);
            }
        }
        return this.a.put(str, bitmap);
    }

    @Override // d.f.a.a.b.b
    /* renamed from: d */
    public Bitmap remove(String str) {
        return this.a.remove(str);
    }
}
