package us.pinguo.repository2020.database.sticker;

import java.util.ArrayList;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Sticker.kt */
/* loaded from: classes6.dex */
public final class Sticker implements NoProguard {
    public static final a Companion = new a(null);
    public static final float FILTER_DEFAULT_VALUE = 0.7f;
    public static final float MAKE_UP_DEFAULT_VALUE = 0.8f;
    private ArrayList<String> categoryIDs;
    private String icon;
    private final int icon_tag;
    private final String icon_tag_pic;
    private boolean isFresh;
    private final int is_theme;
    private final int music_tag;
    private final String name;
    private final long off_time;
    private final long onsale_time;
    private final String pid;
    private final int position;
    private volatile StickerState state;
    private final int type;
    private final StickerTypeCountInfo typeCountInfo;
    private final int unlock_type;
    private final int vip;

    /* compiled from: Sticker.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public Sticker(String pid, String name, String icon, int i2, long j2, long j3, int i3, StickerTypeCountInfo typeCountInfo, int i4, int i5, int i6, String icon_tag_pic, int i7, int i8) {
        s.h(pid, "pid");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(typeCountInfo, "typeCountInfo");
        s.h(icon_tag_pic, "icon_tag_pic");
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.type = i2;
        this.onsale_time = j2;
        this.off_time = j3;
        this.unlock_type = i3;
        this.typeCountInfo = typeCountInfo;
        this.position = i4;
        this.music_tag = i5;
        this.icon_tag = i6;
        this.icon_tag_pic = icon_tag_pic;
        this.vip = i7;
        this.is_theme = i8;
        this.categoryIDs = new ArrayList<>();
        this.state = StickerState.NOT_DOWNLOADED;
    }

    public final String component1() {
        return this.pid;
    }

    public final int component10() {
        return this.music_tag;
    }

    public final int component11() {
        return this.icon_tag;
    }

    public final String component12() {
        return this.icon_tag_pic;
    }

    public final int component13() {
        return this.vip;
    }

    public final int component14() {
        return this.is_theme;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.type;
    }

    public final long component5() {
        return this.onsale_time;
    }

    public final long component6() {
        return this.off_time;
    }

    public final int component7() {
        return this.unlock_type;
    }

    public final StickerTypeCountInfo component8() {
        return this.typeCountInfo;
    }

    public final int component9() {
        return this.position;
    }

    public final Sticker copy(String pid, String name, String icon, int i2, long j2, long j3, int i3, StickerTypeCountInfo typeCountInfo, int i4, int i5, int i6, String icon_tag_pic, int i7, int i8) {
        s.h(pid, "pid");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(typeCountInfo, "typeCountInfo");
        s.h(icon_tag_pic, "icon_tag_pic");
        return new Sticker(pid, name, icon, i2, j2, j3, i3, typeCountInfo, i4, i5, i6, icon_tag_pic, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sticker) {
            Sticker sticker = (Sticker) obj;
            return s.c(this.pid, sticker.pid) && s.c(this.name, sticker.name) && s.c(this.icon, sticker.icon) && this.type == sticker.type && this.onsale_time == sticker.onsale_time && this.off_time == sticker.off_time && this.unlock_type == sticker.unlock_type && s.c(this.typeCountInfo, sticker.typeCountInfo) && this.position == sticker.position && this.music_tag == sticker.music_tag && this.icon_tag == sticker.icon_tag && s.c(this.icon_tag_pic, sticker.icon_tag_pic) && this.vip == sticker.vip && this.is_theme == sticker.is_theme;
        }
        return false;
    }

    public final ArrayList<String> getCategoryIDs() {
        return this.categoryIDs;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getIcon_tag() {
        return this.icon_tag;
    }

    public final String getIcon_tag_pic() {
        return this.icon_tag_pic;
    }

    public final int getMusic_tag() {
        return this.music_tag;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOff_time() {
        return this.off_time;
    }

    public final long getOnsale_time() {
        return this.onsale_time;
    }

    public final String getPid() {
        return this.pid;
    }

    public final int getPosition() {
        return this.position;
    }

    public final StickerState getState() {
        return this.state;
    }

    public final int getType() {
        return this.type;
    }

    public final StickerTypeCountInfo getTypeCountInfo() {
        return this.typeCountInfo;
    }

    public final int getUnlock_type() {
        return this.unlock_type;
    }

    public final int getVip() {
        return this.vip;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.pid.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.type) * 31) + defpackage.c.a(this.onsale_time)) * 31) + defpackage.c.a(this.off_time)) * 31) + this.unlock_type) * 31) + this.typeCountInfo.hashCode()) * 31) + this.position) * 31) + this.music_tag) * 31) + this.icon_tag) * 31) + this.icon_tag_pic.hashCode()) * 31) + this.vip) * 31) + this.is_theme;
    }

    public final boolean isFresh() {
        return this.isFresh;
    }

    public final boolean isMusic() {
        return this.music_tag != 0;
    }

    public final boolean isValid(long j2) {
        if (j2 != 0) {
            long j3 = this.onsale_time;
            if (j3 > 0) {
                long j4 = this.off_time;
                if (j4 > 0) {
                    long j5 = 1000;
                    if (j2 < j3 * j5 || j2 > j4 * j5) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean isVip() {
        return this.vip != 0;
    }

    public final int is_theme() {
        return this.is_theme;
    }

    public final void setCategoryIDs(ArrayList<String> arrayList) {
        s.h(arrayList, "<set-?>");
        this.categoryIDs = arrayList;
    }

    public final void setFresh(boolean z) {
        this.isFresh = z;
    }

    public final void setIcon(String str) {
        s.h(str, "<set-?>");
        this.icon = str;
    }

    public final void setState(StickerState stickerState) {
        s.h(stickerState, "<set-?>");
        this.state = stickerState;
    }

    public String toString() {
        return "Sticker(pid=" + this.pid + ", name=" + this.name + ", icon=" + this.icon + ", type=" + this.type + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ", unlock_type=" + this.unlock_type + ", typeCountInfo=" + this.typeCountInfo + ", position=" + this.position + ", music_tag=" + this.music_tag + ", icon_tag=" + this.icon_tag + ", icon_tag_pic=" + this.icon_tag_pic + ", vip=" + this.vip + ", is_theme=" + this.is_theme + ')';
    }
}
