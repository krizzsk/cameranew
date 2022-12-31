package com.tapjoy.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.coremedia.iso.boxes.MetaBox;
import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class hp {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.hp$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ey.values().length];
            a = iArr;
            try {
                iArr[ey.APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ey.CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ey.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ey.USAGES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String a(fa faVar) {
        bh b = new bh().c().a("sdk").b(faVar.t).a("os_name").b(faVar.f7472k).a("os_ver").b(faVar.f7473l).a("device_id").b(faVar.f7469h).a("device_maker").b(faVar.f7470i).a("device_model").b(faVar.f7471j).a(TapjoyConstants.TJC_PACKAGE_ID).b(faVar.r).a(TapjoyConstants.TJC_PACKAGE_SIGN).b(faVar.s).a("locale").b(faVar.p).a(TapjoyConstants.TJC_DEVICE_TIMEZONE).b(faVar.q);
        if (faVar.m != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY).a((Number) faVar.m);
        }
        if (faVar.n != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH).a((Number) faVar.n);
        }
        if (faVar.o != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT).a((Number) faVar.o);
        }
        if (faVar.f7468g != null) {
            b.a("mac").b(faVar.f7468g);
        }
        if (faVar.u != null) {
            b.a(TapjoyConstants.TJC_DEVICE_COUNTRY_SIM).b(faVar.u);
        }
        if (faVar.v != null) {
            b.a("country_net").b(faVar.v);
        }
        if (faVar.w != null) {
            b.a("imei").b(faVar.w);
        }
        if (faVar.x != null) {
            b.a(TapjoyConstants.TJC_ANDROID_ID).b(faVar.x);
        }
        return b.d().toString();
    }

    public static String a(eu euVar) {
        bh c = new bh().c();
        if (euVar.f7423e != null) {
            c.a(TapjoyConstants.TJC_PACKAGE_VERSION).b(euVar.f7423e);
        }
        if (euVar.f7424f != null) {
            c.a(TapjoyConstants.TJC_PACKAGE_REVISION).a((Number) euVar.f7424f);
        }
        if (euVar.f7425g != null) {
            c.a("data_ver").b(euVar.f7425g);
        }
        if (euVar.f7426h != null) {
            c.a(TapjoyConstants.TJC_INSTALLER).b(euVar.f7426h);
        }
        if (euVar.f7427i != null) {
            c.a(TapjoyConstants.TJC_STORE).b(euVar.f7427i);
        }
        return c.d().toString();
    }

    public static String a(fh fhVar) {
        return a(fhVar, null);
    }

    private static String a(fh fhVar, ev evVar) {
        String str;
        String b;
        bh c = new bh().c();
        if (fhVar.s != null) {
            c.a(TapjoyConstants.TJC_INSTALLED).a((Number) fhVar.s);
        }
        if (fhVar.t != null) {
            c.a("referrer").b(fhVar.t);
        }
        if (fhVar.G != null) {
            c.a("idfa").b(fhVar.G);
            Boolean bool = fhVar.H;
            if (bool != null && bool.booleanValue()) {
                c.a("idfa_optout").a(1L);
            }
        } else if (evVar != null && (str = evVar.r) != null && hc.a.equals(str) && (b = hn.b()) != null) {
            c.a("idfa").b(b);
            if (hn.c()) {
                c.a("idfa_optout").a(1L);
            }
        }
        if (fhVar.u != null) {
            c.a(TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY).a(Math.max(fhVar.u.intValue(), 1));
        }
        if (fhVar.v != null) {
            c.a(TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY).a(Math.max(fhVar.v.intValue(), 1));
        }
        if (fhVar.w.size() > 0) {
            ArrayList arrayList = new ArrayList(fhVar.w.size());
            for (fe feVar : fhVar.w) {
                if (feVar.f7515h != null) {
                    arrayList.add(feVar.f7513f);
                }
            }
            if (!arrayList.isEmpty()) {
                c.a(Constants.PUSH).a();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b((String) it.next());
                }
                c.b();
            }
        }
        c.a("session").c();
        if (fhVar.x != null) {
            c.a("total_count").a((Number) fhVar.x);
        }
        if (fhVar.y != null) {
            c.a("total_length").a((Number) fhVar.y);
        }
        if (fhVar.z != null) {
            c.a("last_at").a((Number) fhVar.z);
        }
        if (fhVar.A != null) {
            c.a("last_length").a((Number) fhVar.A);
        }
        c.d();
        c.a(FirebaseAnalytics.Event.PURCHASE).c();
        if (fhVar.B != null) {
            c.a(FirebaseAnalytics.Param.CURRENCY).b(fhVar.B);
        }
        if (fhVar.C != null) {
            c.a("total_count").a((Number) fhVar.C);
        }
        if (fhVar.D != null) {
            c.a("total_price").a((Number) fhVar.D);
        }
        if (fhVar.E != null) {
            c.a("last_at").a((Number) fhVar.E);
        }
        if (fhVar.F != null) {
            c.a("last_price").a((Number) fhVar.F);
        }
        c.d();
        if (fhVar.I != null) {
            c.a(AccessToken.USER_ID_KEY).b(fhVar.I);
        }
        if (fhVar.J != null) {
            c.a(TapjoyConstants.TJC_USER_LEVEL).a((Number) fhVar.J);
        }
        if (fhVar.K != null) {
            c.a(TapjoyConstants.TJC_USER_FRIEND_COUNT).a((Number) fhVar.K);
        }
        if (fhVar.L != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_1).b(fhVar.L);
        }
        if (fhVar.M != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_2).b(fhVar.M);
        }
        if (fhVar.N != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_3).b(fhVar.N);
        }
        if (fhVar.O != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_4).b(fhVar.O);
        }
        if (fhVar.P != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_5).b(fhVar.P);
        }
        if (fhVar.Q.size() > 0) {
            c.a(JsonMarshaller.TAGS).a((Collection) fhVar.Q);
        }
        if (Boolean.TRUE.equals(fhVar.R)) {
            c.a("push_optout").a(1L);
        }
        return c.d().toString();
    }

    private static String a(ev evVar, boolean z, boolean z2, boolean z3) {
        String str;
        bh b = new bh().c().a("type").b(a(evVar.n)).a("name").b(evVar.o);
        b.a(Issue.ISSUE_REPORT_TIME);
        if (evVar.q != null) {
            b.a((Number) evVar.p);
            b.a("systime").a((Number) evVar.q);
        } else if (v.c() && (str = evVar.r) != null && evVar.s != null && hc.a.equals(str)) {
            b.a(v.a(evVar.s.longValue()));
            b.a("systime").a((Number) evVar.p);
        } else {
            b.a((Number) evVar.p);
        }
        if (evVar.t != null) {
            b.a(TypedValues.TransitionType.S_DURATION).a((Number) evVar.t);
        }
        if (!z && evVar.u != null) {
            b.a(TJAdUnitConstants.String.VIDEO_INFO).a((bl) new bm(a(evVar.u)));
        }
        if (!z2 && evVar.v != null) {
            b.a("app").a((bl) new bm(a(evVar.v)));
        }
        if (!z3 && evVar.w != null) {
            b.a("user").a((bl) new bm(a(evVar.w, evVar)));
        }
        if (evVar.y != null) {
            b.a("event_seq").a((Number) evVar.y);
        }
        if (evVar.z != null) {
            bh a = b.a("event_prev");
            ex exVar = evVar.z;
            bh b2 = new bh().c().a("type").b(a(exVar.f7452e)).a("name").b(exVar.f7453f);
            if (exVar.f7454g != null) {
                b2.a("category").b(exVar.f7454g);
            }
            a.a((bl) new bm(b2.d().toString()));
        }
        if (evVar.A != null) {
            bh a2 = b.a(FirebaseAnalytics.Event.PURCHASE);
            fd fdVar = evVar.A;
            bh b3 = new bh().c().a("product_id").b(fdVar.f7497h);
            if (fdVar.f7498i != null) {
                b3.a("product_quantity").a((Number) fdVar.f7498i);
            }
            if (fdVar.f7499j != null) {
                b3.a("product_price").a((Number) fdVar.f7499j);
            }
            if (fdVar.f7500k != null) {
                b3.a("product_price_currency").b(fdVar.f7500k);
            }
            if (fdVar.s != null) {
                b3.a("currency_price").b(fdVar.s);
            }
            if (fdVar.f7501l != null) {
                b3.a("product_type").b(fdVar.f7501l);
            }
            if (fdVar.m != null) {
                b3.a("product_title").b(fdVar.m);
            }
            if (fdVar.n != null) {
                b3.a("product_description").b(fdVar.n);
            }
            if (fdVar.o != null) {
                b3.a(FirebaseAnalytics.Param.TRANSACTION_ID).b(fdVar.o);
            }
            if (fdVar.p != null) {
                b3.a("transaction_state").a((Number) fdVar.p);
            }
            if (fdVar.q != null) {
                b3.a("transaction_date").a((Number) fdVar.q);
            }
            if (fdVar.r != null) {
                b3.a("campaign_id").b(fdVar.r);
            }
            if (fdVar.t != null) {
                b3.a("receipt").b(fdVar.t);
            }
            if (fdVar.u != null) {
                b3.a("signature").b(fdVar.u);
            }
            a2.a((bl) new bm(b3.d().toString()));
        }
        if (evVar.B != null) {
            b.a("exception").b(evVar.B);
        }
        try {
            if (evVar.D != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str2 = evVar.C;
                if (str2 != null) {
                    bn.b(str2).a(linkedHashMap);
                }
                fc fcVar = evVar.D;
                String str3 = fcVar.f7488d;
                if (str3 != null) {
                    linkedHashMap.put("fq7_change", str3);
                }
                String str4 = fcVar.f7489e;
                if (str4 != null) {
                    linkedHashMap.put("fq30_change", str4);
                }
                String str5 = fcVar.f7490f;
                if (str5 != null) {
                    linkedHashMap.put(TJAdUnitConstants.PARAM_PUSH_ID, str5);
                }
                b.a(MetaBox.TYPE).a((Map) linkedHashMap);
            } else if (evVar.C != null) {
                b.a(MetaBox.TYPE).a((bl) new bm(evVar.C));
            }
        } catch (IOException unused) {
        }
        if (evVar.I != null) {
            b.a(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS).a((bl) new bm(evVar.I));
        }
        if (evVar.J != null) {
            b.a("count").a((Number) evVar.J);
        }
        if (evVar.K != null) {
            b.a("first_time").a((Number) evVar.K);
        }
        if (evVar.L != null) {
            b.a("last_time").a((Number) evVar.L);
        }
        if (evVar.E != null) {
            b.a("category").b(evVar.E);
        }
        if (evVar.F != null) {
            b.a("p1").b(evVar.F);
        }
        if (evVar.G != null) {
            b.a("p2").b(evVar.G);
        }
        if (evVar.H.size() > 0) {
            b.a(TJAdUnitConstants.String.USAGE_TRACKER_VALUES).c();
            for (ez ezVar : evVar.H) {
                b.a(ezVar.f7458e).a((Number) ezVar.f7459f);
            }
            b.d();
        }
        return b.d().toString();
    }

    public static String a(ew ewVar) {
        boolean z;
        boolean z2;
        bh a = new bh().a();
        fa faVar = null;
        eu euVar = null;
        fh fhVar = null;
        for (ev evVar : ewVar.f7450d) {
            boolean z3 = true;
            if (faVar == null || !faVar.equals(evVar.u)) {
                faVar = evVar.u;
                z = false;
            } else {
                z = true;
            }
            if (euVar == null || !euVar.equals(evVar.v)) {
                euVar = evVar.v;
                z2 = false;
            } else {
                z2 = true;
            }
            if (fhVar == null || !fhVar.equals(evVar.w)) {
                fhVar = evVar.w;
                z3 = false;
            }
            a.a((bl) new bm(a(evVar, z, z2, z3)));
        }
        return a.b().toString();
    }

    private static String a(ey eyVar) {
        int i2 = AnonymousClass1.a[eyVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return "usages";
                    }
                    throw new RuntimeException();
                }
                return "custom";
            }
            return "campaign";
        }
        return "app";
    }
}
