package com.ydlclass.builder;

/**
 * @author 
 * @createTime 2023-05-12
 */
public class HtmlDocument {
    private String header = "";
    private String body = "";
    private String footer = "";

    public void addHeader(String header) {
        this.header = header;
    }

    public void addBody(String body) {
        this.body = body;
    }

    public void addFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "<html><head>" + header + "</head><body>" + body + "</body><footer>" + footer + "</footer></html>";
    }

    public static class Builder {
        protected HtmlDocument document;

        public Builder() {
            document = new HtmlDocument();
        }

        public Builder addHeader(String header) {
            document.addHeader(header);
            return this;
        }

        public Builder addBody(String body) {
            document.addBody(body);
            return this;
        }

        public Builder addFooter(String footer) {
            document.addFooter(footer);
            return this;
        }

        public HtmlDocument build() {
            return document;
        }
    }
}
