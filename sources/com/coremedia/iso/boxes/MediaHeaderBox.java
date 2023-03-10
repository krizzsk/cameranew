package com.coremedia.iso.boxes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class MediaHeaderBox extends AbstractFullBox {
    public static final String TYPE = "mdhd";
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
    private Date creationTime;
    private long duration;
    private String language;
    private Date modificationTime;
    private long timescale;

    static {
        ajc$preClinit();
    }

    public MediaHeaderBox() {
        super(TYPE);
        this.creationTime = new Date();
        this.modificationTime = new Date();
        this.language = "eng";
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("MediaHeaderBox.java", MediaHeaderBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 46);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 50);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 118);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", Constants.LONG), 54);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", Constants.LONG), 58);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 62);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 79);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 83);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", Constants.LONG, "timescale", "", "void"), 87);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", Constants.LONG, TypedValues.TransitionType.S_DURATION, "", "void"), 91);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "void"), 95);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(byteBuffer));
            this.timescale = IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt64(byteBuffer);
        } else {
            this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(byteBuffer));
            this.timescale = IsoTypeReader.readUInt32(byteBuffer);
            this.duration = IsoTypeReader.readUInt32(byteBuffer);
        }
        this.language = IsoTypeReader.readIso639(byteBuffer);
        IsoTypeReader.readUInt16(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
            IsoTypeWriter.writeUInt64(byteBuffer, this.duration);
        } else {
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
            IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
            IsoTypeWriter.writeUInt32(byteBuffer, this.duration);
        }
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        IsoTypeWriter.writeUInt16(byteBuffer, 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (getVersion() == 1 ? 32L : 20L) + 2 + 2;
    }

    public Date getCreationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.creationTime;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.duration;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.language;
    }

    public Date getModificationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    public long getTimescale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.timescale;
    }

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, date));
        this.creationTime = date;
    }

    public void setDuration(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, h.a.a.a.a.f(j2)));
        this.duration = j2;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, str));
        this.language = str;
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, date));
        this.modificationTime = date;
    }

    public void setTimescale(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.f(j2)));
        this.timescale = j2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return "MediaHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";timescale=" + getTimescale() + ";duration=" + getDuration() + ";language=" + getLanguage() + "]";
    }
}
