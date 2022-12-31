package com.googlecode.mp4parser.boxes.microsoft;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class XtraBox extends AbstractBox {
    private static final long FILETIME_EPOCH_DIFF = 11644473600000L;
    private static final long FILETIME_ONE_MILLISECOND = 10000;
    public static final int MP4_XTRA_BT_FILETIME = 21;
    public static final int MP4_XTRA_BT_GUID = 72;
    public static final int MP4_XTRA_BT_INT64 = 19;
    public static final int MP4_XTRA_BT_UNICODE = 8;
    public static final String TYPE = "Xtra";
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
    ByteBuffer data;
    private boolean successfulParse;
    Vector<a> tags;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        public int a;
        public String b;
        public long c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f5094d;

        /* renamed from: e  reason: collision with root package name */
        public Date f5095e;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteBuffer byteBuffer) {
            try {
                byteBuffer.putInt(f());
                byteBuffer.putShort((short) this.a);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i2 = this.a;
                if (i2 == 8) {
                    XtraBox.writeUtf16String(byteBuffer, this.b);
                } else if (i2 == 19) {
                    byteBuffer.putLong(this.c);
                } else if (i2 == 21) {
                    byteBuffer.putLong(XtraBox.millisToFiletime(this.f5095e.getTime()));
                } else {
                    byteBuffer.put(this.f5094d);
                }
            } finally {
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f() {
            int length;
            int i2 = this.a;
            if (i2 == 8) {
                length = (this.b.length() * 2) + 2;
            } else if (i2 == 19 || i2 == 21) {
                return 14;
            } else {
                length = this.f5094d.length;
            }
            return length + 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object g() {
            int i2 = this.a;
            if (i2 != 8) {
                if (i2 != 19) {
                    if (i2 != 21) {
                        return this.f5094d;
                    }
                    return this.f5095e;
                }
                return new Long(this.c);
            }
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteBuffer byteBuffer) {
            int i2 = byteBuffer.getInt() - 6;
            this.a = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int i3 = this.a;
            if (i3 == 8) {
                this.b = XtraBox.readUtf16String(byteBuffer, i2);
            } else if (i3 == 19) {
                this.c = byteBuffer.getLong();
            } else if (i3 != 21) {
                byte[] bArr = new byte[i2];
                this.f5094d = bArr;
                byteBuffer.get(bArr);
            } else {
                this.f5095e = new Date(XtraBox.filetimeToMillis(byteBuffer.getLong()));
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public String toString() {
            int i2 = this.a;
            if (i2 == 8) {
                return "[string]" + this.b;
            } else if (i2 == 19) {
                return "[long]" + String.valueOf(this.c);
            } else if (i2 != 21) {
                return "[GUID](nonParsed)";
            } else {
                return "[filetime]" + this.f5095e.toString();
            }
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        private b(String str) {
            this.a = 8;
            this.b = str;
        }

        /* synthetic */ b(String str, b bVar) {
            this(str);
        }

        private b(long j2) {
            this.a = 19;
            this.c = j2;
        }

        /* synthetic */ b(long j2, b bVar) {
            this(j2);
        }

        private b(Date date) {
            this.a = 21;
            this.f5095e = date;
        }

        /* synthetic */ b(Date date, b bVar) {
            this(date);
        }
    }

    static {
        ajc$preClinit();
    }

    public XtraBox() {
        super(TYPE);
        this.successfulParse = false;
        this.tags = new Vector<>();
    }

    private static /* synthetic */ void ajc$preClinit() {
        h.a.a.b.b bVar = new h.a.a.b.b("XtraBox.java", XtraBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 88);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getAllTagNames", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 151);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), 289);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getFirstStringValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.String"), 166);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getFirstDateValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.util.Date"), 183);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getFirstLongValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.Long"), 200);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "[Ljava.lang.Object;"), 216);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "removeTag", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "void"), 236);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setTagValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 249);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), 265);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 276);
    }

    private int detailSize() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.tags.size(); i3++) {
            i2 += this.tags.elementAt(i3).g();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long filetimeToMillis(long j2) {
        return (j2 / 10000) - FILETIME_EPOCH_DIFF;
    }

    private a getTagByName(String str) {
        Iterator<a> it = this.tags.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b.equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long millisToFiletime(long j2) {
        return (j2 + FILETIME_EPOCH_DIFF) * 10000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readAsciiString(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Shouldn't happen", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readUtf16String(ByteBuffer byteBuffer, int i2) {
        int i3 = (i2 / 2) - 1;
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i4] = byteBuffer.getChar();
        }
        byteBuffer.getChar();
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeAsciiString(ByteBuffer byteBuffer, String str) {
        try {
            byteBuffer.put(str.getBytes("US-ASCII"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Shouldn't happen", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUtf16String(ByteBuffer byteBuffer, String str) {
        for (char c : str.toCharArray()) {
            byteBuffer.putChar(c);
        }
        byteBuffer.putChar((char) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int detailSize;
        int remaining = byteBuffer.remaining();
        this.data = byteBuffer.slice();
        this.successfulParse = false;
        try {
            try {
                this.tags.clear();
                while (byteBuffer.remaining() > 0) {
                    a aVar = new a((a) null);
                    aVar.h(byteBuffer);
                    this.tags.addElement(aVar);
                }
                detailSize = detailSize();
            } catch (Exception e2) {
                this.successfulParse = false;
                PrintStream printStream = System.err;
                printStream.println("Malformed Xtra Tag detected: " + e2.toString());
                e2.printStackTrace();
                byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
            }
            if (remaining == detailSize) {
                this.successfulParse = true;
                return;
            }
            throw new RuntimeException("Improperly handled Xtra tag: Calculated sizes don't match ( " + remaining + "/" + detailSize + ")");
        } finally {
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
    }

    public String[] getAllTagNames() {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.c(ajc$tjp_1, this, this));
        String[] strArr = new String[this.tags.size()];
        for (int i2 = 0; i2 < this.tags.size(); i2++) {
            strArr[i2] = this.tags.elementAt(i2).b;
        }
        return strArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        if (this.successfulParse) {
            for (int i2 = 0; i2 < this.tags.size(); i2++) {
                this.tags.elementAt(i2).f(byteBuffer);
            }
            return;
        }
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int limit;
        if (this.successfulParse) {
            limit = detailSize();
        } else {
            limit = this.data.limit();
        }
        return limit;
    }

    public Date getFirstDateValue(String str) {
        Object[] values;
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.d(ajc$tjp_3, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof Date) {
                return (Date) obj;
            }
        }
        return null;
    }

    public Long getFirstLongValue(String str) {
        Object[] values;
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.d(ajc$tjp_4, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return null;
    }

    public String getFirstStringValue(String str) {
        Object[] values;
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.d(ajc$tjp_2, this, this, str));
        for (Object obj : getValues(str)) {
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public Object[] getValues(String str) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.d(ajc$tjp_5, this, this, str));
        a tagByName = getTagByName(str);
        if (tagByName != null) {
            Object[] objArr = new Object[tagByName.c.size()];
            for (int i2 = 0; i2 < tagByName.c.size(); i2++) {
                objArr[i2] = ((b) tagByName.c.elementAt(i2)).g();
            }
            return objArr;
        }
        return new Object[0];
    }

    public void removeTag(String str) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.d(ajc$tjp_6, this, this, str));
        a tagByName = getTagByName(str);
        if (tagByName != null) {
            this.tags.remove(tagByName);
        }
    }

    public void setTagValue(String str, String str2) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.e(ajc$tjp_8, this, this, str, str2));
        setTagValues(str, new String[]{str2});
    }

    public void setTagValues(String str, String[] strArr) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.e(ajc$tjp_7, this, this, str, strArr));
        removeTag(str);
        a aVar = new a(str, null);
        for (String str2 : strArr) {
            aVar.c.addElement(new b(str2, (b) null));
        }
        this.tags.addElement(aVar);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.c(ajc$tjp_0, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        Iterator<a> it = this.tags.iterator();
        while (it.hasNext()) {
            a next = it.next();
            Iterator it2 = next.c.iterator();
            while (it2.hasNext()) {
                stringBuffer.append(next.b);
                stringBuffer.append("=");
                stringBuffer.append(((b) it2.next()).toString());
                stringBuffer.append(";");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private int a;
        private String b;
        private Vector<b> c;

        private a() {
            this.c = new Vector<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteBuffer byteBuffer) {
            byteBuffer.putInt(g());
            byteBuffer.putInt(this.b.length());
            XtraBox.writeAsciiString(byteBuffer, this.b);
            byteBuffer.putInt(this.c.size());
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                this.c.elementAt(i2).e(byteBuffer);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int g() {
            int length = this.b.length() + 12;
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                length += this.c.elementAt(i2).f();
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteBuffer byteBuffer) {
            this.a = byteBuffer.getInt();
            this.b = XtraBox.readAsciiString(byteBuffer, byteBuffer.getInt());
            int i2 = byteBuffer.getInt();
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = new b((b) null);
                bVar.h(byteBuffer);
                this.c.addElement(bVar);
            }
            if (this.a == g()) {
                return;
            }
            throw new RuntimeException("Improperly handled Xtra tag: Sizes don't match ( " + this.a + "/" + g() + ") on " + this.b);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.b);
            stringBuffer.append(" [");
            stringBuffer.append(this.a);
            stringBuffer.append("/");
            stringBuffer.append(this.c.size());
            stringBuffer.append("]:\n");
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                stringBuffer.append("  ");
                stringBuffer.append(this.c.elementAt(i2).toString());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* synthetic */ a(String str, a aVar) {
            this(str);
        }

        private a(String str) {
            this();
            this.b = str;
        }
    }

    public void setTagValue(String str, Date date) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.e(ajc$tjp_9, this, this, str, date));
        removeTag(str);
        a aVar = new a(str, null);
        aVar.c.addElement(new b(date, (b) null));
        this.tags.addElement(aVar);
    }

    public XtraBox(String str) {
        super(str);
        this.successfulParse = false;
        this.tags = new Vector<>();
    }

    public void setTagValue(String str, long j2) {
        RequiresParseDetailAspect.aspectOf().before(h.a.a.b.b.e(ajc$tjp_10, this, this, str, h.a.a.a.a.f(j2)));
        removeTag(str);
        a aVar = new a(str, null);
        aVar.c.addElement(new b(j2, (b) null));
        this.tags.addElement(aVar);
    }
}
