package mysql;

public class UpdateHelper extends DBConnector {
    private String update;
    private String set;
    private String where;
    private static UpdateHelper updateHelper;

    public static UpdateHelper getUpdate() {
        if (updateHelper == null) {
            updateHelper = new UpdateHelper();
        }
        return updateHelper;
    }

    public UpdateHelper update(String update) {
        this.update = update;
        return this;
    }

    public UpdateHelper set(String set) {
        this.set = set;
        return this;
    }

    public UpdateHelper where(String where) {
        this.where = where;
        return this;
    }

    public static void reset() {
        updateHelper = new UpdateHelper();
    }

    public int resultSetUpdate() {
        try {
            return getStatement().executeUpdate("update " + update + " set " + set + " where " + where);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return 0;
    }
}
