package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/* compiled from: XmlParser.java */
/* loaded from: classes.dex */
public class n {

    /* compiled from: XmlParser.java */
    /* loaded from: classes.dex */
    private static class a extends DefaultHandler {
        private HashMap<String, Object> a = new HashMap<>();
        private HashMap<String, Object> b;

        public HashMap<String, Object> a() {
            return this.a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i2, int i3) {
            HashMap<String, Object> hashMap;
            String trim = String.valueOf(cArr, i2, i3).trim();
            if (TextUtils.isEmpty(trim) || (hashMap = this.b) == null) {
                return;
            }
            hashMap.put(FirebaseAnalytics.Param.VALUE, trim);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this.b = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (this.b != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                this.b.put(str2, hashMap);
                this.b = hashMap;
            } else {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                this.b = hashMap2;
                this.a.put(str2, hashMap2);
            }
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                this.b.put(attributes.getLocalName(i2), attributes.getValue(i2));
            }
        }
    }

    public HashMap<String, Object> a(String str) throws Throwable {
        a aVar = new a();
        Xml.parse(str, aVar);
        return aVar.a();
    }
}
