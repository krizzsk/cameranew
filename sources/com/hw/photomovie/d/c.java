package com.hw.photomovie.d;

import android.opengl.GLES20;
import androidx.work.Data;
/* compiled from: FboTexture.java */
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: k  reason: collision with root package name */
    private int f5162k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5163l;
    private int m;

    private void r(int i2, int i3) {
        record.gles.a.a("prepareFramebuffer start");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        record.gles.a.a("glGenTextures");
        int i4 = iArr[0];
        GLES20.glBindTexture(3553, i4);
        record.gles.a.a("glBindTexture " + i4);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        record.gles.a.a("glTexParameter");
        GLES20.glGenFramebuffers(1, iArr, 0);
        record.gles.a.a("glGenFramebuffers");
        int i5 = iArr[0];
        GLES20.glBindFramebuffer(36160, i5);
        record.gles.a.a("glBindFramebuffer " + i5);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        record.gles.a.a("glGenRenderbuffers");
        int i6 = iArr[0];
        this.m = i6;
        GLES20.glBindRenderbuffer(36161, i6);
        record.gles.a.a("glBindRenderbuffer " + this.m);
        GLES20.glRenderbufferStorage(36161, 33189, i2, i3);
        record.gles.a.a("glRenderbufferStorage");
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.m);
        record.gles.a.a("glFramebufferRenderbuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        record.gles.a.a("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus == 36053) {
            GLES20.glBindFramebuffer(36160, 0);
            record.gles.a.a("prepareFramebuffer done");
            this.f5162k = i5;
            this.a = i4;
            return;
        }
        throw new RuntimeException("Framebuffer not complete, status=" + glCheckFramebufferStatus);
    }

    @Override // com.hw.photomovie.d.i
    public boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public int e() {
        return 3553;
    }

    @Override // com.hw.photomovie.d.a
    public boolean j() {
        return this.f5163l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.d.a
    public boolean l(f fVar) {
        return true;
    }

    @Override // com.hw.photomovie.d.a
    public void p(int i2, int i3) {
        super.p(i2, i3);
        r(i2, i3);
    }

    public int q() {
        return this.f5162k;
    }

    public void s() {
        int i2 = this.a;
        if (i2 != 0 && GLES20.glIsTexture(i2)) {
            GLES20.glDeleteTextures(1, new int[]{this.a}, 0);
        }
        int i3 = this.m;
        if (i3 != 0 && GLES20.glIsRenderbuffer(i3)) {
            GLES20.glDeleteRenderbuffers(1, new int[]{this.m}, 0);
        }
        int i4 = this.f5162k;
        if (i4 == 0 || !GLES20.glIsFramebuffer(i4)) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, new int[]{this.f5162k}, 0);
        this.f5162k = 0;
    }
}
