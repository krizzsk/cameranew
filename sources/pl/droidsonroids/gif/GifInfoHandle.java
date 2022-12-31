package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class GifInfoHandle {
    private volatile long gifInfoPtr;

    static {
        h.b(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle() {
    }

    private static native void bindSurface(long j2, Surface surface, long[] jArr);

    private static native void free(long j2);

    private static native long getAllocationByteCount(long j2);

    private static native String getComment(long j2);

    private static native int getCurrentFrameIndex(long j2);

    private static native int getCurrentLoop(long j2);

    private static native int getCurrentPosition(long j2);

    private static native int getDuration(long j2);

    private static native int getFrameDuration(long j2, int i2);

    private static native int getHeight(long j2);

    private static native int getLoopCount(long j2);

    private static native long getMetadataByteCount(long j2);

    private static native int getNativeErrorCode(long j2);

    private static native int getNumberOfFrames(long j2);

    private static native long[] getSavedState(long j2);

    private static native long getSourceLength(long j2);

    private static native int getWidth(long j2);

    private static native void glTexImage2D(long j2, int i2, int i3);

    private static native void glTexSubImage2D(long j2, int i2, int i3);

    private static native void initTexImageDescriptor(long j2);

    private static native boolean isAnimationCompleted(long j2);

    private static native boolean isOpaque(long j2);

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFd(FileDescriptor fileDescriptor, long j2) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openUri(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        return new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    private static native void postUnbindSurface(long j2);

    private static native long renderFrame(long j2, Bitmap bitmap);

    private static native boolean reset(long j2);

    private static native long restoreRemainder(long j2);

    private static native int restoreSavedState(long j2, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j2);

    private static native void seekToFrame(long j2, int i2, Bitmap bitmap);

    private static native void seekToFrameGL(long j2, int i2);

    private static native void seekToTime(long j2, int i2, Bitmap bitmap);

    private static native void setLoopCount(long j2, char c);

    private static native void setOptions(long j2, char c, boolean z);

    private static native void setSpeedFactor(long j2, float f2);

    private static native void startDecoderThread(long j2);

    private static native void stopDecoderThread(long j2);

    private void throwIfFrameIndexOutOfBounds(@IntRange(from = 0) int i2) {
        float numberOfFrames = getNumberOfFrames(this.gifInfoPtr);
        if (i2 < 0 || i2 >= numberOfFrames) {
            throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + '>');
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindSurface(Surface surface, long[] jArr) {
        bindSurface(this.gifInfoPtr, surface, jArr);
    }

    protected void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getAllocationByteCount() {
        return getAllocationByteCount(this.gifInfoPtr);
    }

    synchronized String getComment() {
        return getComment(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentFrameIndex() {
        return getCurrentFrameIndex(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentLoop() {
        return getCurrentLoop(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentPosition() {
        return getCurrentPosition(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getDuration() {
        return getDuration(this.gifInfoPtr);
    }

    synchronized int getFrameDuration(@IntRange(from = 0) int i2) {
        throwIfFrameIndexOutOfBounds(i2);
        return getFrameDuration(this.gifInfoPtr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getHeight() {
        return getHeight(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getLoopCount() {
        return getLoopCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getMetadataByteCount() {
        return getMetadataByteCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getNativeErrorCode() {
        return getNativeErrorCode(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getNumberOfFrames() {
        return getNumberOfFrames(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long[] getSavedState() {
        return getSavedState(this.gifInfoPtr);
    }

    synchronized long getSourceLength() {
        return getSourceLength(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getWidth() {
        return getWidth(this.gifInfoPtr);
    }

    void glTexImage2D(int i2, int i3) {
        glTexImage2D(this.gifInfoPtr, i2, i3);
    }

    void glTexSubImage2D(int i2, int i3) {
        glTexSubImage2D(this.gifInfoPtr, i2, i3);
    }

    void initTexImageDescriptor() {
        initTexImageDescriptor(this.gifInfoPtr);
    }

    synchronized boolean isAnimationCompleted() {
        return isAnimationCompleted(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isOpaque() {
        return isOpaque(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isRecycled() {
        return this.gifInfoPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void postUnbindSurface() {
        postUnbindSurface(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void recycle() {
        free(this.gifInfoPtr);
        this.gifInfoPtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long renderFrame(Bitmap bitmap) {
        return renderFrame(this.gifInfoPtr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean reset() {
        return reset(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long restoreRemainder() {
        return restoreRemainder(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int restoreSavedState(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.gifInfoPtr, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void saveRemainder() {
        saveRemainder(this.gifInfoPtr);
    }

    synchronized void seekToFrame(@IntRange(from = 0, to = 2147483647L) int i2, Bitmap bitmap) {
        seekToFrame(this.gifInfoPtr, i2, bitmap);
    }

    void seekToFrameGL(@IntRange(from = 0) int i2) {
        throwIfFrameIndexOutOfBounds(i2);
        seekToFrameGL(this.gifInfoPtr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void seekToTime(@IntRange(from = 0, to = 2147483647L) int i2, Bitmap bitmap) {
        seekToTime(this.gifInfoPtr, i2, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopCount(@IntRange(from = 0, to = 65535) int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            synchronized (this) {
                setLoopCount(this.gifInfoPtr, (char) i2);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOptions(char c, boolean z) {
        setOptions(this.gifInfoPtr, c, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSpeedFactor(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f && !Float.isNaN(f2)) {
            if (f2 < 4.656613E-10f) {
                f2 = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.gifInfoPtr, f2);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    void startDecoderThread() {
        startDecoderThread(this.gifInfoPtr);
    }

    void stopDecoderThread() {
        stopDecoderThread(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.gifInfoPtr = openFd(fileDescriptor, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.gifInfoPtr = openByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.gifInfoPtr = openDirectByteBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(String str) throws GifIOException {
        this.gifInfoPtr = openFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.gifInfoPtr = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.gifInfoPtr = openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
