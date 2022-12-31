package com.growingio.android.sdk.utils;

import com.growingio.android.sdk.utils.LinkedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GJSONStringer {
    private StringBuilder out = new StringBuilder();
    private final List<Scope> stack = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    private GJSONStringer array() throws JSONException {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    private void beforeKey() throws JSONException {
        Scope peek = peek();
        if (peek == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (peek != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        replaceTop(Scope.DANGLING_KEY);
    }

    private void beforeValue() throws JSONException {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
        } else if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
        } else if (peek == Scope.DANGLING_KEY) {
            this.out.append(":");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (peek != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    private GJSONStringer endArray() throws JSONException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    private GJSONStringer endObject() throws JSONException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    private static void handleChar(StringBuilder sb, char c) {
        if (c == '\f') {
            sb.append("\\f");
        } else if (c == '\r') {
            sb.append("\\r");
        } else if (c != '\"' && c != '/' && c != '\\') {
            switch (c) {
                case '\b':
                    sb.append("\\b");
                    return;
                case '\t':
                    sb.append("\\t");
                    return;
                case '\n':
                    sb.append("\\n");
                    return;
                default:
                    if (c <= 31) {
                        sb.append(String.format("\\u%04x", Integer.valueOf(c)));
                        return;
                    } else {
                        sb.append(c);
                        return;
                    }
            }
        } else {
            sb.append('\\');
            sb.append(c);
        }
    }

    private Scope peek() throws JSONException {
        if (!this.stack.isEmpty()) {
            List<Scope> list = this.stack;
            return list.get(list.size() - 1);
        }
        throw new JSONException("Nesting problem");
    }

    private void replaceTop(Scope scope) {
        List<Scope> list = this.stack;
        list.set(list.size() - 1, scope);
    }

    private static void string(StringBuilder sb, String str) {
        sb.append("\"");
        stringWithoutQuotation(sb, str);
        sb.append("\"");
    }

    private void stringLinkedString(LinkedString linkedString) {
        this.out.append("\"");
        LinkedString.LinkedStringIterator it = linkedString.iterator();
        while (it.hasNext()) {
            handleChar(this.out, it.next());
        }
        this.out.append("\"");
    }

    public static void stringWithoutQuotation(StringBuilder sb, String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            handleChar(sb, str.charAt(i2));
        }
    }

    private GJSONStringer value(Object obj) throws JSONException {
        if (!this.stack.isEmpty()) {
            if (obj instanceof JSONArray) {
                writeToThis((JSONArray) obj);
                return this;
            } else if (obj instanceof JSONObject) {
                writeToThis((JSONObject) obj);
                return this;
            } else {
                beforeValue();
                if (obj != null && !(obj instanceof Boolean) && obj != JSONObject.NULL) {
                    if (obj instanceof Number) {
                        this.out.append(JSONObject.numberToString((Number) obj));
                    } else if (obj instanceof LinkedString) {
                        stringLinkedString((LinkedString) obj);
                    } else {
                        string(this.out, obj.toString());
                    }
                } else {
                    this.out.append(obj);
                }
                return this;
            }
        }
        throw new JSONException("Nesting problem");
    }

    private void writeToThis(JSONObject jSONObject) throws JSONException {
        object();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            key(next).value(jSONObject.get(next));
        }
        endObject();
    }

    GJSONStringer close(Scope scope, Scope scope2, String str) throws JSONException {
        Scope peek = peek();
        if (peek != scope2 && peek != scope) {
            throw new JSONException("Nesting problem");
        }
        List<Scope> list = this.stack;
        list.remove(list.size() - 1);
        this.out.append(str);
        return this;
    }

    public void closeBuffer() {
        this.out = new StringBuilder();
        this.stack.clear();
    }

    public String convertToString(JSONObject jSONObject) {
        this.out.setLength(0);
        this.stack.clear();
        try {
            writeToThis(jSONObject);
        } catch (JSONException e2) {
            LogUtil.d("GIO.JSON", e2.getMessage(), e2);
        }
        return this.out.toString();
    }

    public GJSONStringer key(String str) throws JSONException {
        if (str != null) {
            beforeKey();
            string(this.out, str);
            return this;
        }
        throw new JSONException("Names must be non-null");
    }

    public GJSONStringer object() throws JSONException {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    GJSONStringer open(Scope scope, String str) throws JSONException {
        if (this.stack.isEmpty() && this.out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        beforeValue();
        this.stack.add(scope);
        this.out.append(str);
        return this;
    }

    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }

    public String convertToString(JSONArray jSONArray) {
        this.out.setLength(0);
        this.stack.clear();
        try {
            writeToThis(jSONArray);
        } catch (JSONException e2) {
            LogUtil.d("GIO.JSON", e2.getMessage(), e2);
        }
        return this.out.toString();
    }

    private void writeToThis(JSONArray jSONArray) throws JSONException {
        array();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            value(jSONArray.get(i2));
        }
        endArray();
    }

    public GJSONStringer value(boolean z) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(z);
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public GJSONStringer value(double d2) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(JSONObject.numberToString(Double.valueOf(d2)));
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public GJSONStringer value(long j2) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(j2);
            return this;
        }
        throw new JSONException("Nesting problem");
    }
}
