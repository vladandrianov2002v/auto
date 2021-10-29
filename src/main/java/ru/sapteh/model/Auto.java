package ru.sapteh.model;

import java.util.Objects;

public class Auto {
    private int id;
    private String model;
    private String marka;
    private String bodyType;
    private int typeGasoline;



    public Auto() {

    }

    public Auto(int id, String model, String marka, String bodyType,int typeGasoline) {
        this.id = id;
        this.model = model;
        this.marka= marka;
        this.bodyType= bodyType;
        this.typeGasoline= typeGasoline;
    }

    public Auto(String model, String marka,String bodyType,int typeGasoline) {
        this(0, model, marka,bodyType,typeGasoline);
    }

    public int getId() {
        return id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getTypeGasoline() {
        return typeGasoline;
    }

    public void setTypeGasoline(int typeGasoline) {
        this.typeGasoline = typeGasoline;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,model, marka, bodyType, typeGasoline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return id == auto.id && Objects.equals(model, auto.model) && Objects.equals(marka, auto.marka) && Objects.equals(bodyType, auto.bodyType)&& typeGasoline == auto.typeGasoline;
    }
    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", marka='" + marka + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", typeGasoline='" + typeGasoline + '\'' +
                '}';
    }
}
