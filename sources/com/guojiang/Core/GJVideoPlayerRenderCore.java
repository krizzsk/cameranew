package com.guojiang.Core;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.guojiang.Common.TextureSizeInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import us.pinguo.blockbuster.lib.domain.Input;
/* loaded from: classes2.dex */
public class GJVideoPlayerRenderCore {
    private int mTextureOESHandle = 0;
    private int mTexture2DHandle = 0;
    private int frameBufferHandle = 0;
    private int vertexShaderHandle = 0;
    private int fragmentShaderHandle = 0;
    private int shaderProgrameHandle = 0;
    private int textureParamHandle = 0;
    private int textureCoordinateHandle = 0;
    private int positionHandle = 0;
    private int textureTranformHandle = 0;
    private float[] surfaceTextureTranform = new float[16];
    private float[] textureCoords = {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private float[] squareCoords = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private short[] drawOrder = {0, 1, 2, 0, 2, 3};
    private ShortBuffer drawListBuffer = null;
    private FloatBuffer vertexBuffer = null;
    private FloatBuffer textureBuffer = null;
    private SurfaceTexture mSurfaceTexture = null;
    private TextureSizeInfo currentTextureSize = new TextureSizeInfo(0, 0);

    private int compileShader(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    private int createAndLinkProgram(int i2, int i3, String[] strArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i2);
            GLES20.glAttachShader(glCreateProgram, i3);
            if (strArr != null) {
                int length = strArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    GLES20.glBindAttribLocation(glCreateProgram, i4, strArr[i4]);
                }
            }
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
        }
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    private void initializeBuffers() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.drawOrder.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.drawListBuffer = asShortBuffer;
        asShortBuffer.put(this.drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.squareCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.squareCoords);
        this.vertexBuffer.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect3.asFloatBuffer();
        this.textureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(this.textureCoords);
        this.textureBuffer.position(0);
    }

    private void initializeExternOESTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        this.mTextureOESHandle = i2;
        if (i2 > 0) {
            GLES20.glBindTexture(36197, i2);
            GLES20.glBindTexture(36197, 0);
        }
    }

    private void initializeShader() {
        this.vertexShaderHandle = compileShader(35633, "attribute vec4 aPosition;\nattribute vec4 aTexCoordinate;\nuniform mat4 texTransform;\nvarying vec2 v_TexCoordinate;\nvoid main() {\nv_TexCoordinate = (texTransform * aTexCoordinate).xy;\ngl_Position = aPosition;\n}\n");
        int compileShader = compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES  texture;\nvarying vec2 v_TexCoordinate;\nvoid main() {\nvec4 color = texture2D(texture,v_TexCoordinate);\ngl_FragColor = color;\n}\n");
        this.fragmentShaderHandle = compileShader;
        int createAndLinkProgram = createAndLinkProgram(this.vertexShaderHandle, compileShader, new String[]{Input.INPUT_TYPE_TEXTURE, "aPosition", "aTexCoordinate", "texTransform"});
        this.shaderProgrameHandle = createAndLinkProgram;
        if (createAndLinkProgram > 0) {
            this.textureParamHandle = GLES20.glGetUniformLocation(createAndLinkProgram, Input.INPUT_TYPE_TEXTURE);
            this.textureCoordinateHandle = GLES20.glGetAttribLocation(this.shaderProgrameHandle, "aTexCoordinate");
            this.positionHandle = GLES20.glGetAttribLocation(this.shaderProgrameHandle, "aPosition");
            this.textureTranformHandle = GLES20.glGetUniformLocation(this.shaderProgrameHandle, "texTransform");
        }
    }

    private void initializeTexture2DTexture() {
        int i2 = this.frameBufferHandle;
        if (i2 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            this.frameBufferHandle = 0;
        }
        int i3 = this.mTexture2DHandle;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.mTexture2DHandle = 0;
        }
        if (this.currentTextureSize.isEquals(new TextureSizeInfo(0, 0))) {
            return;
        }
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.frameBufferHandle = iArr[0];
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        this.mTexture2DHandle = iArr2[0];
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        GLES20.glBindTexture(3553, this.mTexture2DHandle);
        TextureSizeInfo textureSizeInfo = this.currentTextureSize;
        GLES20.glTexImage2D(3553, 0, 6407, textureSizeInfo.mWidth, textureSizeInfo.mHeight, 0, 6407, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTexture2DHandle, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindRenderbuffer(36161, 0);
    }

    public void Dispose() {
        int i2 = this.frameBufferHandle;
        if (i2 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            this.frameBufferHandle = 0;
        }
        int i3 = this.mTexture2DHandle;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.mTexture2DHandle = 0;
        }
        int i4 = this.mTextureOESHandle;
        if (i4 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i4}, 0);
            this.mTextureOESHandle = 0;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        int i5 = this.shaderProgrameHandle;
        if (i5 != 0) {
            GLES20.glDeleteProgram(i5);
        }
    }

    public TextureSizeInfo GetCurrentTextureSize() {
        return this.currentTextureSize;
    }

    public SurfaceTexture GetSurfaceTexture() {
        if (this.mSurfaceTexture == null && this.mTextureOESHandle > 0) {
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureOESHandle);
        }
        return this.mSurfaceTexture;
    }

    public int GetTexture2DHandle() {
        return this.mTexture2DHandle;
    }

    public void InitializeRenderCore() {
        initializeShader();
        initializeBuffers();
        initializeExternOESTexture();
    }

    public void RenderToTexture() {
        if (this.mTexture2DHandle <= 0 || this.mTextureOESHandle <= 0) {
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        GLES20.glBindTexture(36197, this.mTextureOESHandle);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        GLES20.glUseProgram(this.shaderProgrameHandle);
        TextureSizeInfo textureSizeInfo = this.currentTextureSize;
        GLES20.glViewport(0, 0, textureSizeInfo.mWidth, textureSizeInfo.mHeight);
        GLES20.glEnableVertexAttribArray(this.positionHandle);
        GLES20.glVertexAttribPointer(this.positionHandle, 2, 5126, false, 0, (Buffer) this.vertexBuffer);
        GLES20.glEnableVertexAttribArray(this.textureCoordinateHandle);
        GLES20.glVertexAttribPointer(this.textureCoordinateHandle, 4, 5126, false, 0, (Buffer) this.textureBuffer);
        this.mSurfaceTexture.getTransformMatrix(this.surfaceTextureTranform);
        GLES20.glUniformMatrix4fv(this.textureTranformHandle, 1, false, this.surfaceTextureTranform, 0);
        GLES20.glUniform1i(this.textureParamHandle, 0);
        GLES20.glDrawElements(4, this.drawOrder.length, 5123, this.drawListBuffer);
        GLES20.glDisableVertexAttribArray(this.positionHandle);
        GLES20.glDisableVertexAttribArray(this.textureCoordinateHandle);
        GLES20.glUseProgram(0);
    }

    public void SetCurrentTextureSize(TextureSizeInfo textureSizeInfo) {
        if (this.currentTextureSize.isEquals(textureSizeInfo)) {
            return;
        }
        this.currentTextureSize = new TextureSizeInfo(textureSizeInfo.mWidth, textureSizeInfo.mHeight);
        initializeTexture2DTexture();
    }
}
