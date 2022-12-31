package us.pinguo.svideo.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() { // from class: us.pinguo.svideo.bean.VideoInfo.1
        @Override // android.os.Parcelable.Creator
        public VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VideoInfo[] newArray(int i2) {
            return new VideoInfo[i2];
        }
    };
    private long duration;
    private int frameCount;
    private float frameRate;
    private int index;
    private boolean isSquare;
    private String music;
    private int videoBitRate;
    private int videoHeight;
    private String videoPath;
    private int videoRotation;
    private int videoWidth;

    public VideoInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMusic() {
        return this.music;
    }

    public int getVideoBitRate() {
        return this.videoBitRate;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public int getVideoRotation() {
        return this.videoRotation;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public float getWHRate() {
        int i2;
        int i3 = this.videoWidth;
        if (i3 <= 0 || (i2 = this.videoHeight) <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    public boolean isSquare() {
        return this.isSquare;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setFrameCount(int i2) {
        this.frameCount = i2;
    }

    public void setFrameRate(float f2) {
        this.frameRate = f2;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setIsSquare(boolean z) {
        this.isSquare = z;
    }

    public void setMusic(String str) {
        this.music = str;
    }

    public void setVideoBitRate(int i2) {
        this.videoBitRate = i2;
    }

    public void setVideoHeight(int i2) {
        this.videoHeight = i2;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVideoRotation(int i2) {
        this.videoRotation = i2;
    }

    public void setVideoWidth(int i2) {
        this.videoWidth = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.videoPath);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeInt(this.index);
        parcel.writeString(this.music);
        parcel.writeInt(this.frameCount);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.isSquare ? 1 : 0);
        parcel.writeInt(this.videoBitRate);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.videoRotation);
    }

    protected VideoInfo(Parcel parcel) {
        this.videoPath = parcel.readString();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.index = parcel.readInt();
        this.music = parcel.readString();
        this.frameCount = parcel.readInt();
        this.duration = parcel.readLong();
        this.isSquare = parcel.readInt() == 1;
        this.videoBitRate = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.videoRotation = parcel.readInt();
    }

    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.videoRotation = this.videoRotation;
        videoInfo.frameRate = this.frameRate;
        videoInfo.isSquare = this.isSquare;
        videoInfo.duration = this.duration;
        videoInfo.videoBitRate = this.videoBitRate;
        videoInfo.frameCount = this.frameCount;
        videoInfo.music = this.music;
        videoInfo.index = this.index;
        videoInfo.videoHeight = this.videoHeight;
        videoInfo.videoWidth = this.videoWidth;
        videoInfo.videoPath = this.videoPath;
        return videoInfo;
    }
}
