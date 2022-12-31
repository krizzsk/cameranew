package us.pinguo.foundation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: VideoMusic.kt */
/* loaded from: classes4.dex */
public final class VideoMusic implements Parcelable {
    public static final a CREATOR = new a(null);
    private final String author;
    private final String cover;
    private String downloadMusicPath;
    private final String duration;
    private final String musicId;
    private final String name;
    private final int status;
    private final int uploadTime;
    private final String url;

    /* compiled from: VideoMusic.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Parcelable.Creator<VideoMusic> {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoMusic createFromParcel(Parcel parcel) {
            s.h(parcel, "parcel");
            return new VideoMusic(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoMusic[] newArray(int i2) {
            return new VideoMusic[i2];
        }
    }

    public VideoMusic(String musicId, String name, String author, String url, String cover, String duration, int i2, int i3) {
        s.h(musicId, "musicId");
        s.h(name, "name");
        s.h(author, "author");
        s.h(url, "url");
        s.h(cover, "cover");
        s.h(duration, "duration");
        this.musicId = musicId;
        this.name = name;
        this.author = author;
        this.url = url;
        this.cover = cover;
        this.duration = duration;
        this.uploadTime = i2;
        this.status = i3;
    }

    public final String a() {
        return this.author;
    }

    public final String b() {
        return this.cover;
    }

    public final String c() {
        return this.downloadMusicPath;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoMusic) {
            VideoMusic videoMusic = (VideoMusic) obj;
            return s.c(this.musicId, videoMusic.musicId) && s.c(this.name, videoMusic.name) && s.c(this.author, videoMusic.author) && s.c(this.url, videoMusic.url) && s.c(this.cover, videoMusic.cover) && s.c(this.duration, videoMusic.duration) && this.uploadTime == videoMusic.uploadTime && this.status == videoMusic.status;
        }
        return false;
    }

    public final String f() {
        return this.duration;
    }

    public final String g() {
        return this.musicId;
    }

    public final String h() {
        return this.name;
    }

    public int hashCode() {
        return (((((((((((((this.musicId.hashCode() * 31) + this.name.hashCode()) * 31) + this.author.hashCode()) * 31) + this.url.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.uploadTime) * 31) + this.status;
    }

    public final String j() {
        return this.url;
    }

    public final void k(String str) {
        this.downloadMusicPath = str;
    }

    public String toString() {
        return "VideoMusic(musicId=" + this.musicId + ", name=" + this.name + ", author=" + this.author + ", url=" + this.url + ", cover=" + this.cover + ", duration=" + this.duration + ", uploadTime=" + this.uploadTime + ", status=" + this.status + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        s.h(parcel, "parcel");
        parcel.writeString(this.musicId);
        parcel.writeString(this.name);
        parcel.writeString(this.author);
        parcel.writeString(this.url);
        parcel.writeString(this.cover);
        parcel.writeString(this.duration);
        parcel.writeInt(this.uploadTime);
        parcel.writeInt(this.status);
        parcel.writeString(this.downloadMusicPath);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VideoMusic(android.os.Parcel r12) {
        /*
            r11 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.s.h(r12, r0)
            java.lang.String r0 = r12.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto Lf
            r3 = r1
            goto L10
        Lf:
            r3 = r0
        L10:
            java.lang.String r0 = r12.readString()
            if (r0 != 0) goto L18
            r4 = r1
            goto L19
        L18:
            r4 = r0
        L19:
            java.lang.String r0 = r12.readString()
            if (r0 != 0) goto L21
            r5 = r1
            goto L22
        L21:
            r5 = r0
        L22:
            java.lang.String r0 = r12.readString()
            if (r0 != 0) goto L2a
            r6 = r1
            goto L2b
        L2a:
            r6 = r0
        L2b:
            java.lang.String r0 = r12.readString()
            if (r0 != 0) goto L33
            r7 = r1
            goto L34
        L33:
            r7 = r0
        L34:
            java.lang.String r0 = r12.readString()
            if (r0 != 0) goto L3c
            r8 = r1
            goto L3d
        L3c:
            r8 = r0
        L3d:
            int r9 = r12.readInt()
            int r10 = r12.readInt()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r12 = r12.readString()
            r11.downloadMusicPath = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.VideoMusic.<init>(android.os.Parcel):void");
    }
}
