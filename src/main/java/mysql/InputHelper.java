package mysql;

public class InputHelper extends DBConnector {
    private String insert;
    private String into;
    private String values;
    private static InputHelper inputHelper;

    public static InputHelper getInsert() {
        if (inputHelper == null) {
            inputHelper = new InputHelper();
        }
        return inputHelper;
    }

    public InputHelper insert() {
        this.insert = insert;
        return this;
    }

    public InputHelper into(String into) {
        this.into = into;
        return this;
    }

    public InputHelper values(String values) {
        this.values = values;
        return this;
    }

    public static void reset() {
        inputHelper = new InputHelper();
    }

    public int resultSetInsert() {
        try {
            return getStatement().executeUpdate("insert " + " into " + into + " values " + values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return 0;
    }
}
