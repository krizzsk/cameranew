package us.pinguo.glrender;

import android.content.Context;
import android.opengl.GLES20;
import androidx.work.Data;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
class Texture2DExt {

    /* renamed from: e  reason: collision with root package name */
    private static float[] f11133e = {1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    private static short[] f11134f = {0, 1, 2, 0, 2, 3};

    /* renamed from: g  reason: collision with root package name */
    private static float[] f11135g = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: h  reason: collision with root package name */
    private static int f11136h;
    private int a;
    private int b;
    private FloatBuffer c;

    /* renamed from: d  reason: collision with root package name */
    private FloatBuffer f11137d;

    public Texture2DExt(Context context) {
        a();
        e();
        b(context);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        this.a = i2;
        f11136h = i2;
        GLES20.glBindTexture(36197, i2);
        c.a("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    public static void a() {
        if (f11136h > 0) {
            us.pinguo.common.log.a.c("delete last texture id:" + f11136h, new Object[0]);
            GLES20.glDeleteTextures(1, new int[]{f11136h}, 0);
            f11136h = 0;
        }
    }

    private void b(Context context) {
        this.b = GLES20.glCreateProgram();
        int b = c.b(35633, f(context, "vertex.glsl"));
        int b2 = c.b(35632, f(context, "fragment.glsl"));
        GLES20.glAttachShader(this.b, b);
        c.a("glAttachShader vertexShader");
        GLES20.glAttachShader(this.b, b2);
        c.a("glAttachShader fragmentShader");
        GLES20.glLinkProgram(this.b);
    }

    private void e() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f11133e.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f11137d = asFloatBuffer;
        asFloatBuffer.put(f11133e);
        this.f11137d.position(0);
        ByteBuffer.allocateDirect(f11134f.length * 2).order(ByteOrder.nativeOrder());
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(f11135g.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.c = asFloatBuffer2;
        asFloatBuffer2.put(f11135g);
        this.c.position(0);
    }

    private static String f(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr, 0, open.available());
            return new String(bArr, "utf-8");
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void c(float[] fArr) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.b);
        c.a("glUseProgram");
        GLES20.glBindBuffer(34963, 0);
        GLES20.glBindBuffer(34962, 0);
        c.a("glBindBuffer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.a);
        c.a("glBindTexture");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.b, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, (Buffer) this.f11137d);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.b, "aTextureCoord");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 0, (Buffer) this.c);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        c.a("glEnableVertexAttribArray");
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.b, "sTexture"), 0);
        c.a("glUniform1i");
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.b, "uMVPMatrix"), 1, false, fArr, 0);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(36197, 0);
    }

    public int d() {
        return this.a;
    }
}
