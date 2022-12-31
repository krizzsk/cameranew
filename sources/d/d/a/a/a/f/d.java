package d.d.a.a.a.f;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import d.d.a.a.a.f.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d implements a {
    private final int[] a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0294a interfaceC0294a) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            interfaceC0294a.a(viewGroup.getChildAt(i2), this, jSONObject);
        }
    }

    @TargetApi(21)
    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0294a interfaceC0294a) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0294a.a((View) it2.next(), this, jSONObject);
            }
        }
    }

    @Override // d.d.a.a.a.f.a
    public JSONObject a(View view) {
        if (view == null) {
            return d.d.a.a.a.g.b.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] iArr = this.a;
        return d.d.a.a.a.g.b.b(iArr[0], iArr[1], width, height);
    }

    @Override // d.d.a.a.a.f.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0294a interfaceC0294a, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                b(viewGroup, jSONObject, interfaceC0294a);
            } else {
                c(viewGroup, jSONObject, interfaceC0294a);
            }
        }
    }
}
