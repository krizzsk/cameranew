package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDisplay.kt */
/* loaded from: classes6.dex */
public final class Stroke implements NoProguard {
    private final String display_md5;
    private final String down_url;
    private final String icon;
    private final int icon_tag;
    private final String icon_tag_pic;
    private final int music_tag;
    private final String name;
    private final long off_time;
    private final long onsale_time;
    private final String pid;
    private final int type;
    private final int unlock_type;
    private final int vip;

    public Stroke(String pid, String name, String icon, int i2, long j2, long j3, int i3, int i4, int i5, String icon_tag_pic, int i6, String display_md5, String down_url) {
        s.h(pid, "pid");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(icon_tag_pic, "icon_tag_pic");
        s.h(display_md5, "display_md5");
        s.h(down_url, "down_url");
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.type = i2;
        this.onsale_time = j2;
        this.off_time = j3;
        this.unlock_type = i3;
        this.music_tag = i4;
        this.icon_tag = i5;
        this.icon_tag_pic = icon_tag_pic;
        this.vip = i6;
        this.display_md5 = display_md5;
        this.down_url = down_url;
    }

    public final String component1() {
        return this.pid;
    }

    public final String component10() {
        return this.icon_tag_pic;
    }

    public final int component11() {
        return this.vip;
    }

    public final String component12() {
        return this.display_md5;
    }

    public final String component13() {
        return this.down_url;
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

    public final int component8() {
        return this.music_tag;
    }

    public final int component9() {
        return this.icon_tag;
    }

    public final Stroke copy(String pid, String name, String icon, int i2, long j2, long j3, int i3, int i4, int i5, String icon_tag_pic, int i6, String display_md5, String down_url) {
        s.h(pid, "pid");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(icon_tag_pic, "icon_tag_pic");
        s.h(display_md5, "display_md5");
        s.h(down_url, "down_url");
        return new Stroke(pid, name, icon, i2, j2, j3, i3, i4, i5, icon_tag_pic, i6, display_md5, down_url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Stroke) {
            Stroke stroke = (Stroke) obj;
            return s.c(this.pid, stroke.pid) && s.c(this.name, stroke.name) && s.c(this.icon, stroke.icon) && this.type == stroke.type && this.onsale_time == stroke.onsale_time && this.off_time == stroke.off_time && this.unlock_type == stroke.unlock_type && this.music_tag == stroke.music_tag && this.icon_tag == stroke.icon_tag && s.c(this.icon_tag_pic, stroke.icon_tag_pic) && this.vip == stroke.vip && s.c(this.display_md5, stroke.display_md5) && s.c(this.down_url, stroke.down_url);
        }
        return false;
    }

    public final String getDisplay_md5() {
        return this.display_md5;
    }

    public final String getDown_url() {
        return this.down_url;
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

    public final int getType() {
        return this.type;
    }

    public final int getUnlock_type() {
        return this.unlock_type;
    }

    public final int getVip() {
        return this.vip;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.pid.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.type) * 31) + c.a(this.onsale_time)) * 31) + c.a(this.off_time)) * 31) + this.unlock_type) * 31) + this.music_tag) * 31) + this.icon_tag) * 31) + this.icon_tag_pic.hashCode()) * 31) + this.vip) * 31) + this.display_md5.hashCode()) * 31) + this.down_url.hashCode();
    }

    public String toString() {
        return "Stroke(pid=" + this.pid + ", name=" + this.name + ", icon=" + this.icon + ", type=" + this.type + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ", unlock_type=" + this.unlock_type + ", music_tag=" + this.music_tag + ", icon_tag=" + this.icon_tag + ", icon_tag_pic=" + this.icon_tag_pic + ", vip=" + this.vip + ", display_md5=" + this.display_md5 + ", down_url=" + this.down_url + ')';
    }
}
