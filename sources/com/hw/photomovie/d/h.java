package com.hw.photomovie.d;
/* compiled from: RawTexture.java */
/* loaded from: classes2.dex */
public class h extends a {

    /* renamed from: k  reason: collision with root package name */
    private final boolean f5173k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5174l;

    @Override // com.hw.photomovie.d.i
    public boolean b() {
        return this.f5173k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public int e() {
        return 3553;
    }

    @Override // com.hw.photomovie.d.a
    public boolean j() {
        return this.f5174l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public boolean l(f fVar) {
        if (k()) {
            return true;
        }
        com.hw.photomovie.util.b.d("RawTexture", "lost the content due to context change");
        return false;
    }
}
