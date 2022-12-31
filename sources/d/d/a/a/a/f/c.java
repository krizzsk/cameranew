package d.d.a.a.a.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.ironsrc.adsession.g;
import d.d.a.a.a.f.a;
import d.d.a.a.a.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // d.d.a.a.a.f.a
    public JSONObject a(View view) {
        return d.d.a.a.a.g.b.b(0, 0, 0, 0);
    }

    @Override // d.d.a.a.a.f.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0294a interfaceC0294a, boolean z) {
        Iterator<View> it = b().iterator();
        while (it.hasNext()) {
            interfaceC0294a.a(it.next(), this.a, jSONObject);
        }
    }

    @NonNull
    ArrayList<View> b() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        d.d.a.a.a.d.a a = d.d.a.a.a.d.a.a();
        if (a != null) {
            Collection<g> e2 = a.e();
            IdentityHashMap identityHashMap = new IdentityHashMap((e2.size() * 2) + 3);
            for (g gVar : e2) {
                View i2 = gVar.i();
                if (i2 != null && f.c(i2) && (rootView = i2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && f.a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }
}
