package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.work.Data;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* compiled from: TextureRenderer.java */
@TargetApi(16)
/* loaded from: classes9.dex */
public class f {

    /* renamed from: k  reason: collision with root package name */
    private static final float[] f11282k = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private FloatBuffer a;

    /* renamed from: d  reason: collision with root package name */
    private int f11283d;

    /* renamed from: f  reason: collision with root package name */
    private int f11285f;

    /* renamed from: g  reason: collision with root package name */
    private int f11286g;

    /* renamed from: h  reason: collision with root package name */
    private int f11287h;

    /* renamed from: i  reason: collision with root package name */
    private int f11288i;

    /* renamed from: j  reason: collision with root package name */
    private int f11289j;
    private float[] b = new float[16];
    private float[] c = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private int f11284e = -12345;

    public f(int i2) {
        this.f11289j = 0;
        this.f11289j = i2;
        float[] fArr = f11282k;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.a = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.c, 0);
    }

    private int b(String str, String str2) {
        int e2;
        int e3 = e(35633, str);
        if (e3 == 0 || (e2 = e(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, e3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, e2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private int e(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void c(SurfaceTexture surfaceTexture, boolean z) {
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.c);
        if (z) {
            float[] fArr = this.c;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.f11283d);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f11284e);
        this.a.position(0);
        GLES20.glVertexAttribPointer(this.f11287h, 3, 5126, false, 20, (Buffer) this.a);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f11287h);
        a("glEnableVertexAttribArray maPositionHandle");
        this.a.position(3);
        GLES20.glVertexAttribPointer(this.f11288i, 2, 5126, false, 20, (Buffer) this.a);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f11288i);
        a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f11286g, 1, false, this.c, 0);
        GLES20.glUniformMatrix4fv(this.f11285f, 1, false, this.b, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public int d() {
        return this.f11284e;
    }

    public void f() {
        int b = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f11283d = b;
        if (b != 0) {
            this.f11287h = GLES20.glGetAttribLocation(b, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f11287h != -1) {
                this.f11288i = GLES20.glGetAttribLocation(this.f11283d, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f11288i != -1) {
                    this.f11285f = GLES20.glGetUniformLocation(this.f11283d, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f11285f != -1) {
                        this.f11286g = GLES20.glGetUniformLocation(this.f11283d, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f11286g != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i2 = iArr[0];
                            this.f11284e = i2;
                            GLES20.glBindTexture(36197, i2);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            a("glTexParameter");
                            Matrix.setIdentityM(this.b, 0);
                            int i3 = this.f11289j;
                            if (i3 != 0) {
                                Matrix.rotateM(this.b, 0, i3, 0.0f, 0.0f, 1.0f);
                                return;
                            }
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }
}
