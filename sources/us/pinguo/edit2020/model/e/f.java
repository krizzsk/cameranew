package us.pinguo.edit2020.model.e;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* compiled from: GLRendererImpl.java */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: i  reason: collision with root package name */
    private static final float[] f10552i = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f10553j = {-1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final short[] f10554k = {0, 1, 1, 1, 0, 0, 1, 0};
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10555d;

    /* renamed from: e  reason: collision with root package name */
    private int f10556e;

    /* renamed from: f  reason: collision with root package name */
    private FloatBuffer f10557f;

    /* renamed from: g  reason: collision with root package name */
    private ShortBuffer f10558g;

    /* renamed from: h  reason: collision with root package name */
    private int f10559h;

    public f(boolean z) {
        if (z) {
            float[] fArr = f10553j;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f10557f = asFloatBuffer;
            asFloatBuffer.put(fArr).position(0);
        } else {
            float[] fArr2 = f10552i;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f10557f = asFloatBuffer2;
            asFloatBuffer2.put(fArr2).position(0);
        }
        short[] sArr = f10554k;
        ShortBuffer asShortBuffer = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.f10558g = asShortBuffer;
        asShortBuffer.put(sArr).position(0);
    }

    private void a() {
        if (this.a != 0) {
            return;
        }
        int[] iArr = new int[1];
        int d2 = d(35633, "attribute vec4 a_position;    \nattribute vec2 a_texCoords; \nvarying vec2 v_texCoords; \nvoid main()                  \n{                            \n   gl_Position = a_position;  \n    v_texCoords = a_texCoords; \n}                            \n");
        int d3 = d(35632, "precision mediump float;\t\t\t\t\t  \nuniform sampler2D u_Texture; \nvarying vec2 v_texCoords; \nvoid main()                                  \n{                                            \n  gl_FragColor = texture2D(u_Texture, v_texCoords) ;\n}                                            \n");
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return;
        }
        GLES20.glAttachShader(glCreateProgram, d2);
        GLES20.glAttachShader(glCreateProgram, d3);
        GLES20.glBindAttribLocation(glCreateProgram, 0, "a_position");
        GLES20.glBindAttribLocation(glCreateProgram, 1, "a_texCoords");
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(glCreateProgram);
        } else {
            this.a = glCreateProgram;
        }
    }

    private int d(int i2, String str) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void b() {
        int i2 = this.a;
        if (i2 != 0) {
            GLES20.glDeleteProgram(i2);
            this.a = 0;
        }
    }

    public void c() {
        int i2;
        int i3;
        int i4 = this.b;
        int i5 = this.c;
        float f2 = i4 / i5;
        int i6 = this.f10555d;
        int i7 = this.f10556e;
        if (f2 < i6 / i7) {
            i3 = (int) (i4 * (i7 / i6));
            i2 = i4;
        } else {
            i2 = (int) (i5 * (i6 / i7));
            i3 = i5;
        }
        GLES20.glViewport((i4 - i2) / 2, (i5 - i3) / 2, i2, i3);
        GLES20.glClearColor(0.9333f, 0.9333f, 0.9333f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.a);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) this.f10557f);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5122, false, 0, (Buffer) this.f10558g);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f10559h);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.a, "u_Texture"), 0.0f);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void e(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public void f(int i2, int i3, int i4) {
        a();
        this.f10559h = i2;
        this.f10555d = i3;
        this.f10556e = i4;
        GLES20.glClearColor(0.9333f, 0.9333f, 0.9333f, 1.0f);
    }
}
