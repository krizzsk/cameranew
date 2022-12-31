package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import org.json.JSONObject;
import us.pinguo.foundation.statistics.k;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushPreference;
import us.pinguo.push.PushResult;
import us.pinguo.push.h;
import vStudio.Android.Camera360.R;
/* compiled from: PushWakeUpControl.java */
/* loaded from: classes3.dex */
public class f extends us.pinguo.push.c {

    /* renamed from: i  reason: collision with root package name */
    private int f6942i = 15;

    /* renamed from: j  reason: collision with root package name */
    private String f6943j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6944k = null;

    @Override // us.pinguo.push.c
    public PushResult j() {
        us.pinguo.common.log.a.m("newPush", "onPushEvent", new Object[0]);
        Context d2 = BaseApplication.d();
        f fVar = (f) this.f11775h;
        h d3 = d();
        if (fVar instanceof f) {
            PushPreference pushPreference = new PushPreference(d2);
            pushPreference.f("key_weak_up_days", fVar.f6942i);
            pushPreference.h("key_weak_up_title", fVar.f6943j);
            pushPreference.h("key_weak_up_msg", fVar.f6944k);
            pushPreference.h("key_weak_up_id", fVar.b());
            pushPreference.a();
            if (d3 != null) {
                Intent intent = new Intent("us.pinguo.camera360.EFFECT_IMAGE_CAPTURE");
                intent.putExtra("web_view_from", Constants.PUSH);
                intent.putExtra("web_view_push_id", b());
                us.pinguo.push.d dVar = new us.pinguo.push.d();
                dVar.k(e());
                dVar.g(R.mipmap.ic_launcher);
                dVar.h(R.mipmap.ic_md_push);
                dVar.l(d3.b());
                dVar.j(d3.a());
                dVar.i(intent);
                if (us.pinguo.push.g.a(dVar, true)) {
                    k.l(0, b());
                    return PushResult.SUCCESS;
                }
                return PushResult.FAIL;
            }
            return PushResult.SUCCESS;
        }
        return PushResult.FAIL;
    }

    @Override // us.pinguo.push.c
    /* renamed from: k */
    public f i(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.f6942i = jSONObject.getInt("days");
            fVar.f6943j = jSONObject.getString("title");
            fVar.f6944k = jSONObject.getString("msg");
            return fVar;
        } catch (Exception e2) {
            us.pinguo.common.log.a.m("newPush", "push error:" + e2, new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
