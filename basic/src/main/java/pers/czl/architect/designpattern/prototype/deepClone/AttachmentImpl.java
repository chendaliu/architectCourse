package pers.czl.architect.designpattern.prototype.deepClone;

import com.sun.xml.internal.ws.api.message.Attachment;

import javax.activation.DataHandler;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * 附件对象
 *
 * @author: daliu
 * @date: 2021-12-28 14:47
 **/
public class AttachmentImpl implements Attachment, Serializable {

    @Override
    public String getContentId() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    public DataHandler asDataHandler() {
        return null;
    }

    @Override
    public Source asSource() {
        return null;
    }

    @Override
    public InputStream asInputStream() {
        return null;
    }

    @Override
    public void writeTo(OutputStream outputStream) throws IOException {

    }

    @Override
    public void writeTo(SOAPMessage soapMessage) throws SOAPException {

    }
}