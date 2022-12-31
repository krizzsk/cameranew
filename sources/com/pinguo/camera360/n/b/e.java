package com.pinguo.camera360.n.b;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.foundation.statistics.k;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushResult;
import us.pinguo.push.h;
import vStudio.Android.Camera360.R;
/* compiled from: PushUpdateControl.java */
/* loaded from: classes3.dex */
public class e extends us.pinguo.push.c {

    /* renamed from: i  reason: collision with root package name */
    private String f6938i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f6939j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f6940k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f6941l = 3;
    private int m = TypedValues.PositionType.TYPE_TRANSITION_EASING;

    @Override // us.pinguo.push.c
    public PushResult j() {
        Context d2 = BaseApplication.d();
        e eVar = (e) this.f11775h;
        if (eVar == null) {
            return PushResult.SUCCESS;
        }
        if (f() == 0) {
            return PushResult.SUCCESS;
        }
        h d3 = d();
        if (d3 == null) {
            return PushResult.SUCCESS;
        }
        String str = eVar.f6939j;
        String str2 = eVar.f6940k;
        if (str2 == null) {
            return PushResult.SUCCESS;
        }
        String str3 = eVar.f6938i;
        int i2 = eVar.m;
        int c = new vStudio.Android.Camera360.a().c();
        if (i2 <= c) {
            us.pinguo.common.log.a.m("newPush", "versionCode <= Integer.getInteger(lastVersion) : " + i2 + " " + c, new Object[0]);
            return PushResult.SUCCESS;
        }
        k.h(b());
        Intent intent = new Intent();
        intent.setClassName(d2, "com.pinguo.camera360.push.utils.PushDialogActivity");
        intent.putExtra("type", 7);
        intent.putExtra("dialog_title", str);
        intent.putExtra("btn_link_2", str2);
        intent.putExtra("dialog_msg", str3);
        intent.putExtra("web_view_push_id", b());
        us.pinguo.push.d dVar = new us.pinguo.push.d();
        dVar.k(e());
        dVar.g(R.mipmap.ic_launcher);
        dVar.h(R.mipmap.ic_md_push);
        dVar.l(d3.b());
        dVar.j(d3.a());
        dVar.i(intent);
        if (us.pinguo.push.g.a(dVar, true)) {
            return PushResult.SUCCESS;
        }
        return PushResult.FAIL;
    }

    @Override // us.pinguo.push.c
    /* renamed from: k */
    public e i(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            e eVar = new e();
            eVar.f6938i = jSONObject.getString("msg");
            eVar.f6939j = jSONObject.getString("title");
            eVar.f6940k = jSONObject.getString("link");
            eVar.f6941l = jSONObject.getInt("alarmWifi");
            us.pinguo.common.log.a.m("newPush", "timewifi: " + eVar.f6941l, new Object[0]);
            jSONObject.getInt("alarmOther");
            if (jSONObject.toString().contains("versionCode")) {
                eVar.m = jSONObject.getInt("versionCode");
            }
            return eVar;
        } catch (JSONException e2) {
            us.pinguo.common.log.a.m("newPush", "push error:" + e2, new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
