package us.pinguo.common.pgdownloader.download;

import kotlin.jvm.internal.s;
/* compiled from: ConnectInfo.kt */
/* loaded from: classes4.dex */
public final class ConnectInfo {
    private final int contentLength;
    private final String filename;

    public ConnectInfo(int i2, String filename) {
        s.h(filename, "filename");
        this.contentLength = i2;
        this.filename = filename;
    }

    public static /* synthetic */ ConnectInfo copy$default(ConnectInfo connectInfo, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = connectInfo.contentLength;
        }
        if ((i3 & 2) != 0) {
            str = connectInfo.filename;
        }
        return connectInfo.copy(i2, str);
    }

    public final int component1() {
        return this.contentLength;
    }

    public final String component2() {
        return this.filename;
    }

    public final ConnectInfo copy(int i2, String filename) {
        s.h(filename, "filename");
        return new ConnectInfo(i2, filename);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectInfo) {
            ConnectInfo connectInfo = (ConnectInfo) obj;
            return this.contentLength == connectInfo.contentLength && s.c(this.filename, connectInfo.filename);
        }
        return false;
    }

    public final int getContentLength() {
        return this.contentLength;
    }

    public final String getFilename() {
        return this.filename;
    }

    public int hashCode() {
        return (this.contentLength * 31) + this.filename.hashCode();
    }

    public String toString() {
        return "ConnectInfo(contentLength=" + this.contentLength + ", filename=" + this.filename + ')';
    }
}
