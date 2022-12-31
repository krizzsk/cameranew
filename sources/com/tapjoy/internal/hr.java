package com.tapjoy.internal;

import com.coremedia.iso.boxes.MetaBox;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public final class hr extends hq {

    /* renamed from: d  reason: collision with root package name */
    public static final bi f7632d = new bi() { // from class: com.tapjoy.internal.hr.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hr(bnVar);
        }
    };
    public ArrayList a = new ArrayList();
    public Map b;
    public float c;

    public hr(bn bnVar) {
        bnVar.h();
        String str = null;
        String str2 = null;
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if ("layouts".equals(l2)) {
                bnVar.a(this.a, ia.f7666d);
            } else if (MetaBox.TYPE.equals(l2)) {
                this.b = bnVar.d();
            } else if ("max_show_time".equals(l2)) {
                this.c = (float) bnVar.p();
            } else if ("ad_content".equals(l2)) {
                str = bnVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                str2 = bnVar.b();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        ArrayList arrayList = this.a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = ((ia) it.next()).c;
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        hz hzVar = (hz) it2.next();
                        if (hzVar.f7662i == null) {
                            hzVar.f7662i = str;
                        }
                        if (hzVar.f7661h == null) {
                            hzVar.f7661h = str2;
                        }
                    }
                }
            }
        }
    }
}
