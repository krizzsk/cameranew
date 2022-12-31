package com.pinguo.camera360.m;

import androidx.collection.ArrayMap;
import com.pinguo.camera360.effect.model.entity.Effect;
import org.json.JSONObject;
import us.pinguo.librouter.b.c.f;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.manager.FilterRepository;
/* compiled from: PictureInfo.java */
/* loaded from: classes3.dex */
public class b implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private f f6861f;

    /* renamed from: i  reason: collision with root package name */
    private String f6864i;
    private int a = 0;
    private com.pinguo.camera360.k.a.a.a.b b = null;
    private long c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f6859d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f6860e = null;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f6862g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6863h = false;

    public b() {
        new ArrayMap();
    }

    public void A(com.pinguo.camera360.k.a.a.a.b bVar) {
    }

    public void B(int i2) {
        this.a = i2;
    }

    public void C(int i2) {
    }

    public void D(long j2) {
        this.c = j2;
    }

    public String b() {
        return this.f6860e;
    }

    public String c() {
        return this.f6859d;
    }

    protected Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        com.pinguo.camera360.k.a.a.a.b bVar2 = this.b;
        if (bVar2 != null) {
            bVar.b = (com.pinguo.camera360.k.a.a.a.b) bVar2.clone();
        }
        bVar.v(this.f6861f);
        return bVar;
    }

    public byte[] d() {
        return this.f6862g;
    }

    public String e() {
        return this.f6864i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && j() == ((b) obj).j();
    }

    public String f() {
        FilterParamsTable r = FilterRepository.a.r(b());
        if (r == null) {
            return null;
        }
        return r.getOnlineParam();
    }

    public String g() {
        return FilterRepository.a.g(b()).getPackageMd5();
    }

    public int h() {
        return 0;
    }

    public int hashCode() {
        return Long.valueOf(j()).intValue();
    }

    public int i() {
        return this.a;
    }

    public long j() {
        return this.c;
    }

    public boolean k() {
        return this.f6863h;
    }

    public void l(int i2) {
    }

    public void m(Effect effect) {
    }

    public void n(String str) {
        this.f6860e = str;
    }

    public void o(com.pinguo.camera360.m.d.a aVar) {
    }

    public void p(String str) {
        this.f6859d = str;
    }

    public void q(byte[] bArr) {
        this.f6862g = bArr;
    }

    public void r(String str) {
        if (str != null && !str.trim().isEmpty()) {
            try {
                new JSONObject(str).optInt("ui_ori", 0);
            } catch (Exception unused) {
            }
        }
    }

    public void s(boolean z) {
    }

    public void t(String str) {
    }

    public void u(String str) {
    }

    public void v(f fVar) {
        this.f6861f = fVar;
    }

    public void w(String str) {
    }

    public void x(com.pinguo.camera360.k.a.a.a.b bVar) {
        this.b = bVar;
    }

    public void y(int i2) {
    }

    public void z(int i2) {
    }
}
