package com.coremedia.iso.boxes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Matrix;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tapjoy.TJAdUnitConstants;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class MovieHeaderBox extends AbstractFullBox {
    public static final String TYPE = "mvhd";
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
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    private Date creationTime;
    private int currentTime;
    private long duration;
    private Matrix matrix;
    private Date modificationTime;
    private long nextTrackId;
    private int posterTime;
    private int previewDuration;
    private int previewTime;
    private double rate;
    private int selectionDuration;
    private int selectionTime;
    private long timescale;
    private float volume;

    static {
        ajc$preClinit();
    }

    public MovieHeaderBox() {
        super(TYPE);
        this.rate = 1.0d;
        this.volume = 1.0f;
        this.matrix = Matrix.ROTATE_0;
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 63);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 67);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 203);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", Constants.LONG, "timescale", "", "void"), 211);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", Constants.LONG, TypedValues.TransitionType.S_DURATION, "", "void"), 215);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 222);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", TypedValues.Custom.S_FLOAT, "volume", "", "void"), 226);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 230);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", Constants.LONG, "nextTrackId", "", "void"), 234);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 238);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 242);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 246);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", Constants.LONG), 71);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 254);
        ajc$tjp_22 = bVar.h("method-execution", bVar.g("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 258);
        ajc$tjp_23 = bVar.h("method-execution", bVar.g("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 262);
        ajc$tjp_24 = bVar.h("method-execution", bVar.g("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 266);
        ajc$tjp_25 = bVar.h("method-execution", bVar.g("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), BaseBlurEffect.ROTATION_270);
        ajc$tjp_26 = bVar.h("method-execution", bVar.g("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 274);
        ajc$tjp_27 = bVar.h("method-execution", bVar.g("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 278);
        ajc$tjp_28 = bVar.h("method-execution", bVar.g("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", TJAdUnitConstants.String.VIDEO_CURRENT_TIME, "", "void"), 282);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", Constants.LONG), 75);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 79);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", TypedValues.Custom.S_FLOAT), 83);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 87);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", Constants.LONG), 91);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 139);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 195);
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
        this.rate = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.volume = IsoTypeReader.readFixedPoint88(byteBuffer);
        IsoTypeReader.readUInt16(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
        IsoTypeReader.readUInt32(byteBuffer);
        this.matrix = Matrix.fromByteBuffer(byteBuffer);
        this.previewTime = byteBuffer.getInt();
        this.previewDuration = byteBuffer.getInt();
        this.posterTime = byteBuffer.getInt();
        this.selectionTime = byteBuffer.getInt();
        this.selectionDuration = byteBuffer.getInt();
        this.currentTime = byteBuffer.getInt();
        this.nextTrackId = IsoTypeReader.readUInt32(byteBuffer);
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
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.rate);
        IsoTypeWriter.writeFixedPoint88(byteBuffer, this.volume);
        IsoTypeWriter.writeUInt16(byteBuffer, 0);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        IsoTypeWriter.writeUInt32(byteBuffer, 0L);
        this.matrix.getContent(byteBuffer);
        byteBuffer.putInt(this.previewTime);
        byteBuffer.putInt(this.previewDuration);
        byteBuffer.putInt(this.posterTime);
        byteBuffer.putInt(this.selectionTime);
        byteBuffer.putInt(this.selectionDuration);
        byteBuffer.putInt(this.currentTime);
        IsoTypeWriter.writeUInt32(byteBuffer, this.nextTrackId);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (getVersion() == 1 ? 32L : 20L) + 80;
    }

    public Date getCreationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.creationTime;
    }

    public int getCurrentTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_27, this, this));
        return this.currentTime;
    }

    public long getDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.duration;
    }

    public Matrix getMatrix() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.matrix;
    }

    public Date getModificationTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    public long getNextTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.nextTrackId;
    }

    public int getPosterTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_21, this, this));
        return this.posterTime;
    }

    public int getPreviewDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_19, this, this));
        return this.previewDuration;
    }

    public int getPreviewTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_17, this, this));
        return this.previewTime;
    }

    public double getRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.rate;
    }

    public int getSelectionDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_25, this, this));
        return this.selectionDuration;
    }

    public int getSelectionTime() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_23, this, this));
        return this.selectionTime;
    }

    public long getTimescale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.timescale;
    }

    public float getVolume() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.volume;
    }

    public void setCreationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, date));
        this.creationTime = date;
        if (DateHelper.convert(date) >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            setVersion(1);
        }
    }

    public void setCurrentTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_28, this, this, h.a.a.a.a.e(i2)));
        this.currentTime = i2;
    }

    public void setDuration(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, h.a.a.a.a.f(j2)));
        this.duration = j2;
        if (j2 >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            setVersion(1);
        }
    }

    public void setMatrix(Matrix matrix) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, matrix));
        this.matrix = matrix;
    }

    public void setModificationTime(Date date) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, date));
        this.modificationTime = date;
        if (DateHelper.convert(date) >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            setVersion(1);
        }
    }

    public void setNextTrackId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_16, this, this, h.a.a.a.a.f(j2)));
        this.nextTrackId = j2;
    }

    public void setPosterTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_22, this, this, h.a.a.a.a.e(i2)));
        this.posterTime = i2;
    }

    public void setPreviewDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_20, this, this, h.a.a.a.a.e(i2)));
        this.previewDuration = i2;
    }

    public void setPreviewTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_18, this, this, h.a.a.a.a.e(i2)));
        this.previewTime = i2;
    }

    public void setRate(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.c(d2)));
        this.rate = d2;
    }

    public void setSelectionDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_26, this, this, h.a.a.a.a.e(i2)));
        this.selectionDuration = i2;
    }

    public void setSelectionTime(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_24, this, this, h.a.a.a.a.e(i2)));
        this.selectionTime = i2;
    }

    public void setTimescale(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.f(j2)));
        this.timescale = j2;
    }

    public void setVolume(float f2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_14, this, this, h.a.a.a.a.d(f2)));
        this.volume = f2;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return "MovieHeaderBox[creationTime=" + getCreationTime() + ";modificationTime=" + getModificationTime() + ";timescale=" + getTimescale() + ";duration=" + getDuration() + ";rate=" + getRate() + ";volume=" + getVolume() + ";matrix=" + this.matrix + ";nextTrackId=" + getNextTrackId() + "]";
    }
}
