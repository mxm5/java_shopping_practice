package ir.maktab56.base.models;

public class BaseEntity<ID> implements Entity<ID> {

    private ID id;

    private boolean deleted;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public void setDeleted(boolean b) {
        deleted = b;
    }
}
