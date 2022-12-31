package com.tapjoy.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.tapjoy.internal.di;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class dl implements di {
    private final int[] a = new int[2];

    @Override // com.tapjoy.internal.di
    public final JSONObject a(View view) {
        if (view == null) {
            return dm.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] iArr = this.a;
        return dm.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.tapjoy.internal.di
    public final void a(View view, JSONObject jSONObject, di.a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            if (z && Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                while (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                    }
                    arrayList.add(childAt);
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(hashMap.keySet());
                Collections.sort(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
                    while (it2.hasNext()) {
                        aVar.a((View) it2.next(), this, jSONObject);
                    }
                }
                return;
            }
            while (i2 < viewGroup.getChildCount()) {
                aVar.a(viewGroup.getChildAt(i2), this, jSONObject);
                i2++;
            }
        }
    }
}
