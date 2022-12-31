package d.e.a;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: EventsTracker.java */
/* loaded from: classes2.dex */
public class b {
    private c a;
    private d.e.a.a b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f8524d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventsTracker.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.e.c.d dVar = new d.e.c.d();
                ArrayList<Pair<String, String>> d2 = b.this.b.d();
                if ("POST".equals(b.this.b.e())) {
                    dVar = d.e.c.c.d(b.this.b.b(), this.a, d2);
                } else if ("GET".equals(b.this.b.e())) {
                    dVar = d.e.c.c.c(b.this.b.b(), this.a, d2);
                }
                b bVar = b.this;
                bVar.e("response status code: " + dVar.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public b(d.e.a.a aVar, c cVar) {
        if (aVar != null) {
            if (aVar.c() != null) {
                this.b = aVar;
                this.a = cVar;
                this.c = aVar.c();
                this.f8524d = Executors.newSingleThreadExecutor();
                return;
            }
            throw new InvalidParameterException("Null formatter not supported ");
        }
        throw new InvalidParameterException("Null configuration not supported ");
    }

    private void c(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (this.b.f()) {
            Log.d("EventsTracker", str);
        }
    }

    private void f(String str) {
        this.f8524d.submit(new a(str));
    }

    public void d(String str, Map<String, Object> map) {
        e(String.format(Locale.ENGLISH, "%s %s", str, map.toString()));
        if (this.b.a() && !str.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventname", str);
            c(hashMap, this.a.a());
            c(hashMap, map);
            f(this.c.a(hashMap));
        }
    }
}
