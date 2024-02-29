package com.ydlclass.abstractFactory.product.impl;

import com.ydlclass.abstractFactory.product.AbstractPictureResource;

import java.io.InputStream;

/**
 * @author
 * @createTime 2023-05-10
 */
public class FtpPictureResource extends AbstractPictureResource {

    public FtpPictureResource() {
    }

    public FtpPictureResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
