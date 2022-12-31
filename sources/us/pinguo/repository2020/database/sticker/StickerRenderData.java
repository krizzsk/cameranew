package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerRenderData.kt */
/* loaded from: classes6.dex */
public final class StickerRenderData implements NoProguard {
    private final StickerBeauty beauty;
    private final Float filterDisplayStrength;
    private final StickerFilterInner filterInner;
    private final boolean hasBeauty;
    private final boolean hasFilter;
    private final boolean hasMusic;
    private final String key;
    private final Float makeupDisplayStrength;
    private final String[] musicList;
    private final String subt;
    private final int supportVersion;
    private final String t;
    private final String type;
    private final StickerUnity unity;
    private final int unityTouchMode;
    private final int version;

    public StickerRenderData(StickerBeauty stickerBeauty, StickerFilterInner filterInner, String t, String[] musicList, int i2, String type, int i3, String subt, boolean z, int i4, boolean z2, boolean z3, String key, StickerUnity unity, Float f2, Float f3) {
        s.h(filterInner, "filterInner");
        s.h(t, "t");
        s.h(musicList, "musicList");
        s.h(type, "type");
        s.h(subt, "subt");
        s.h(key, "key");
        s.h(unity, "unity");
        this.beauty = stickerBeauty;
        this.filterInner = filterInner;
        this.t = t;
        this.musicList = musicList;
        this.version = i2;
        this.type = type;
        this.supportVersion = i3;
        this.subt = subt;
        this.hasMusic = z;
        this.unityTouchMode = i4;
        this.hasBeauty = z2;
        this.hasFilter = z3;
        this.key = key;
        this.unity = unity;
        this.filterDisplayStrength = f2;
        this.makeupDisplayStrength = f3;
    }

    public final StickerBeauty component1() {
        return this.beauty;
    }

    public final int component10() {
        return this.unityTouchMode;
    }

    public final boolean component11() {
        return this.hasBeauty;
    }

    public final boolean component12() {
        return this.hasFilter;
    }

    public final String component13() {
        return this.key;
    }

    public final StickerUnity component14() {
        return this.unity;
    }

    public final Float component15() {
        return this.filterDisplayStrength;
    }

    public final Float component16() {
        return this.makeupDisplayStrength;
    }

    public final StickerFilterInner component2() {
        return this.filterInner;
    }

    public final String component3() {
        return this.t;
    }

    public final String[] component4() {
        return this.musicList;
    }

    public final int component5() {
        return this.version;
    }

    public final String component6() {
        return this.type;
    }

    public final int component7() {
        return this.supportVersion;
    }

    public final String component8() {
        return this.subt;
    }

    public final boolean component9() {
        return this.hasMusic;
    }

    public final StickerRenderData copy(StickerBeauty stickerBeauty, StickerFilterInner filterInner, String t, String[] musicList, int i2, String type, int i3, String subt, boolean z, int i4, boolean z2, boolean z3, String key, StickerUnity unity, Float f2, Float f3) {
        s.h(filterInner, "filterInner");
        s.h(t, "t");
        s.h(musicList, "musicList");
        s.h(type, "type");
        s.h(subt, "subt");
        s.h(key, "key");
        s.h(unity, "unity");
        return new StickerRenderData(stickerBeauty, filterInner, t, musicList, i2, type, i3, subt, z, i4, z2, z3, key, unity, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerRenderData.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerRenderData");
            StickerRenderData stickerRenderData = (StickerRenderData) obj;
            return s.c(this.beauty, stickerRenderData.beauty) && s.c(this.filterInner, stickerRenderData.filterInner) && s.c(this.t, stickerRenderData.t) && Arrays.equals(this.musicList, stickerRenderData.musicList) && this.version == stickerRenderData.version && s.c(this.type, stickerRenderData.type) && this.supportVersion == stickerRenderData.supportVersion && s.c(this.subt, stickerRenderData.subt) && this.hasMusic == stickerRenderData.hasMusic && this.unityTouchMode == stickerRenderData.unityTouchMode && this.hasBeauty == stickerRenderData.hasBeauty && this.hasFilter == stickerRenderData.hasFilter && s.c(this.key, stickerRenderData.key) && s.c(this.unity, stickerRenderData.unity);
        }
        return false;
    }

    public final StickerBeauty getBeauty() {
        return this.beauty;
    }

    public final Float getFilterDisplayStrength() {
        return this.filterDisplayStrength;
    }

    public final StickerFilterInner getFilterInner() {
        return this.filterInner;
    }

    public final boolean getHasBeauty() {
        return this.hasBeauty;
    }

    public final boolean getHasFilter() {
        return this.hasFilter;
    }

    public final boolean getHasMusic() {
        return this.hasMusic;
    }

    public final String getKey() {
        return this.key;
    }

    public final Float getMakeupDisplayStrength() {
        return this.makeupDisplayStrength;
    }

    public final String[] getMusicList() {
        return this.musicList;
    }

    public final String getSubt() {
        return this.subt;
    }

    public final int getSupportVersion() {
        return this.supportVersion;
    }

    public final String getT() {
        return this.t;
    }

    public final String getType() {
        return this.type;
    }

    public final StickerUnity getUnity() {
        return this.unity;
    }

    public final int getUnityTouchMode() {
        return this.unityTouchMode;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        StickerBeauty stickerBeauty = this.beauty;
        return ((((((((((((((((((((((((((stickerBeauty == null ? 0 : stickerBeauty.hashCode()) * 31) + this.filterInner.hashCode()) * 31) + this.t.hashCode()) * 31) + Arrays.hashCode(this.musicList)) * 31) + this.version) * 31) + this.type.hashCode()) * 31) + this.supportVersion) * 31) + this.subt.hashCode()) * 31) + defpackage.b.a(this.hasMusic)) * 31) + this.unityTouchMode) * 31) + defpackage.b.a(this.hasBeauty)) * 31) + defpackage.b.a(this.hasFilter)) * 31) + this.key.hashCode()) * 31) + this.unity.hashCode();
    }

    public String toString() {
        return "StickerRenderData(beauty=" + this.beauty + ", filterInner=" + this.filterInner + ", t=" + this.t + ", musicList=" + Arrays.toString(this.musicList) + ", version=" + this.version + ", type=" + this.type + ", supportVersion=" + this.supportVersion + ", subt=" + this.subt + ", hasMusic=" + this.hasMusic + ", unityTouchMode=" + this.unityTouchMode + ", hasBeauty=" + this.hasBeauty + ", hasFilter=" + this.hasFilter + ", key=" + this.key + ", unity=" + this.unity + ", filterDisplayStrength=" + this.filterDisplayStrength + ", makeupDisplayStrength=" + this.makeupDisplayStrength + ')';
    }
}
