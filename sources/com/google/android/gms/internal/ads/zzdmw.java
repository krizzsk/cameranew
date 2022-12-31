package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.collection.Constants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmw {
    public final String id;
    public final boolean zzbpm;
    @Nullable
    public final String zzcht;
    public final String zzdlu;
    public final String zzdmf;
    public final String zzdmg;
    public final List<String> zzdmp;
    public final List<String> zzdmq;
    public final String zzdmv;
    public final boolean zzdnc;
    public final boolean zzdnd;
    public final boolean zzdne;
    public final String zzdoq;
    public final List<String> zzdwa;
    public final String zzdwd;
    public final String zzdwg;
    @Nullable
    public final zzavj zzdwm;
    public final List<String> zzdwn;
    public final List<String> zzdwo;
    public final boolean zzdww;
    public final boolean zzdwz;
    public final boolean zzdxa;
    public final boolean zzdxt;
    public final String zzeuo;
    public final int zzfto;
    public final boolean zzftp;
    public final boolean zzftq;
    public final String zzfzc;
    public final List<String> zzhix;
    public final int zzhiy;
    public final int zzhiz;
    public final List<String> zzhja;
    public final List<String> zzhjb;
    public final List<String> zzhjc;
    public final List<String> zzhjd;
    public final int zzhje;
    public final List<zzdmz> zzhjf;
    @Nullable
    public final zzdnd zzhjg;
    public final List<String> zzhjh;
    public final List<zzdmz> zzhji;
    public final JSONObject zzhjj;
    public final zzawu zzhjk;
    public final JSONObject zzhjl;
    public final JSONObject zzhjm;
    public final String zzhjn;
    public final boolean zzhjo;
    public final int zzhjp;
    public final int zzhjq;
    public final OmidSettings zzhjr;
    public final int zzhjs;
    public final boolean zzhjt;
    public final zzarx zzhju;
    @Nullable
    public final zzvu zzhjv;
    public final String zzhjw;
    public final boolean zzhjx;
    public final JSONObject zzhjy;
    public final boolean zzhjz;
    public final JSONObject zzhka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmw(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<zzdmz> list;
        char c;
        List<String> list2;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<String> emptyList10 = Collections.emptyList();
        List<zzdmz> emptyList11 = Collections.emptyList();
        List<String> emptyList12 = Collections.emptyList();
        List<zzdmz> emptyList13 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        JSONObject jSONObject7 = jSONObject;
        JSONObject jSONObject8 = jSONObject2;
        JSONObject jSONObject9 = jSONObject3;
        JSONObject jSONObject10 = jSONObject4;
        JSONObject jSONObject11 = jSONObject5;
        JSONObject jSONObject12 = jSONObject6;
        zzavj zzavjVar = null;
        zzdnd zzdndVar = null;
        zzawu zzawuVar = null;
        zzarx zzarxVar = null;
        zzvu zzvuVar = null;
        String str13 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i5 = -1;
        int i6 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i7 = 0;
        int i8 = -1;
        boolean z11 = false;
        boolean z12 = true;
        boolean z13 = false;
        boolean z14 = false;
        List<String> list3 = emptyList12;
        List<zzdmz> list4 = emptyList13;
        List<String> list5 = emptyList10;
        List<zzdmz> list6 = emptyList11;
        List<String> list7 = emptyList8;
        List<String> list8 = emptyList9;
        List<String> list9 = emptyList6;
        List<String> list10 = emptyList7;
        List<String> list11 = emptyList4;
        List<String> list12 = emptyList5;
        List<String> list13 = emptyList2;
        List<String> list14 = emptyList3;
        List<String> list15 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str14 = nextName == null ? "" : nextName;
            str14.hashCode();
            switch (str14.hashCode()) {
                case -1980587809:
                    list = list4;
                    if (str14.equals("debug_signals")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1965512151:
                    list = list4;
                    if (str14.equals("omid_settings")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1812055556:
                    list = list4;
                    if (str14.equals("play_prewarm_options")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1662989631:
                    list = list4;
                    if (str14.equals("is_interscroller")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1620470467:
                    list = list4;
                    if (str14.equals("backend_query_id")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440104884:
                    list = list4;
                    if (str14.equals("is_custom_close_blocked")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1439500848:
                    list = list4;
                    if (str14.equals("orientation")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1428969291:
                    list = list4;
                    if (str14.equals("enable_omid")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1403779768:
                    list = list4;
                    if (str14.equals("showable_impression_type")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1375413093:
                    list = list4;
                    if (str14.equals("ad_cover")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1360811658:
                    list = list4;
                    if (str14.equals("ad_sizes")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1306015996:
                    list = list4;
                    if (str14.equals("adapters")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1303332046:
                    list = list4;
                    if (str14.equals("test_mode_enabled")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1289032093:
                    list = list4;
                    if (str14.equals("extras")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1240082064:
                    list = list4;
                    if (str14.equals("ad_event_value")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1234181075:
                    list = list4;
                    if (str14.equals("allow_pub_rendered_attribution")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -1168140544:
                    list = list4;
                    if (str14.equals("presentation_error_urls")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case -1152230954:
                    list = list4;
                    if (str14.equals("ad_type")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1146534047:
                    list = list4;
                    if (str14.equals("is_scroll_aware")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case -1115838944:
                    list = list4;
                    if (str14.equals("fill_urls")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -1081936678:
                    list = list4;
                    if (str14.equals("allocation_id")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case -1078050970:
                    list = list4;
                    if (str14.equals("video_complete_urls")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case -1051269058:
                    list = list4;
                    if (str14.equals("active_view")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case -982608540:
                    list = list4;
                    if (str14.equals("valid_from_timestamp")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case -776859333:
                    list = list4;
                    if (str14.equals("click_urls")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case -544216775:
                    list = list4;
                    if (str14.equals("safe_browsing")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case -437057161:
                    list = list4;
                    if (str14.equals("imp_urls")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case -404433734:
                    list = list4;
                    if (str14.equals("rtb_native_required_assets")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -404326515:
                    list = list4;
                    if (str14.equals("render_timeout_ms")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case -397704715:
                    list = list4;
                    if (str14.equals("ad_close_time_ms")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case -388807511:
                    list = list4;
                    if (str14.equals("content_url")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case -369773488:
                    list = list4;
                    if (str14.equals("is_close_button_enabled")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case -213424028:
                    list = list4;
                    if (str14.equals("watermark")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case -154616268:
                    list = list4;
                    if (str14.equals("is_offline_ad")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case -29338502:
                    list = list4;
                    if (str14.equals("allow_custom_click_gesture")) {
                        c = '\"';
                        break;
                    }
                    c = 65535;
                    break;
                case 3107:
                    list = list4;
                    if (str14.equals("ad")) {
                        c = Constants.ID_PREFIX;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    list = list4;
                    if (str14.equals(TapjoyAuctionFlags.AUCTION_ID)) {
                        c = '$';
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    list = list4;
                    if (str14.equals("data")) {
                        c = '%';
                        break;
                    }
                    c = 65535;
                    break;
                case 63195984:
                    list = list4;
                    if (str14.equals("render_test_label")) {
                        c = '&';
                        break;
                    }
                    c = 65535;
                    break;
                case 107433883:
                    list = list4;
                    if (str14.equals("qdata")) {
                        c = '\'';
                        break;
                    }
                    c = 65535;
                    break;
                case 230323073:
                    list = list4;
                    if (str14.equals("ad_load_urls")) {
                        c = '(';
                        break;
                    }
                    c = 65535;
                    break;
                case 418392395:
                    list = list4;
                    if (str14.equals("is_closable_area_disabled")) {
                        c = ')';
                        break;
                    }
                    c = 65535;
                    break;
                case 549176928:
                    list = list4;
                    if (str14.equals("presentation_error_timeout_ms")) {
                        c = '*';
                        break;
                    }
                    c = 65535;
                    break;
                case 597473788:
                    list = list4;
                    if (str14.equals("debug_dialog_string")) {
                        c = '+';
                        break;
                    }
                    c = 65535;
                    break;
                case 673261304:
                    list = list4;
                    if (str14.equals("reward_granted_urls")) {
                        c = ',';
                        break;
                    }
                    c = 65535;
                    break;
                case 754887508:
                    list = list4;
                    if (str14.equals("container_sizes")) {
                        c = '-';
                        break;
                    }
                    c = 65535;
                    break;
                case 791122864:
                    list = list4;
                    if (str14.equals("impression_type")) {
                        c = '.';
                        break;
                    }
                    c = 65535;
                    break;
                case 1010584092:
                    list = list4;
                    if (str14.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        c = '/';
                        break;
                    }
                    c = 65535;
                    break;
                case 1100650276:
                    list = list4;
                    if (str14.equals("rewards")) {
                        c = '0';
                        break;
                    }
                    c = 65535;
                    break;
                case 1321720943:
                    list = list4;
                    if (str14.equals("allow_pub_owned_ad_view")) {
                        c = '1';
                        break;
                    }
                    c = 65535;
                    break;
                case 1637553475:
                    list = list4;
                    if (str14.equals("bid_response")) {
                        c = '2';
                        break;
                    }
                    c = 65535;
                    break;
                case 1638957285:
                    list = list4;
                    if (str14.equals("video_start_urls")) {
                        c = '3';
                        break;
                    }
                    c = 65535;
                    break;
                case 1686319423:
                    list = list4;
                    if (str14.equals("ad_network_class_name")) {
                        c = '4';
                        break;
                    }
                    c = 65535;
                    break;
                case 1688341040:
                    list = list4;
                    if (str14.equals("video_reward_urls")) {
                        c = '5';
                        break;
                    }
                    c = 65535;
                    break;
                case 1799285870:
                    list = list4;
                    if (str14.equals("use_third_party_container_height")) {
                        c = '6';
                        break;
                    }
                    c = 65535;
                    break;
                case 1839650832:
                    list = list4;
                    if (str14.equals("renderers")) {
                        c = '7';
                        break;
                    }
                    c = 65535;
                    break;
                case 1875425491:
                    list = list4;
                    if (str14.equals("is_analytics_logging_enabled")) {
                        c = '8';
                        break;
                    }
                    c = 65535;
                    break;
                case 2068142375:
                    list = list4;
                    if (str14.equals("rule_line_external_id")) {
                        c = '9';
                        break;
                    }
                    c = 65535;
                    break;
                case 2072888499:
                    list = list4;
                    if (str14.equals("manual_tracking_urls")) {
                        c = ':';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    list = list4;
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    jSONObject8 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 1:
                    jSONObject10 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 2:
                    JSONObject zzc = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    if (zzc == null) {
                        list2 = list3;
                        zzarxVar = null;
                    } else {
                        list2 = list3;
                        zzarxVar = new zzarx(zzc.optBoolean("enable_prewarming", false), zzc.optString("prefetch_url", ""));
                    }
                    list3 = list2;
                    break;
                case 3:
                    z13 = jsonReader.nextBoolean();
                    break;
                case 4:
                    str10 = jsonReader.nextString();
                    break;
                case 5:
                    z6 = jsonReader.nextBoolean();
                    break;
                case 6:
                    String nextString = jsonReader.nextString();
                    if (!TJAdUnitConstants.String.LANDSCAPE.equalsIgnoreCase(nextString)) {
                        if (!TJAdUnitConstants.String.PORTRAIT.equalsIgnoreCase(nextString)) {
                            i5 = -1;
                            break;
                        } else {
                            i5 = 7;
                            break;
                        }
                    } else {
                        i5 = 6;
                        break;
                    }
                case 7:
                    z8 = jsonReader.nextBoolean();
                    break;
                case '\b':
                    i7 = jsonReader.nextInt();
                    break;
                case '\t':
                    jSONObject11 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case '\n':
                    list4 = zzdmz.zze(jsonReader);
                    continue;
                case 11:
                    list3 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case '\f':
                    z5 = jsonReader.nextBoolean();
                    break;
                case '\r':
                    jSONObject9 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 14:
                    zzvuVar = zzvu.zza(com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader));
                    break;
                case 15:
                    z = jsonReader.nextBoolean();
                    break;
                case 16:
                    list8 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 17:
                    String nextString2 = jsonReader.nextString();
                    if (!"banner".equals(nextString2)) {
                        if (!"interstitial".equals(nextString2)) {
                            if (!"native_express".equals(nextString2)) {
                                if (!TapjoyConstants.TJC_PLUGIN_NATIVE.equals(nextString2)) {
                                    if (!"rewarded".equals(nextString2)) {
                                        if (!"app_open_ad".equals(nextString2)) {
                                            i2 = 0;
                                            break;
                                        } else {
                                            i2 = 6;
                                            break;
                                        }
                                    } else {
                                        i2 = 5;
                                        break;
                                    }
                                } else {
                                    i2 = 4;
                                    break;
                                }
                            } else {
                                i2 = 3;
                                break;
                            }
                        } else {
                            i2 = 2;
                            break;
                        }
                    } else {
                        i2 = 1;
                        break;
                    }
                case 18:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 19:
                    list7 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 20:
                    str3 = jsonReader.nextString();
                    break;
                case 21:
                    list10 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 22:
                    str6 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader).toString();
                    break;
                case 23:
                    str2 = jsonReader.nextString();
                    break;
                case 24:
                    list13 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 25:
                    zzawuVar = zzawu.zzg(com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader));
                    break;
                case 26:
                    list14 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 27:
                    jSONObject12 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 28:
                    i6 = jsonReader.nextInt();
                    break;
                case 29:
                    i8 = jsonReader.nextInt();
                    break;
                case 30:
                    str13 = jsonReader.nextString();
                    break;
                case 31:
                    z12 = jsonReader.nextBoolean();
                    break;
                case ' ':
                    str9 = jsonReader.nextString();
                    break;
                case '!':
                    z14 = jsonReader.nextBoolean();
                    break;
                case '\"':
                    z3 = jsonReader.nextBoolean();
                    break;
                case '#':
                    zzdndVar = new zzdnd(jsonReader);
                    break;
                case '$':
                    str4 = jsonReader.nextString();
                    break;
                case '%':
                    jSONObject7 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case '&':
                    z4 = jsonReader.nextBoolean();
                    break;
                case '\'':
                    str5 = jsonReader.nextString();
                    break;
                case '(':
                    list11 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case ')':
                    z7 = jsonReader.nextBoolean();
                    break;
                case '*':
                    i4 = jsonReader.nextInt();
                    break;
                case '+':
                    str7 = jsonReader.nextString();
                    break;
                case ',':
                    com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case '-':
                    list6 = zzdmz.zze(jsonReader);
                    break;
                case '.':
                    int nextInt = jsonReader.nextInt();
                    if (nextInt != 0 && nextInt != 1) {
                        i3 = 0;
                        break;
                    } else {
                        i3 = nextInt;
                        break;
                    }
                case '/':
                    str = jsonReader.nextString();
                    break;
                case '0':
                    zzavjVar = zzavj.zza(com.google.android.gms.ads.internal.util.zzbh.zzd(jsonReader));
                    break;
                case '1':
                    z2 = jsonReader.nextBoolean();
                    break;
                case '2':
                    str8 = jsonReader.nextString();
                    break;
                case '3':
                    list12 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case '4':
                    str12 = jsonReader.nextString();
                    break;
                case '5':
                    list9 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case '6':
                    z11 = jsonReader.nextBoolean();
                    break;
                case '7':
                    list15 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case '8':
                    z9 = jsonReader.nextBoolean();
                    break;
                case '9':
                    str11 = jsonReader.nextString();
                    break;
                case ':':
                    list5 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            list4 = list;
        }
        jsonReader.endObject();
        this.zzhix = list15;
        this.zzhiy = i2;
        this.zzdmp = list13;
        this.zzdmq = list14;
        this.zzhja = list11;
        this.zzhiz = i3;
        this.zzdwn = list12;
        this.zzdwo = list9;
        this.zzhjb = list10;
        this.zzdmf = str;
        this.zzdmg = str2;
        this.zzdwm = zzavjVar;
        this.zzhjc = list7;
        this.zzhjd = list8;
        this.zzdwa = list5;
        this.zzhje = i4;
        this.zzhjf = list6;
        this.zzhjg = zzdndVar;
        this.zzhjh = list3;
        this.zzhji = list4;
        this.zzdlu = str3;
        this.zzhjj = jSONObject7;
        this.id = str4;
        this.zzdmv = str5;
        this.zzdwg = str6;
        this.zzhjk = zzawuVar;
        this.zzdwd = str7;
        this.zzhjl = jSONObject8;
        this.zzhjm = jSONObject9;
        this.zzdnc = z;
        this.zzdnd = z2;
        this.zzdne = z3;
        this.zzdxt = z4;
        this.zzhjo = z5;
        this.zzftq = z6;
        this.zzbpm = z7;
        this.zzhjp = i5;
        this.zzhjq = i6;
        this.zzdww = z8;
        this.zzeuo = str8;
        this.zzhjr = new OmidSettings(jSONObject10);
        this.zzdwz = z9;
        this.zzdxa = z10;
        this.zzhjs = i7;
        this.zzdoq = str9;
        this.zzfto = i8;
        this.zzfzc = str10;
        this.zzhjt = z11;
        this.zzhju = zzarxVar;
        this.zzftp = z12;
        this.zzhjv = zzvuVar;
        this.zzhjw = str11;
        this.zzhjx = z13;
        this.zzhjy = jSONObject11;
        this.zzhjn = str12;
        this.zzhjz = z14;
        this.zzhka = jSONObject12;
        this.zzcht = str13;
    }
}
