package com.coremedia.iso.boxes.fragment;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class TrackRunBox extends AbstractFullBox {
    public static final String TYPE = "trun";
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
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private int dataOffset;
    private List<Entry> entries;
    private SampleFlags firstSampleFlags;

    /* loaded from: classes.dex */
    public static class Entry {
        private long sampleCompositionTimeOffset;
        private long sampleDuration;
        private SampleFlags sampleFlags;
        private long sampleSize;

        public Entry() {
        }

        public long getSampleCompositionTimeOffset() {
            return this.sampleCompositionTimeOffset;
        }

        public long getSampleDuration() {
            return this.sampleDuration;
        }

        public SampleFlags getSampleFlags() {
            return this.sampleFlags;
        }

        public long getSampleSize() {
            return this.sampleSize;
        }

        public void setSampleCompositionTimeOffset(int i2) {
            this.sampleCompositionTimeOffset = i2;
        }

        public void setSampleDuration(long j2) {
            this.sampleDuration = j2;
        }

        public void setSampleFlags(SampleFlags sampleFlags) {
            this.sampleFlags = sampleFlags;
        }

        public void setSampleSize(long j2) {
            this.sampleSize = j2;
        }

        public String toString() {
            return "Entry{duration=" + this.sampleDuration + ", size=" + this.sampleSize + ", dlags=" + this.sampleFlags + ", compTimeOffset=" + this.sampleCompositionTimeOffset + '}';
        }

        public Entry(long j2, long j3, SampleFlags sampleFlags, int i2) {
            this.sampleDuration = j2;
            this.sampleSize = j3;
            this.sampleFlags = sampleFlags;
            this.sampleCompositionTimeOffset = i2;
        }
    }

    static {
        ajc$preClinit();
    }

    public TrackRunBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackRunBox.java", TrackRunBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.util.List"), 57);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "int", "dataOffset", "", "void"), 120);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", TypedValues.Custom.S_BOOLEAN, "v", "", "void"), 267);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", TypedValues.Custom.S_BOOLEAN, "v", "", "void"), 275);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "setSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", TypedValues.Custom.S_BOOLEAN, "v", "", "void"), 283);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", TypedValues.Custom.S_BOOLEAN, "v", "", "void"), 292);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "setSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", TypedValues.Custom.S_BOOLEAN, "v", "", "void"), IjkMediaCodecInfo.RANK_SECURE);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "getDataOffset", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "int"), 309);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "getFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 313);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setFirstSampleFlags", "com.coremedia.iso.boxes.fragment.TrackRunBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "firstSampleFlags", "", "void"), TypedValues.AttributesType.TYPE_EASING);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "java.lang.String"), 327);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackRunBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 342);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getSampleCompositionTimeOffsets", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", "[J"), 129);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getSampleCount", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", Constants.LONG), 238);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "isDataOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 242);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "isFirstSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 246);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "isSampleSizePresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 251);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "isSampleDurationPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 255);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "isSampleFlagsPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 259);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "isSampleCompositionTimeOffsetPresent", "com.coremedia.iso.boxes.fragment.TrackRunBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 263);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.dataOffset = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        } else {
            this.dataOffset = -1;
        }
        if ((getFlags() & 4) == 4) {
            this.firstSampleFlags = new SampleFlags(byteBuffer);
        }
        for (int i2 = 0; i2 < readUInt32; i2++) {
            Entry entry = new Entry();
            if ((getFlags() & 256) == 256) {
                entry.sampleDuration = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 512) == 512) {
                entry.sampleSize = IsoTypeReader.readUInt32(byteBuffer);
            }
            if ((getFlags() & 1024) == 1024) {
                entry.sampleFlags = new SampleFlags(byteBuffer);
            }
            if ((getFlags() & 2048) == 2048) {
                entry.sampleCompositionTimeOffset = byteBuffer.getInt();
            }
            this.entries.add(entry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        int flags = getFlags();
        if ((flags & 1) == 1) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.dataOffset);
        }
        if ((flags & 4) == 4) {
            this.firstSampleFlags.getContent(byteBuffer);
        }
        for (Entry entry : this.entries) {
            if ((flags & 256) == 256) {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleDuration);
            }
            if ((flags & 512) == 512) {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleSize);
            }
            if ((flags & 1024) == 1024) {
                entry.sampleFlags.getContent(byteBuffer);
            }
            if ((flags & 2048) == 2048) {
                if (getVersion() == 0) {
                    IsoTypeWriter.writeUInt32(byteBuffer, entry.sampleCompositionTimeOffset);
                } else {
                    byteBuffer.putInt((int) entry.sampleCompositionTimeOffset);
                }
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int flags = getFlags();
        long j2 = (flags & 1) == 1 ? 12L : 8L;
        if ((flags & 4) == 4) {
            j2 += 4;
        }
        long j3 = (flags & 256) == 256 ? 4L : 0L;
        if ((flags & 512) == 512) {
            j3 += 4;
        }
        if ((flags & 1024) == 1024) {
            j3 += 4;
        }
        if ((flags & 2048) == 2048) {
            j3 += 4;
        }
        return j2 + (j3 * this.entries.size());
    }

    public int getDataOffset() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_15, this, this));
        return this.dataOffset;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public SampleFlags getFirstSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.firstSampleFlags;
    }

    public long[] getSampleCompositionTimeOffsets() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        if (isSampleCompositionTimeOffsetPresent()) {
            int size = this.entries.size();
            long[] jArr = new long[size];
            for (int i2 = 0; i2 < size; i2++) {
                jArr[i2] = this.entries.get(i2).getSampleCompositionTimeOffset();
            }
            return jArr;
        }
        return null;
    }

    public long getSampleCount() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.entries.size();
    }

    public boolean isDataOffsetPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return (getFlags() & 1) == 1;
    }

    public boolean isFirstSampleFlagsPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return (getFlags() & 4) == 4;
    }

    public boolean isSampleCompositionTimeOffsetPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_9, this, this));
        return (getFlags() & 2048) == 2048;
    }

    public boolean isSampleDurationPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return (getFlags() & 256) == 256;
    }

    public boolean isSampleFlagsPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return (getFlags() & 1024) == 1024;
    }

    public boolean isSampleSizePresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return (getFlags() & 512) == 512;
    }

    public void setDataOffset(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        if (i2 == -1) {
            setFlags(getFlags() & 16777214);
        } else {
            setFlags(getFlags() | 1);
        }
        this.dataOffset = i2;
    }

    public void setDataOffsetPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, h.a.a.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & 16777214);
        }
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, list));
        this.entries = list;
    }

    public void setFirstSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, sampleFlags));
        if (sampleFlags == null) {
            setFlags(getFlags() & 16777211);
        } else {
            setFlags(getFlags() | 4);
        }
        this.firstSampleFlags = sampleFlags;
    }

    public void setSampleCompositionTimeOffsetPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, h.a.a.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 2048);
        } else {
            setFlags(getFlags() & 16775167);
        }
    }

    public void setSampleDurationPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, h.a.a.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 256);
        } else {
            setFlags(getFlags() & 16776959);
        }
    }

    public void setSampleFlagsPresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 1024);
        } else {
            setFlags(getFlags() & 16776191);
        }
    }

    public void setSampleSizePresent(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.a(z)));
        if (z) {
            setFlags(getFlags() | 512);
        } else {
            setFlags(getFlags() & 16776703);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return "TrackRunBox{sampleCount=" + this.entries.size() + ", dataOffset=" + this.dataOffset + ", dataOffsetPresent=" + isDataOffsetPresent() + ", sampleSizePresent=" + isSampleSizePresent() + ", sampleDurationPresent=" + isSampleDurationPresent() + ", sampleFlagsPresentPresent=" + isSampleFlagsPresent() + ", sampleCompositionTimeOffsetPresent=" + isSampleCompositionTimeOffsetPresent() + ", firstSampleFlags=" + this.firstSampleFlags + '}';
    }
}
