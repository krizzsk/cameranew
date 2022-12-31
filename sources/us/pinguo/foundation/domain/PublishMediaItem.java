package us.pinguo.foundation.domain;

import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class PublishMediaItem implements Comparable<PublishMediaItem> {
    public long createTime;
    public int durationInSec;
    public String durationStr;
    public String filePath;
    public int height;
    public boolean isVideo;
    public Object mediaItem;
    public int rotation;
    public int width;

    public PublishMediaItem(Object obj, String str, long j2, int i2, int i3, int i4, boolean z) {
        this.filePath = str;
        this.createTime = j2;
        this.width = i2;
        this.height = i3;
        this.rotation = i4;
        this.isVideo = z;
        this.mediaItem = obj;
    }

    public int getDurationInSec() {
        return this.durationInSec;
    }

    public String getDurationStr() {
        return this.durationStr;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getHeight() {
        return this.height;
    }

    @Nullable
    public Object getMediaItem() {
        return this.mediaItem;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDurationInSec(int i2) {
        this.durationInSec = i2;
    }

    public void setDurationStr(String str) {
        this.durationStr = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(PublishMediaItem publishMediaItem) {
        return (int) (publishMediaItem.createTime - this.createTime);
    }
}
