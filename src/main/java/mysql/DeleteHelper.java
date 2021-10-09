package mysql;

public class DeleteHelper extends DBConnector {
    private String delete;
    private String from;
    private String where;
    private static DeleteHelper deleteHelper;

    public static DeleteHelper getDelete() {
        if (deleteHelper == null) {
            deleteHelper = new DeleteHelper();
        }
        return deleteHelper;
    }

    public DeleteHelper delete() {
        this.delete = delete;
        return this;
    }

    public DeleteHelper from(String from) {
        this.from = from;
        return this;
    }

    public DeleteHelper where(String where) {
        this.where = where;
        return this;
    }

    public static void reset() {
        deleteHelper = new DeleteHelper();
    }

    public int resultSetDelete() {
        try {
            return getStatement().executeUpdate("delete " + " from " + from + " where " + where);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return 0;
    }
}
