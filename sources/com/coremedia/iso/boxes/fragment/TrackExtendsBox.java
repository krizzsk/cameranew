package com.coremedia.iso.boxes.fragment;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class TrackExtendsBox extends AbstractFullBox {
    public static final String TYPE = "trex";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private long defaultSampleDescriptionIndex;
    private long defaultSampleDuration;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize;
    private long trackId;

    static {
        ajc$preClinit();
    }

    public TrackExtendsBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackExtendsBox.java", TrackExtendsBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", Constants.LONG), 72);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", Constants.LONG), 76);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 112);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", Constants.LONG), 80);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", Constants.LONG), 84);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 88);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getDefaultSampleFlagsStr", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "java.lang.String"), 92);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", Constants.LONG, "trackId", "", "void"), 96);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", Constants.LONG, "defaultSampleDescriptionIndex", "", "void"), 100);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", Constants.LONG, "defaultSampleDuration", "", "void"), 104);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", Constants.LONG, "defaultSampleSize", "", "void"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleDescriptionIndex = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleDuration = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleSize = IsoTypeReader.readUInt32(byteBuffer);
        this.defaultSampleFlags = new SampleFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleDescriptionIndex);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleDuration);
        IsoTypeWriter.writeUInt32(byteBuffer, this.defaultSampleSize);
        this.defaultSampleFlags.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24L;
    }

    public long getDefaultSampleDescriptionIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.defaultSampleDescriptionIndex;
    }

    public long getDefaultSampleDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.defaultSampleDuration;
    }

    public SampleFlags getDefaultSampleFlags() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.defaultSampleFlags;
    }

    public String getDefaultSampleFlagsStr() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.defaultSampleFlags.toString();
    }

    public long getDefaultSampleSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.defaultSampleSize;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.trackId;
    }

    public void setDefaultSampleDescriptionIndex(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.f(j2)));
        this.defaultSampleDescriptionIndex = j2;
    }

    public void setDefaultSampleDuration(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, h.a.a.a.a.f(j2)));
        this.defaultSampleDuration = j2;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, sampleFlags));
        this.defaultSampleFlags = sampleFlags;
    }

    public void setDefaultSampleSize(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.f(j2)));
        this.defaultSampleSize = j2;
    }

    public void setTrackId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, h.a.a.a.a.f(j2)));
        this.trackId = j2;
    }
}
