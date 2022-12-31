package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.model.p;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.model.r;
import com.ironsource.mediationsdk.model.s;
import com.ironsource.mediationsdk.model.t;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* compiled from: ServerResponseWrapper.java */
/* loaded from: classes2.dex */
public class k {
    private q a;
    private r b;
    private com.ironsource.mediationsdk.model.i c;

    /* renamed from: d  reason: collision with root package name */
    private String f5671d;

    /* renamed from: e  reason: collision with root package name */
    private String f5672e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f5673f;

    /* renamed from: g  reason: collision with root package name */
    private Context f5674g;

    public k(Context context, String str, String str2, String str3) {
        this.f5674g = context;
        try {
            if (TextUtils.isEmpty(str3)) {
                this.f5673f = new JSONObject();
            } else {
                this.f5673f = new JSONObject(str3);
            }
            q();
            o();
            p();
            this.f5671d = TextUtils.isEmpty(str) ? "" : str;
            this.f5672e = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            a();
        }
    }

    private void a() {
        this.f5673f = new JSONObject();
        this.f5671d = "";
        this.f5672e = "";
        this.a = new q();
        this.b = r.e();
        this.c = new com.ironsource.mediationsdk.model.i();
    }

    private Context c() {
        return this.f5674g;
    }

    private int e(JSONObject jSONObject, JSONObject jSONObject2, String str, int i2) {
        int i3 = 0;
        if (jSONObject.has(str)) {
            i3 = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            i3 = jSONObject2.optInt(str, 0);
        }
        return i3 == 0 ? i2 : i3;
    }

