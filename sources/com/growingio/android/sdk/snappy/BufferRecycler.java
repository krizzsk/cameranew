package com.growingio.android.sdk.snappy;

import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
class BufferRecycler {
    private static final int MIN_ENCODING_BUFFER = 4000;
    private static final int MIN_OUTPUT_BUFFER = 8000;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> recyclerRef = new ThreadLocal<>();
    private byte[] decodingBuffer;
    private byte[] encodingBuffer;
    private short[] encodingHash;
    private byte[] inputBuffer;
    private byte[] outputBuffer;

    BufferRecycler() {
    }

    public static BufferRecycler instance() {
        ThreadLocal<SoftReference<BufferRecycler>> threadLocal = recyclerRef;
        SoftReference<BufferRecycler> softReference = threadLocal.get();
        BufferRecycler bufferRecycler = softReference == null ? null : softReference.get();
        if (bufferRecycler == null) {
            BufferRecycler bufferRecycler2 = new BufferRecycler();
            threadLocal.set(new SoftReference<>(bufferRecycler2));
            return bufferRecycler2;
        }
        return bufferRecycler;
    }

    public byte[] allocDecodeBuffer(int i2) {
        byte[] bArr = this.decodingBuffer;
        if (bArr != null && bArr.length >= i2) {
            this.decodingBuffer = null;
            return bArr;
        }
        return new byte[i2];
    }

    public byte[] allocEncodingBuffer(int i2) {
        byte[] bArr = this.encodingBuffer;
        if (bArr != null && bArr.length >= i2) {
            this.encodingBuffer = null;
            return bArr;
        }
        return new byte[Math.max(i2, 4000)];
    }

    public short[] allocEncodingHash(int i2) {
        short[] sArr = this.encodingHash;
        if (sArr != null && sArr.length >= i2) {
            this.encodingHash = null;
            return sArr;
        }
        return new short[i2];
    }

    public byte[] allocInputBuffer(int i2) {
        byte[] bArr = this.inputBuffer;
        if (bArr != null && bArr.length >= i2) {
            this.inputBuffer = null;
            return bArr;
        }
        return new byte[Math.max(i2, 8000)];
    }

    public byte[] allocOutputBuffer(int i2) {
        byte[] bArr = this.outputBuffer;
        if (bArr != null && bArr.length >= i2) {
            this.outputBuffer = null;
            return bArr;
        }
        return new byte[Math.max(i2, 8000)];
    }

    public void clear() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decodingBuffer = null;
        this.encodingBuffer = null;
        this.encodingHash = null;
    }

    public void releaseDecodeBuffer(byte[] bArr) {
        byte[] bArr2 = this.decodingBuffer;
        if (bArr2 == null || (bArr != null && bArr.length > bArr2.length)) {
            this.decodingBuffer = bArr;
        }
    }

    public void releaseEncodeBuffer(byte[] bArr) {
        byte[] bArr2 = this.encodingBuffer;
        if (bArr2 == null || bArr.length > bArr2.length) {
            this.encodingBuffer = bArr;
        }
    }

    public void releaseEncodingHash(short[] sArr) {
        short[] sArr2 = this.encodingHash;
        if (sArr2 == null || (sArr != null && sArr.length > sArr2.length)) {
            this.encodingHash = sArr;
        }
    }

    public void releaseInputBuffer(byte[] bArr) {
        byte[] bArr2 = this.inputBuffer;
        if (bArr2 == null || (bArr != null && bArr.length > bArr2.length)) {
            this.inputBuffer = bArr;
        }
    }

    public void releaseOutputBuffer(byte[] bArr) {
        byte[] bArr2 = this.outputBuffer;
        if (bArr2 == null || (bArr != null && bArr.length > bArr2.length)) {
            this.outputBuffer = bArr;
        }
    }
}
