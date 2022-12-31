package us.pinguo.camera2020.utils.d;

import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import us.pinguo.blockbuster.lib.domain.Input;
/* compiled from: GLRendering.java */
/* loaded from: classes3.dex */
public class b {
    private int a;
    private int[] b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9248d;

    public b(int i2, int i3) {
        b();
    }

    private void b() {
        String[] strArr = {"matrix", Input.INPUT_TYPE_TEXTURE, "textureMatrix"};
        int[] iArr = new int[3];
        this.b = iArr;
        int e2 = c.e("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoord;\nuniform mat4 matrix;\nuniform mat4 textureMatrix;\nvarying highp vec2 texCoord;\nvoid main() {\n  texCoord = (textureMatrix * vec4(textureCoord.x, textureCoord.y, 0.0, 1.0)).xy;\n  gl_Position = matrix * position; \n}", "#extension GL_OES_EGL_image_external : require\nuniform sampler2D texture;\nvarying highp vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(texture, texCoord);\n}", new String[]{"position", "textureCoord"}, new int[]{1, 2}, strArr, iArr);
        this.a = e2;
        if (e2 > 0) {
            GLES20.glUseProgram(e2);
            int i2 = this.b[0];
            float[] fArr = c.a;
            GLES20.glUniformMatrix4fv(i2, 1, false, fArr, 0);
            GLES20.glUniform1i(this.b[1], 2);
            GLES20.glUniformMatrix4fv(this.b[2], 1, false, fArr, 0);
            c.a("Creating program - setting uniform");
            int[] iArr2 = new int[2];
            GLES20.glGenBuffers(2, iArr2, 0);
            this.c = iArr2[0];
            this.f9248d = iArr2[1];
            FloatBuffer d2 = c.d(new float[]{-1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 0.0f, 1.0f});
            GLES20.glBindBuffer(34962, this.c);
            GLES20.glBufferData(34962, d2.capacity() * 4, d2, 35048);
            c.a("Creating array buffer");
            GLES20.glBindBuffer(34962, 0);
            ShortBuffer f2 = c.f(new short[]{2, 1, 0, 0, 3, 2});
            GLES20.glBindBuffer(34963, this.f9248d);
            c.a("Creating element buffer");
            GLES20.glBufferData(34963, f2.capacity() * 2, f2, 35044);
            c.a("Creating element buffer");
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glLineWidth(3.0f);
            GLES20.glBlendEquation(32774);
            GLES20.glBlendFunc(770, 771);
            return;
        }
        throw new RuntimeException("Error creating warp program");
    }

    public void a(int i2, int i3) {
        GLES20.glUseProgram(this.a);
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.orthoM(fArr, 0, 1.0f, -1.0f, 1.0f, -1.0f, -50.0f, 100.0f);
        Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.b[0], 1, false, fArr, 0);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        c.a("texture parameters");
        GLES20.glBindBuffer(34962, this.c);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(1, 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(2);
        GLES20.glVertexAttribPointer(2, 2, 5126, false, 20, 12);
        GLES20.glBindBuffer(34963, this.f9248d);
        c.a("VBO setup");
        GLES20.glDrawElements(4, 6, 5123, 0);
        c.a("Drawing background");
        GLES20.glDisableVertexAttribArray(2);
        GLES20.glDisableVertexAttribArray(1);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindBuffer(34963, 0);
        GLES20.glBindBuffer(34962, 0);
    }
}
