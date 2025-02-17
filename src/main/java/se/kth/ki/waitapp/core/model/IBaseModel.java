package se.kth.ki.waitapp.core.model;

public interface IBaseModel {
    Long getId();

    void setId(Long id);

    boolean isPersistent();
}
