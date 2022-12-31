package us.pinguo.camera2020.utils.d;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* compiled from: PGGLUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static final float[] a;

    static {
        float[] fArr = new float[16];
        a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void a(String str) {
        int glGetError;
        if (GLES20.glGetError() == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
        Log.e("GL utils", str2);
        int[] iArr = new int[2];
        GLES20.glGetIntegerv(34964, iArr, 0);
        GLES20.glGetIntegerv(34975, iArr, 1);
        Log.e("GL utils", "Current bound array buffer: " + iArr[0]);
        Log.e("GL utils", "Current bound vertex attrib: " + iArr[1]);
        throw new RuntimeException(str2);
    }

    private static int b(int i2, String str, int[] iArr) {
        iArr[0] = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(iArr[0], str);
        GLES20.glCompileShader(iArr[0]);
        a("Compile shader");
        int[] iArr2 = new int[1];
        GLES20.glGetShaderiv(iArr[0], 35713, iArr2, 0);
        if (iArr2[0] == 0) {
            Log.e("GL utils", "Failed to compile shader: " + GLES20.glGetShaderInfoLog(iArr[0]));
            GLES20.glDeleteShader(iArr[0]);
        }
        return iArr2[0];
    }

    public static FloatBuffer c(int i2) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asFloatBuffer();
    }

    public static FloatBuffer d(float[] fArr) {
        FloatBuffer c = c(fArr.length);
        c.put(fArr);
        c.position(0);
        return c;
    }

    public static int e(String str, String str2, String[] strArr, int[] iArr, String[] strArr2, int[] iArr2) {
        int glCreateProgram = GLES20.glCreateProgram();
        int[] iArr3 = new int[1];
        int[] iArr4 = new int[1];
        int b = b(35633, str, iArr3) * 1 * b(35632, str2, iArr4);
        a("Compiling shaders");
        GLES20.glAttachShader(glCreateProgram, iArr3[0]);
        a("Attach shader");
        GLES20.glAttachShader(glCreateProgram, iArr4[0]);
        a("Attach shader fragment");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            GLES20.glBindAttribLocation(glCreateProgram, iArr[i2], strArr[i2]);
            a("Bind attribute: " + strArr[i2]);
        }
        if (b * g(glCreateProgram) * h(glCreateProgram) > 0) {
            for (int i3 = 0; i3 < strArr2.length; i3++) {
                int glGetUniformLocation = GLES20.glGetUniformLocation(glCreateProgram, strArr2[i3]);
                a("glGetUniformLocation - " + strArr2[i3]);
                if (glGetUniformLocation < 0) {
                    Log.e("GL utils", "Bad uniform " + strArr2[i3]);
                }
                iArr2[i3] = glGetUniformLocation;
            }
        } else {
            GLES20.glDeleteProgram(glCreateProgram);
            glCreateProgram = 0;
        }
        if (iArr3[0] > 0) {
            GLES20.glDeleteShader(iArr3[0]);
            GLES20.glDetachShader(glCreateProgram, iArr3[0]);
        }
        if (iArr4[0] > 0) {
            GLES20.glDeleteShader(iArr4[0]);
            GLES20.glDetachShader(glCreateProgram, iArr4[0]);
        }
        a("Shaders deleted");
        return glCreateProgram;
    }

    public static ShortBuffer f(short[] sArr) {
        ShortBuffer asShortBuffer = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        asShortBuffer.put(sArr).position(0);
        return asShortBuffer;
    }

    private static int g(int i2) {
        int[] iArr = new int[1];
        GLES20.glLinkProgram(i2);
        GLES20.glGetProgramiv(i2, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GL utils", "Error linking program: " + GLES20.glGetProgramInfoLog(i2));
            return 0;
        }
        return 1;
    }

    private static int h(int i2) {
        int[] iArr = new int[1];
        GLES20.glValidateProgram(i2);
        GLES20.glGetProgramiv(i2, 35715, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GL utils", "Error validating program: " + GLES20.glGetProgramInfoLog(i2));
            return 0;
        }
        return 1;
    }
}
