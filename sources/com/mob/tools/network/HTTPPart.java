package com.mob.tools.network;

import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;
/* loaded from: classes2.dex */
public abstract class HTTPPart {
    private OnReadListener listener;
    private long offset;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract InputStream getInputStream() throws Throwable;

    public Object getInputStreamEntity() throws Throwable {
        InputStream inputStream = toInputStream();
        long length = length() - this.offset;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", inputStream, Long.valueOf(length));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long length() throws Throwable;

    public void setOffset(long j2) {
        this.offset = j2;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    public InputStream toInputStream() throws Throwable {
        ByteCounterInputStream byteCounterInputStream = new ByteCounterInputStream(getInputStream());
        byteCounterInputStream.setOnInputStreamReadListener(this.listener);
        long j2 = this.offset;
        if (j2 > 0) {
            byteCounterInputStream.skip(j2);
        }
        return byteCounterInputStream;
    }
}
