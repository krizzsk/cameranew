package us.pinguo.camera360.shop.data.show;

import android.content.Context;
import com.pinguo.lib.GsonUtilKt;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.camera360.shop.bean.Package;
import us.pinguo.camera360.shop.bean.ShopData;
import us.pinguo.camera360.shop.bean.ShopJson;
import us.pinguo.camera360.shop.bean.Topic;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: StickerDetailCache.java */
/* loaded from: classes4.dex */
public class y {

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f9660g = {"5e6a360fa35dde3d3e028c2d"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f9661h = {"5e6a360ea35dde3d3e028c25", "5e6a360fa35dde3d3e028c29", "5e6a360fa35dde3d3e028c2d", "5e6a35fba35dde3d3e028bc1", "5e6a3601a35dde3d3e028bd9", "5e6a3600a35dde3d3e028bd5", "5e6a3603a35dde3d3e028be9", "5e6a3602a35dde3d3e028be1", "5e6a3607a35dde3d3e028c05", "5e6a3620a35dde3d3e028c7d", "5e6a361ba35dde3d3e028c69", "5e6a3621a35dde3d3e028c81", "5e6a3629a35dde3d3e028ca9", "5e6a3628a35dde3d3e028ca5", "5e6a3625a35dde3d3e028c99", "5e6a3637a35dde3d3e028ce9", "5e6a3639a35dde3d3e028cf1", "5e6a363ba35dde3d3e028cf9"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f9662i = {"5e6b28fff40fcf357ce33aa1", "5e6b286efb27046915d6a8bd", "5e6b28ccf34b854438fe448f", "5e6b295d9ac530cd0ab9bc53", "5e6b29ad9ac5302773b9c714", "5e6b29f69ac530bf31b9b912"};
    private boolean a = false;
    private final boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private UnlockManager f9663d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ShopJson f9664e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.camera360.shop.data.m.c f9665f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str, UnlockManager unlockManager) {
        boolean z = false;
        new ArrayList();
        this.f9664e = null;
        this.f9663d = unlockManager;
        this.f9665f = us.pinguo.camera360.shop.data.m.c.a;
        Locale locale = Locale.getDefault();
        if ("zh".equals(locale.getLanguage()) && "CN".equals(locale.getCountry())) {
            z = true;
        }
        this.b = z;
    }

    private String b() {
        return this.b ? "builtin_data/sticker/sticker_cn.json" : "builtin_data/sticker/sticker_en.json";
    }

    private us.pinguo.camera360.shop.data.m.b c(ShopData shopData, boolean z) {
        Package[] packageArr;
        String[] strArr;
        long currentTimeMillis = z ? 0L : System.currentTimeMillis();
        boolean z2 = this.a && this.f9663d.p() != null;
        us.pinguo.common.log.a.m("UnlockManager", "supportIap: " + z2, new Object[0]);
        Map<String, ShowPkg> hashMap = new HashMap<>();
        for (Package r9 : shopData.packages) {
            ShowPkg showPkg = r9.toShowPkg(z2, true, currentTimeMillis, false);
            if (showPkg != null) {
                hashMap.put(r9.pid, showPkg);
            }
        }
        for (String str : f9661h) {
            ShowPkg showPkg2 = hashMap.get(str);
            if (showPkg2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("unity_pkg_icon_");
                sb.append(str);
                boolean z3 = this.b;
                sb.append(".png");
                showPkg2.setIcon("assets://builtin_data/sticker/" + sb.toString());
            }
        }
        if (!hashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Topic[] topicArr = shopData.topics;
            if (topicArr == null) {
                topicArr = new Topic[0];
            }
            for (Topic topic : topicArr) {
                ShowTopic showTopicForSticker = topic.toShowTopicForSticker(z2, currentTimeMillis, hashMap);
                if (showTopicForSticker != null) {
                    arrayList.add(showTopicForSticker);
                    String id = showTopicForSticker.getId();
                    if (us.pinguo.foundation.utils.y.c(f9662i, id) >= 0) {
                        showTopicForSticker.setIcon("assets://builtin_data/sticker/" + ("unity_topic_icon_" + id + ".png"));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                if (this.c) {
                    z.b().i(hashMap.values(), arrayList, false);
                } else if (z.b().j(hashMap.values(), arrayList)) {
                    us.pinguo.foundation.q.a.i(BaseApplication.d());
                }
                return new us.pinguo.camera360.shop.data.m.b(arrayList, hashMap);
            }
            throw new IllegalArgumentException("error, empty topic");
        }
        throw new IllegalArgumentException("error, empty package");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(us.pinguo.camera360.shop.data.install.p pVar) {
        Context d2 = BaseApplication.d();
        InputStreamReader inputStreamReader = null;
        try {
            try {
                z.b().a();
                ShopJson shopJson = this.f9664e;
                if (shopJson == null) {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(new BufferedInputStream(d2.getAssets().open(b(), 3)));
                    try {
                        ShopJson shopJson2 = (ShopJson) GsonUtilKt.getCachedGson().h(inputStreamReader2, ShopJson.class);
                        this.f9664e = shopJson2;
                        inputStreamReader = inputStreamReader2;
                        shopJson = shopJson2;
                    } catch (Exception e2) {
                        e = e2;
                        inputStreamReader = inputStreamReader2;
                        us.pinguo.common.log.a.f(e);
                        us.pinguo.util.f.a(inputStreamReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = inputStreamReader2;
                        us.pinguo.util.f.a(inputStreamReader);
                        throw th;
                    }
                }
                this.c = true;
                this.f9665f.c(c(shopJson.data, true), true);
                us.pinguo.util.f.a(inputStreamReader);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z) {
        this.a = z;
    }
}
