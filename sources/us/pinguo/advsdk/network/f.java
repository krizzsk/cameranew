package us.pinguo.advsdk.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: ThirdAdsGetErrReportTask.java */
/* loaded from: classes3.dex */
public class f extends AbsAdvBaseTask {
    private Handler a;
    private AdsItem b;
    private us.pinguo.advsdk.bean.b c;

    /* renamed from: d  reason: collision with root package name */
    private String f9084d;

    /* renamed from: e  reason: collision with root package name */
    private String f9085e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThirdAdsGetErrReportTask.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ HashMap b;

        a(String str, HashMap hashMap) {
            this.a = str;
            this.b = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!f.this.b.bLocal) {
                g.k().u(f.this.b.stat, this.b, null);
                return;
            }
            f fVar = f.this;
            fVar.d(fVar.b.stat, this.a);
        }
    }

    public f(Context context, AdsItem adsItem, us.pinguo.advsdk.bean.b bVar) {
        super(context);
        this.f9084d = "";
        this.f9085e = "";
        this.b = adsItem;
        this.c = bVar;
        try {
            this.a = new Handler(Looper.getMainLooper());
        } catch (Exception unused) {
            us.pinguo.advsdk.utils.b.a("new handler failed");
        }
    }

    private void b() throws Exception {
        us.pinguo.advsdk.utils.b.a("final mAdsItem.stat = " + this.b.stat);
        if (TextUtils.isEmpty(this.b.stat)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 3);
        jSONObject.put("pullErrno", TextUtils.isEmpty(this.f9084d) ? "" : this.f9084d);
        jSONObject.put("pullError", TextUtils.isEmpty(this.f9085e) ? "" : this.f9085e);
        if (this.c != null) {
            jSONObject.put("placementId", TextUtils.isEmpty(this.b.placementId) ? "" : this.b.placementId);
        }
        String decode = URLDecoder.decode(new String(jSONObject.toString().getBytes(), "UTF-8"), "UTF-8");
        HashMap hashMap = new HashMap();
        if (this.a != null) {
            String entryData = getEntryData(decode, false);
            hashMap.put("data", entryData);
            this.a.post(new a(entryData, hashMap));
        }
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("deliverType", this.b.deliverType);
        hashMap.put("unitId", this.c.c);
        hashMap.put("source", this.b.source);
        if (!TextUtils.isEmpty(this.b.offerId)) {
            hashMap.put(TapjoyConstants.TJC_PLACEMENT_OFFER_ID, this.b.offerId);
        }
        return hashMap;
    }

    protected void d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str2);
        g k2 = g.k();
        k2.v(str + "/api/stat?", c(), hashMap, null);
    }

    @Override // us.pinguo.advsdk.network.AbsAdvBaseTask
    protected void doInBackground() {
        if (this.b == null) {
            return;
        }
        try {
            b();
        } catch (Exception unused) {
        }
    }

    public AbsAdvBaseTask e(String str, String str2) {
        this.f9084d = str;
        this.f9085e = str2;
        return this;
    }
}
