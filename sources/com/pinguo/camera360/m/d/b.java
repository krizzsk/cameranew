package com.pinguo.camera360.m.d;

import android.graphics.PointF;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: EffectAppendTiltShiftLine.java */
/* loaded from: classes3.dex */
public class b extends a {
    private PointF a = new PointF(0.5f, 0.5f);
    private int b = 90;
    private float c = 0.2f;

    /* renamed from: d  reason: collision with root package name */
    private float f6865d = 0.25f;

    protected b() {
    }

    public static b c(String str) {
        b bVar = new b();
        if (str == null) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.e((float) jSONObject.getDouble("x"), (float) jSONObject.getDouble("y"));
            bVar.f(jSONObject.getInt("degree"));
            bVar.g((float) jSONObject.getDouble("prog"));
            bVar.h((float) jSONObject.getDouble("width"));
        } catch (JSONException unused) {
        }
        return bVar;
    }

    private void d() {
        if (this.a == null) {
            this.a = new PointF(0.5f, 0.5f);
        }
        PointF pointF = this.a;
        float f2 = pointF.x;
        if (f2 > 1.0f || f2 < 0.0f) {
            pointF.x = 0.5f;
        }
        float f3 = pointF.y;
        if (f3 > 1.0f || f3 < 0.0f) {
            pointF.y = 0.5f;
        }
        int i2 = this.b;
        if (i2 >= 360) {
            this.b = i2 % BaseBlurEffect.ROTATION_360;
        }
        while (true) {
            int i3 = this.b;
            if (i3 >= 0) {
                break;
            }
            this.b = i3 + BaseBlurEffect.ROTATION_360;
        }
        float f4 = this.c;
        if (f4 > 1.0f || f4 < 0.001f) {
            this.c = 0.2f;
        }
        float f5 = this.f6865d;
        if (f5 > 1.0f || f5 < 0.001f) {
            this.f6865d = 0.05f;
        }
    }

    @Override // com.pinguo.camera360.m.d.a
    public String b() {
        d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.a.x);
            jSONObject.put("y", this.a.y);
            jSONObject.put("degree", this.b);
            jSONObject.put("width", this.c);
            jSONObject.put("prog", this.f6865d);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void e(float f2, float f3) {
        this.a = new PointF(f2, f3);
    }

    public void f(int i2) {
        this.b = i2;
    }

    public void g(float f2) {
        this.f6865d = f2;
    }

    public void h(float f2) {
        this.c = f2;
    }
}
