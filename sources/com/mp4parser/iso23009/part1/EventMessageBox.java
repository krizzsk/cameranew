package com.mp4parser.iso23009.part1;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.tapjoy.TapjoyAuctionFlags;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public class EventMessageBox extends AbstractFullBox {
    public static final String TYPE = "emsg";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    long eventDuration;
    long id;
    byte[] messageData;
    long presentationTimeDelta;
    String schemeIdUri;
    long timescale;
    String value;

    static {
        ajc$preClinit();
    }

    public EventMessageBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("EventMessageBox.java", EventMessageBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 59);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "schemeIdUri", "", "void"), 63);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getId", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", Constants.LONG), 99);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setId", "com.mp4parser.iso23009.part1.EventMessageBox", Constants.LONG, TapjoyAuctionFlags.AUCTION_ID, "", "void"), 103);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "getMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "[B"), 107);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "[B", "messageData", "", "void"), 111);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getValue", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 67);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setValue", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", FirebaseAnalytics.Param.VALUE, "", "void"), 71);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", Constants.LONG), 75);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", Constants.LONG, "timescale", "", "void"), 79);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", Constants.LONG), 83);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", Constants.LONG, "presentationTimeDelta", "", "void"), 87);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", Constants.LONG), 91);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", Constants.LONG, "eventDuration", "", "void"), 95);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeIdUri = IsoTypeReader.readString(byteBuffer);
        this.value = IsoTypeReader.readString(byteBuffer);
        this.timescale = IsoTypeReader.readUInt32(byteBuffer);
        this.presentationTimeDelta = IsoTypeReader.readUInt32(byteBuffer);
        this.eventDuration = IsoTypeReader.readUInt32(byteBuffer);
        this.id = IsoTypeReader.readUInt32(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.messageData = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUtf8String(byteBuffer, this.schemeIdUri);
        IsoTypeWriter.writeUtf8String(byteBuffer, this.value);
        IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
        IsoTypeWriter.writeUInt32(byteBuffer, this.presentationTimeDelta);
        IsoTypeWriter.writeUInt32(byteBuffer, this.eventDuration);
        IsoTypeWriter.writeUInt32(byteBuffer, this.id);
        byteBuffer.put(this.messageData);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.schemeIdUri) + 22 + Utf8.utf8StringLengthInBytes(this.value) + this.messageData.length;
    }

    public long getEventDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.eventDuration;
    }

    public long getId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.id;
    }

    public byte[] getMessageData() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.messageData;
    }

    public long getPresentationTimeDelta() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.presentationTimeDelta;
    }

    public String getSchemeIdUri() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.schemeIdUri;
    }

    public long getTimescale() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.timescale;
    }

    public String getValue() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.value;
    }

    public void setEventDuration(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.f(j2)));
        this.eventDuration = j2;
    }

    public void setId(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.f(j2)));
        this.id = j2;
    }

    public void setMessageData(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, bArr));
        this.messageData = bArr;
    }

    public void setPresentationTimeDelta(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.f(j2)));
        this.presentationTimeDelta = j2;
    }

    public void setSchemeIdUri(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.schemeIdUri = str;
    }

    public void setTimescale(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.f(j2)));
        this.timescale = j2;
    }

    public void setValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.value = str;
    }
}