    private long f(JSONObject jSONObject, JSONObject jSONObject2, String str, long j2) {
        long optLong;
        if (jSONObject.has(str)) {
            optLong = jSONObject.optLong(str, 0L);
        } else {
            optLong = jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        }
        return optLong == 0 ? j2 : optLong;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r7.toString().equals(r6) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ironsource.mediationsdk.model.p g(org.json.JSONObject r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            com.ironsource.mediationsdk.model.p$b r1 = new com.ironsource.mediationsdk.model.p$b
            r1.<init>()
            java.lang.String r2 = "delivery"
            r3 = 1
            boolean r2 = r10.optBoolean(r2, r3)
            r1.c(r2)
            java.lang.String r2 = "capping"
            org.json.JSONObject r2 = r10.optJSONObject(r2)
            java.lang.String r4 = "enabled"
            r5 = 0
            if (r2 == 0) goto L59
            java.lang.String r6 = "unit"
            java.lang.String r6 = r2.optString(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L45
            com.ironsource.mediationsdk.model.PlacementCappingType r7 = com.ironsource.mediationsdk.model.PlacementCappingType.PER_DAY
            java.lang.String r8 = r7.toString()
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L38
        L36:
            r0 = r7
            goto L45
        L38:
            com.ironsource.mediationsdk.model.PlacementCappingType r7 = com.ironsource.mediationsdk.model.PlacementCappingType.PER_HOUR
            java.lang.String r8 = r7.toString()
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L45
            goto L36
        L45:
            java.lang.String r6 = "maxImpressions"
            int r6 = r2.optInt(r6, r5)
            boolean r2 = r2.optBoolean(r4, r5)
            if (r2 == 0) goto L55
            if (r6 <= 0) goto L55
            r2 = 1
            goto L56
        L55:
            r2 = 0
        L56:
            r1.b(r2, r0, r6)
        L59:
            java.lang.String r0 = "pacing"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            if (r10 == 0) goto L74
            java.lang.String r0 = "numOfSeconds"
            int r0 = r10.optInt(r0, r5)
            boolean r10 = r10.optBoolean(r4, r5)
            if (r10 == 0) goto L70
            if (r0 <= 0) goto L70
            goto L71
        L70:
            r3 = 0
        L71:
            r1.d(r3, r0)
        L74:
            com.ironsource.mediationsdk.model.p r10 = r1.a()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.k.g(org.json.JSONObject):com.ironsource.mediationsdk.model.p");
    }

    private JSONObject l(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private boolean m() {
        JSONObject l2 = l(l(this.f5673f, TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS), "adUnits");
        JSONArray names = l2.names();
        if (names == null) {
            return false;
        }
        for (int i2 = 0; i2 < names.length(); i2++) {
            JSONArray optJSONArray = l(l2, names.optString(i2)).optJSONArray("placements");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return false;
            }
        }
        return true;
    }

    private void o() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject3;
        String str8;
        String str9;
        s sVar;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        JSONObject jSONObject4;
        com.ironsource.mediationsdk.model.j jVar;
        String str18;
        String str19;
        JSONObject jSONObject5;
        String str20;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        com.ironsource.mediationsdk.model.g gVar;
        String str27;
        com.ironsource.mediationsdk.model.m mVar;
        com.ironsource.mediationsdk.model.e eVar;
        JSONObject l2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        b bVar;
        b bVar2;
        int i2;
        boolean z;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        b bVar3;
        int i3;
        boolean z2;
        int[] iArr13;
        int[] iArr14;
        int[] iArr15;
        int[] iArr16;
        b bVar4;
        try {
            JSONObject l3 = l(this.f5673f, TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS);
            JSONObject l4 = l(l3, "adUnits");
            JSONObject l5 = l(l3, "application");
            JSONObject l6 = l(l4, "rewardedVideo");
            JSONObject l7 = l(l4, "interstitial");
            JSONObject l8 = l(l4, "offerwall");
            JSONObject l9 = l(l4, "banner");
            JSONObject l10 = l(l5, "events");
            JSONObject l11 = l(l5, "loggers");
            JSONObject l12 = l(l5, "token");
            JSONObject l13 = l(l5, "segment");
            JSONObject l14 = l(l5, "auction");
            JSONObject l15 = l(l5, "crashReporter");
            JSONObject l16 = l(l5, "settings");
            JSONObject l17 = l(l5, "external");
            if (l5 != null) {
                jSONObject = l17;
                jSONObject2 = l15;
                IronSourceUtils.V(this.f5674g, "uuidEnabled", l5.optBoolean("uuidEnabled", true));
            } else {
                jSONObject = l17;
                jSONObject2 = l15;
            }
            if (l10 != null) {
                String optString = l10.optString("abt");
                if (!TextUtils.isEmpty(optString)) {
                    InterstitialEventsManager.getInstance().S(optString);
                    RewardedVideoEventsManager.getInstance().S(optString);
                }
            }
            String str28 = "nonConnectivityEvents";
            String str29 = "triggerEvents";
            String str30 = "optIn";
            if (l6 != null) {
                JSONArray optJSONArray = l6.optJSONArray("placements");
                str3 = "placements";
                JSONObject l18 = l(l6, "events");
                str = "events";
                int e2 = e(l6, l5, "maxNumOfAdaptersToLoadOnStart", 2);
                str2 = "maxNumOfAdaptersToLoadOnStart";
                int e3 = e(l6, l5, "advancedLoading", 0);
                if (e3 > 0) {
                    i3 = e3;
                    z2 = true;
                } else {
                    i3 = e2;
                    z2 = false;
                }
                int e4 = e(l6, l5, "adapterTimeOutInSeconds", 60);
                int e5 = e(l6, l5, "loadRVInterval", IjkMediaCodecInfo.RANK_SECURE);
                int e6 = e(l6, l5, "expiredDurationInMinutes", -1);
                JSONObject T = IronSourceUtils.T(l18, l10);
                boolean optBoolean = T.optBoolean("sendUltraEvents", false);
                boolean optBoolean2 = T.optBoolean("sendEventsToggle", false);
                String optString2 = T.optString("serverEventsURL", "");
                String optString3 = T.optString("serverEventsType", "");
                int optInt = T.optInt("backupThreshold", -1);
                int optInt2 = T.optInt("maxNumberOfEvents", -1);
                int optInt3 = T.optInt("maxEventsPerBatch", 5000);
                JSONArray optJSONArray2 = T.optJSONArray("optOut");
                if (optJSONArray2 != null) {
                    int[] iArr17 = new int[optJSONArray2.length()];
                    str6 = "maxEventsPerBatch";
                    str7 = "optOut";
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        iArr17[i4] = optJSONArray2.optInt(i4);
                    }
                    iArr13 = iArr17;
                } else {
                    str6 = "maxEventsPerBatch";
                    str7 = "optOut";
                    iArr13 = null;
                }
                JSONArray optJSONArray3 = T.optJSONArray(str30);
                if (optJSONArray3 != null) {
                    int[] iArr18 = new int[optJSONArray3.length()];
                    str30 = str30;
                    for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                        iArr18[i5] = optJSONArray3.optInt(i5);
                    }
                    iArr14 = iArr18;
                } else {
                    str30 = str30;
                    iArr14 = null;
                }
                JSONArray optJSONArray4 = T.optJSONArray(str29);
                if (optJSONArray4 != null) {
                    int[] iArr19 = new int[optJSONArray4.length()];
                    str29 = str29;
                    for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                        iArr19[i6] = optJSONArray4.optInt(i6);
                    }
                    iArr15 = iArr19;
                } else {
                    str29 = str29;
                    iArr15 = null;
                }
                JSONArray optJSONArray5 = T.optJSONArray(str28);
                if (optJSONArray5 != null) {
                    int[] iArr20 = new int[optJSONArray5.length()];
                    for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                        iArr20[i7] = optJSONArray5.optInt(i7);
                    }
                    iArr16 = iArr20;
                } else {
                    iArr16 = null;
                }
                com.ironsource.mediationsdk.model.d dVar = new com.ironsource.mediationsdk.model.d(optBoolean, optBoolean2, optString2, optString3, optInt, optInt2, optInt3, iArr13, iArr14, iArr15, iArr16);
                if (l14 != null) {
                    JSONObject l19 = l(l14, "rewardedVideo");
                    str28 = str28;
                    str9 = "maxNumberOfEvents";
                    jSONObject3 = l14;
                    str4 = "backupThreshold";
                    str5 = "serverEventsType";
                    str8 = "serverEventsURL";
                    b bVar5 = new b(l14.optString("auctionData", ""), l14.optString("auctioneerURL", ""), l14.optInt("auctionTrials", 2), l14.optInt("auctionSavedHistory", 15), l14.optLong("auctionTimeout", 10000L), l19.optBoolean("programmatic", false), l19.optInt("minTimeBeforeFirstAuction", 2000), l19.optInt("auctionRetryInterval", BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH), l19.optInt("timeToWaitBeforeAuction", 5000), l19.optInt("timeToWaitBeforeLoad", 50), l19.optBoolean("isAuctionOnShowStart", false), l19.optBoolean("isLoadWhileShow", false), l19.optInt("timeToDeleteOldWaterfallAfterAuction", BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH), l14.optBoolean("compressAuctionRequest", false), l14.optBoolean("compressAuctionResponse", false), false);
                    JSONArray optJSONArray6 = l19.optJSONArray("disableLoadWhileShowSupportFor");
                    if (optJSONArray6 != null) {
                        for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                            bVar5.a(optJSONArray6.optString(i8));
                        }
                    }
                    bVar4 = bVar5;
                } else {
                    str8 = "serverEventsURL";
                    str28 = str28;
                    str4 = "backupThreshold";
                    str5 = "serverEventsType";
                    jSONObject3 = l14;
                    str9 = "maxNumberOfEvents";
                    bVar4 = new b();
                }
                s sVar2 = new s(i3, z2, e4, e5, e6, dVar, bVar4);
                if (optJSONArray != null) {
                    for (int i9 = 0; i9 < optJSONArray.length(); i9++) {
                        o u = u(optJSONArray.optJSONObject(i9));
                        if (u != null) {
                            sVar2.a(u);
                        }
                    }
                }
                String optString4 = l6.optString("backFill");
                if (!TextUtils.isEmpty(optString4)) {
                    sVar2.l(optString4);
                }
                String optString5 = l6.optString("premium");
                if (!TextUtils.isEmpty(optString5)) {
                    sVar2.m(optString5);
                }
                sVar = sVar2;
            } else {
                str = "events";
                str2 = "maxNumOfAdaptersToLoadOnStart";
                str3 = "placements";
                str4 = "backupThreshold";
                str5 = "serverEventsType";
                str6 = "maxEventsPerBatch";
                str7 = "optOut";
                jSONObject3 = l14;
                str8 = "serverEventsURL";
                str9 = "maxNumberOfEvents";
                sVar = null;
            }
            if (l7 != null) {
                str11 = str3;
                JSONArray optJSONArray7 = l7.optJSONArray(str11);
                str12 = str;
                JSONObject l20 = l(l7, str12);
                str13 = str2;
                int e7 = e(l7, l5, str13, 2);
                int e8 = e(l7, l5, "advancedLoading", 0);
                if (e8 > 0) {
                    i2 = e8;
                    z = true;
                } else {
                    i2 = e7;
                    z = false;
                }
                int e9 = e(l7, l5, "adapterTimeOutInSeconds", 60);
                int e10 = e(l7, l5, "delayLoadFailure", 3);
                JSONObject T2 = IronSourceUtils.T(l20, l10);
                boolean optBoolean3 = T2.optBoolean("sendEventsToggle", false);
                String optString6 = T2.optString(str8, "");
                str14 = str5;
                String optString7 = T2.optString(str14, "");
                String str31 = str4;
                int optInt4 = T2.optInt(str31, -1);
                String str32 = str9;
                int optInt5 = T2.optInt(str32, -1);
                str17 = str8;
                String str33 = str6;
                int optInt6 = T2.optInt(str33, 5000);
                str6 = str33;
                String str34 = str7;
                JSONArray optJSONArray8 = T2.optJSONArray(str34);
                if (optJSONArray8 != null) {
                    str7 = str34;
                    int[] iArr21 = new int[optJSONArray8.length()];
                    str16 = str32;
                    str4 = str31;
                    for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                        iArr21[i10] = optJSONArray8.optInt(i10);
                    }
                    iArr9 = iArr21;
                } else {
                    str16 = str32;
                    str7 = str34;
                    str4 = str31;
                    iArr9 = null;
                }
                String str35 = str30;
                JSONArray optJSONArray9 = T2.optJSONArray(str35);
                if (optJSONArray9 != null) {
                    int[] iArr22 = new int[optJSONArray9.length()];
                    str30 = str35;
                    for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                        iArr22[i11] = optJSONArray9.optInt(i11);
                    }
                    iArr10 = iArr22;
                } else {
                    str30 = str35;
                    iArr10 = null;
                }
                String str36 = str29;
                JSONArray optJSONArray10 = T2.optJSONArray(str36);
                if (optJSONArray10 != null) {
                    int[] iArr23 = new int[optJSONArray10.length()];
                    str29 = str36;
                    for (int i12 = 0; i12 < optJSONArray10.length(); i12++) {
                        iArr23[i12] = optJSONArray10.optInt(i12);
                    }
                    iArr11 = iArr23;
                } else {
                    str29 = str36;
                    iArr11 = null;
                }
                str10 = str28;
                JSONArray optJSONArray11 = T2.optJSONArray(str10);
                if (optJSONArray11 != null) {
                    int[] iArr24 = new int[optJSONArray11.length()];
                    for (int i13 = 0; i13 < optJSONArray11.length(); i13++) {
                        iArr24[i13] = optJSONArray11.optInt(i13);
                    }
                    iArr12 = iArr24;
                } else {
                    iArr12 = null;
                }
                com.ironsource.mediationsdk.model.d dVar2 = new com.ironsource.mediationsdk.model.d(false, optBoolean3, optString6, optString7, optInt4, optInt5, optInt6, iArr9, iArr10, iArr11, iArr12);
                if (jSONObject3 != null) {
                    jSONObject4 = jSONObject3;
                    JSONObject l21 = l(jSONObject4, "interstitial");
                    str15 = "sendEventsToggle";
                    bVar3 = new b(jSONObject4.optString("auctionData", ""), jSONObject4.optString("auctioneerURL", ""), jSONObject4.optInt("auctionTrials", 2), jSONObject4.optInt("auctionSavedHistory", 15), jSONObject4.optLong("auctionTimeout", 10000L), l21.optBoolean("programmatic", false), l21.optInt("minTimeBeforeFirstAuction", 2000), 0L, 0L, 0L, true, true, 0, jSONObject4.optBoolean("compressAuctionRequest", false), jSONObject4.optBoolean("compressAuctionResponse", false), l21.optBoolean("objectPerWaterfall", false));
                } else {
                    str15 = "sendEventsToggle";
                    jSONObject4 = jSONObject3;
                    bVar3 = new b();
                }
                com.ironsource.mediationsdk.model.j jVar2 = new com.ironsource.mediationsdk.model.j(i2, z, e9, dVar2, bVar3, e10);
                if (optJSONArray7 != null) {
                    for (int i14 = 0; i14 < optJSONArray7.length(); i14++) {
                        com.ironsource.mediationsdk.model.k s = s(optJSONArray7.optJSONObject(i14));
                        if (s != null) {
                            jVar2.a(s);
                        }
                    }
                }
                String optString8 = l7.optString("backFill");
                if (!TextUtils.isEmpty(optString8)) {
                    jVar2.l(optString8);
                }
                String optString9 = l7.optString("premium");
                if (!TextUtils.isEmpty(optString9)) {
                    jVar2.m(optString9);
                }
                jVar = jVar2;
            } else {
                str10 = str28;
                str11 = str3;
                str12 = str;
                str13 = str2;
                str14 = str5;
                str15 = "sendEventsToggle";
                str16 = str9;
                str17 = str8;
                jSONObject4 = jSONObject3;
                jVar = null;
            }
            if (l9 != null) {
                JSONArray optJSONArray12 = l9.optJSONArray(str11);
                JSONObject l22 = l(l9, str12);
                int e11 = e(l9, l5, str13, 1);
                str18 = str11;
                str20 = str12;
                jSONObject6 = jSONObject2;
                jSONObject7 = l16;
                String str37 = str29;
                String str38 = str30;
                long f2 = f(l9, l5, "atim", 10000L);
                int e12 = e(l9, l5, "delayLoadFailure", 3);
                int e13 = e(l9, l5, "bannerInterval", 60);
                JSONObject T3 = IronSourceUtils.T(l22, l10);
                str22 = str15;
                boolean optBoolean4 = T3.optBoolean(str22, false);
                str21 = str17;
                str19 = "";
                String optString10 = T3.optString(str21, str19);
                String optString11 = T3.optString(str14, str19);
                str26 = str4;
                int optInt7 = T3.optInt(str26, -1);
                String str39 = str16;
                int optInt8 = T3.optInt(str39, -1);
                String str40 = str6;
                int optInt9 = T3.optInt(str40, 5000);
                String str41 = str7;
                JSONArray optJSONArray13 = T3.optJSONArray(str41);
                if (optJSONArray13 != null) {
                    jSONObject5 = l5;
                    int[] iArr25 = new int[optJSONArray13.length()];
                    str6 = str40;
                    str7 = str41;
                    for (int i15 = 0; i15 < optJSONArray13.length(); i15++) {
                        iArr25[i15] = optJSONArray13.optInt(i15);
                    }
                    iArr5 = iArr25;
                } else {
                    jSONObject5 = l5;
                    str6 = str40;
                    str7 = str41;
                    iArr5 = null;
                }
                JSONArray optJSONArray14 = T3.optJSONArray(str38);
                if (optJSONArray14 != null) {
                    int[] iArr26 = new int[optJSONArray14.length()];
                    str24 = str38;
                    for (int i16 = 0; i16 < optJSONArray14.length(); i16++) {
                        iArr26[i16] = optJSONArray14.optInt(i16);
                    }
                    iArr6 = iArr26;
                } else {
                    str24 = str38;
                    iArr6 = null;
                }
                JSONArray optJSONArray15 = T3.optJSONArray(str37);
                if (optJSONArray15 != null) {
                    int[] iArr27 = new int[optJSONArray15.length()];
                    str23 = str37;
                    for (int i17 = 0; i17 < optJSONArray15.length(); i17++) {
                        iArr27[i17] = optJSONArray15.optInt(i17);
                    }
                    iArr7 = iArr27;
                } else {
                    str23 = str37;
                    iArr7 = null;
                }
                JSONArray optJSONArray16 = T3.optJSONArray(str10);
                if (optJSONArray16 != null) {
                    int[] iArr28 = new int[optJSONArray16.length()];
                    for (int i18 = 0; i18 < optJSONArray16.length(); i18++) {
                        iArr28[i18] = optJSONArray16.optInt(i18);
                    }
                    iArr8 = iArr28;
                } else {
                    iArr8 = null;
                }
                com.ironsource.mediationsdk.model.d dVar3 = new com.ironsource.mediationsdk.model.d(false, optBoolean4, optString10, optString11, optInt7, optInt8, optInt9, iArr5, iArr6, iArr7, iArr8);
                if (jSONObject4 != null) {
                    JSONObject l23 = l(jSONObject4, "banner");
                    if (l23 != null) {
                        str25 = str39;
                        bVar2 = new b(jSONObject4.optString("auctionData", str19), jSONObject4.optString("auctioneerURL", str19), jSONObject4.optInt("auctionTrials", 2), jSONObject4.optInt("auctionSavedHistory", 15), jSONObject4.optLong("auctionTimeout", 10000L), l23.optBoolean("programmatic", false), l23.optInt("minTimeBeforeFirstAuction", 2000), 0L, 0L, 0L, true, true, 0, jSONObject4.optBoolean("compressAuctionRequest", false), jSONObject4.optBoolean("compressAuctionResponse", false), false);
                    } else {
                        str25 = str39;
                        bVar2 = new b();
                    }
                    bVar = bVar2;
                } else {
                    str25 = str39;
                    bVar = new b();
                }
                com.ironsource.mediationsdk.model.g gVar2 = new com.ironsource.mediationsdk.model.g(e11, f2, dVar3, e13, bVar, e12);
                if (optJSONArray12 != null) {
                    for (int i19 = 0; i19 < optJSONArray12.length(); i19++) {
                        com.ironsource.mediationsdk.model.h r = r(optJSONArray12.optJSONObject(i19));
                        if (r != null) {
                            gVar2.a(r);
                        }
                    }
                }
                gVar = gVar2;
            } else {
                str18 = str11;
                str19 = "";
                jSONObject5 = l5;
                str20 = str12;
                jSONObject6 = jSONObject2;
                jSONObject7 = l16;
                str21 = str17;
                str22 = str15;
                str23 = str29;
                str24 = str30;
                str25 = str16;
                str26 = str4;
                gVar = null;
            }
            if (l8 != null) {
                str27 = str20;
                JSONObject T4 = IronSourceUtils.T(l(l8, str27), l10);
                boolean optBoolean5 = T4.optBoolean(str22, false);
                String optString12 = T4.optString(str21, str19);
                String optString13 = T4.optString(str14, str19);
                int optInt10 = T4.optInt(str26, -1);
                int optInt11 = T4.optInt(str25, -1);
                int optInt12 = T4.optInt(str6, 5000);
                JSONArray optJSONArray17 = T4.optJSONArray(str7);
                if (optJSONArray17 != null) {
                    int[] iArr29 = new int[optJSONArray17.length()];
                    for (int i20 = 0; i20 < optJSONArray17.length(); i20++) {
                        iArr29[i20] = optJSONArray17.optInt(i20);
                    }
                    iArr = iArr29;
                } else {
                    iArr = null;
                }
                JSONArray optJSONArray18 = T4.optJSONArray(str24);
                if (optJSONArray18 != null) {
                    int[] iArr30 = new int[optJSONArray18.length()];
                    for (int i21 = 0; i21 < optJSONArray18.length(); i21++) {
                        iArr30[i21] = optJSONArray18.optInt(i21);
                    }
                    iArr2 = iArr30;
                } else {
                    iArr2 = null;
                }
                JSONArray optJSONArray19 = T4.optJSONArray(str23);
                if (optJSONArray19 != null) {
                    int[] iArr31 = new int[optJSONArray19.length()];
                    for (int i22 = 0; i22 < optJSONArray19.length(); i22++) {
                        iArr31[i22] = optJSONArray19.optInt(i22);
                    }
                    iArr3 = iArr31;
                } else {
                    iArr3 = null;
                }
                JSONArray optJSONArray20 = T4.optJSONArray(str10);
                if (optJSONArray20 != null) {
                    int[] iArr32 = new int[optJSONArray20.length()];
                    for (int i23 = 0; i23 < optJSONArray20.length(); i23++) {
                        iArr32[i23] = optJSONArray20.optInt(i23);
                    }
                    iArr4 = iArr32;
                } else {
                    iArr4 = null;
                }
                com.ironsource.mediationsdk.model.m mVar2 = new com.ironsource.mediationsdk.model.m(new com.ironsource.mediationsdk.model.d(false, optBoolean5, optString12, optString13, optInt10, optInt11, optInt12, iArr, iArr2, iArr3, iArr4));
                mVar2.d(l8);
                JSONArray optJSONArray21 = l8.optJSONArray(str18);
                if (optJSONArray21 != null) {
                    for (int i24 = 0; i24 < optJSONArray21.length(); i24++) {
                        com.ironsource.mediationsdk.model.n t = t(optJSONArray21.optJSONObject(i24));
                        if (t != null) {
                            mVar2.a(t);
                        }
                    }
                }
                mVar = mVar2;
            } else {
                str27 = str20;
                mVar = null;
            }
            n nVar = new n();
            if (l12 != null) {
                JSONArray optJSONArray22 = l12.optJSONArray("optInKeys");
                if (optJSONArray22 != null) {
                    for (int i25 = 0; i25 < optJSONArray22.length(); i25++) {
                        nVar.a(optJSONArray22.optString(i25));
                    }
                }
                JSONObject optJSONObject = l12.optJSONObject("tokenGenericParams");
                if (optJSONObject != null) {
                    nVar.b(optJSONObject);
                }
            }
            com.ironsource.mediationsdk.model.f fVar = new com.ironsource.mediationsdk.model.f(l11.optInt("server", 3), l11.optInt("publisher", 3), l11.optInt("console", 3));
            com.ironsource.mediationsdk.model.c cVar = new com.ironsource.mediationsdk.model.c();
            JSONObject jSONObject8 = jSONObject6;
            if (jSONObject8 != null) {
                cVar.i(jSONObject8.optBoolean(TJAdUnitConstants.String.ENABLED, false));
                cVar.k(jSONObject8.optString("reporterURL", str19));
                cVar.j(jSONObject8.optString("reporterKeyword", str19));
                cVar.l(jSONObject8.optBoolean("includeANR", false));
                cVar.h(jSONObject8.optInt("timeout", 5000));
                JSONArray optJSONArray23 = jSONObject8.optJSONArray("keysToInclude");
                if (optJSONArray23 != null) {
                    for (int i26 = 0; i26 < optJSONArray23.length(); i26++) {
                        cVar.a(optJSONArray23.optString(i26));
                    }
                }
            }
            t tVar = l13 != null ? new t(l13.optString("name", str19), l13.optString(TapjoyAuctionFlags.AUCTION_ID, TaskDetailBasePresenter.SCENE_LIST), l13.optJSONObject("custom")) : null;
            JSONObject jSONObject9 = jSONObject7;
            a aVar = jSONObject9 != null ? new a(jSONObject9.optBoolean("isExternalArmEventsEnabled", true), jSONObject9.optString("externalArmEventsUrl", "http://outcome-arm-ext-med-ext.sonic-us.supersonicads.com/aemData")) : new a();
            com.ironsource.mediationsdk.model.e eVar2 = new com.ironsource.mediationsdk.model.e();
            if (jSONObject != null) {
                JSONObject jSONObject10 = jSONObject;
                JSONObject optJSONObject2 = jSONObject10.optJSONObject("mediationTypes");
                Map hashMap = new HashMap();
                if (optJSONObject2 != null) {
                    hashMap = IronSourceUtils.U(optJSONObject2);
                }
                eVar = new com.ironsource.mediationsdk.model.e(jSONObject10.optBoolean("compressExternalToken", false), hashMap);
            } else {
                eVar = eVar2;
            }
            this.c = new com.ironsource.mediationsdk.model.i(sVar, jVar, mVar, gVar, new com.ironsource.mediationsdk.model.b(fVar, tVar, nVar, jSONObject5.optBoolean("integration", false), cVar, aVar, eVar));
            JSONObject l24 = l(l10, "genericParams");
            if (l24 != null && (l2 = l(l24, str27)) != null) {
                l24.remove(str27);
                Map<String, String> U = IronSourceUtils.U(l2);
                RewardedVideoEventsManager.getInstance().X(U);
                InterstitialEventsManager.getInstance().X(U);
            }
            if (l24 != null) {
                Map<String, String> U2 = IronSourceUtils.U(l24);
                RewardedVideoEventsManager.getInstance().U(U2);
                InterstitialEventsManager.getInstance().U(U2);
            }
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    private void p() {
        try {
            JSONObject l2 = l(this.f5673f, "providerOrder");
            JSONArray optJSONArray = l2.optJSONArray("rewardedVideo");
            JSONArray optJSONArray2 = l2.optJSONArray("interstitial");
            JSONArray optJSONArray3 = l2.optJSONArray("banner");
            this.a = new q();
            if (optJSONArray != null && b() != null && b().e() != null) {
                String b = b().e().b();
                String f2 = b().e().f();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString.equals(b)) {
                        this.a.k(b);
                    } else {
                        if (optString.equals(f2)) {
                            this.a.l(f2);
                        }
                        this.a.c(optString);
                        com.ironsource.mediationsdk.model.l d2 = r.e().d(optString);
                        if (d2 != null) {
                            d2.D(i2);
                        }
                    }
                }
            }
            if (optJSONArray2 != null && b() != null && b().c() != null) {
                String b2 = b().c().b();
                String k2 = b().c().k();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    String optString2 = optJSONArray2.optString(i3);
                    if (optString2.equals(b2)) {
                        this.a.i(b2);
                    } else {
                        if (optString2.equals(k2)) {
                            this.a.j(k2);
                        }
                        this.a.b(optString2);
                        com.ironsource.mediationsdk.model.l d3 = r.e().d(optString2);
                        if (d3 != null) {
                            d3.z(i3);
                        }
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    String optString3 = optJSONArray3.optString(i4);
                    this.a.a(optString3);
                    com.ironsource.mediationsdk.model.l d4 = r.e().d(optString3);
                    if (d4 != null) {
                        d4.w(i4);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void q() {
        JSONObject jSONObject;
        try {
            this.b = r.e();
            JSONObject l2 = l(this.f5673f, "providerSettings");
            Iterator<String> keys = l2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = l2.optJSONObject(next);
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("mpis", false);
                    String optString = optJSONObject.optString("spId", "0");
                    String optString2 = optJSONObject.optString("adSourceName", null);
                    String optString3 = optJSONObject.optString("providerLoadName", next);
                    String optString4 = optJSONObject.optString("providerDefaultInstance", optString3);
                    JSONObject l3 = l(optJSONObject, "adUnits");
                    JSONObject l4 = l(optJSONObject, "application");
                    JSONObject l5 = l(l3, "rewardedVideo");
                    JSONObject l6 = l(l3, "interstitial");
                    JSONObject l7 = l(l3, "banner");
                    JSONObject T = IronSourceUtils.T(l5, l4);
                    JSONObject T2 = IronSourceUtils.T(l6, l4);
                    JSONObject T3 = IronSourceUtils.T(l7, l4);
                    if (this.b.b(next)) {
                        com.ironsource.mediationsdk.model.l d2 = this.b.d(next);
                        JSONObject o = d2.o();
                        JSONObject h2 = d2.h();
                        JSONObject d3 = d2.d();
                        d2.F(IronSourceUtils.T(o, T));
                        d2.B(IronSourceUtils.T(h2, T2));
                        d2.y(IronSourceUtils.T(d3, T3));
                        d2.C(optBoolean);
                        d2.G(optString);
                        d2.u(optString2);
                    } else {
                        if (v(optString3)) {
                            com.ironsource.mediationsdk.model.l d4 = this.b.d("Mediation");
                            JSONObject o2 = d4.o();
                            JSONObject h3 = d4.h();
                            JSONObject d5 = d4.d();
                            jSONObject = l2;
                            com.ironsource.mediationsdk.model.l lVar = new com.ironsource.mediationsdk.model.l(next, optString3, optString4, l4, IronSourceUtils.T(new JSONObject(o2.toString()), T), IronSourceUtils.T(new JSONObject(h3.toString()), T2), IronSourceUtils.T(new JSONObject(d5.toString()), T3));
                            lVar.C(optBoolean);
                            lVar.G(optString);
                            lVar.u(optString2);
                            this.b.a(lVar);
                        } else {
                            jSONObject = l2;
                            com.ironsource.mediationsdk.model.l lVar2 = new com.ironsource.mediationsdk.model.l(next, optString3, optString4, l4, T, T2, T3);
                            lVar2.C(optBoolean);
                            lVar2.G(optString);
                            lVar2.u(optString2);
                            this.b.a(lVar2);
                        }
                        l2 = jSONObject;
                    }
                }
                jSONObject = l2;
                l2 = jSONObject;
            }
            this.b.c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private com.ironsource.mediationsdk.model.h r(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            p g2 = g(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                com.ironsource.mediationsdk.model.h hVar = new com.ironsource.mediationsdk.model.h(optInt, optString, optBoolean, g2);
                if (g2 != null) {
                    CappingManager.a(this.f5674g, hVar);
                    return hVar;
                }
                return hVar;
            }
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.k s(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            p g2 = g(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                com.ironsource.mediationsdk.model.k kVar = new com.ironsource.mediationsdk.model.k(optInt, optString, optBoolean, g2);
                if (g2 != null) {
                    CappingManager.b(this.f5674g, kVar);
                    return kVar;
                }
                return kVar;
            }
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.n t(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                return new com.ironsource.mediationsdk.model.n(optInt, optString, optBoolean);
            }
        }
        return null;
    }

    private o u(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            String optString2 = jSONObject.optString("virtualItemName", "");
            int optInt2 = jSONObject.optInt("virtualItemCount", -1);
            p g2 = g(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optInt2 > 0) {
                o oVar = new o(optInt, optString, optBoolean, optString2, optInt2, g2);
                if (g2 != null) {
                    CappingManager.c(this.f5674g, oVar);
                    return oVar;
                }
                return oVar;
            }
        }
        return null;
    }

    private boolean v(String str) {
        String a = com.ironsource.environment.j.a(str);
        return this.b.b("Mediation") && (com.ironsource.environment.j.a("SupersonicAds").equals(a) || com.ironsource.environment.j.a("IronSource").equals(a));
    }

    public com.ironsource.mediationsdk.model.i b() {
        return this.c;
    }

    public List<IronSource.AD_UNIT> d() {
        q qVar;
        q qVar2;
        if (this.f5673f == null || this.c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.c.e() != null && (qVar2 = this.a) != null && qVar2.h().size() > 0) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (this.c.c() != null && (qVar = this.a) != null && qVar.e().size() > 0) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.c.d() != null) {
            arrayList.add(IronSource.AD_UNIT.OFFERWALL);
        }
        if (this.c.b() != null) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        return arrayList;
    }

    public q h() {
        return this.a;
    }

    public r i() {
        return this.b;
    }

    public String j() {
        try {
            return this.a.f();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.INTERNAL, "getRVBackFillProvider", e2);
            return null;
        }
    }

    public String k() {
        try {
            return this.a.g();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.INTERNAL, "getRVPremiumProvider", e2);
            return null;
        }
    }

    public boolean n() {
        JSONObject jSONObject = this.f5673f;
        return (((((jSONObject != null) && !jSONObject.has("error")) && this.a != null) && this.b != null) && this.c != null) && m();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.f5671d);
            jSONObject.put(GuestProfileFragment.USER_ID, this.f5672e);
            jSONObject.put("response", this.f5673f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public k(k kVar) {
        try {
            this.f5674g = kVar.c();
            this.f5673f = new JSONObject(kVar.f5673f.toString());
            this.f5671d = kVar.f5671d;
            this.f5672e = kVar.f5672e;
            this.a = kVar.h();
            this.b = kVar.i();
            this.c = kVar.b();
        } catch (Exception unused) {
            a();
        }
    }
}
