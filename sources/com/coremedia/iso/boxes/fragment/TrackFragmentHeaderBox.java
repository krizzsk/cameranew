package com.coremedia.iso.boxes.fragment;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
import us.pinguo.user.recycler.c;
/* loaded from: classes.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {
    public static final String TYPE = "tfhd";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private long baseDataOffset;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;

    static {
        ajc$preClinit();
    }

    public TrackFragmentHeaderBox() {
        super(TYPE);
        this.baseDataOffset = -1L;
        this.defaultSampleDuration = -1L;
        this.defaultSampleSize = -1L;
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 126);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 130);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 166);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 170);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 174);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", Constants.LONG, "trackId", "", "void"), 178);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", Constants.LONG, "baseDataOffset", "", "void"), 182);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", Constants.LONG, "sampleDescriptionIndex", "", "void"), 191);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", Constants.LONG, "defaultSampleDuration", "", "void"), 200);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", Constants.LONG, "defaultSampleSize", "", "void"), 205);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 210);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", TypedValues.Custom.S_BOOLEAN, "durationIsEmpty", "", "void"), 215);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 134);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", TypedValues.Custom.S_BOOLEAN, "defaultBaseIsMoof", "", "void"), 220);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 226);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 138);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 142);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", Constants.LONG), 146);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", Constants.LONG), 150);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", Constants.LONG), 154);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", Constants.LONG), 158);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", Constants.LONG), 162);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.baseDataOffset = IsoTypeReader.readUInt64(byteBuffer);
        }
        if ((getFlags() & 2) == 2) {
            this.sampleDescriptionIndex = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 8) == 8) {
            this.defaultSampleDuration = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 16) == 16) {
            this.defaultSampleSize = IsoTypeReader.readUInt32(byteBuffer);
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags = new SampleFlags(byteBuffer);
        }
        if ((getFlags() & 65536) == 65536) {
            this.durationIsEmpty = true;
        }
        if ((getFlags() & 131072) == 131072) {
            this.defaultBaseIsMoof = true;
        }
    }

    public long getBaseDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.baseDataOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        if ((getFlags() & 1) == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, getBaseDataOffset());
        }
        if ((getFlags() & 2) == 2) {
            IsoTypeWriter.writeUInt32(byteBuffer, getSampleDescriptionIndex());
        }
        if ((getFlags() & 8) == 8) {
            IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleDuration());
        }
        if ((getFlags() & 16) == 16) {
            IsoTypeWriter.writeUInt32(byteBuffer, getDefaultSampleSize());
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags.getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int flags = getFlags();
        long j2 = (flags & 1) == 1 ? 16L : 8L;
        if ((flags & 2) == 2) {
            j2 += 4;
        }
        if ((flags & 8) == 8) {
            j2 += 4;
        }
        if ((flags & 16) == 16) {
            j2 += 4;
        }
        return (flags & 32) == 32 ? j2 + 4 : j2;
    }

    public long getDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.defaultSampleDuration;
    }

    public SampleFlags getDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.defaultSampleFlags;
    }

    public long getDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return this.defaultSampleSize;
    }

    public long getSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.sampleDescriptionIndex;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.trackId;
    }

    public boolean hasBaseDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return (getFlags() & 1) != 0;
    }

    public boolean hasDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return (getFlags() & 8) != 0;
    }

    public boolean hasDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return (getFlags() & 32) != 0;
    }

    public boolean hasDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return (getFlags() & 16) != 0;
    }

    public boolean hasSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return (getFlags() & 2) != 0;
    }

    public boolean isDefaultBaseIsMoof() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.defaultBaseIsMoof;
    }

    public boolean isDurationIsEmpty() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_11, this, this));
        return this.durationIsEmpty;
    }

    public void setBaseDataOffset(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, h.a.a.a.a.f(j2)));
        if (j2 == -1) {
            setFlags(getFlags() & c.TYPE_EMPTY);
        } else {
            setFlags(getFlags() | 1);
        }
        this.baseDataOffset = j2;
    }

    public void setDefaultBaseIsMoof(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_20, this, this, h.a.a.a.a.a(z)));
        setFlags(getFlags() | 131072);
        this.defaultBaseIsMoof = z;
    }

    public void setDefaultSampleDuration(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, h.a.a.a.a.f(j2)));
        setFlags(getFlags() | 8);
        this.defaultSampleDuration = j2;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_18, this, this, sampleFlags));
        setFlags(getFlags() | 32);
        this.defaultSampleFlags = sampleFlags;
    }

    public void setDefaultSampleSize(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, h.a.a.a.a.f(j2)));
        setFlags(getFlags() | 16);
        this.defaultSampleSize = j2;
    }

    public void setDurationIsEmpty(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, h.a.a.a.a.a(z)));
        setFlags(getFlags() | 65536);
        this.durationIsEmpty = z;
    }

    public void setSampleDescriptionIndex(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, h.a.a.a.a.f(j2)));
        if (j2 == -1) {
            setFlags(getFlags() & c.TYPE_ERROR);
        } else {
            setFlags(getFlags() | 2);
        }
        this.sampleDescriptionIndex = j2;
    }

    public void setTrackId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.f(j2)));
        this.trackId = j2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_21, this, this));
        return "TrackFragmentHeaderBox{trackId=" + this.trackId + ", baseDataOffset=" + this.baseDataOffset + ", sampleDescriptionIndex=" + this.sampleDescriptionIndex + ", defaultSampleDuration=" + this.defaultSampleDuration + ", defaultSampleSize=" + this.defaultSampleSize + ", defaultSampleFlags=" + this.defaultSampleFlags + ", durationIsEmpty=" + this.durationIsEmpty + ", defaultBaseIsMoof=" + this.defaultBaseIsMoof + '}';
    }
}
