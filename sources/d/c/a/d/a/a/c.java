package d.c.a.d.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.j;
import com.google.android.play.core.internal.y;
import com.google.android.play.core.splitcompat.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class c<StateT> {
    protected final j a;
    private final IntentFilter b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    protected final Set<a<StateT>> f8509d = new HashSet();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private b f8510e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f8511f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(j jVar, IntentFilter intentFilter, Context context) {
        this.a = jVar;
        this.b = intentFilter;
        this.c = q.a(context);
    }

    private final void g() {
        b bVar;
        if ((this.f8511f || !this.f8509d.isEmpty()) && this.f8510e == null) {
            b bVar2 = new b(this);
            this.f8510e = bVar2;
            this.c.registerReceiver(bVar2, this.b);
        }
        if (this.f8511f || !this.f8509d.isEmpty() || (bVar = this.f8510e) == null) {
            return;
        }
        this.c.unregisterReceiver(bVar);
        this.f8510e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void b(a<StateT> aVar) {
        this.a.f("registerListener", new Object[0]);
        y.c(aVar, "Registered Play Core listener should not be null.");
        this.f8509d.add(aVar);
        g();
    }

    public final synchronized void c(StateT statet) {
        Iterator it = new HashSet(this.f8509d).iterator();
        while (it.hasNext()) {
            ((a) it.next()).onStateUpdate(statet);
        }
    }

    public final synchronized void d(boolean z) {
        this.f8511f = z;
        g();
    }

    public final synchronized void e(a<StateT> aVar) {
        this.a.f("unregisterListener", new Object[0]);
        y.c(aVar, "Unregistered Play Core listener should not be null.");
        this.f8509d.remove(aVar);
        g();
    }

    public final synchronized boolean f() {
        return this.f8510e != null;
    }
}
