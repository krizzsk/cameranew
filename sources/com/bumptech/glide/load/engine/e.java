package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.b {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.d f750d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.d f751e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.f f752f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.load.e f753g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.b f754h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.load.a f755i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bumptech.glide.load.b f756j;

    /* renamed from: k  reason: collision with root package name */
    private String f757k;

    /* renamed from: l  reason: collision with root package name */
    private int f758l;
    private com.bumptech.glide.load.b m;

    public e(String str, com.bumptech.glide.load.b bVar, int i2, int i3, com.bumptech.glide.load.d dVar, com.bumptech.glide.load.d dVar2, com.bumptech.glide.load.f fVar, com.bumptech.glide.load.e eVar, com.bumptech.glide.load.resource.transcode.b bVar2, com.bumptech.glide.load.a aVar) {
        this.a = str;
        this.f756j = bVar;
        this.b = i2;
        this.c = i3;
        this.f750d = dVar;
        this.f751e = dVar2;
        this.f752f = fVar;
        this.f753g = eVar;
        this.f754h = bVar2;
        this.f755i = aVar;
    }

    @Override // com.bumptech.glide.load.b
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
        this.f756j.a(messageDigest);
        messageDigest.update(this.a.getBytes("UTF-8"));
        messageDigest.update(array);
        com.bumptech.glide.load.d dVar = this.f750d;
        messageDigest.update((dVar != null ? dVar.getId() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.d dVar2 = this.f751e;
        messageDigest.update((dVar2 != null ? dVar2.getId() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.f fVar = this.f752f;
        messageDigest.update((fVar != null ? fVar.getId() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.e eVar = this.f753g;
        messageDigest.update((eVar != null ? eVar.getId() : "").getBytes("UTF-8"));
        com.bumptech.glide.load.a aVar = this.f755i;
        messageDigest.update((aVar != null ? aVar.getId() : "").getBytes("UTF-8"));
    }

    public com.bumptech.glide.load.b b() {
        if (this.m == null) {
            this.m = new h(this.a, this.f756j);
        }
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a.equals(eVar.a) && this.f756j.equals(eVar.f756j) && this.c == eVar.c && this.b == eVar.b) {
            com.bumptech.glide.load.f fVar = this.f752f;
            if ((fVar == null) ^ (eVar.f752f == null)) {
                return false;
            }
            if (fVar == null || fVar.getId().equals(eVar.f752f.getId())) {
                com.bumptech.glide.load.d dVar = this.f751e;
                if ((dVar == null) ^ (eVar.f751e == null)) {
                    return false;
                }
                if (dVar == null || dVar.getId().equals(eVar.f751e.getId())) {
                    com.bumptech.glide.load.d dVar2 = this.f750d;
                    if ((dVar2 == null) ^ (eVar.f750d == null)) {
                        return false;
                    }
                    if (dVar2 == null || dVar2.getId().equals(eVar.f750d.getId())) {
                        com.bumptech.glide.load.e eVar2 = this.f753g;
                        if ((eVar2 == null) ^ (eVar.f753g == null)) {
                            return false;
                        }
                        if (eVar2 == null || eVar2.getId().equals(eVar.f753g.getId())) {
                            com.bumptech.glide.load.resource.transcode.b bVar = this.f754h;
                            if ((bVar == null) ^ (eVar.f754h == null)) {
                                return false;
                            }
                            if (bVar == null || bVar.getId().equals(eVar.f754h.getId())) {
                                com.bumptech.glide.load.a aVar = this.f755i;
                                if ((aVar == null) ^ (eVar.f755i == null)) {
                                    return false;
                                }
                                return aVar == null || aVar.getId().equals(eVar.f755i.getId());
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        if (this.f758l == 0) {
            int hashCode = this.a.hashCode();
            this.f758l = hashCode;
            int hashCode2 = (hashCode * 31) + this.f756j.hashCode();
            this.f758l = hashCode2;
            int i2 = (hashCode2 * 31) + this.b;
            this.f758l = i2;
            int i3 = (i2 * 31) + this.c;
            this.f758l = i3;
            int i4 = i3 * 31;
            com.bumptech.glide.load.d dVar = this.f750d;
            int hashCode3 = i4 + (dVar != null ? dVar.getId().hashCode() : 0);
            this.f758l = hashCode3;
            int i5 = hashCode3 * 31;
            com.bumptech.glide.load.d dVar2 = this.f751e;
            int hashCode4 = i5 + (dVar2 != null ? dVar2.getId().hashCode() : 0);
            this.f758l = hashCode4;
            int i6 = hashCode4 * 31;
            com.bumptech.glide.load.f fVar = this.f752f;
            int hashCode5 = i6 + (fVar != null ? fVar.getId().hashCode() : 0);
            this.f758l = hashCode5;
            int i7 = hashCode5 * 31;
            com.bumptech.glide.load.e eVar = this.f753g;
            int hashCode6 = i7 + (eVar != null ? eVar.getId().hashCode() : 0);
            this.f758l = hashCode6;
            int i8 = hashCode6 * 31;
            com.bumptech.glide.load.resource.transcode.b bVar = this.f754h;
            int hashCode7 = i8 + (bVar != null ? bVar.getId().hashCode() : 0);
            this.f758l = hashCode7;
            int i9 = hashCode7 * 31;
            com.bumptech.glide.load.a aVar = this.f755i;
            this.f758l = i9 + (aVar != null ? aVar.getId().hashCode() : 0);
        }
        return this.f758l;
    }

    public String toString() {
        if (this.f757k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.a);
            sb.append('+');
            sb.append(this.f756j);
            sb.append("+[");
            sb.append(this.b);
            sb.append('x');
            sb.append(this.c);
            sb.append("]+");
            sb.append('\'');
            com.bumptech.glide.load.d dVar = this.f750d;
            sb.append(dVar != null ? dVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.d dVar2 = this.f751e;
            sb.append(dVar2 != null ? dVar2.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.f fVar = this.f752f;
            sb.append(fVar != null ? fVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.e eVar = this.f753g;
            sb.append(eVar != null ? eVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.resource.transcode.b bVar = this.f754h;
            sb.append(bVar != null ? bVar.getId() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            com.bumptech.glide.load.a aVar = this.f755i;
            sb.append(aVar != null ? aVar.getId() : "");
            sb.append('\'');
            sb.append('}');
            this.f757k = sb.toString();
        }
        return this.f757k;
    }
}
