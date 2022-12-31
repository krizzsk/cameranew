package us.pinguo.share.core;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class PGShareInfo {
    String imageUri;
    String text;
    String thumbnailUri;
    String title;
    String videoUri;
    String webUrl;

    public String getImageUri() {
        return this.imageUri;
    }

    public String getText() {
        return this.text;
    }

    public String getThumbnailUri() {
        return this.thumbnailUri;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUri() {
        return this.videoUri;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(this.imageUri);
    }

    public boolean hasThumbnail() {
        return !TextUtils.isEmpty(this.thumbnailUri);
    }

    public boolean hasVideo() {
        return !TextUtils.isEmpty(this.videoUri);
    }

    public boolean hasWebUrl() {
        return !TextUtils.isEmpty(this.webUrl);
    }

    public void setImageUri(String str) {
        this.imageUri = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setThumbnailUri(String str) {
        this.thumbnailUri = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoUri(String str) {
        this.videoUri = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }
}
