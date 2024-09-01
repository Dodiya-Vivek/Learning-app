package com.example.skillupnow.ModelClass;

public class PdfModel {

    int image;
    String name;
    private String pdfUrl;

    public PdfModel(int image, String name,String pdfUrl) {
        this.image = image;
        this.name = name;
        this.pdfUrl = pdfUrl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
