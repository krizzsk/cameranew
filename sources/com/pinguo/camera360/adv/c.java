package com.pinguo.camera360.adv;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.pinguo.camera360.adv.interaction.Interaction;
import com.pinguo.camera360.adv.oaid.MiitHelper;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.vip.VipManager;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Interface.AdvConfig;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.a0;
import us.pinguo.foundation.utils.i;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import us.pinguo.util.v;
/* compiled from: Camera360AdvConfig.java */
/* loaded from: classes3.dex */
public class c extends AdvConfig implements us.pinguo.advsdk.manager.a {
    public static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f6149d = false;

    /* renamed from: e  reason: collision with root package name */
    private static String f6150e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f6151f = false;
    private String a = "";
    private AdvConfig.LifecycleListener b = new a();

    /* compiled from: Camera360AdvConfig.java */
    /* loaded from: classes3.dex */
    class a extends AdvConfig.SimpleLifecycleListener {
        a() {
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onParseAdvError() {
            a.C0243a.j(3);
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onReadAdvCacheFileError() {
            a.C0243a.j(4);
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdv() {
            a.C0243a.a();
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvIOError() {
            a.C0243a.j(0);
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvSecureError() {
            a.C0243a.j(1);
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onRequestAdvSuccess() {
            a.C0243a.b();
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onSaveAdvCacheFileError() {
            a.C0243a.j(2);
        }

        @Override // us.pinguo.advconfigdata.Interface.AdvConfig.SimpleLifecycleListener, us.pinguo.advconfigdata.Interface.AdvConfig.LifecycleListener
        public void onSaveAdvCacheFileSuccess() {
            c.this.o();
        }
    }

    /* compiled from: Camera360AdvConfig.java */
    /* loaded from: classes3.dex */
    class b extends AsyncTask<Object, Object, Object> {
        b() {
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(BaseApplication.d());
                if (advertisingIdInfo != null) {
                    c.this.p(advertisingIdInfo.getId());
                    c.this.a = advertisingIdInfo.getId();
                }
            } catch (Throwable unused) {
            }
            return CameraBusinessSettingModel.v().x() ? "unknown" : c.this.a;
        }
    }

    public static void g(Context context) {
        if (f6149d || !TextUtils.isEmpty(f6150e)) {
            return;
        }
        String t = CameraBusinessSettingModel.v().t("key_web_user_agent", null);
        if (TextUtils.isEmpty(t)) {
            try {
                String userAgentString = new WebView(context).getSettings().getUserAgentString();
                f6150e = userAgentString;
                if (userAgentString != null) {
                    CameraBusinessSettingModel.v().H("key_web_user_agent", f6150e);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                f6150e = null;
            }
        } else {
            f6150e = t;
        }
        f6149d = true;
    }

    public static void h() {
        f6151f = true;
        AdvConfigManager.getInstance().setAdEnable(false);
        PgAdvManager.getInstance().y(false);
        com.pinguo.camera360.adv.a.b();
    }

    public static void i() {
        f6151f = false;
        AdvConfigManager.getInstance().setAdEnable(true);
        PgAdvManager.getInstance().y(true);
        com.pinguo.camera360.adv.a.a();
    }

    private String j() {
        return CameraBusinessSettingModel.v().x() ? "unknown" : SPUtils.get(BaseApplication.d(), "GOOGLE_AID", "").toString();
    }

    private long k() {
        long GetAttachValue = AdvConfigManager.getInstance().GetAttachValue("resPopupInterval", 1209600) * 1000;
        if (GetAttachValue >= 259200000 && GetAttachValue <= 2592000000L) {
            return GetAttachValue;
        }
        return 1209600000L;
    }

    private static boolean l(AdvItem advItem) {
        return advItem != null && "app://camera360/ar2".equals(advItem.interactionUri);
    }

    public static boolean m() {
        return f6151f;
    }

    private static boolean n(AdvItem advItem) {
        String str;
        return (advItem == null || (str = advItem.interactionUri) == null || !str.startsWith("app://camera360/familyAlbum")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            Object b2 = a0.b(Class.forName("us.pinguo.admobvista.AdvPGManager"), "getInstance");
            if (b2 == null) {
                return;
            }
            a0.a(b2, "refreshStrategy", new Class[]{Boolean.class}, Boolean.FALSE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        SPUtils.put(BaseApplication.d(), "GOOGLE_AID", str);
    }

    @Override // us.pinguo.advsdk.manager.a
    public String a() {
        return getDeviceID();
    }

    @Override // us.pinguo.advsdk.manager.a
    public String b() {
        return CameraBusinessSettingModel.v().x() ? "unknown" : MiitHelper.getInstance().a();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getAppChannel() {
        return i.a();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getAppName() {
        return "camera360";
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getAppVersion(Context context) {
        return super.getAppVersion(context);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public List<AdvItem> getDefaultAdvItems(String str) {
        return new ArrayList();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getDeviceID() {
        String w = us.pinguo.bigdata.f.a.w(v.a());
        if (TextUtils.isEmpty(w)) {
            w = "unknown";
        }
        return CameraBusinessSettingModel.v().x() ? "not_allowed" : w;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getGeoLocation() {
        return CameraBusinessSettingModel.v().h();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getGpId() {
        new b().executeOnPoolExecutor(new Object[0]);
        if (!TextUtils.isEmpty(this.a)) {
            return CameraBusinessSettingModel.v().x() ? "unknown" : this.a;
        }
        String j2 = j();
        this.a = j2;
        return j2;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getGrowingIOUserId() {
        String visitUserId = AbstractGrowingIO.getInstance().getVisitUserId();
        return !com.pinguo.camera360.utils.a.a.a() ? "unknown" : u0.o ? "not_allowed" : TextUtils.isEmpty(visitUserId) ? "unknown" : visitUserId;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getHttpRequestMD5Secret() {
        return "3d5cb3286b2543822861ef1cab99f223";
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getJumpLinkKey() {
        return "camera360";
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public AdvConfig.LifecycleListener getLifecycleListener() {
        return this.b;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getNewAddToday() {
        return User.d().k();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public List<String> getPreloadDownloadedImageGuids() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("83e8038d279dd0745afb5c0d6c727aa7");
        arrayList.add("1c076547816bd43efd2931b1ed8e1fc1");
        arrayList.add("72ba7c334d1aec71e75f82397c2c82f0");
        arrayList.add("14a08e7f6d2040bf8af808028462e3ce");
        arrayList.add("75f78142f6205d00d8c347f44a487e14");
        arrayList.add("eae77201a0313555644877c074710069");
        arrayList.add("a2708d8113ee758a5e172f8b4a8952d0");
        arrayList.add("8beec15ed46842378dd5f77232eabc73");
        arrayList.add("74e9e34397164b4d84eb4f9d24f18ff2");
        arrayList.add("059cb142134fa6993e486b574028e6e4");
        arrayList.add("a1521af5338242258abb1a71876325cf");
        arrayList.add(InspireStaticeConfig.EDIT_RESULT_GUID);
        arrayList.add("869937bc355c2c46d5d0796d4bf4f3e1");
        if (Build.VERSION.SDK_INT > 18) {
            arrayList.add("14e89b8dbb648f81fb8d7960ddde7806");
            arrayList.add("ba31db1c73151b4c13f459ff46d132b3");
        }
        return arrayList;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public int getRequestMode() {
        if (us.pinguo.foundation.d.f10985d) {
            return us.pinguo.foundation.d.b ? AdvConstants.MODE_QA : AdvConstants.MODE_DEV;
        }
        return AdvConstants.MODE_OFFICE;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getShowAppName() {
        return null;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public Boolean getTSLEnable() {
        return Boolean.TRUE;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public long getThirdAdvFileCachedDuration(String str) {
        if ("83e8038d279dd0745afb5c0d6c727aa7".equals(str)) {
            return 86400L;
        }
        return super.getThirdAdvFileCachedDuration(str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getUa() {
        return f6150e;
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getUserId() {
        return User.l();
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public String getVipStatus() {
        return VipManager.a.I() ? "vip" : "original";
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public boolean isOnlyPreloadOneImageUrl(String str) {
        return "83e8038d279dd0745afb5c0d6c727aa7".equals(str) || "74e9e34397164b4d84eb4f9d24f18ff2".equals(str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public boolean isOnlyShowHighestPriority(String str) {
        return "7aa6b6e69f16a93101bc51832f331b1f".equals(str) || "5fbc9f682e81deb7d4ded6786be77127".equals(str) || "c2ad2100efe70d1679fcec433649b710".equals(str) || "adf730a700ad0441b962aa35c1bef35e".equals(str) || "b97ca8c070ed85b5be0a9d6e5190bbd4".equals(str);
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public void onAdvPreload(boolean z) {
    }

    @Override // us.pinguo.advconfigdata.Interface.AdvConfig
    public List<AdvItem> onInterceptDuringLoaded(String str, List<AdvItem> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        if ("75f78142f6205d00d8c347f44a487e14".equals(str)) {
            if (Math.abs(System.currentTimeMillis() - CameraBusinessSettingModel.v().q("adv_show_time_75f78142f6205d00d8c347f44a487e14", 0L)) < k()) {
                return new ArrayList();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (AdvItem advItem : list) {
            if (!l(advItem) && !n(advItem)) {
                if ("75f78142f6205d00d8c347f44a487e14".equals(str)) {
                    if (AdvConfigManager.getInstance().getGuidDisplayCount("75f78142f6205d00d8c347f44a487e14", advItem.advId) <= 0) {
                        arrayList.add(advItem);
                    }
                } else if (Build.VERSION.SDK_INT > 18 || (!"14e89b8dbb648f81fb8d7960ddde7806".equals(str) && !"ba31db1c73151b4c13f459ff46d132b3".equals(str))) {
                    if (Interaction.asyncValidAndUpdate(advItem.interactionUri, null) == 0) {
                        arrayList.add(advItem);
                    }
                }
            }
        }
        return arrayList.isEmpty() ? getDefaultAdvItems(str) : arrayList;
    }
}
