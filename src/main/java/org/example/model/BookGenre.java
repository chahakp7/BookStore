package org.example.model;

public enum BookGenre {

    ACTION, COMIC, HISTORICAL, HORROR;
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
};

