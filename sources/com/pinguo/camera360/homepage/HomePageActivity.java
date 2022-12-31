package com.pinguo.camera360.homepage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.StatFs;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.ads.AdError;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.lib.HardwareInfo;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.util.LinkedHashMap;
import kotlinx.coroutines.z0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.admobvista.StaticsAdv.DauStatistics;
import us.pinguo.admobvista.StaticsAdv.GIOStatisticManager;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.foundation.base.SubscriptionActivity;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.u3dengine.PgUnityPlayer;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageActivity.kt */
/* loaded from: classes3.dex */
public final class HomePageActivity extends SubscriptionActivity implements q0, us.pinguo.foundation.statistics.e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f6744d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static boolean f6745e;
    private l0 a;
    private int b;
    private boolean c;

    /* compiled from: HomePageActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    /* compiled from: HomePageActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b implements UnlockManager.g {
        b() {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void R(String str) {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void b0() {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void h0() {
        }
    }

    /* compiled from: HomePageActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends OnBackPressedCallback {
        c() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            l0 l0Var = HomePageActivity.this.a;
            if (l0Var == null) {
                kotlin.jvm.internal.s.z("homeInitPresenter");
                throw null;
            } else if (l0Var.m()) {
            } else {
                setEnabled(false);
                HomePageActivity.this.onBackPressed();
            }
        }
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class d extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Mosaic>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class e extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Graffiti>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class f extends com.google.gson.t.a<String[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class g extends com.google.gson.t.a<Integer[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class h extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Mosaic>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class i extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Graffiti>>> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class j extends com.google.gson.t.a<String[]> {
    }

    /* compiled from: MaterialDataManager.kt */
    /* loaded from: classes3.dex */
    public static final class k extends com.google.gson.t.a<Integer[]> {
    }

    public HomePageActivity() {
        new LinkedHashMap();
        this.b = -1;
        this.c = true;
    }

    private final void A0() {
        if (us.pinguo.repository2020.abtest.f.a.b() && this.c) {
            this.c = false;
        } else if (com.pinguo.camera360.adv.a.a) {
        } else {
            us.pinguo.ad.a aVar = us.pinguo.ad.a.a;
            String UNIT_ID_INTERSTITIAL_REWARD = IADStatisticBase.UNIT_ID_INTERSTITIAL_REWARD;
            kotlin.jvm.internal.s.g(UNIT_ID_INTERSTITIAL_REWARD, "UNIT_ID_INTERSTITIAL_REWARD");
            us.pinguo.ad.a.g(aVar, this, UNIT_ID_INTERSTITIAL_REWARD, false, 4, null);
        }
    }

    private final void r0() {
        long nanoTime = System.nanoTime();
        new Thread(new Runnable() { // from class: com.pinguo.camera360.homepage.g
            @Override // java.lang.Runnable
            public final void run() {
                HomePageActivity.s0(HomePageActivity.this);
            }
        }).start();
        long nanoTime2 = System.nanoTime();
        us.pinguo.common.log.a.k("" + (nanoTime2 - nanoTime) + "ns", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(HomePageActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.u0(BaseApplication.d())) {
            return;
        }
        us.pinguo.common.log.a.k("Toast.makeText", new Object[0]);
        new Handler(Looper.getMainLooper()).post(com.pinguo.camera360.homepage.i.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0() {
        Toast makeText = Toast.makeText(BaseApplication.d(), (int) R.string.not_enought_mem, 1);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    private final boolean u0(Context context) {
        String str;
        if (kotlin.jvm.internal.s.c(Environment.getExternalStorageState(), "mounted")) {
            if (context != null) {
                str = us.pinguo.foundation.base.e.d(context, "external_storage_directory");
                kotlin.jvm.internal.s.g(str, "getString(context, \"external_storage_directory\")");
            } else {
                str = "";
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (!(str.length() == 0) && !kotlin.jvm.internal.s.c(str, externalStorageDirectory.getAbsolutePath())) {
                CrashReport.postCatchedException(new Exception("External storage path changed, last:" + str + ", now:" + ((Object) externalStorageDirectory.getAbsolutePath())));
                us.pinguo.foundation.base.e.g(context, "external_storage_directory", externalStorageDirectory.getAbsolutePath());
            }
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            us.pinguo.common.log.a.k("sd card:" + ((availableBlocks / 1204) / 1024) + "MB", new Object[0]);
            if (availableBlocks >= 52428800) {
                return true;
            }
        } else {
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = statFs2.getBlockSize();
            long availableBlocks2 = statFs2.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("inner card:");
            long j2 = availableBlocks2 * blockSize;
            long j3 = 1024;
            sb.append((j2 / j3) / j3);
            sb.append("MB");
            us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
            if (j2 >= 52428800) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0(HomePageActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.repository2020.utils.k.a.b();
        this$0.z0();
        View findViewById = this$0.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            PerformanceLevelManager.a.j((ViewGroup) findViewById);
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:(1:3)(41:322|(1:324)|318|24|(1:26)(32:214|(1:216)|210|43|44|(1:46)(15:199|(1:201)|66|(1:68)(4:98|(1:100)|85|86)|69|(1:71)(4:95|(1:97)|85|86)|72|73|(1:75)(4:92|(1:94)|85|86)|76|77|(4:79|(1:90)(1:81)|82|83)|91|85|86)|47|(1:49)(15:196|(1:198)|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|50|(1:52)(15:193|(1:195)|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|53|(1:55)(3:189|(1:191)|192)|56|57|(4:135|(12:138|(3:168|(3:171|(2:173|174)|169)|175)|142|(1:144)(1:167)|145|(2:146|(2:148|(2:151|152)(1:150))(2:165|166))|153|(1:155)|156|(3:162|163|164)(3:158|159|160)|161|136)|176|177)|(3:108|(1:110)(4:112|(6:115|(3:122|(3:124|125|126)(1:128)|127)|129|(0)(0)|127|113)|130|131)|111)(1:61)|62|(1:64)(2:101|(2:103|(1:105)(2:106|107)))|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|27|(1:29)(32:211|(1:213)|210|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(1:59)(5:132|135|(1:136)|176|177)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|30|31|(1:33)(32:207|(1:209)|210|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|34|(5:36|(1:205)(1:38)|39|40|(30:42|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86))(1:206)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(1:6)(41:319|(1:321)|318|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(1:9)(41:315|(1:317)|318|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(46:251|(15:254|255|256|257|(3:285|(3:288|(2:291|292)(1:290)|286)|293)|261|(1:263)(1:284)|264|(2:265|(2:267|(2:270|271)(1:269))(2:282|283))|272|(1:274)|275|(2:277|278)(2:280|281)|279|252)|303|304|(3:224|(1:226)(4:228|(6:231|(3:238|(3:240|241|242)(1:244)|243)|245|(0)(0)|243|229)|246|247)|227)(1:19)|20|(1:22)(2:217|(2:219|(1:221)(2:222|223)))|23|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:(24:(1:3)(41:322|(1:324)|318|24|(1:26)(32:214|(1:216)|210|43|44|(1:46)(15:199|(1:201)|66|(1:68)(4:98|(1:100)|85|86)|69|(1:71)(4:95|(1:97)|85|86)|72|73|(1:75)(4:92|(1:94)|85|86)|76|77|(4:79|(1:90)(1:81)|82|83)|91|85|86)|47|(1:49)(15:196|(1:198)|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|50|(1:52)(15:193|(1:195)|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|53|(1:55)(3:189|(1:191)|192)|56|57|(4:135|(12:138|(3:168|(3:171|(2:173|174)|169)|175)|142|(1:144)(1:167)|145|(2:146|(2:148|(2:151|152)(1:150))(2:165|166))|153|(1:155)|156|(3:162|163|164)(3:158|159|160)|161|136)|176|177)|(3:108|(1:110)(4:112|(6:115|(3:122|(3:124|125|126)(1:128)|127)|129|(0)(0)|127|113)|130|131)|111)(1:61)|62|(1:64)(2:101|(2:103|(1:105)(2:106|107)))|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|27|(1:29)(32:211|(1:213)|210|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(1:59)(5:132|135|(1:136)|176|177)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|30|31|(1:33)(32:207|(1:209)|210|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|34|(5:36|(1:205)(1:38)|39|40|(30:42|43|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86))(1:206)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(1:6)(41:319|(1:321)|318|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(1:9)(41:315|(1:317)|318|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|(46:251|(15:254|255|256|257|(3:285|(3:288|(2:291|292)(1:290)|286)|293)|261|(1:263)(1:284)|264|(2:265|(2:267|(2:270|271)(1:269))(2:282|283))|272|(1:274)|275|(2:277|278)(2:280|281)|279|252)|303|304|(3:224|(1:226)(4:228|(6:231|(3:238|(3:240|241|242)(1:244)|243)|245|(0)(0)|243|229)|246|247)|227)(1:19)|20|(1:22)(2:217|(2:219|(1:221)(2:222|223)))|23|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|56|57|(0)(0)|(0)(0)|62|(0)(0)|65|66|(0)(0)|69|(0)(0)|72|73|(0)(0)|76|77|(0)|91|85|86)|14|15|17|(0)(0)|20|(0)(0)|23|24|(0)(0)|27|(0)(0)|30|31|(0)(0)|34|(0)(0)|202|44|(0)(0)|47|(0)(0)|50|(0)(0)|53|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02bb, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0624, code lost:
        if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.entity.Graffiti.class, us.pinguo.repository2020.entity.Mosaic.class) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0626, code lost:
        r0 = r6.f();
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x062b, code lost:
        r0.setValue(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0633, code lost:
        if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.entity.Graffiti.class, us.pinguo.repository2020.entity.Graffiti.class) != false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0635, code lost:
        r0 = r6.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0639, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x06b2, code lost:
        if (r3.c(r2, (r4 == null || (r4 = r4.getInterval()) == null) ? -1 : r4.intValue(), null) == us.pinguo.repository2020.utils.RequestIntervalPref.RefreshType.NONE_REFRESH) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0480 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0482 A[Catch: all -> 0x061e, Exception -> 0x0620, TryCatch #0 {Exception -> 0x0620, blocks: (B:180:0x0450, B:240:0x05fa, B:242:0x0600, B:243:0x0608, B:245:0x060e, B:247:0x0614, B:248:0x0618, B:249:0x061d, B:221:0x05b9, B:239:0x05f7, B:224:0x05c1, B:225:0x05ca, B:227:0x05d0, B:229:0x05dd, B:231:0x05e3, B:237:0x05ef, B:238:0x05f3, B:183:0x0482, B:186:0x048a, B:187:0x048e, B:189:0x0494, B:191:0x04b0, B:201:0x04d9, B:203:0x04e8, B:204:0x04ef, B:206:0x04f5, B:211:0x050e, B:213:0x0512, B:214:0x059f, B:217:0x05a7, B:202:0x04e1, B:194:0x04b8, B:195:0x04bc, B:197:0x04c2, B:218:0x05b4), top: B:300:0x0450, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0494 A[Catch: all -> 0x061e, Exception -> 0x0620, TryCatch #0 {Exception -> 0x0620, blocks: (B:180:0x0450, B:240:0x05fa, B:242:0x0600, B:243:0x0608, B:245:0x060e, B:247:0x0614, B:248:0x0618, B:249:0x061d, B:221:0x05b9, B:239:0x05f7, B:224:0x05c1, B:225:0x05ca, B:227:0x05d0, B:229:0x05dd, B:231:0x05e3, B:237:0x05ef, B:238:0x05f3, B:183:0x0482, B:186:0x048a, B:187:0x048e, B:189:0x0494, B:191:0x04b0, B:201:0x04d9, B:203:0x04e8, B:204:0x04ef, B:206:0x04f5, B:211:0x050e, B:213:0x0512, B:214:0x059f, B:217:0x05a7, B:202:0x04e1, B:194:0x04b8, B:195:0x04bc, B:197:0x04c2, B:218:0x05b4), top: B:300:0x0450, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05b9 A[Catch: all -> 0x061e, Exception -> 0x0620, TryCatch #0 {Exception -> 0x0620, blocks: (B:180:0x0450, B:240:0x05fa, B:242:0x0600, B:243:0x0608, B:245:0x060e, B:247:0x0614, B:248:0x0618, B:249:0x061d, B:221:0x05b9, B:239:0x05f7, B:224:0x05c1, B:225:0x05ca, B:227:0x05d0, B:229:0x05dd, B:231:0x05e3, B:237:0x05ef, B:238:0x05f3, B:183:0x0482, B:186:0x048a, B:187:0x048e, B:189:0x0494, B:191:0x04b0, B:201:0x04d9, B:203:0x04e8, B:204:0x04ef, B:206:0x04f5, B:211:0x050e, B:213:0x0512, B:214:0x059f, B:217:0x05a7, B:202:0x04e1, B:194:0x04b8, B:195:0x04bc, B:197:0x04c2, B:218:0x05b4), top: B:300:0x0450, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0600 A[Catch: all -> 0x061e, Exception -> 0x0620, TryCatch #0 {Exception -> 0x0620, blocks: (B:180:0x0450, B:240:0x05fa, B:242:0x0600, B:243:0x0608, B:245:0x060e, B:247:0x0614, B:248:0x0618, B:249:0x061d, B:221:0x05b9, B:239:0x05f7, B:224:0x05c1, B:225:0x05ca, B:227:0x05d0, B:229:0x05dd, B:231:0x05e3, B:237:0x05ef, B:238:0x05f3, B:183:0x0482, B:186:0x048a, B:187:0x048e, B:189:0x0494, B:191:0x04b0, B:201:0x04d9, B:203:0x04e8, B:204:0x04ef, B:206:0x04f5, B:211:0x050e, B:213:0x0512, B:214:0x059f, B:217:0x05a7, B:202:0x04e1, B:194:0x04b8, B:195:0x04bc, B:197:0x04c2, B:218:0x05b4), top: B:300:0x0450, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0608 A[Catch: all -> 0x061e, Exception -> 0x0620, TryCatch #0 {Exception -> 0x0620, blocks: (B:180:0x0450, B:240:0x05fa, B:242:0x0600, B:243:0x0608, B:245:0x060e, B:247:0x0614, B:248:0x0618, B:249:0x061d, B:221:0x05b9, B:239:0x05f7, B:224:0x05c1, B:225:0x05ca, B:227:0x05d0, B:229:0x05dd, B:231:0x05e3, B:237:0x05ef, B:238:0x05f3, B:183:0x0482, B:186:0x048a, B:187:0x048e, B:189:0x0494, B:191:0x04b0, B:201:0x04d9, B:203:0x04e8, B:204:0x04ef, B:206:0x04f5, B:211:0x050e, B:213:0x0512, B:214:0x059f, B:217:0x05a7, B:202:0x04e1, B:194:0x04b8, B:195:0x04bc, B:197:0x04c2, B:218:0x05b4), top: B:300:0x0450, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x028a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0254 A[Catch: all -> 0x02b9, Exception -> 0x02bd, TryCatch #1 {Exception -> 0x02bd, blocks: (B:93:0x0295, B:95:0x029b, B:96:0x02a3, B:98:0x02a9, B:100:0x02af, B:101:0x02b3, B:102:0x02b8, B:74:0x0254, B:92:0x0292, B:77:0x025c, B:78:0x0265, B:80:0x026b, B:82:0x0278, B:84:0x027e, B:90:0x028a, B:91:0x028e, B:40:0x011f, B:42:0x0132, B:53:0x0162, B:55:0x0171, B:56:0x0178, B:58:0x017e, B:63:0x01a1, B:65:0x01a5, B:66:0x0232, B:69:0x0239, B:54:0x016a, B:45:0x013a, B:46:0x013e, B:48:0x0144, B:71:0x024d), top: B:301:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x029b A[Catch: all -> 0x02b9, Exception -> 0x02bd, TryCatch #1 {Exception -> 0x02bd, blocks: (B:93:0x0295, B:95:0x029b, B:96:0x02a3, B:98:0x02a9, B:100:0x02af, B:101:0x02b3, B:102:0x02b8, B:74:0x0254, B:92:0x0292, B:77:0x025c, B:78:0x0265, B:80:0x026b, B:82:0x0278, B:84:0x027e, B:90:0x028a, B:91:0x028e, B:40:0x011f, B:42:0x0132, B:53:0x0162, B:55:0x0171, B:56:0x0178, B:58:0x017e, B:63:0x01a1, B:65:0x01a5, B:66:0x0232, B:69:0x0239, B:54:0x016a, B:45:0x013a, B:46:0x013e, B:48:0x0144, B:71:0x024d), top: B:301:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a3 A[Catch: all -> 0x02b9, Exception -> 0x02bd, TryCatch #1 {Exception -> 0x02bd, blocks: (B:93:0x0295, B:95:0x029b, B:96:0x02a3, B:98:0x02a9, B:100:0x02af, B:101:0x02b3, B:102:0x02b8, B:74:0x0254, B:92:0x0292, B:77:0x025c, B:78:0x0265, B:80:0x026b, B:82:0x0278, B:84:0x027e, B:90:0x028a, B:91:0x028e, B:40:0x011f, B:42:0x0132, B:53:0x0162, B:55:0x0171, B:56:0x0178, B:58:0x017e, B:63:0x01a1, B:65:0x01a5, B:66:0x0232, B:69:0x0239, B:54:0x016a, B:45:0x013a, B:46:0x013e, B:48:0x0144, B:71:0x024d), top: B:301:0x011f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z0() {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.HomePageActivity.z0():void");
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "page_main";
    }

    @Override // com.pinguo.camera360.homepage.q0
    public Activity getActivity() {
        return this;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.s.g(decorView, "this.window.decorView");
        e2.q("hairCut", us.pinguo.util.h.b(decorView));
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if ((findFragmentById instanceof HomePageFragment2020 ? (HomePageFragment2020) findFragmentById : null) == null) {
            HomePageFragment2020 a2 = HomePageFragment2020.q.a();
            Bundle bundle = new Bundle();
            bundle.putInt("union_adv_index", this.b);
            d0 d0Var = d0.a;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
            d0Var.a(supportFragmentManager, a2, R.id.contentFrame, bundle);
        }
        s0.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        PgUnityPlayer.d(this);
        this.b = getIntent().getIntExtra("union_adv_index", -1);
        us.pinguo.foundation.utils.n0.k(BaseApplication.d());
        r0();
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        us.pinguo.foundation.c.d(this, "create");
        this.a = new l0();
        if (this.b != -1) {
            Window window = getWindow();
            window.requestFeature(12);
            window.requestFeature(13);
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.union_ad_transition);
            window.setAllowEnterTransitionOverlap(false);
            window.setSharedElementEnterTransition(inflateTransition);
            postponeEnterTransition();
        }
        setContentView(R.layout.activity_homepage_layout);
        l0 l0Var = this.a;
        if (l0Var != null) {
            l0Var.a(this);
            l0 l0Var2 = this.a;
            if (l0Var2 != null) {
                l0Var2.n();
                if (us.pinguo.foundation.d.f10985d) {
                    AdvConfigManager.getInstance().forceUpdate(true);
                }
                us.pinguo.advsdk.a.n q = PgAdvManager.getInstance().q();
                if (q != null) {
                    q.f();
                }
                GIOStatisticManager.onEvent(GIOStatisticManager.KEY_DAU_INNER);
                DauStatistics.dauStatisticsForeground(this);
                HuaweiAgent.get().connectAndUpdate(this);
                Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.pinguo.camera360.homepage.h
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        boolean y0;
                        y0 = HomePageActivity.y0(HomePageActivity.this);
                        return y0;
                    }
                });
                UnlockManager.getInstance().N(0, new b());
                com.pinguo.camera360.member.t0.a.c();
                us.pinguo.edit2020.b.b.a.a(CameraBusinessSettingModel.v().o());
                getOnBackPressedDispatcher().addCallback(this, new c());
                return;
            }
            kotlin.jvm.internal.s.z("homeInitPresenter");
            throw null;
        }
        kotlin.jvm.internal.s.z("homeInitPresenter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.foundation.c.d(this, "destroy");
        l0 l0Var = this.a;
        if (l0Var != null) {
            l0Var.d();
            l0 l0Var2 = this.a;
            if (l0Var2 != null) {
                l0Var2.p();
                return;
            } else {
                kotlin.jvm.internal.s.z("homeInitPresenter");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("homeInitPresenter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.c.d(this, "pause");
        us.pinguo.foundation.utils.x.a.b(this);
        l0 l0Var = this.a;
        if (l0Var != null) {
            l0Var.r();
        } else {
            kotlin.jvm.internal.s.z("homeInitPresenter");
            throw null;
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        A0();
        if (us.pinguo.foundation.utils.i.c()) {
            return;
        }
        us.pinguo.bigdata.a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.c.d(this, "resume");
        requestCheckIsFullDisplay(1);
        GIOStatisticManager.onEvent(GIOStatisticManager.KEY_ADV_HOME_PV);
        l0 l0Var = this.a;
        if (l0Var != null) {
            l0Var.s();
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(z0.c()), null, null, new HomePageActivity$onResume$1(null), 3, null);
            return;
        }
        kotlin.jvm.internal.s.z("homeInitPresenter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (f6745e) {
            return;
        }
        f6745e = true;
        HardwareInfo hardwareInfo = HardwareInfo.get();
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String valueOf = String.valueOf((hardwareInfo.getMemSize().longValue() + ((long) IjkMediaCodecInfo.RANK_SECURE)) / 500);
        String str = Build.HARDWARE;
        cVar.l0("pro_edit_stat", valueOf, str, String.valueOf(hardwareInfo.getScore() / 500), "");
        cVar.l0("pro_edit_hardware", str, hardwareInfo.getHardware(), us.pinguo.util.n.a(), "");
        PerformanceLevelManager performanceLevelManager = PerformanceLevelManager.a;
        String f2 = performanceLevelManager.f();
        String d2 = performanceLevelManager.d();
        Integer g2 = performanceLevelManager.g();
        Integer i2 = performanceLevelManager.i();
        String valueOf2 = i2 == null ? AdError.UNDEFINED_DOMAIN : String.valueOf(i2);
        us.pinguo.common.log.a.k("Hardware Info:gpu->" + ((Object) f2) + ",cpu->" + ((Object) d2) + ",memory->" + valueOf2, new Object[0]);
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "gpu_ladder_report_flag", false, null, 4, null)) {
            return;
        }
        if (kotlin.jvm.internal.s.c(g2, performanceLevelManager.b())) {
            cVar.z0(d2, valueOf2, f2, AdError.UNDEFINED_DOMAIN);
        } else {
            cVar.z0(d2, valueOf2, f2, String.valueOf(g2));
        }
        us.pinguo.repository2020.utils.o.n(oVar, "gpu_ladder_report_flag", true, null, 4, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        requestCheckIsFullDisplay(1);
    }

    @Override // com.pinguo.camera360.homepage.q0
    public void v() {
    }
}
