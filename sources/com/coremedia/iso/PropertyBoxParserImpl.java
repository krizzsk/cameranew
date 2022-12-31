package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.UserBox;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes.dex */
public class PropertyBoxParserImpl extends AbstractBoxParser {
    static String[] EMPTY_STRING_ARRAY = new String[0];
    String clazzName;
    Properties mapping;
    String[] param;
    Pattern constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
    StringBuilder buildLookupStrings = new StringBuilder();

    public PropertyBoxParserImpl(String... strArr) {
        InputStream resourceAsStream = getClass().getResourceAsStream("/isoparser-default.properties");
        try {
            Properties properties = new Properties();
            this.mapping = properties;
            try {
                properties.load(resourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    InputStream openStream = resources.nextElement().openStream();
                    try {
                        this.mapping.load(openStream);
                        openStream.close();
                    } catch (Throwable th) {
                        openStream.close();
                        throw th;
                    }
                }
                for (String str : strArr) {
                    this.mapping.load(getClass().getResourceAsStream(str));
                }
                try {
                    resourceAsStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        } catch (Throwable th2) {
            try {
                resourceAsStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    @Override // com.coremedia.iso.AbstractBoxParser
    public Box createBox(String str, byte[] bArr, String str2) {
        invoke(str, bArr, str2);
        try {
            Class<?> cls = Class.forName(this.clazzName);
            String[] strArr = this.param;
            if (strArr.length > 0) {
                Class<?>[] clsArr = new Class[strArr.length];
                Object[] objArr = new Object[strArr.length];
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.param;
                    if (i2 >= strArr2.length) {
                        return (Box) cls.getConstructor(clsArr).newInstance(objArr);
                    }
                    if ("userType".equals(strArr2[i2])) {
                        objArr[i2] = bArr;
                        clsArr[i2] = byte[].class;
                    } else if ("type".equals(this.param[i2])) {
                        objArr[i2] = str;
                        clsArr[i2] = String.class;
                    } else if ("parent".equals(this.param[i2])) {
                        objArr[i2] = str2;
                        clsArr[i2] = String.class;
                    } else {
                        throw new InternalError("No such param: " + this.param[i2]);
                    }
                    i2++;
                }
            } else {
                return (Box) cls.newInstance();
            }
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public void invoke(String str, byte[] bArr, String str2) {
        String property;
        if (bArr != null) {
            if (UserBox.TYPE.equals(str)) {
                Properties properties = this.mapping;
                property = properties.getProperty("uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
                if (property == null) {
                    Properties properties2 = this.mapping;
                    property = properties2.getProperty(String.valueOf(str2) + "-uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
                }
                if (property == null) {
                    property = this.mapping.getProperty(UserBox.TYPE);
                }
            } else {
                throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
            }
        } else {
            property = this.mapping.getProperty(str);
            if (property == null) {
                StringBuilder sb = this.buildLookupStrings;
                sb.append(str2);
                sb.append('-');
                sb.append(str);
                String sb2 = sb.toString();
                this.buildLookupStrings.setLength(0);
                property = this.mapping.getProperty(sb2);
            }
        }
        if (property == null) {
            property = this.mapping.getProperty(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
        }
        if (property != null) {
            if (!property.endsWith(")")) {
                this.param = EMPTY_STRING_ARRAY;
                this.clazzName = property;
                return;
            }
            Matcher matcher = this.constuctorPattern.matcher(property);
            if (matcher.matches()) {
                this.clazzName = matcher.group(1);
                if (matcher.group(2).length() == 0) {
                    this.param = EMPTY_STRING_ARRAY;
                    return;
                } else {
                    this.param = matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0];
                    return;
                }
            }
            throw new RuntimeException("Cannot work with that constructor: " + property);
        }
        throw new RuntimeException("No box object found for " + str);
    }

    public PropertyBoxParserImpl(Properties properties) {
        this.mapping = properties;
    }
}
