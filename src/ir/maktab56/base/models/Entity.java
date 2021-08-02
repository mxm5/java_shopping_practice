package ir.maktab56.base.models;

public interface Entity<ID> {

    ID getId();

    void setId(ID id);

    boolean getDeleted();

    void setDeleted(boolean b);
}
