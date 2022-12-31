package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.lib.ui.js.RespJsData;
import com.pinguo.lib.download.PGDownloadUtils;
import com.pinguo.lib.network.HttpFileRequest;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.utils.h0;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.webview.PGJsWebView;
import us.pinguo.webview.f.h.a0;
import us.pinguo.webview.f.h.c0;
import us.pinguo.webview.f.h.d0;
import us.pinguo.webview.f.h.g0;
import us.pinguo.webview.f.h.i0;
import us.pinguo.webview.f.h.y;
/* compiled from: PGWebBusinessCenter.java */
/* loaded from: classes3.dex */
public class s implements us.pinguo.webview.g.b {
    private PGJsWebView a;
    private b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PGWebBusinessCenter.java */
    /* loaded from: classes3.dex */
    public class a extends HttpFileRequest {
        final /* synthetic */ us.pinguo.webview.f.h.g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, String str3, us.pinguo.webview.f.h.g gVar) {
            super(str, str2, str3);
            this.a = gVar;
        }

        @Override // com.pinguo.lib.network.HttpFileRequest
        protected void onErrorResponse(Exception exc) {
            this.a.d(s.this.a, new g0(Payload.SERVER_ERROR_CODE_10501, "error"));
        }

        @Override // com.pinguo.lib.network.HttpFileRequest
        protected void onResponse(File file) {
            if (!file.exists()) {
                this.a.d(s.this.a, new g0(Payload.SERVER_ERROR_CODE_10501, "error"));
                return;
            }
            g0 g0Var = new g0();
            g0Var.b(us.pinguo.webview.b.h(file));
            this.a.d(s.this.a, g0Var);
        }
    }

    /* compiled from: PGWebBusinessCenter.java */
    /* loaded from: classes3.dex */
    public interface b {
        void B(com.pinguo.camera360.lib.ui.js.c cVar);

        void I(us.pinguo.webview.f.h.j jVar);

        void K(int i2);

        void U(us.pinguo.webview.f.h.d dVar);

        boolean Z(List<String> list);

        void a0(com.pinguo.camera360.lib.ui.js.b bVar);

        void c(us.pinguo.webview.f.h.e eVar);

        void d(com.pinguo.camera360.lib.ui.js.a aVar);

        void d0(us.pinguo.webview.f.h.k kVar);

        void g0(us.pinguo.webview.f.h.f fVar);

        void o(us.pinguo.webview.f.h.o oVar);

        void z(us.pinguo.webview.f.h.b bVar);
    }

    public s(PGJsWebView pGJsWebView, b bVar) {
        this.a = null;
        this.b = null;
        this.a = pGJsWebView;
        this.b = bVar;
    }

    private void d(us.pinguo.webview.f.h.g gVar) {
        String a2 = gVar.b().a();
        if (TextUtils.isEmpty(a2)) {
            gVar.d(this.a, new g0(Payload.SERVER_ERROR_CODE_10501, "error url"));
            return;
        }
        String str = PGDownloadUtils.generate(a2) + ".jpg";
        String f2 = us.pinguo.webview.b.f(str);
        if (f2 == null) {
            gVar.d(this.a, new g0(Payload.SERVER_ERROR_CODE_10501, "download path error"));
        } else {
            new a(a2, new File(f2).getParent(), str, gVar).execute(Looper.getMainLooper());
        }
    }

    private void e(Context context, Map<String, String> map) {
        String[] split;
        User.Info h2 = User.d().h();
        if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
            map.put("uid", us.pinguo.foundation.utils.p.a(h2.userId));
            map.put(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(h2.userId));
            map.put("userToken", us.pinguo.foundation.utils.p.a(h2.token));
            map.put("token", us.pinguo.foundation.utils.p.a(h2.token));
            if (!TextUtils.isEmpty(h2.mobile)) {
                map.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, h2.mobile);
            }
        }
        map.put("platform", us.pinguo.foundation.utils.p.a(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
        map.put("channel", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a()));
        map.put("appName", us.pinguo.foundation.utils.p.a("camera360"));
        String d2 = h0.d(context);
        if (!TextUtils.isEmpty(d2)) {
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, us.pinguo.foundation.utils.p.a(d2));
        }
        map.put("deviceId", us.pinguo.foundation.utils.p.a(us.pinguo.bigdata.f.a.e(context).trim()));
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, us.pinguo.foundation.utils.p.a(Build.MODEL));
        String locale = us.pinguo.foundation.utils.v.a().toString();
        if (!TextUtils.isEmpty(locale)) {
            map.put("locale", us.pinguo.foundation.utils.p.a(locale));
            map.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, us.pinguo.foundation.utils.p.a(locale));
        }
        String h3 = CameraBusinessSettingModel.v().h();
        if (h3 != null && !h3.isEmpty() && (split = h3.split(",")) != null && split.length == 2) {
            map.put("geoInfo", h3);
            map.put(BigAlbumStore.PhotoColumns.LONGITUDE, split[1]);
            map.put(BigAlbumStore.PhotoColumns.LATITUDE, split[0]);
        }
        map.put("appVersionCode", us.pinguo.util.s.f(BaseApplication.d()));
        map.put("systemVersion", String.valueOf(Build.VERSION.SDK_INT));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[Catch: Exception -> 0x00f6, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f6, blocks: (B:40:0x00f2, B:44:0x00fa), top: B:48:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(us.pinguo.webview.f.h.i r14) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.lib.ui.s.f(us.pinguo.webview.f.h.i):void");
    }

    private void g(us.pinguo.webview.f.h.n nVar) {
        a0 b2 = nVar.b();
        File e2 = us.pinguo.webview.b.e(b2.a());
        if (e2 != null && e2.exists()) {
            try {
                String f2 = w.f(b2.b(), e2);
                if (f2 == null) {
                    nVar.d(this.a, new i0(10699, "Error Response Code"));
                    return;
                }
                JSONObject jSONObject = new JSONObject(f2);
                int i2 = jSONObject.getInt("status");
                if (i2 != 200) {
                    nVar.d(this.a, new i0(i2, "error upload status"));
                    return;
                }
                String string = jSONObject.getJSONObject("data").getString("serverId");
                i0 i0Var = new i0();
                i0Var.b(string);
                nVar.d(this.a, i0Var);
                return;
            } catch (IOException e3) {
                nVar.d(this.a, new i0(10699, e3.getMessage()));
                return;
            } catch (JSONException unused) {
                nVar.d(this.a, new i0(10300, "error upload rsp"));
                return;
            }
        }
        nVar.d(this.a, new i0(Payload.SERVER_ERROR_CODE_10501, "file not exist!"));
    }

    @Override // us.pinguo.webview.g.b
    public void a(String str, String str2) {
        us.pinguo.common.log.a.g("BusinessCenter", str + "/json:" + str2, new Object[0]);
    }

    @Override // us.pinguo.webview.g.b
    public void b(us.pinguo.webview.f.b bVar) {
        String a2 = bVar.a();
        boolean z = false;
        us.pinguo.common.log.a.c("fun:" + a2, new Object[0]);
        if ("chooseImage".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.d)) {
            b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.U((us.pinguo.webview.f.h.d) bVar);
            }
        } else if ("uploadImage".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.n)) {
            g((us.pinguo.webview.f.h.n) bVar);
        } else if ("downloadImage".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.g)) {
            d((us.pinguo.webview.f.h.g) bVar);
        } else if ("saveImage".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.i)) {
            f((us.pinguo.webview.f.h.i) bVar);
        } else if ("showMenuItems".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.l)) {
            us.pinguo.webview.f.h.l lVar = (us.pinguo.webview.f.h.l) bVar;
            y b2 = lVar.b();
            b bVar3 = this.b;
            if (bVar3 != null && bVar3.Z(b2.a())) {
                z = true;
            }
            if (z) {
                lVar.d(this.a, new us.pinguo.webview.f.e());
            } else {
                lVar.d(this.a, new us.pinguo.webview.f.e(10300, "参数异常"));
            }
        } else if ("shareImage".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.j)) {
            b bVar4 = this.b;
            if (bVar4 != null) {
                bVar4.I((us.pinguo.webview.f.h.j) bVar);
            }
        } else if ("shareUrl".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.k)) {
            b bVar5 = this.b;
            if (bVar5 != null) {
                bVar5.d0((us.pinguo.webview.f.h.k) bVar);
            }
        } else if ("triggerAlipay".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.b)) {
            b bVar6 = this.b;
            if (bVar6 != null) {
                bVar6.z((us.pinguo.webview.f.h.b) bVar);
            }
        } else if ("getNativeInfo".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.h)) {
            HashMap hashMap = new HashMap();
            e(BaseApplication.d(), hashMap);
            c0 c0Var = new c0();
            c0Var.b(hashMap);
            ((us.pinguo.webview.f.h.h) bVar).d(this.a, c0Var);
        } else if ("createSignature".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.m)) {
            us.pinguo.webview.f.h.m mVar = (us.pinguo.webview.f.h.m) bVar;
            Map<String, String> a3 = mVar.b().a();
            String e2 = us.pinguo.util.o.e(a3, "059f96c20c08ceab946623304a54e351");
            a3.put("sig", e2);
            if (us.pinguo.foundation.d.f10987f) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : a3.entrySet()) {
                    sb.append("&");
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                }
                us.pinguo.common.log.a.g("PGWebBusinessCenter", sb.toString(), new Object[0]);
            }
            d0 d0Var = new d0();
            d0Var.b(e2);
            mVar.d(this.a, d0Var);
        } else if ("createSignatureForLive".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.m)) {
            us.pinguo.webview.f.h.m mVar2 = (us.pinguo.webview.f.h.m) bVar;
            Map<String, String> a4 = mVar2.b().a();
            String e3 = us.pinguo.util.o.e(a4, "3d5cb3286b2543822861ef1cab99f223");
            a4.put("sig", e3);
            if (us.pinguo.foundation.d.f10987f) {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry<String, String> entry2 : a4.entrySet()) {
                    sb2.append("&");
                    sb2.append(entry2.getKey());
                    sb2.append("=");
                    sb2.append(entry2.getValue());
                }
                us.pinguo.common.log.a.g("PGWebBusinessCenter", sb2.toString(), new Object[0]);
            }
            d0 d0Var2 = new d0();
            d0Var2.b(e3);
            mVar2.d(this.a, d0Var2);
        } else if ("triggerWechatPay".equals(a2) && (bVar instanceof us.pinguo.webview.f.h.o)) {
            us.pinguo.webview.f.h.o oVar = (us.pinguo.webview.f.h.o) bVar;
            b bVar7 = this.b;
            if (bVar7 != null) {
                bVar7.o(oVar);
            }
        } else if (FirebaseAnalytics.Event.LOGIN.equals(bVar.a()) && (bVar instanceof com.pinguo.camera360.lib.ui.js.c)) {
            com.pinguo.camera360.lib.ui.js.c cVar = (com.pinguo.camera360.lib.ui.js.c) bVar;
            User d2 = User.d();
            if (d2.n()) {
                RespJsData respJsData = new RespJsData(200, "", d2.h());
                com.pinguo.camera360.lib.ui.js.h hVar = new com.pinguo.camera360.lib.ui.js.h();
                hVar.b(respJsData);
                cVar.d(this.a, hVar);
                return;
            }
            b bVar8 = this.b;
            if (bVar8 != null) {
                bVar8.B(cVar);
            }
        } else if ("configToolBar".equals(bVar.a()) && (bVar instanceof us.pinguo.webview.f.h.f)) {
            b bVar9 = this.b;
            if (bVar9 != null) {
                bVar9.g0((us.pinguo.webview.f.h.f) bVar);
            }
        } else if ("configReturnBtn".equals(bVar.a()) && (bVar instanceof us.pinguo.webview.f.h.e)) {
            b bVar10 = this.b;
            if (bVar10 != null) {
                bVar10.c((us.pinguo.webview.f.h.e) bVar);
            }
        } else if ("logout".equals(bVar.a()) && (bVar instanceof com.pinguo.camera360.lib.ui.js.d)) {
            User.E();
            ((com.pinguo.camera360.lib.ui.js.d) bVar).d(this.a, new us.pinguo.webview.f.e());
        } else if ("chooseC360Image".equals(bVar.a()) && (bVar instanceof com.pinguo.camera360.lib.ui.js.b)) {
            b bVar11 = this.b;
            if (bVar11 != null) {
                bVar11.a0((com.pinguo.camera360.lib.ui.js.b) bVar);
            }
        } else if ("bindMobile".equals(bVar.a()) && (bVar instanceof com.pinguo.camera360.lib.ui.js.a)) {
            b bVar12 = this.b;
            if (bVar12 != null) {
                bVar12.d((com.pinguo.camera360.lib.ui.js.a) bVar);
            }
        } else {
            bVar.d(this.a, new us.pinguo.webview.f.e());
        }
    }
}
