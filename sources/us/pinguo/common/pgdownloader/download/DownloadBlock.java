package us.pinguo.common.pgdownloader.download;

import kotlin.jvm.internal.s;
/* compiled from: DownloadBlock.kt */
/* loaded from: classes4.dex */
public final class DownloadBlock {
    private Integer code;
    private int current;
    private final int end;
    private String message;
    private String method;
    private final int start;
    private BlockStatus status;
    private final String targetPath;
    private final String url;

    /* compiled from: DownloadBlock.kt */
    /* loaded from: classes4.dex */
    public enum BlockStatus {
        READY(0),
        RUNNING(0),
        ERROR(0),
        FINISHED(0);
        
        private int code;

        BlockStatus(int i2) {
            this.code = i2;
        }

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int i2) {
            this.code = i2;
        }
    }

    public DownloadBlock(String url, String targetPath, int i2, int i3, String str, Integer num, String str2) {
        s.h(url, "url");
        s.h(targetPath, "targetPath");
        this.url = url;
        this.targetPath = targetPath;
        this.start = i2;
        this.end = i3;
        this.method = str;
        this.code = num;
        this.message = str2;
        this.current = i2;
        this.status = BlockStatus.READY;
    }

    public static /* synthetic */ DownloadBlock copy$default(DownloadBlock downloadBlock, String str, String str2, int i2, int i3, String str3, Integer num, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = downloadBlock.url;
        }
        if ((i4 & 2) != 0) {
            str2 = downloadBlock.targetPath;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            i2 = downloadBlock.start;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = downloadBlock.end;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            str3 = downloadBlock.method;
        }
        String str6 = str3;
        if ((i4 & 32) != 0) {
            num = downloadBlock.code;
        }
        Integer num2 = num;
        if ((i4 & 64) != 0) {
            str4 = downloadBlock.message;
        }
        return downloadBlock.copy(str, str5, i5, i6, str6, num2, str4);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.targetPath;
    }

    public final int component3() {
        return this.start;
    }

    public final int component4() {
        return this.end;
    }

    public final String component5() {
        return this.method;
    }

    public final Integer component6() {
        return this.code;
    }

    public final String component7() {
        return this.message;
    }

    public final DownloadBlock copy(String url, String targetPath, int i2, int i3, String str, Integer num, String str2) {
        s.h(url, "url");
        s.h(targetPath, "targetPath");
        return new DownloadBlock(url, targetPath, i2, i3, str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadBlock) {
            DownloadBlock downloadBlock = (DownloadBlock) obj;
            return s.c(this.url, downloadBlock.url) && s.c(this.targetPath, downloadBlock.targetPath) && this.start == downloadBlock.start && this.end == downloadBlock.end && s.c(this.method, downloadBlock.method) && s.c(this.code, downloadBlock.code) && s.c(this.message, downloadBlock.message);
        }
        return false;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMethod() {
        return this.method;
    }

    public final int getStart() {
        return this.start;
    }

    public final BlockStatus getStatus() {
        return this.status;
    }

    public final String getTargetPath() {
        return this.targetPath;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((((((this.url.hashCode() * 31) + this.targetPath.hashCode()) * 31) + this.start) * 31) + this.end) * 31;
        String str = this.method;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.code;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.message;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final void setCurrent(int i2) {
        this.current = i2;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final void setStatus(BlockStatus blockStatus) {
        s.h(blockStatus, "<set-?>");
        this.status = blockStatus;
    }

    public String toString() {
        return "DownloadBlock(url=" + this.url + ", targetPath=" + this.targetPath + ", start=" + this.start + ", end=" + this.end + ", method=" + ((Object) this.method) + ", code=" + this.code + ", message=" + ((Object) this.message) + ')';
    }
}
