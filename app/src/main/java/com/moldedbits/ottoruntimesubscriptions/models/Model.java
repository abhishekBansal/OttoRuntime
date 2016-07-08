package com.moldedbits.ottoruntimesubscriptions.models;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public abstract class Model {
    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public enum ModelType {
        MODEL_1,
        MODEL_2,
        MODEL_3
    }

    public Model(ModelType modelType) {
        this.modelType = modelType;
    }

    private ModelType modelType;

    abstract public void runtimeSubscribe();
    abstract public void unsubscribe();
}
