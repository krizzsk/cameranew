package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: AdInfoFactory.java */
/* loaded from: classes.dex */
public class c {
    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.a a(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.a aVar = new com.bytedance.sdk.openadsdk.core.d.a();
            aVar.a(jSONObject.optString("request_id"));
            aVar.a(jSONObject.optInt("ret"));
            aVar.b(jSONObject.optString("message"));
            String optString = jSONObject.optString("auction_price");
            if (aVar.b() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    com.bytedance.sdk.openadsdk.core.d.h b = b(optJSONArray.optJSONObject(i2), adSlot);
                    if (b != null && a(b)) {
                        b.b(optString);
                        aVar.a(b);
                    }
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.h b(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.h hVar = new com.bytedance.sdk.openadsdk.core.d.h();
        hVar.l(jSONObject.optInt("interaction_type"));
        hVar.d(jSONObject.optString("target_url"));
        hVar.i(jSONObject.optString("ad_id"));
        hVar.c(jSONObject.optString("source"));
        hVar.o(jSONObject.optInt("dislike_control", 0));
        hVar.h(jSONObject.optInt("play_bar_show_time", -200));
        hVar.a(jSONObject.optBoolean("is_playable"));
        hVar.b(jSONObject.optInt("playable_type", 0));
        hVar.a(jSONObject.optString("playable_style"));
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        hVar.b(jSONObject.optBoolean("screenshot", false));
        hVar.f(jSONObject.optInt("play_bar_style", 0));
        hVar.k(jSONObject.optString("market_url", ""));
        hVar.d(jSONObject.optInt("video_adaptation", 0));
        hVar.c(jSONObject.optInt("feed_video_opentype", 0));
        hVar.a(jSONObject.optJSONObject("session_params"));
        hVar.b(jSONObject.optString("auction_price", ""));
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.d.g gVar = new com.bytedance.sdk.openadsdk.core.d.g();
            gVar.a(optJSONObject.optString("url"));
            gVar.b(optJSONObject.optInt("height"));
            gVar.a(optJSONObject.optInt("width"));
            hVar.a(gVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cover_image");
        if (optJSONObject2 != null) {
            com.bytedance.sdk.openadsdk.core.d.g gVar2 = new com.bytedance.sdk.openadsdk.core.d.g();
            gVar2.a(optJSONObject2.optString("url"));
            gVar2.b(optJSONObject2.optInt("height"));
            gVar2.a(optJSONObject2.optInt("width"));
            hVar.b(gVar2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(QiniuAuthToken.TYPE_IMAGE);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.bytedance.sdk.openadsdk.core.d.g gVar3 = new com.bytedance.sdk.openadsdk.core.d.g();
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                gVar3.a(optJSONObject3.optString("url"));
                gVar3.b(optJSONObject3.optInt("height"));
                gVar3.a(optJSONObject3.optInt("width"));
                hVar.c(gVar3);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                hVar.D().add(optJSONArray2.optString(i3));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(TapjoyConstants.TJC_CLICK_URL);
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                hVar.E().add(optJSONArray3.optString(i4));
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("play_start");
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                hVar.F().add(optJSONArray4.optString(i5));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("click_area");
        if (optJSONObject4 != null) {
            com.bytedance.sdk.openadsdk.core.d.c cVar = new com.bytedance.sdk.openadsdk.core.d.c();
            cVar.a = optJSONObject4.optBoolean("click_upper_content_area", true);
            cVar.b = optJSONObject4.optBoolean("click_upper_non_content_area", true);
            cVar.c = optJSONObject4.optBoolean("click_lower_content_area", true);
            cVar.f1553d = optJSONObject4.optBoolean("click_lower_non_content_area", true);
            cVar.f1554e = optJSONObject4.optBoolean("click_button_area", true);
            cVar.f1555f = optJSONObject4.optBoolean("click_video_area", true);
            hVar.a(cVar);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("adslot");
        if (optJSONObject5 != null) {
            hVar.a(b(optJSONObject5));
        } else {
            hVar.a(adSlot);
        }
        hVar.g(jSONObject.optInt("intercept_flag", 0));
        hVar.e(jSONObject.optString("phone_num"));
        hVar.f(jSONObject.optString("title"));
        hVar.g(jSONObject.optString(SocialConstants.PARAM_COMMENT));
        hVar.h(jSONObject.optString("button_text"));
        hVar.e(jSONObject.optInt("ad_logo", 1));
        hVar.j(jSONObject.optString("ext"));
        hVar.m(jSONObject.optInt("image_mode"));
        JSONObject optJSONObject6 = jSONObject.optJSONObject("app");
        JSONObject optJSONObject7 = jSONObject.optJSONObject("deep_link");
        hVar.a(d(optJSONObject6));
        hVar.a(e(optJSONObject7));
        JSONArray optJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray5 != null) {
            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                FilterWord c = c(optJSONArray5.optJSONObject(i6));
                if (c != null && c.isValid()) {
                    hVar.a(c);
                }
            }
        }
        hVar.n(jSONObject.optInt("count_down"));
        hVar.a(jSONObject.optLong("expiration_time"));
        JSONObject optJSONObject8 = jSONObject.optJSONObject("video");
        if (optJSONObject8 != null) {
            hVar.a(f(optJSONObject8));
        }
        hVar.a(g(jSONObject.optJSONObject("media_ext")));
        JSONObject optJSONObject9 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject9 != null) {
            h.a aVar = new h.a();
            aVar.b(optJSONObject9.optString(TapjoyAuctionFlags.AUCTION_ID));
            aVar.c(optJSONObject9.optString("md5"));
            aVar.d(optJSONObject9.optString("url"));
            aVar.e(optJSONObject9.optString("data"));
            aVar.f(optJSONObject9.optString("diff_data"));
            aVar.g(optJSONObject9.optString("dynamic_creative"));
            aVar.a(optJSONObject9.optString("version"));
            hVar.a(aVar);
        }
        hVar.a(jSONObject.optInt("if_block_lp", 0));
        hVar.i(jSONObject.optInt("cache_sort", 1));
        hVar.j(jSONObject.optInt("if_sp_cache", 0));
        hVar.k(jSONObject.optInt("ua_policy", 2));
        return hVar;
    }

    private static FilterWord c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString(TapjoyAuctionFlags.AUCTION_ID));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    FilterWord c = c(optJSONArray.optJSONObject(i2));
                    if (c != null && c.isValid()) {
                        filterWord.addOption(c);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.b d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.b bVar = new com.bytedance.sdk.openadsdk.core.d.b();
        bVar.b(jSONObject.optString("app_name"));
        bVar.c(jSONObject.optString("package_name"));
        bVar.a(jSONObject.optString("download_url"));
        bVar.a(jSONObject.optInt(FirebaseAnalytics.Param.SCORE, 4));
        bVar.b(jSONObject.optInt("comment_num", 6870));
        bVar.c(jSONObject.optInt("app_size", 0));
        return bVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.e eVar = new com.bytedance.sdk.openadsdk.core.d.e();
        eVar.a(jSONObject.optString("deeplink_url"));
        eVar.b(jSONObject.optString("fallback_url"));
        eVar.a(jSONObject.optInt("fallback_type"));
        return eVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.n f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.n nVar = new com.bytedance.sdk.openadsdk.core.d.n();
        nVar.b(jSONObject.optInt("cover_height"));
        nVar.c(jSONObject.optInt("cover_width"));
        nVar.a(jSONObject.optString("resolution"));
        nVar.a(jSONObject.optLong(BigAlbumStore.PhotoColumns.SIZE));
        nVar.a(jSONObject.optDouble("video_duration"));
        nVar.b(jSONObject.optString("cover_url"));
        nVar.c(jSONObject.optString(TapjoyConstants.TJC_VIDEO_URL));
        nVar.d(jSONObject.optString("endcard"));
        nVar.e(jSONObject.optString("playable_download_url"));
        nVar.f(jSONObject.optString("file_hash"));
        nVar.d(jSONObject.optInt("if_playable_loading_show", 0));
        nVar.e(jSONObject.optInt("remove_loading_page_type", 0));
        nVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
        return nVar;
    }

    private static Map<String, Object> g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.h a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return b(jSONObject, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
        if (r0 != 16) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(com.bytedance.sdk.openadsdk.core.d.h r7) {
        /*
            r0 = 1
            r1 = 0
            if (r7 != 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            if (r7 == 0) goto L8b
            java.lang.String r3 = r7.J()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L8a
            java.lang.String r3 = r7.J()
            int r3 = r3.length()
            if (r3 > r0) goto L1f
            goto L8a
        L1f:
            com.bytedance.sdk.openadsdk.core.d.e r0 = r7.L()
            boolean r0 = a(r0)
            if (r0 != 0) goto L2a
            return r1
        L2a:
            int r0 = r7.x()
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L51
            if (r0 == r5) goto L51
            if (r0 == r4) goto L46
            if (r0 == r3) goto L3b
            goto L5c
        L3b:
            java.lang.String r0 = r7.C()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5c
            goto L5b
        L46:
            com.bytedance.sdk.openadsdk.core.d.b r0 = r7.K()
            boolean r0 = a(r0)
            if (r0 != 0) goto L5c
            goto L5b
        L51:
            java.lang.String r0 = r7.A()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5c
        L5b:
            r2 = 0
        L5c:
            if (r2 != 0) goto L5f
            return r2
        L5f:
            int r0 = r7.N()
            if (r0 == r6) goto L7f
            if (r0 == r5) goto L7f
            if (r0 == r4) goto L7f
            if (r0 == r3) goto L74
            r3 = 15
            if (r0 == r3) goto L74
            r3 = 16
            if (r0 == r3) goto L7f
            goto L8b
        L74:
            com.bytedance.sdk.openadsdk.core.d.n r7 = r7.v()
            boolean r7 = a(r7)
            if (r7 != 0) goto L8b
            goto L8c
        L7f:
            java.util.List r7 = r7.B()
            boolean r7 = a(r7)
            if (r7 != 0) goto L8b
            goto L8c
        L8a:
            return r1
        L8b:
            r1 = r2
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.d.h):boolean");
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(eVar.a()) || TextUtils.isEmpty(eVar.b())) {
            return false;
        }
        return eVar.c() == 1 || eVar.c() == 2;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.n nVar) {
        return (nVar == null || TextUtils.isEmpty(nVar.h()) || TextUtils.isEmpty(nVar.g())) ? false : true;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.a())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.util.List<com.bytedance.sdk.openadsdk.core.d.g> r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L4
            return r0
        L4:
            int r1 = r2.size()
            if (r1 > 0) goto Lb
            return r0
        Lb:
            java.util.Iterator r2 = r2.iterator()
        Lf:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L29
            java.lang.Object r1 = r2.next()
            com.bytedance.sdk.openadsdk.core.d.g r1 = (com.bytedance.sdk.openadsdk.core.d.g) r1
            if (r1 != 0) goto L1e
            return r0
        L1e:
            java.lang.String r1 = r1.a()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lf
            return r0
        L29:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.c.a(java.util.List):boolean");
    }

    private static AdSlot b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("mCodeId", "");
        int optInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        int optInt3 = jSONObject.optInt("mAdCount", 6);
        boolean optBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String optString2 = jSONObject.optString("mRewardName", "");
        int optInt4 = jSONObject.optInt("mRewardAmount", 0);
        String optString3 = jSONObject.optString("mMediaExtra", "");
        String optString4 = jSONObject.optString("mUserID", "");
        int optInt5 = jSONObject.optInt("mOrientation", 2);
        int optInt6 = jSONObject.optInt("mNativeAdType", 0);
        boolean optBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean optBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize((float) jSONObject.optDouble("mExpressViewAcceptedWidth", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (float) jSONObject.optDouble("mExpressViewAcceptedHeight", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setOrientation(optInt5).setNativeAdType(optInt6).setIsAutoPlay(optBoolean2).isExpressAd(optBoolean3).withBid(jSONObject.optString("mBidAdm", "")).build();
    }
}
