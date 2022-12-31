package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.coremedia.iso.boxes.MetaBox;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class hu extends hq {
    public static final bi n = new bi() { // from class: com.tapjoy.internal.hu.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hu(bnVar);
        }
    };
    @Nullable
    public hx a;
    @Nullable
    public hx b;
    public hx c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Point f7642d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public hx f7643e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public hx f7644f;

    /* renamed from: g  reason: collision with root package name */
    public String f7645g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public gl f7646h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f7647i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f7648j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public Map f7649k;

    /* renamed from: l  reason: collision with root package name */
    public long f7650l;
    @Nullable
    public hv m;

    public hu() {
    }

    public final boolean a() {
        return (this.c == null || this.a == null || this.f7643e == null) ? false : true;
    }

    public final boolean b() {
        return (this.c == null || this.b == null || this.f7644f == null) ? false : true;
    }

    hu(bn bnVar) {
        bnVar.h();
        String str = null;
        String str2 = null;
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if (TypedValues.AttributesType.S_FRAME.equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l3 = bnVar.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l3)) {
                        this.a = (hx) hx.f7652e.a(bnVar);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l3)) {
                        this.b = (hx) hx.f7652e.a(bnVar);
                    } else if ("close_button".equals(l3)) {
                        this.c = (hx) hx.f7652e.a(bnVar);
                    } else if ("close_button_offset".equals(l3)) {
                        this.f7642d = (Point) bj.a.a(bnVar);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if ("creative".equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l4 = bnVar.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l4)) {
                        this.f7643e = (hx) hx.f7652e.a(bnVar);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l4)) {
                        this.f7644f = (hx) hx.f7652e.a(bnVar);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if ("url".equals(l2)) {
                this.f7645g = bnVar.b();
            } else if (ho.a(l2)) {
                this.f7646h = ho.a(l2, bnVar);
            } else if ("mappings".equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l5 = bnVar.l();
                    if (TJAdUnitConstants.String.PORTRAIT.equals(l5)) {
                        bnVar.a(this.f7647i, hs.f7633h);
                    } else if (TJAdUnitConstants.String.LANDSCAPE.equals(l5)) {
                        bnVar.a(this.f7648j, hs.f7633h);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if (MetaBox.TYPE.equals(l2)) {
                this.f7649k = bnVar.d();
            } else if (Constants.FirelogAnalytics.PARAM_TTL.equals(l2)) {
                this.f7650l = SystemClock.elapsedRealtime() + ((long) (bnVar.p() * 1000.0d));
            } else if ("no_more_today".equals(l2)) {
                this.m = (hv) hv.f7651d.a(bnVar);
            } else if ("ad_content".equals(l2)) {
                str = bnVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                str2 = bnVar.b();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        if (this.f7645g == null) {
            this.f7645g = "";
        }
        ArrayList arrayList = this.f7647i;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hs hsVar = (hs) it.next();
                if (hsVar.f7636f == null) {
                    hsVar.f7636f = str;
                }
                if (hsVar.f7635e == null) {
                    hsVar.f7635e = str2;
                }
            }
        }
        ArrayList arrayList2 = this.f7648j;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                hs hsVar2 = (hs) it2.next();
                if (hsVar2.f7636f == null) {
                    hsVar2.f7636f = str;
                }
                if (hsVar2.f7635e == null) {
                    hsVar2.f7635e = str2;
                }
            }
        }
    }
}
